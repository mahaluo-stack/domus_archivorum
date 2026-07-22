import { Component, computed, ElementRef, inject, OnInit, ViewChild } from '@angular/core';
import { PageHeaderComponent } from "../../../../components/phone/page-header/page-header.component";
import { EditorRadioComponent } from "../../../../components/responsive/editor-radio/editor-radio.component";
import { EditorSelectComponent } from "../../../../components/responsive/editor-select/editor-select.component";
import { DisciplinarumService } from '../../../../../core/services/api/disciplinarum.service';
import { toSignal } from '@angular/core/rxjs-interop';
import { EditorSelectOption } from '../../../../../core/models/ui/editor-select-option.interface';

@Component({
  selector: 'disciplina',
  standalone: true,
  imports: [PageHeaderComponent, EditorSelectComponent],
  templateUrl: './disciplina.component.html',
  styleUrl: './disciplina.component.scss'
})
export class DisciplinaComponent implements OnInit {

  @ViewChild('blueprint', { static: true })
  blueprint!: ElementRef<HTMLDivElement>;

  private readonly disciplinarumService = inject(DisciplinarumService);
  readonly exercises = this.disciplinarumService.exercises;
  
  ngOnInit(): void {
    this.disciplinarumService.loadExerciseData();
    this.updateGridOffset();
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
}
