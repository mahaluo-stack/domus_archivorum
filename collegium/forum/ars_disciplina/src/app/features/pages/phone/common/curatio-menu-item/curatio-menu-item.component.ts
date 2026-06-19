import { Component } from '@angular/core';
import { ReturnButtonComponent } from '../../common/return-button/return-button.component';

@Component({
  selector: 'curatio-menu-item',
  standalone: true,
  imports: [ReturnButtonComponent],
  templateUrl: './curatio-menu-item.component.html',
  styleUrl: './curatio-menu-item.component.scss'
})
export class CuratioMenuItemComponent {

}
