import svgpath from 'svgpath';
import { svgPathProperties } from 'svg-path-properties';

import { Region, ViewBox } from '../models/types/anatomy.types';

export interface AnatomyParseResult {

    viewBox: ViewBox;

    regions: Region[];

    transform: {

        x: number;

        y: number;

        scale: number;

    };

}

export class AnatomySvgParser {

    static parse(
        svg: string,
        names: Record<string, string> = {}
    ): AnatomyParseResult {

        const viewBox = this.parseViewBox(svg);

        const paths = this.extractPaths(svg);

        const regions: Region[] = [];

        paths.forEach((d, index) => {

            const pts = this.pathToPoints(d);

            if (pts.length < 3)
                return;

            const bb = this.bbox(pts);

            if (bb.x < 15 && bb.w < 12)
                return;

            if (bb.w < 2 || bb.h < 2)
                return;

            if (bb.h > viewBox.h * 0.6)
                return;

            const id = `r-${index}`;

            regions.push({
                id,
                name: names[id] ?? id,
                points: pts
                    .map(([x, y]) => `${x},${y}`)
                    .join(' '),
                bbox: bb
            });

        });

        regions.sort(
            (a, b) =>
                b.bbox.w * b.bbox.h -
                a.bbox.w * a.bbox.h
        );

        // -------------------------------------------------
        // Calculate body bounds
        // -------------------------------------------------
        let minX = Infinity;
        let minY = Infinity;
        let maxX = -Infinity;
        let maxY = -Infinity;

        for (const region of regions) {

            minX = Math.min(minX, region.bbox.x);
            minY = Math.min(minY, region.bbox.y);

            maxX = Math.max(maxX, region.bbox.x + region.bbox.w);
            maxY = Math.max(maxY, region.bbox.y + region.bbox.h);

        }


        const bodyWidth = maxX - minX;
        const bodyHeight = maxY - minY;
        const FIT = 0.82;

        const scale = Math.min(
            (viewBox.w * FIT) / bodyWidth,
            (viewBox.h * FIT) / bodyHeight
        );

        const x = (viewBox.w - bodyWidth * scale) / 2 - minX * scale;

        const TOP_BIAS = 0.7;

        const y = (viewBox.h - bodyHeight * scale) * TOP_BIAS - minY * scale;

        return {

            viewBox,
            regions,
            transform: {
                x,
                y,
                scale
            }
        };
    }

    private static parseViewBox(svg: string): ViewBox {

        const match = svg.match(/viewBox=["']([^"']+)["']/i);

        if (!match)
            throw new Error('No viewBox found.');

        const [, , w, h] = match[1]
            .trim()
            .split(/\s+/)
            .map(Number);

        return {
            w,
            h
        };

    }

    private static extractPaths(svg: string): string[] {

        const out: string[] = [];

        const re = /<path[^>]*\sd="([^"]+)"/g;

        let m: RegExpExecArray | null;

        while ((m = re.exec(svg)) !== null) {

            out.push(m[1]);

        }

        return out;

    }

    private static pathToPoints(d: string): [number, number][] {

        const normalized = svgpath(d)
            .abs()
            .unshort()
            .unarc()
            .toString();

        const props = new svgPathProperties(normalized);

        const length = props.getTotalLength();

        const points: [number, number][] = [];

        const STEP = 2;

        for (let l = 0; l <= length; l += STEP) {

            const p = props.getPointAtLength(l);

            points.push([
                Number(p.x.toFixed(2)),
                Number(p.y.toFixed(2))
            ]);

        }

        return points;

    }

    private static bbox(points: [number, number][]) {

        let minX = Infinity;
        let minY = Infinity;
        let maxX = -Infinity;
        let maxY = -Infinity;

        for (const [x, y] of points) {

            minX = Math.min(minX, x);
            minY = Math.min(minY, y);
            maxX = Math.max(maxX, x);
            maxY = Math.max(maxY, y);

        }

        return {

            x: minX,
            y: minY,
            w: maxX - minX,
            h: maxY - minY

        };

    }

}