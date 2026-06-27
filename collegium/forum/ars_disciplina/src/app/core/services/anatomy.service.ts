import { Injectable, inject } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { map, Observable } from 'rxjs';



import { AnatomySvgParser } from '../util/anatomy.svg.parser';
import { AnatomyModel, AnatomyView } from '../models/types/anatomy.types';

@Injectable({
    providedIn: 'root'
})
export class AnatomyService {

    private readonly http = inject(HttpClient);

    load(view: AnatomyView): Observable<AnatomyModel> {

        return this.http
            .get(`assets/anatomy/${view}.svg`, {
                responseType: 'text'
            })
            .pipe(
                map(svg => {

                    const anatomy = AnatomySvgParser.parse(svg);

                    return {
                        regions: anatomy.regions,
                        viewBox: `0 0 ${anatomy.viewBox.w} ${anatomy.viewBox.h}`,
                        transform: anatomy.transform
                    };

                })
            );
    }
}