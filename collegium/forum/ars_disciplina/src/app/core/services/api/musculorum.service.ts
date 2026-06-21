import { Injectable, inject } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { map, Observable } from 'rxjs';
import { Muscle } from '../../models/interfaces/muscle/muscle.interface';
import { apiUrl } from '../../models/constants/api.constants'
import { MusculiDTO } from '../../models/dto/musculorum/musculi.dto.interface';
import { MuscleMapper } from '../../mapping/muscle.mapper';

@Injectable({
  providedIn: 'root'
})
export class MusculorumService {

  private readonly http = inject(HttpClient);
  private readonly schema = 'musculorum'

getAllMuscles(): Observable<Muscle[]> {
    return this.http
        .get<MusculiDTO[]>(`${apiUrl}/${this.schema}/musculi`)
        .pipe(map(MuscleMapper.fromDtos));
}
  
  getAllMuscleGroups(): Observable<Muscle[]> {
    return this.http.get<Muscle[]>(`${apiUrl}/${this.schema}/musculi-regio`);
  }

   getAllMuscleParts(): Observable<Muscle[]> {
    return this.http.get<Muscle[]>(`${apiUrl}/${this.schema}/musculi-pars`);
  }
}