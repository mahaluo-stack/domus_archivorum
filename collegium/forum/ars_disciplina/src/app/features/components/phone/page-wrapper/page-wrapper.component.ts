import { Component } from '@angular/core';
import { MenuNavigatorComponent } from "../menu-navigator/menu-navigator.component";
import { PageHeaderComponent } from "../page-header/page-header.component";

@Component({
  selector: 'page-wrapper',
  standalone: true,
  imports: [MenuNavigatorComponent, PageHeaderComponent],
  templateUrl: './page-wrapper.component.html',
  styleUrl: './page-wrapper.component.scss'
})
export class PageWrapperComponent {

}
