import { Component, input, output } from '@angular/core';

@Component({
  selector: 'editor-text-field',
  standalone: true,
  imports: [],
  templateUrl: './editor-text-field.component.html',
  styleUrl: './editor-text-field.component.scss'
})
export class EditorTextFieldComponent {

  readonly placeholder = input('');
  readonly value = input('');
  readonly disabled = input(false);
  readonly type = input('text');

  readonly valueChange = output<string>();

  protected onInput(event: Event): void {

    const value = (event.target as HTMLInputElement).value;

    this.valueChange.emit(value);
  }
}
