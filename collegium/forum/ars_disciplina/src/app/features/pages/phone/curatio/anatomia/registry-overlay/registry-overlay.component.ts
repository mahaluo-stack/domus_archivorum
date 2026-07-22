import { Component, computed, inject, input, OnInit } from '@angular/core';
import { EditorSelectOption } from '../../../../../../core/models/ui/editor-select-option.interface';
import { EditorSelectComponent } from "../../../../../components/responsive/editor-select/editor-select.component";
import { EditorRadioComponent } from "../../../../../components/responsive/editor-radio/editor-radio.component";
import { EditorRadioOption } from '../../../../../../core/models/ui/editor-radio-option.interface';
import { toSignal } from '@angular/core/rxjs-interop';
import { MusculorumService } from '../../../../../../core/services/api/musculorum.service';
import { EditorTextFieldComponent } from "../../../../../components/responsive/editor-text-field/editor-text-field.component";
import { EditorIconButtonComponent } from "../../../../../components/responsive/editor-icon-button/editor-icon-button.component";
import { MusculiDTO } from '../../../../../../core/models/dto/musculorum/musculi.dto.interface';
import { MusculiParsDTO } from '../../../../../../core/models/dto/musculorum/musculi-pars.dto.interface';
import { MusculiRegioDTO } from '../../../../../../core/models/dto/musculorum/musculi-regio.dto.interface';
import { SnackbarService } from '../../../../../../core/services/snackbar.service';
import { Muscle } from '../../../../../../core/models/muscle/muscle.interface';
import { MuscleGroup } from '../../../../../../core/models/muscle/muscle-group.interface';
import { PetitioMusculi } from '../../../../../../core/models/dto/petitio/petitio-musculi.interface';
import { PetitioMusculiPars } from '../../../../../../core/models/dto/petitio/petitio-musculi-pars.interface';
import { PetitioMusculiRegio } from '../../../../../../core/models/dto/petitio/petitio-musculi-regio.interface';

@Component({
  selector: 'registry-overlay',
  standalone: true,
  imports: [EditorSelectComponent, EditorRadioComponent, EditorTextFieldComponent, EditorIconButtonComponent],
  templateUrl: './registry-overlay.component.html',
  styleUrl: './registry-overlay.component.scss'
})
export class RegistryOverlayComponent {

  private readonly musculorumService = inject(MusculorumService);
  private readonly snackbar = inject(SnackbarService);

  protected radioOptions: EditorRadioOption[] = [
    {
      value: 1,
      source: 'muscle parts',
      target: ''
    },
    {
      value: 2,
      source: 'muscles',
      target: ''
    },
    {
      value: 3,
      source: 'muscle groups',
      target: ''
    }
  ];

  protected get sourcePlaceholder(): string {
    if (!this.selectedRadioOption) {
      return 'select registry'
    }

    if (this.selectedRadioOption === 1) {
      return 'select muscle part';
    }

    if (this.selectedRadioOption === 2) {
      return 'select muscle'
    }

    if (this.selectedRadioOption === 3) {
      return 'select muscle group'
    }
    return ''
  };

  protected modifiedMuscleParts: MusculiParsDTO[] = [];
  protected modifiedMuscles: MusculiDTO[] = [];
  protected modifiedMuscleGroups: MusculiRegioDTO[] = [];

  readonly muscleOptions = input<EditorSelectOption[]>([]);
  readonly muscleGroupOptions = input<EditorSelectOption[]>([]);
  readonly musclePartOptions = input<EditorSelectOption[]>([]);

  protected selectedRadioOption: number | undefined;
  protected selectedSource?: number;
  protected nameTextFieldValue: string = '';
  protected descriptionTextFieldValue: string = '';

  protected sourceOptions: EditorSelectOption[] = [];

  protected disabledSourceSelect = true;
  protected disabledNameTextField = true;
  protected disabledDescriptionTextField = true;

  protected activeAddButton = false;
  protected activeCancelButton = false;
  private activeSaveButton = false;

  protected onSourceChange($event: number) {
    this.selectedSource = $event;
    this.activeSaveButton = false;
    this.disabledNameTextField = false;
    this.disabledDescriptionTextField = false;

    let source = this.sourceOptions[$event - 1];

    this.nameTextFieldValue = source.name;
    this.descriptionTextFieldValue = source.description;
  }

  protected onRadioEvent(value: number): void {
    this.clearSelection();

    this.selectedRadioOption = value;
    this.disabledSourceSelect = false;
    this.activeAddButton = true;
    this.activeCancelButton = true;

    if (value === 1) {
      this.sourceOptions = this.musclePartOptions();
    }
    if (value === 2) {
      this.sourceOptions = this.muscleOptions();
    }
    if (value === 3) {
      this.sourceOptions = this.muscleGroupOptions();
    }
  }

  protected getSourceName(): string {
    if (this.selectedSource) {
      return this.sourceOptions[this.selectedSource].name
    }
    return '';
  }

  protected getDisabledSourceSelect(): boolean {
    return this.disabledSourceSelect;
  }

  protected getDisabledNameTextField(): boolean {
    return this.disabledNameTextField;
  }

  protected getDisabledDescriptionTextField(): boolean {
    return this.disabledDescriptionTextField;
  }

  protected getSourceDescription(): string {
    if (this.selectedSource) {
      return this.sourceOptions[this.selectedSource].description;
    }
    return '';
  }

