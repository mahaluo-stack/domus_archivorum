import { HttpClient } from "@angular/common/http";
import { inject, Injectable, signal } from "@angular/core";
import { MuscleEntity } from "../../models/entity/muscle.entity";
import { Responsum } from "../../models/dto/responsum.interface";
import { apiUrl } from "../../models/constants/api.constants";
import { Observable } from "rxjs";

@Injectable({
    providedIn: 'root'
})
export class EntiaService {

    private loaded = false;
    private readonly http = inject(HttpClient);
    private readonly schema = 'entia';

    private readonly muscleEntitySignal = signal<MuscleEntity[]>([]);
    readonly muscleEntities = this.muscleEntitySignal.asReadonly();

    loadMuscleEntities(): void {
        if (!this.loaded) {
            this.http.get<Responsum<void>>(`${apiUrl}/${this.schema}/musculi`);
        }
        this.loaded = true;
    }
}