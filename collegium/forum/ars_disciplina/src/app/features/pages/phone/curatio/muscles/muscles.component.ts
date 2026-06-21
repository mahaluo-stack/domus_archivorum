import { Component, inject, OnInit } from '@angular/core';
import { PageWrapperComponent } from '../../../../components/phone/page-wrapper/page-wrapper.component';
import { MusculorumService } from '../../../../../core/services/api/musculorum.service';
import { Muscle } from '../../../../../core/models/interfaces/muscle/muscle.interface';
import { MuscleGroup } from '../../../../../core/models/interfaces/muscle/muscle.group.interface';
import { MusclePart } from '../../../../../core/models/interfaces/muscle/muscle.part.interface';
import { PageHeaderComponent } from "../../../../components/phone/page-header/page-header.component";

@Component({
  selector: 'app-muscles',
  standalone: true,
  imports: [PageWrapperComponent, PageHeaderComponent],
  templateUrl: './muscles.component.html',
  styleUrl: './muscles.component.scss'
})
export class MusclesComponent implements OnInit {

  private readonly musculiService = inject(MusculorumService);

  muscles: Muscle[] = [];
  muscleParts: MusclePart[] = [];
  muscleGroups: MuscleGroup[] = [];

  ngOnInit(): void {
    this.musculiService.getAllMuscles().subscribe(r => {
      this.muscles = r;
    });
     this.musculiService.getAllMuscleParts().subscribe(r => {
      this.muscleParts = r;
    });
     this.musculiService.getAllMuscleGroups().subscribe(r => {
      this.muscleGroups = r;
    });
  }
}
