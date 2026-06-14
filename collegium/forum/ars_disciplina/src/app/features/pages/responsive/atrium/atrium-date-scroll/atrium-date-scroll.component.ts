import { DatePipe } from '@angular/common';
import { Component, ElementRef, ViewChild, AfterViewInit, ViewChildren, QueryList } from '@angular/core';

@Component({
  selector: 'responsive-atrium-date-scroll',
  standalone: true,
  imports: [DatePipe],
  templateUrl: './atrium-date-scroll.component.html',
  styleUrl: './atrium-date-scroll.component.scss'
})
export class AtriumDateScrollComponent implements AfterViewInit {

  @ViewChild('atriumScrollContainer')
  scrollContainer!: ElementRef<HTMLDivElement>;

  @ViewChildren('atriumScrollCard')
  cards!: QueryList<ElementRef<HTMLDivElement>>;

  dates: Date[] = [];
  selectedIndex = 0;
  private readonly batchSize = 100;

  constructor() {
    this.generateInitialDates();
  }

  ngAfterViewInit(): void {
    queueMicrotask(() => {
      const container = this.scrollContainer.nativeElement;
      container.scrollTop = container.scrollHeight / 2 - container.clientHeight / 2;
    });
  }

  onScroll(): void {
    const container = this.scrollContainer.nativeElement;

    if (container.scrollTop < 500) {
      this.prependDates();
    }

    if (
      container.scrollTop + container.clientHeight >
      container.scrollHeight - 500
    ) {
      this.appendDates();
    }

    this.updateSelectedCard();
  }

  private updateSelectedCard(): void {

    const containerRect =
      this.scrollContainer.nativeElement.getBoundingClientRect();

    const containerCenter =
      containerRect.top + containerRect.height / 2;

    let closestIndex = 0;
    let closestDistance = Number.MAX_VALUE;

    this.cards.forEach((card, index) => {

      const rect = card.nativeElement.getBoundingClientRect();

      const cardCenter =
        rect.top + rect.height / 2;

      const distance =
        Math.abs(containerCenter - cardCenter);

      if (distance < closestDistance) {
        closestDistance = distance;
        closestIndex = index;
      }
    });

    this.selectedIndex = closestIndex;
  }

  private generateInitialDates(): void {
    const today = new Date();

    for (let i = -this.batchSize; i <= this.batchSize; i++) {
      const date = new Date(today);
      date.setDate(today.getDate() + i);

      this.dates.push(date);
    }
  }

  private prependDates(): void {
    const container = this.scrollContainer.nativeElement;
    const previousHeight = container.scrollHeight;

    const firstDate = this.dates[0];

    const newDates: Date[] = [];

    for (let i = this.batchSize; i >= 1; i--) {
      const date = new Date(firstDate);
      date.setDate(firstDate.getDate() - i);

      newDates.push(date);
    }

    this.dates = [...newDates, ...this.dates];

    queueMicrotask(() => {
      container.scrollTop += container.scrollHeight - previousHeight;
    });
  }

  private appendDates(): void {
    const lastDate = this.dates[this.dates.length - 1];

    for (let i = 1; i <= this.batchSize; i++) {
      const date = new Date(lastDate);
      date.setDate(lastDate.getDate() + i);

      this.dates.push(date);
    }
  }

  trackByDate(_: number, date: Date): number {
    return date.getTime();
  }
}