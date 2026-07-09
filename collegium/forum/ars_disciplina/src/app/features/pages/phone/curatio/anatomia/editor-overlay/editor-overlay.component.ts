import {
  Component,
  computed,
  inject,
  OnInit
} from '@angular/core';
import { EditorSelectOption } from '../../../../../../core/models/interfaces/ui/editor.select.option.interface';
import { EditorSelectComponent } from '../../../../../components/responsive/editor-select/editor-select.component';
import { EditorRadioOption } from '../../../../../../core/models/interfaces/ui/editor.radio.option.interface';
import { toSignal } from '@angular/core/rxjs-interop';
import { MusculorumService } from '../../../../../../core/services/api/musculorum.service';
import { EditorRadioComponent } from "../../../../../components/responsive/editor-radio/editor-radio.component";
import { EditorIconButtonComponent } from "../../../../../components/responsive/editor-icon-button/editor-icon-button.component";
import { SnackbarService } from '../../../../../../core/services/snackbar.service';

@Component({
  selector: 'editor-overlay',
  standalone: true,
  imports: [
    EditorSelectComponent,
    EditorRadioComponent,
    EditorIconButtonComponent
  ],
  templateUrl: './editor-overlay.component.html',
  styleUrls: ['./editor-overlay.component.scss']
})
export class EditorOverlayComponent implements OnInit {

  private readonly snackbar = inject(SnackbarService);

  ngOnInit(): void {
    this.musculorumService.loadMusculorum();
  }

  protected sourceLabel = 'select configuration';

  protected get sourceLock(): boolean {
    return !this.selectedRadioOption;
  }
  protected get targetLock(): boolean {
    return !this.selectedSource;
  }

  protected get sourcePlaceholder(): string {
    if (!this.selectedRadioOption) {
      return 'select configuration'
    }

    if (this.selectedRadioOption === 1) {
      return 'select muscle';
    }

    if (this.selectedRadioOption === 2) {
      return 'select group'
    }
    return ''
  }

  protected get targetPlaceholder(): string {
    if (!this.selectedRadioOption) {
      return 'select configuration'
    }
    return this.selectedRadioOption === 1 ? 'select parts' : 'select muscles'
  }

  protected sourceOptions: EditorSelectOption[] = [];
  protected targetOptions: EditorSelectOption[] = [];
  protected radioOptions: EditorRadioOption[] = [
    {
      value: 1,
      source: 'muscle parts',
      target: 'muscle'
    },
    {
      value: 2,
      source: 'muscle',
      target: 'muscle group'
    }
  ];

  protected selectedRadioOption: number | undefined;
  protected selectedSource?: number;
  protected selectedTarget?: number;
  protected selectedTargets: Set<number> = new Set();
  private readonly musculorumService = inject(MusculorumService);

  readonly muscles = toSignal(
    this.musculorumService.muscles$,
    { initialValue: [] }
  );
  readonly muscleOptions = computed<EditorSelectOption[]>(() =>
    this.muscles().map(muscle => ({
      id: muscle.id,
      label: muscle.name,
      description: muscle.description
    }))
  );

  readonly muscleGroups = toSignal(
    this.musculorumService.muscleGroups$,
    { initialValue: [] }
  );
  readonly muscleGroupOptions = computed<EditorSelectOption[]>(() =>
    this.muscleGroups().map(group => ({
      id: group.id,
      label: group.name,
      description: group.description
    }))
  );

  readonly muscleParts = toSignal(
    this.musculorumService.muscleParts$,
    { initialValue: [] }
  );
  readonly musclePartOptions = computed<EditorSelectOption[]>(() =>
    this.muscleParts().map(part => ({
      id: part.id,
      label: part.name,
      description: part.description
    }))
  );

  protected onRadioEvent(value: number): void {

    this.selectedRadioOption = value;
    this.selectedSource = undefined;
    this.selectedTarget = undefined;
    this.selectedTargets = new Set();

    if (value === 1) {
      this.sourceLabel = 'select muscle';
      this.sourceOptions = this.muscleOptions();
      this.targetOptions = this.musclePartOptions();
    }
    if (value === 2) {
      this.sourceLabel = 'select muscle group';
      this.sourceOptions = this.muscleGroupOptions();
      this.targetOptions = this.muscleOptions();
    }
  }

  onSourceChange($event: number) {
    this.selectedSource = $event;
  }

  targetSelected($event: number) {
    this.selectedTarget = $event;
    this.selectedTargets = new Set([...this.selectedTargets, $event]);
  }

  getTargetLabel(id: number): string {
    return this.targetOptions[id - 1].label
  }

  getSourceLabel(): string {
    if (this.selectedSource) {
      return this.sourceOptions[this.selectedSource - 1].label;
    }
    return '';
  }

  removeTarget(id: number) {
    this.selectedTargets.delete(id)
    this.selectedTarget = undefined;
  }

  removeSource() {
    this.selectedSource = undefined;
    this.selectedTargets.clear();
    this.selectedTarget = undefined;
  }

  protected getActiveSaveButton() {
    return this.selectedTargets.size !== 0;
  }

  protected onSave(): void {
    this.snackbar.loading('saving configuration..');

  }

  protected onDelete(): void {
    this.snackbar.loading('deleting configuration..');
  }

  protected clearSelection(): void {
    this.selectedRadioOption = undefined;
    this.removeSource();
  }
}