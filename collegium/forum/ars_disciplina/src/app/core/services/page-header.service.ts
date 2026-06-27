import { Injectable, signal } from '@angular/core';

@Injectable({
    providedIn: 'root'
})
export class PageHeaderService {

    readonly titleOverride = signal<string | null>(null);

    setTitle(title: string): void {
        this.titleOverride.set(title);
    }

    clearTitle(): void {
        this.titleOverride.set(null);
    }
}