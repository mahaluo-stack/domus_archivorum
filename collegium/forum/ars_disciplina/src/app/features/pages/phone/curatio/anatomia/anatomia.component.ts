import { Component, DestroyRef, ElementRef, inject, OnInit, signal, ViewChild } from '@angular/core';
import { PageHeaderComponent } from "../../../../components/phone/page-header/page-header.component";
import { AnatomiaSvgComponent } from "../../../../components/responsive/anatomia-svg/anatomia-svg.component";
import { takeUntilDestroyed } from '@angular/core/rxjs-interop';
import { Region, AnatomyView } from '../../../../../core/models/types/anatomy.types';
import { AnatomyService } from '../../../../../core/services/anatomy.service';
import { EditorOverlayComponent } from "./editor-overlay/editor-overlay.component";
import { RegistryOverlayComponent } from "./registry-overlay/registry-overlay.component";

enum Workspace {
  Editor = 0,
  Registry = 1
}

@Component({
  selector: 'app-anatomia',
  standalone: true,
  imports: [PageHeaderComponent, AnatomiaSvgComponent, EditorOverlayComponent, RegistryOverlayComponent],
  templateUrl: './anatomia.component.html',
  styleUrl: './anatomia.component.scss'
})
export class AnatomiaComponent implements OnInit {

  protected readonly Workspace = Workspace;


  protected editorExpanded = false;
  @ViewChild('blueprint', { static: true })
  blueprint!: ElementRef<HTMLDivElement>;


  currentWorkspace = Workspace.Editor;
  private startX = 0;

  pointerDown(event: PointerEvent) {
    this.startX = event.clientX;
  }

  pointerUp(event: PointerEvent) {

    const delta = event.clientX - this.startX;

    if (delta > 75) {
      this.previousWorkspace();
    }

    if (delta < -75) {
      this.nextWorkspace();
    }
  }

  nextWorkspace() {
    this.currentWorkspace = 1;
  }

  previousWorkspace() {
    this.currentWorkspace = 0;
  }

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
