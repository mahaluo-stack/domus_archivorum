import { Component, input, output } from '@angular/core';

@Component({
  selector: 'editor-icon-button',
  standalone: true,
  imports: [],
  templateUrl: './editor-icon-button.component.html',
  styleUrl: './editor-icon-button.component.scss'
})
export class EditorIconButtonComponent {

  readonly disabled = input(false);
  readonly active = input(false);
  readonly label = input('');
  readonly clicked = output();

  protected onClick(): void {
    this.clicked.emit();
  }
}