  protected onSave(): void {

    var petitio: PetitioMusculi | PetitioMusculiPars | PetitioMusculiRegio = {
      identitas: this.selectedSource ?? 0,
      nomen: this.nameTextFieldValue,
      descriptio: this.descriptionTextFieldValue
    }

    if (!this.selectedSource) {
      if (this.selectedRadioOption === 1) {
        this.snackbar
          .track(
            this.musculorumService.createMusclePart(petitio),
            'creating muscle part...'
          )
          .subscribe();
      }
      if (this.selectedRadioOption === 2) {
        this.snackbar
          .track(
            this.musculorumService.createMuscle(petitio),
            'creating muscle ...'
          )
          .subscribe();
      }
      if (this.selectedRadioOption === 3) {
        this.snackbar
          .track(
            this.musculorumService.createMuscleGroup(petitio),
            'creating muscle group...'
          )
          .subscribe();
      }
    }
    else {
      if (this.selectedRadioOption === 1) {
        this.snackbar
          .track(
            this.musculorumService.updateMusclePart(petitio),
            'updating muscle part...'
          )
          .subscribe();
      }
      if (this.selectedRadioOption === 2) {
        this.snackbar
          .track(
            this.musculorumService.updateMuscle(petitio),
            'updating muscle ...'
          )
          .subscribe();
      }
      if (this.selectedRadioOption === 3) {
        this.snackbar
          .track(
            this.musculorumService.updateMuscleGroup(petitio),
            'updating muscle group...'
          )
          .subscribe();
      }
    }
  }

  protected onDelete(): void {
    if (!this.selectedSource) {
      this.snackbar.info('make a selection first')
    }
    else {
      if (this.selectedRadioOption === 1) {
        this.snackbar
          .track(
            this.musculorumService.deleteMusclePart(this.selectedSource),
            'deleting muscle part...'
          )
          .subscribe();
      }

      if (this.selectedRadioOption === 2) {
        this.snackbar
          .track(
            this.musculorumService.deleteMuscle(this.selectedSource),
            'deleting muscle...'
          )
          .subscribe();
      }

      if (this.selectedRadioOption === 3) {
        this.snackbar
          .track(
            this.musculorumService.deleteMuscleGroup(this.selectedSource),
            'deleting muscle group...'
          )
          .subscribe();
      }
    }
  }

  protected clearSelection(): void {
    this.selectedSource = undefined;
    this.selectedRadioOption = undefined;
    this.disabledSourceSelect = true;
    this.disabledNameTextField = true;
    this.disabledDescriptionTextField = true;
    this.activeAddButton = false;
    this.activeCancelButton = false;
    this.activeSaveButton = false;
    this.nameTextFieldValue = '';
    this.descriptionTextFieldValue = '';
  }

  protected handleNameValueChange($value: string) {

    let existingSource = this.selectedSource;

    if (existingSource) {
      let modifiedSource = this.sourceOptions[existingSource];
      modifiedSource.name = $value;

      if (this.selectedRadioOption === 1) {
        this.modifiedMuscleParts.push({
          musculiParsIdentitas: modifiedSource.id,
          nomen: $value,
          descriptio: modifiedSource.description
        });
      }
      if (this.selectedRadioOption === 2) {
        this.modifiedMuscles.push({
          musculiIdentitas: modifiedSource.id,
          nomen: $value,
          descriptio: modifiedSource.description
        });
      }
      if (this.selectedRadioOption === 3) {
        this.modifiedMuscleGroups.push({
          musculiRegioIdentitas: modifiedSource.id,
          nomen: $value,
          descriptio: modifiedSource.description
        });
      }
    }
    else {

      if (this.selectedRadioOption === 1) {
        let descriptio = this.modifiedMuscleParts.find(mp => mp.nomen === $value)?.descriptio ?? '';

        this.modifiedMuscleParts.push({
          nomen: $value,
          descriptio: descriptio
        });
      }
      if (this.selectedRadioOption === 2) {
        let descriptio = this.modifiedMuscles.find(mp => mp.nomen === $value)?.descriptio ?? '';

        this.modifiedMuscles.push({
          nomen: $value,
          descriptio: descriptio
        });
      }
      if (this.selectedRadioOption === 3) {
        let descriptio = this.modifiedMuscleGroups.find(mp => mp.nomen === $value)?.descriptio ?? '';

        this.modifiedMuscleGroups.push({
          nomen: $value,
          descriptio: descriptio
        });
      }
    }

    this.activeSaveButton = true;
    this.disabledDescriptionTextField = false;
    this.nameTextFieldValue = $value;
  }

  protected handleDescriptionValueChange($value: string) {
    this.sourceOptions[this.selectedSource!].description = $value;
    this.activeSaveButton = true;
    this.descriptionTextFieldValue = $value;
  }

  protected getActiveSaveButton(): boolean {
    return this.activeSaveButton;
  }

  protected getActiveAddButton(): boolean {
    return this.activeAddButton;
  }

  protected getActiveCancelButton(): boolean {
    return this.activeCancelButton;
  }

  protected toggleAddPanel() {
    let selectedRadioOption = this.selectedRadioOption
    this.clearSelection();
    this.selectedRadioOption = selectedRadioOption;
    this.disabledSourceSelect = true;
    this.disabledNameTextField = false;
    this.disabledDescriptionTextField = true;
    this.activeAddButton = true;
    this.activeCancelButton = true;
  }
}
