import {
  Component,
  inject,
  input,
  OnInit
} from '@angular/core';
import { EditorSelectOption } from '../../../../../../core/models/ui/editor-select-option.interface';
import { EditorSelectComponent } from '../../../../../components/responsive/editor-select/editor-select.component';
import { EditorRadioOption } from '../../../../../../core/models/ui/editor-radio-option.interface';
import { EditorRadioComponent } from "../../../../../components/responsive/editor-radio/editor-radio.component";
import { EditorIconButtonComponent } from "../../../../../components/responsive/editor-icon-button/editor-icon-button.component";
import { SnackbarService } from '../../../../../../core/services/snackbar.service';
import { NexuumService } from '../../../../../../core/services/api/nexuum.service';
import { PetitioConfiguratioMusculi } from '../../../../../../core/models/dto/petitio/petitio-configuratio-musculi.interface';
import { MuscleConfig } from '../../../../../../core/models/muscle/muscle-config.interface';

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
export class EditorOverlayComponent {

  private readonly snackbar = inject(SnackbarService);
  private readonly nexuumService = inject(NexuumService);

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

  readonly muscleOptions = input<EditorSelectOption[]>([]);
  readonly muscleGroupOptions = input<EditorSelectOption[]>([]);
  readonly musclePartOptions = input<EditorSelectOption[]>([]);
  readonly muscleConfig = this.nexuumService.muscleConfig;
  readonly muscleGroupConfig = this.nexuumService.muscleGroupConfig;

  protected getMuscleConfiguration(muscleId: number): MuscleConfig | null {
    return this.muscleConfig().find(it => muscleId === it.muscleId) ?? null
  }

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
    return this.targetOptions[id - 1].name
  }

  getSourceLabel(): string {
    if (this.selectedSource) {
      return this.sourceOptions[this.selectedSource - 1].name;
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

    if (!this.selectedRadioOption) {
      this.snackbar.info('select a configuration type first')
      return
    }

    if (!this.selectedSource) {
      this.snackbar.info('to save a configuration, select a source')
      return
    }

    if (!this.selectedTargets || this.selectedTargets.size === 0) {
      this.snackbar.info('to save a configuration, select targets')
      return
    }

    if (this.selectedRadioOption === 1) {

      let muscleConfig: PetitioConfiguratioMusculi = {
        musculiIdentitas: this.selectedSource!,
        musculiParsIdentitates: [...this.selectedTargets]
      }

      this.snackbar
        .track(
          this.nexuumService.updateMuscleConfiguration(muscleConfig),
          'saving muscle configuration...'
        )
        .subscribe();
    }
  }

  protected onDelete(): void {

    if (!this.selectedSource) {
      this.snackbar.info('select a configuration to delete first')
    }
    else {

      if (this.selectedRadioOption === 1) {
        this.snackbar
          .track(
            this.nexuumService.deleteMuscleConfiguration(this.selectedSource),
            'deleting muscle configuration...'
          )
          .subscribe();
      }

    }
  }

  protected clearSelection(): void {
    this.selectedRadioOption = undefined;
    this.removeSource();
  }
}