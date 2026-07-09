import { Component, input, output } from '@angular/core';

@Component({
  selector: 'editor-button',
  standalone: true,
  imports: [],
  templateUrl: './editor-button.component.html',
  styleUrl: './editor-button.component.scss'
})
export class EditorButtonComponent {

  readonly disabled = input(false);
  readonly active = input(false);
  readonly label = input('');
  readonly clicked = output();

  protected onClick(): void {
    this.clicked.emit();
  }
}
