import { Component, signal } from '@angular/core';
import { AtriumDateScrollComponent } from './atrium-date-scroll/atrium-date-scroll.component';

@Component({
  selector: 'responsive-atrium-component',
  standalone: true,
  imports: [AtriumDateScrollComponent],
  templateUrl: './atrium.component.html',
  styleUrl: './atrium.component.scss'
})
export class AtriumComponent {
  
}


