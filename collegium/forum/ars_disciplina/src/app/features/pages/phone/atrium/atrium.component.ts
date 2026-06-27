import { Component, signal } from '@angular/core';
import { AtriumDateScrollComponent } from './atrium-date-scroll/atrium-date-scroll.component';
import { PageWrapperComponent } from "../../../components/phone/page-wrapper/page-wrapper.component";
import { PageHeaderComponent } from "../../../components/phone/page-header/page-header.component";
import { MenuNavigatorComponent } from "../../../components/phone/menu-navigator/menu-navigator.component";

@Component({
  selector: 'atrium-page',
  standalone: true,
  imports: [AtriumDateScrollComponent, PageWrapperComponent, PageHeaderComponent, MenuNavigatorComponent],
  templateUrl: './atrium.component.html',
  styleUrl: './atrium.component.scss'
})
export class AtriumComponent {
  
}


