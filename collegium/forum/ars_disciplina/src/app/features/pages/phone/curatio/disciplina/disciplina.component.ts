import { Component, ElementRef, OnInit, ViewChild } from '@angular/core';
import { PageHeaderComponent } from "../../../../components/phone/page-header/page-header.component";

@Component({
  selector: 'disciplina',
  standalone: true,
  imports: [PageHeaderComponent],
  templateUrl: './disciplina.component.html',
  styleUrl: './disciplina.component.scss'
})
export class DisciplinaComponent implements OnInit {

  @ViewChild('blueprint', { static: true })
  blueprint!: ElementRef<HTMLDivElement>;

  ngOnInit(): void {

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
