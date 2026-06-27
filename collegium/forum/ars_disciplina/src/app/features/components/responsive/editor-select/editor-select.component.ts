import {
  Component,
  ElementRef,
  EventEmitter,
  HostListener,
  Input,
  Output,
  ViewChild,
} from '@angular/core';
import { EditorOption } from '../../../../core/models/interfaces/ui/editor.option.interface';

@Component({
  selector: 'editor-select',
  standalone: true,
  templateUrl: './editor-select.component.html',
  styleUrls: ['./editor-select.component.scss']
})
export class EditorSelectComponent<T = unknown> {

  @ViewChild('container', { static: true })
  protected container!: ElementRef<HTMLDivElement>;

  @Input({ required: true })
  label = '';

  @Input()
  placeholder = 'Select...';

  @Input({ required: true })
  options: EditorOption<T>[] = [];

  @Input()
  value?: T;

  @Output()
  valueChange = new EventEmitter<T>();

  protected expanded = false;

  protected toggle(): void {
    this.expanded = !this.expanded;
  }

  protected select(option: EditorOption<T>): void {

    this.value = option.value;
    this.expanded = false;

    this.valueChange.emit(option.value);
  }

  protected get selectedLabel(): string {

    const option = this.options.find(o => o.value === this.value);
    return option?.label ?? this.placeholder;
  }

  protected isSelected(option: EditorOption<T>): boolean {
    return option.value === this.value;
  }

  @HostListener('document:click', ['$event'])
  protected onDocumentClick(event: MouseEvent): void {

    if (!this.expanded) {
      return;
    }

    if (!this.container.nativeElement.contains(event.target as Node)) {
      this.expanded = false;
    }
  }
}