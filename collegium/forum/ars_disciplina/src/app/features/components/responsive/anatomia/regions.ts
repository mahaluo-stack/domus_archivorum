import { Region, regionNames, AnatomyView } from "../../../../core/models/types/anatomy.types";

export function parseViewBox(svg: string): { w: number; h: number } {

    const match = svg.match(
        /viewBox="(?:[\d.]+)\s+(?:[\d.]+)\s+([\d.]+)\s+([\d.]+)"/
    );

    if (!match) {
        return {
            w: 0,
            h: 0
        };
    }

    return {
        w: parseFloat(match[1]),
        h: parseFloat(match[2])
    };
}

export function extractPaths(svg: string): string[] {

    const paths: string[] = [];
    const regex = /<path[^>]*\sd="([^"]+)"/g;

    let match: RegExpExecArray | null;

    while ((match = regex.exec(svg)) !== null) {
        paths.push(match[1]);
    }

    return paths;
}

function pathToPoints(d: string): Array<[number, number]> {

    const tokens = d
        .replace(/([a-zA-Z])/g, ' $1 ')
        .replace(/,/g, ' ')
        .trim()
        .split(/\s+/);

    const pts: Array<[number, number]> = [];

    let i = 0;
    let x = 0;
    let y = 0;
    let cmd = '';

    while (i < tokens.length) {

        const token = tokens[i];

        if (/^[a-zA-Z]$/.test(token)) {
            cmd = token;
            i++;
            continue;
        }

        switch (cmd) {

            case 'M': {

                x = parseFloat(tokens[i++]);
                y = parseFloat(tokens[i++]);
                pts.push([x, y]);
                cmd = 'L';
                break;
            }

            case 'm': {

                x += parseFloat(tokens[i++]);
                y += parseFloat(tokens[i++]);
                pts.push([x, y]);
                cmd = 'l';
                break;
            }

            case 'L': {

                x = parseFloat(tokens[i++]);
                y = parseFloat(tokens[i++]);
                pts.push([x, y]);
                break;

            }

            case 'l': {

                x += parseFloat(tokens[i++]);
                y += parseFloat(tokens[i++]);
                pts.push([x, y]);
                break;
            }

            case 'H': {

                x = parseFloat(tokens[i++]);
                pts.push([x, y]);
                break;
            }

            case 'h': {
                x += parseFloat(tokens[i++]);
                pts.push([x, y]);

                break;
            }

            case 'V': {

                y = parseFloat(tokens[i++]);
                pts.push([x, y]);

                break;
            }

            case 'v': {
                y += parseFloat(tokens[i++]);
                pts.push([x, y]);

                break;
            }

            default: {

                i++;
            }
        }
    }

    return pts;
}

export function calculateBoundingBox(
    points: Array<[number, number]>
): Region['bbox'] {

    let minX = Number.POSITIVE_INFINITY;
    let minY = Number.POSITIVE_INFINITY;
    let maxX = Number.NEGATIVE_INFINITY;
    let maxY = Number.NEGATIVE_INFINITY;

    for (const [x, y] of points) {

        if (x < minX) minX = x;
        if (y < minY) minY = y;
        if (x > maxX) maxX = x;
        if (y > maxY) maxY = y;

    }

    return {
        x: minX,
        y: minY,
        w: maxX - minX,
        h: maxY - minY
    };
}

export function buildRegions(
    svg: string,
    view: AnatomyView
): Region[] {

    const viewBox = parseViewBox(svg);
    const paths = extractPaths(svg);
    const names = regionNames[view] ?? {};

    const regions: Region[] = [];


    regions.sort((a, b) => {

        const areaA = a.bbox.w * a.bbox.h;
        const areaB = b.bbox.w * b.bbox.h;

        return areaB - areaA;

    });

    return regions;
}