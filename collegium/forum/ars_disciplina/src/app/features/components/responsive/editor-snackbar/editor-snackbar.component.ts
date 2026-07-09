import { Component, inject } from '@angular/core';
import { SnackbarService } from '../../../../core/services/snackbar.service';

@Component({
  selector: 'editor-snackbar',
  standalone: true,
  imports: [],
  templateUrl: './editor-snackbar.component.html',
  styleUrl: './editor-snackbar.component.scss'
})
export class EditorSnackbarComponent {

  readonly snackbar = inject(SnackbarService).current;
}
