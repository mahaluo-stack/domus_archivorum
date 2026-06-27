import { Component, DestroyRef, ElementRef, inject, OnInit, ViewChild } from '@angular/core';
import { PageHeaderComponent } from "../../../../components/phone/page-header/page-header.component";
import { AnatomiaComponent } from "../../../../components/responsive/anatomia/anatomia.component";
import { takeUntilDestroyed } from '@angular/core/rxjs-interop';
import { Region, AnatomyView } from '../../../../../core/models/types/anatomy.types';
import { AnatomyService } from '../../../../../core/services/anatomy.service';
import { EditorOverlayComponent } from "./editor-overlay/editor-overlay.component";
import { EditorOption } from '../../../../../core/models/interfaces/ui/editor.option.interface';

@Component({
  selector: 'app-anatomia-wrapper',
  standalone: true,
  imports: [PageHeaderComponent, AnatomiaComponent, EditorOverlayComponent],
  templateUrl: './anatomia-wrapper.component.html',
  styleUrl: './anatomia-wrapper.component.scss'
})
export class AnatomiaWrapperComponent implements OnInit {
  saveRelationships() {
  }
  protected editorExpanded = false;
  @ViewChild('blueprint', { static: true })
  blueprint!: ElementRef<HTMLDivElement>;
  protected sourceOptions: EditorOption<string>[] = [
    {
      value: 'pec-major',
      label: 'Pectoralis Major'
    },
    {
      value: 'lat',
      label: 'Latissimus Dorsi'
    },
    {
      value: 'trap',
      label: 'Trapezius'
    }
  ];
  protected relationshipOptions: EditorOption<string>[] = [
    {
      value: 'muscle-group',
      label: 'muscle → muscle group'
    },
    {
      value: 'part-muscle',
      label: 'muscle parts → muscle'
    },
    {
      value: 'part-exercise',
      label: 'muscle parts → exercise'
    }
  ];

  ngOnInit(): void {
    this.updateGridOffset();
    this.loadSvg();
  }

  private updateGridOffset(): void {
    const grid = 64;

    const width = this.blueprint.nativeElement.clientWidth;
    const height = this.blueprint.nativeElement.clientHeight;

    const offsetX = (width / 2) % grid;
    const offsetY = (height / 2) % grid;

    this.blueprint.nativeElement.style.setProperty('--grid-x', `${offsetX}px`);
    this.blueprint.nativeElement.style.setProperty('--grid-y', `${offsetY}px`);
  }
  private readonly anatomyService = inject(AnatomyService);
  private readonly destroyRef = inject(DestroyRef);

  protected regions: Region[] = [];

  protected viewBox = '';

  protected transform = {
    x: 0,
    y: 0,
    scale: 1
  };

  protected selectedRegions = new Set<string>();

  protected currentSex: 'male' | 'female' = 'male';
  protected currentSide: 'front' | 'back' = 'front';

  private loadSvg(): void {

    const view =
      `${this.currentSex}-${this.currentSide}` as AnatomyView;

    this.anatomyService
      .load(view)
      .pipe(takeUntilDestroyed(this.destroyRef))
      .subscribe(anatomy => {

        this.regions = anatomy.regions;
        this.viewBox = anatomy.viewBox;
        this.transform = anatomy.transform;

      });

  }

  protected onRegionClicked(region: Region): void {

    const selected = new Set(this.selectedRegions);

    if (selected.has(region.id)) {
      selected.delete(region.id);
    } else {
      selected.add(region.id);
    }

    this.selectedRegions = selected;
  }

  protected toggleSide(): void {

    this.currentSide =
      this.currentSide === 'front'
        ? 'back'
        : 'front';

    this.selectedRegions = new Set();

    this.loadSvg();
  }

  protected toggleSex(): void {

    this.currentSex =
      this.currentSex === 'male'
        ? 'female'
        : 'male';

    this.selectedRegions = new Set();

    this.loadSvg();
  }

  protected get allRegionsSelected(): boolean {
    return this.selectedRegions.size === this.regions.length;
  }

  protected toggleRegionSelection(): void {

    if (this.allRegionsSelected) {

      this.selectedRegions = new Set();

    } else {

      this.selectedRegions = new Set(
        this.regions.map(r => r.id)
      );

    }
  }

}
