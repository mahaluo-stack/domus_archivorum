import { Component, effect, inject } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { toSignal } from '@angular/core/rxjs-interop';
import { map } from 'rxjs';
import { MusculorumService } from '../../../../../../core/services/api/musculorum.service';
import { PageHeaderService } from '../../../../../../core/services/page-header.service';
import { PageWrapperComponent } from '../../../../../components/phone/page-wrapper/page-wrapper.component';

@Component({
  selector: 'edit-muscle',
  standalone: true,
  imports: [PageWrapperComponent],
  templateUrl: './edit-muscle.component.html',
  styleUrl: './edit-muscle.component.scss'
})
export class EditMuscleComponent {

  private readonly route = inject(ActivatedRoute);
  private readonly headerService = inject(PageHeaderService);
  private readonly musculorumService = inject(MusculorumService);

  readonly muscleId = toSignal(
    this.route.paramMap.pipe(
      map(params => Number(params.get('id')))
    ),
    { initialValue: 0 }
  );

  readonly muscle = this.musculorumService.getMuscle(this.muscleId);

  constructor() {

    effect(() => {

      const muscle = this.muscle();

      if (!muscle) {
        return;
      }

      this.headerService.setTitle(muscle.name);

    }, { allowSignalWrites: true });
  }
}