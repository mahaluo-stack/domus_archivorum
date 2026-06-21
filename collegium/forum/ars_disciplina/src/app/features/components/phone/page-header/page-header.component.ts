import { Location } from '@angular/common';
import { Component, inject } from '@angular/core';
import { Router, NavigationEnd } from '@angular/router';
import { filter } from 'rxjs';

@Component({
  selector: 'page-header',
  standalone: true,
  imports: [],
  templateUrl: './page-header.component.html',
  styleUrl: './page-header.component.scss'
})
export class PageHeaderComponent {

  private readonly router = inject(Router);
  private readonly location = inject(Location);

  title = '';
  showBackButton = false;

  constructor() {

    this.router.events
      .pipe(
        filter(event => event instanceof NavigationEnd)
      )
      .subscribe(() => this.updateHeader());

    this.updateHeader();
  }

  back(): void {
    this.location.back();
  }

  private updateHeader(): void {

    const route = this.router.config.find(r => r.path === this.router.url.substring(1));

    this.title = route?.title?.toString() ?? '';
    this.showBackButton = route?.data?.['root'] !== true;
  }
}
