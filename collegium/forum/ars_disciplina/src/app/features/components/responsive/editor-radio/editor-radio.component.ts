import { Component, EventEmitter, input, Input, Output } from '@angular/core';
import { EditorRadioOption } from '../../../../core/models/ui/editor-radio-option.interface';

@Component({
  selector: 'editor-radio',
  standalone: true,
  imports: [],
  templateUrl: './editor-radio.component.html',
  styleUrl: './editor-radio.component.scss'
})
export class EditorRadioComponent {

  readonly selectedValue = input<number | undefined>(undefined);

  @Input({ required: true})
  options: EditorRadioOption[] = [];

  @Input()
  label?: string;

  @Output()
  clicked = new EventEmitter<number>();
  
  protected select(option: EditorRadioOption): void {
    this.clicked.emit(option.value);
  }
}
