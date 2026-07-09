import { Injectable, signal } from '@angular/core';
import { Snackbar, SnackbarState } from '../models/interfaces/ui/editor.snackbar.types';

@Injectable({
  providedIn: 'root'
})
export class SnackbarService {

  private readonly snackbar = signal<Snackbar | null>(null);

  readonly current = this.snackbar.asReadonly();

  private timeout?: ReturnType<typeof setTimeout>;

  loading(message: string): SnackbarHandle {

    this.set({
      state: 'loading',
      message
    });

    return new SnackbarHandle(this);

  }

  success(message: string): void {

    this.complete('success', message);

  }

  error(message: string): void {

    this.complete('error', message);

  }

  warning(message: string): void {

    this.complete('warning', message);

  }

  info(message: string): void {

    this.complete('info', message);

  }

  private complete(
    state: SnackbarState,
    message: string,
    duration = 750
  ): void {

    this.set({
      state,
      message
    });

    this.timeout = setTimeout(() => {
      this.snackbar.set(null);
      this.timeout = undefined;
    }, duration);
  }

  private set(snackbar: Snackbar): void {

    if (this.timeout) {
      clearTimeout(this.timeout);
      this.timeout = undefined;
    }

    this.snackbar.set(snackbar);
  }
}

export class SnackbarHandle {

  constructor(
    private readonly snackbar: SnackbarService
  ) { }

  success(message: string): void {

    this.snackbar.success(message);
  }

  error(message: string): void {

    this.snackbar.error(message);
  }

  warning(message: string): void {

    this.snackbar.warning(message);
  }

  info(message: string): void {

    this.snackbar.info(message);
  }
}