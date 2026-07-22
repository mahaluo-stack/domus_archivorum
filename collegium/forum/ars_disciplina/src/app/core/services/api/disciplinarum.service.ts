import { HttpClient } from "@angular/common/http";
import { Injectable, inject, signal } from "@angular/core";
import { forkJoin } from "rxjs";
import { Exercise } from "../../models/exercise/exercise.interface";
import { apiUrl } from "../../models/constants/api.constants";
import { Responsum } from "../../models/dto/responsum.interface";
import { DisciplinaDTO } from "../../models/dto/disciplinarum/disciplina.dto.interface";
import { ExerciseMapper } from "../../mapping/disciplinarum.mapper";

@Injectable({
    providedIn: 'root'
})
export class DisciplinarumService {

    private loaded = false;
    private readonly http = inject(HttpClient);
    private readonly schema = 'disciplinarum';

    private readonly exerciseSignal = signal<Exercise[]>([]);
    readonly exercises = this.exerciseSignal.asReadonly();

    loadExerciseData(): void {
        if (this.loaded) {
            return;
        }

        forkJoin({
            exerciseSignal: this.http.get<Responsum<DisciplinaDTO[]>>(`${apiUrl}/${this.schema}/disciplinae`)
        }).subscribe(result => {

            this.exerciseSignal.set(ExerciseMapper.fromDtos(result.exerciseSignal.data));
            this.loaded = true;
        });
    }
}