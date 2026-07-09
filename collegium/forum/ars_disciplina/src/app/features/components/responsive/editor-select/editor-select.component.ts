import {
  Component,
  ElementRef,
  EventEmitter,
  HostListener,
  Input,
  Output,
  ViewChild,
} from '@angular/core';
import { EditorSelectOption } from '../../../../core/models/interfaces/ui/editor.select.option.interface';

@Component({
  selector: 'editor-select',
  standalone: true,
  templateUrl: './editor-select.component.html',
  styleUrls: ['./editor-select.component.scss']
})
export class EditorSelectComponent<T = unknown> {

  @ViewChild('container', { static: true })
  protected container!: ElementRef<HTMLDivElement>;

  @Input({ required: false })
  disabled = false;

  @Input()
  placeholder = 'select...';

  @Input({ required: true })
  options: EditorSelectOption[] = [];

  @Input()
  value?: number;

  @Output()
  valueChange = new EventEmitter<number>();

  protected expanded = false;

  protected toggle(): void {
    this.expanded = this.disabled ? false : !this.expanded;
  }

  get hasValue(): boolean {
    return this.value !== null && this.selectedLabel !== this.placeholder;
  }

  protected select(option: EditorSelectOption): void {

    this.value = option.id;
    this.expanded = false;

    this.valueChange.emit(option.id);
  }

  protected get selectedLabel(): string {
    const option = this.options.find(o => o.id === this.value);
    return option?.label ?? this.placeholder;
  }

  protected isSelected(option: EditorSelectOption): boolean {
    return option.id === this.value;
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