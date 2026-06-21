import { Component, inject } from '@angular/core';
import { ActivatedRoute, NavigationEnd, Router } from '@angular/router';
import { filter } from 'rxjs/operators';

@Component({
  selector: 'page-title',
  standalone: true,
  templateUrl: './page-title.component.html',
  styleUrl: './page-title.component.scss'
})
export class PageTitleComponent {

  private readonly router = inject(Router);
  private readonly activatedRoute = inject(ActivatedRoute);

  title = '';

  constructor() {
    this.router.events
      .pipe(
        filter(event => event instanceof NavigationEnd)
      )
      .subscribe(() => this.updateTitle());

    this.updateTitle();
  }

  private updateTitle(): void {

    let route = this.activatedRoute;

    while (route.firstChild) {
      route = route.firstChild;
    }

    this.title = route.snapshot['title'] ?? '';
  }
}