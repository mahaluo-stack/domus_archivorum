import { Injectable, Signal, computed, inject } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { BehaviorSubject, forkJoin, map, tap } from 'rxjs';
import { Muscle } from '../../models/muscle/muscle.interface';
import { apiUrl } from '../../models/constants/api.constants'
import { MusculiDTO } from '../../models/dto/musculorum/musculi.dto.interface';
import { MuscleGroupMapper, MuscleMapper, MusclePartMapper } from '../../mapping/musculorum.mapper';
import { MuscleGroup } from '../../models/muscle/muscle-group.interface';
import { MusclePart } from '../../models/muscle/muscle-part.interface';
import { MusculiRegioDTO } from '../../models/dto/musculorum/musculi-regio.dto.interface';
import { MusculiParsDTO } from '../../models/dto/musculorum/musculi-pars.dto.interface';
import { toSignal } from '@angular/core/rxjs-interop';
import { Responsum } from '../../models/dto/responsum.interface';
import { PetitioMusculi } from '../../models/dto/petitio/petitio-musculi.interface';
import { PetitioMusculiPars } from '../../models/dto/petitio/petitio-musculi-pars.interface';
import { PetitioMusculiRegio } from '../../models/dto/petitio/petitio-musculi-regio.interface';

@Injectable({
  providedIn: 'root'
})
export class MusculorumService {

  private loaded = false;
  private readonly http = inject(HttpClient);
  private readonly schema = 'musculorum';

  private readonly muscleSubject = new BehaviorSubject<Muscle[]>([]);
  readonly muscles$ = this.muscleSubject.asObservable();

  private readonly muscleGroupSubject = new BehaviorSubject<MuscleGroup[]>([]);
  readonly muscleGroups$ = this.muscleGroupSubject.asObservable();

  private readonly musclePartSubject = new BehaviorSubject<MusclePart[]>([]);
  readonly muscleParts$ = this.musclePartSubject.asObservable();

  readonly muscles = toSignal(this.muscles$, { initialValue: [] });

  getMuscle(id: Signal<number>): Signal<Muscle | undefined> {
    return computed(() =>
      this.muscles().find(m => m.id === id())
    );
  }

  loadMusculorum(): void {

    if (this.loaded) {
      return;
    }

    forkJoin({
      muscles: this.http.get<Responsum<MusculiDTO[]>>(`${apiUrl}/${this.schema}/musculi`),
      groups: this.http.get<Responsum<MusculiRegioDTO[]>>(`${apiUrl}/${this.schema}/musculi-regio`),
      parts: this.http.get<Responsum<MusculiParsDTO[]>>(`${apiUrl}/${this.schema}/musculi-pars`)
    }).subscribe(result => {

      this.muscleSubject.next(MuscleMapper.fromDtos(result.muscles.data));
      this.muscleGroupSubject.next(MuscleGroupMapper.fromDtos(result.groups.data));
      this.musclePartSubject.next(MusclePartMapper.fromDtos(result.parts.data));

      this.loaded = true;
    });
  }

  deleteMuscle(muscleId: number) {
    return this.http.delete<Responsum<void>>(
      `${apiUrl}/${this.schema}/musculi/${muscleId}`
    )
  }

  createMuscle(petitioMusculi: PetitioMusculi) {
    return this.http.post<Responsum<void>>(
      `${apiUrl}/${this.schema}/musculi`,
      {
       ...petitioMusculi
      }
    )
  }

  updateMuscle(petitioMusculi: PetitioMusculi) {
    return this.http.put<Responsum<void>>(
      `${apiUrl}/${this.schema}/musculi/${petitioMusculi.identitas}`,
      {
        ...petitioMusculi
      }
    )
  }

  deleteMusclePart(musclePartId: number) {
    return this.http.delete<Responsum<void>>(
      `${apiUrl}/${this.schema}/musculi-pars/${musclePartId}`
    )
  }

  createMusclePart(petitioMusculiPars: PetitioMusculiPars) {
    return this.http.post<Responsum<void>>(
      `${apiUrl}/${this.schema}/musculi-pars`,
      {
        ...petitioMusculiPars
      }
    )
  }

  updateMusclePart(petitioMusculiPars: PetitioMusculiPars) {
    return this.http.put<Responsum<void>>(
      `${apiUrl}/${this.schema}/musculi-pars/${petitioMusculiPars.identitas}`,
      {
        ...petitioMusculiPars
      }
    )
  }

  deleteMuscleGroup(muscleGroupId: number) {
    return this.http.delete<Responsum<void>>(
      `${apiUrl}/${this.schema}/musculi-regio/${muscleGroupId}`
    )
  }

  createMuscleGroup(petitioMusculiRegio: PetitioMusculiRegio) {
    return this.http.post<Responsum<void>>(
      `${apiUrl}/${this.schema}/musculi-regio`,
      {
        ...petitioMusculiRegio
      }
    )
  }

  updateMuscleGroup(petitioMusculiRegio: PetitioMusculiRegio) {
    return this.http.put<Responsum<void>>(
      `${apiUrl}/${this.schema}/musculi-regio/${petitioMusculiRegio.identitas}`,
      {
        ...petitioMusculiRegio
      }
    )
  }
}