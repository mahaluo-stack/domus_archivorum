import { Injectable, Signal, computed, inject } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { BehaviorSubject, forkJoin, map, Observable, tap } from 'rxjs';
import { Muscle } from '../../models/muscle/muscle.interface';
import { apiUrl } from '../../models/constants/api.constants'
import { MusculiDTO } from '../../models/dto/musculorum/musculi.dto.interface';
import { MuscleGroupMapper, MuscleMapper, MusclePartMapper } from '../../mapping/musculorum.mapper';
import { MuscleGroup } from '../../models/muscle/muscle-group.interface';
import { MusclePart } from '../../models/muscle/muscle-part.interface';
import { MusculiRegioDTO } from '../../models/dto/musculorum/musculi-regio.dto.interface';
import { MusculiParsDTO } from '../../models/dto/musculorum/musculi-pars.dto.interface';
import { toSignal } from '@angular/core/rxjs-interop';

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
      muscles: this.http
        .get<MusculiDTO[]>(`${apiUrl}/${this.schema}/musculi`)
        .pipe(
          map(MuscleMapper.fromDtos),
          tap(muscles => this.muscleSubject.next(muscles))
        ),
      groups: this.http
        .get<MusculiRegioDTO[]>(`${apiUrl}/${this.schema}/musculi-regio`)
        .pipe(
          map(MuscleGroupMapper.fromDtos),
          tap(muscles => this.muscleGroupSubject.next(muscles))
        ),
      parts: this.http
        .get<MusculiParsDTO[]>(`${apiUrl}/${this.schema}/musculi-pars`)
        .pipe(
          map(MusclePartMapper.fromDtos),
          tap(muscles => this.musclePartSubject.next(muscles))
        )

    }).subscribe(result => {

      this.muscleSubject.next(result.muscles);
      this.muscleGroupSubject.next(result.groups);
      this.musclePartSubject.next(result.parts);

      this.loaded = true;
    });
  }
}