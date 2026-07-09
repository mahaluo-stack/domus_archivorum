import { Location } from '@angular/common';
import {
  Component,
  computed,
  inject,
  signal
} from '@angular/core';
import {
  ActivatedRoute,
  NavigationEnd,
  Router
} from '@angular/router';
import { filter } from 'rxjs';
import { PageHeaderService } from '../../../../core/services/page.header.service';

@Component({
  selector: 'page-header',
  standalone: true,
  imports: [],
  templateUrl: './page-header.component.html',
  styleUrl: './page-header.component.scss'
})
export class PageHeaderComponent {

  private readonly router = inject(Router);
  private readonly activatedRoute = inject(ActivatedRoute);
  private readonly location = inject(Location);

  readonly header = inject(PageHeaderService);

  private readonly routeTitle = signal('');
  readonly showBackButton = signal(false);

  readonly title = computed(() =>
    this.header.titleOverride() ?? this.routeTitle()
  );

  constructor() {

    this.router.events
      .pipe(
        filter(event => event instanceof NavigationEnd)
      )
      .subscribe(() => {

        this.header.clearTitle();
        this.updateRouteData();

      });

    this.updateRouteData();
  }

  back(): void {
    this.location.back();
  }

  private updateRouteData(): void {

    let route = this.activatedRoute;

    while (route.firstChild) {
      route = route.firstChild;
    }

    const routeConfig = route.snapshot.routeConfig;

    this.routeTitle.set(
      routeConfig?.title?.toString() ?? ''
    );

    this.showBackButton.set(
      routeConfig?.data?.['root'] !== true
    );
  }
}