import { computed, inject, Injectable, signal } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { apiUrl } from '../../models/constants/api.constants';
import { Responsum } from '../../models/dto/responsum.interface';
import { forkJoin, Observable } from 'rxjs';
import { MusculiMusculiParsDTO } from '../../models/dto/nexuum/musculi-regio-musculi.dto.interface';
import { MusculiRegioMusculiDTO } from '../../models/dto/nexuum/musculi-musculi-pars.dto.interface';
import { PetitioConfiguratioMusculi } from '../../models/dto/petitio/petitio-configuratio-musculi.interface';
import { MuscleConfig } from '../../models/muscle/muscle-config.interface';
import { MuscleGroupConfig } from '../../models/muscle/muscle-group-config.interface';
import { MuscleConfigMapper, MuscleGroupConfigMapper } from '../../mapping/muscle-config.mapper';

@Injectable({
    providedIn: 'root'
})
export class NexuumService {

    private loaded = false;
    private readonly http = inject(HttpClient);
    private readonly schema = 'nexuum';

    private readonly muscleConfigSignal = signal<MuscleConfig[]>([]);
    readonly muscleConfig = this.muscleConfigSignal.asReadonly();

    private readonly muscleGroupConfigSignal = signal<MuscleGroupConfig[]>([]);
    readonly muscleGroupConfig = this.muscleGroupConfigSignal.asReadonly();

    loadMuscleConfig(): void {
        if (this.loaded) {
            return;
        }

        forkJoin({
            muscleConfig: this.http.get<Responsum<MusculiMusculiParsDTO[]>>(`${apiUrl}/${this.schema}/musculi`),
            muscleGroupConfig: this.http.get<Responsum<MusculiRegioMusculiDTO[]>>(`${apiUrl}/${this.schema}/musculi-regio`)
        }).subscribe(result => {

            this.muscleConfigSignal.set(MuscleConfigMapper.fromDtos(result.muscleConfig.data));
            this.muscleGroupConfigSignal.set(MuscleGroupConfigMapper.fromDtos(result.muscleGroupConfig.data));
            this.loaded = true;
        });
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

    deleteMuscleConfiguration(muscleId: number) {
        return this.http.delete<Responsum<void>>(
            `${apiUrl}/${this.schema}/musculi/${muscleId}`
        )
    }

    deleteMuscleGroupConfiguration(muscleGroupId: number) {
        return this.http.delete<Responsum<void>>(
            `${apiUrl}/${this.schema}/musculi-regio/${muscleGroupId}`
        )
    }
}