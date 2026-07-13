import { computed, inject, Injectable, signal } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { apiUrl } from '../../models/constants/api.constants';
import { Responsum } from '../../models/dto/responsum.interface';
import { Observable } from 'rxjs';
import { MusculiMusculiParsDTO } from '../../models/dto/nexuum/musculi-regio-musculi.dto.interface';
import { MusculiRegioMusculiDTO } from '../../models/dto/nexuum/musculi-musculi-pars.dto.interface';
import { PetitioConfiguratioMusculi } from '../../models/dto/petitio/petitio-configuratio-musculi.interface';

@Injectable({
    providedIn: 'root'
})
export class NexuumService {

    private loaded = false;
    private readonly http = inject(HttpClient);
    private readonly schema = 'nexuum';

    private readonly musclePartConfig = signal<MusculiMusculiParsDTO[]>([]);
    readonly musclePartConfigurations = this.musclePartConfig.asReadonly();

    private readonly muscleGroupConfig = signal<MusculiRegioMusculiDTO[]>([]);
    readonly muscleGroupConfigurations = this.muscleGroupConfig.asReadonly();

    loadMuscleNexus(): void {
        if (this.loaded) {
            return;
        }

        this.http
            .get<MusculiMusculiParsDTO[]>(`${apiUrl}/${this.schema}/musculi`)
            .subscribe(configs => this.musclePartConfig.set(configs));

        this.http
            .get<MusculiRegioMusculiDTO[]>(`${apiUrl}/${this.schema}/musculi-regio`)
            .subscribe(configs => this.muscleGroupConfig.set(configs));
    }

    updateMuscleConfiguration(muscleConfig: PetitioConfiguratioMusculi): Observable<Responsum<void>> {
        return this.http.put<Responsum<void>>(
            `${apiUrl}/${this.schema}/musculi`,
            {
                musculiIdentitas: muscleConfig.musculiIdentitas,
                musculiParsIdentitates: muscleConfig.musculiParsIdentitates
            }
        )
    }
}