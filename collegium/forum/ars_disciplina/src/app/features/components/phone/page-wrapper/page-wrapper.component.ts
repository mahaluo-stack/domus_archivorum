import { Component } from '@angular/core';
import { ReturnButtonComponent } from '../return-button/return-button.component';
import { PageTitleComponent } from "../page-title/page-title.component";

@Component({
  selector: 'page-wrapper',
  standalone: true,
  imports: [ReturnButtonComponent, PageTitleComponent],
  templateUrl: './page-wrapper.component.html',
  styleUrl: './page-wrapper.component.scss'
})
export class PageWrapperComponent {

}
