import { Component } from '@angular/core';
import { Location } from '@angular/common';
import { MatIconModule } from '@angular/material/icon';

@Component({
  selector: 'return-button',
  standalone: true,
  imports: [
    MatIconModule
  ],
  templateUrl: './return-button.component.html',
  styleUrl: './return-button.component.scss'
})
export class ReturnButtonComponent {

  constructor(
    private location: Location
  ) { }

  navigateBack(): void {

    this.location.back();
  }
}