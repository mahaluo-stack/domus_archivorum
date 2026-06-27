import { ChangeDetectionStrategy, Component, inject, OnInit } from '@angular/core';
import { toSignal } from '@angular/core/rxjs-interop';
import { Router } from '@angular/router';
import { MusculorumService } from '../../../../../core/services/api/musculorum.service';
import { PageWrapperComponent } from '../../../../components/phone/page-wrapper/page-wrapper.component';

@Component({
  selector: 'muscle',
  standalone: true,
  imports: [PageWrapperComponent],
  templateUrl: './muscle.component.html',
  styleUrl: './muscle.component.scss',
  changeDetection: ChangeDetectionStrategy.OnPush
})
export class MuscleComponent implements OnInit {

  private readonly musculorumService = inject(MusculorumService);

  readonly muscles = toSignal(
    this.musculorumService.muscles$,
    { initialValue: [] }
  );

  readonly muscleGroups = toSignal(
    this.musculorumService.muscleGroups$,
    { initialValue: [] }
  );

  readonly muscleParts = toSignal(
    this.musculorumService.muscleParts$,
    { initialValue: [] }
  );

  ngOnInit(): void {

    this.musculorumService.loadMusculorum();
  }
}