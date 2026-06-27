import {
  AfterViewInit,
  Component,
  ElementRef,
  OnDestroy,
  ViewChild
} from '@angular/core';
import { LongDatePipe } from '../../../../../core/pipes/long-date.pipe';

@Component({
  selector: 'atrium-date-scroll',
  standalone: true,
  imports: [LongDatePipe],
  templateUrl: './atrium-date-scroll.component.html',
  styleUrl: './atrium-date-scroll.component.scss'
})
export class AtriumDateScrollComponent implements AfterViewInit, OnDestroy {

  selectedDate = new Date();

  touchStartY = 0;
  translateY = 0;

  isAnimating = false;
  containerHeight = 0;

  private resizeObserver?: ResizeObserver;

  @ViewChild('atriumDateSwipeContainer')
  private swipeContainer!: ElementRef<HTMLDivElement>;

  ngAfterViewInit(): void {

    this.updateContainerHeight();

    this.resizeObserver = new ResizeObserver(() => {
      this.updateContainerHeight();
    });

    this.resizeObserver.observe(
      this.swipeContainer.nativeElement
    );
  }

  ngOnDestroy(): void {
    this.resizeObserver?.disconnect();
  }

  get stackTransform(): string {
    return `translateY(calc(-100% + ${this.translateY}px))`;
  }

  get pages(): Date[] {

    return [
      this.addDays(this.selectedDate, -1),
      this.selectedDate,
      this.addDays(this.selectedDate, 1)
    ];
  }

  onTouchStart(event: TouchEvent): void {

    if (this.isAnimating) {
      return;
    }

    this.touchStartY = event.touches[0].clientY;
  }

  onTouchMove(event: TouchEvent): void {

    if (this.isAnimating) {
      return;
    }

    const currentY = event.touches[0].clientY;

    this.translateY = currentY - this.touchStartY;
  }

  onTouchEnd(): void {

    if (this.isAnimating) {
      return;
    }

    const threshold = this.containerHeight * 0.15;

    if (this.translateY > threshold) {
      this.animatePreviousDay();
      return;
    }

    if (this.translateY < -threshold) {
      this.animateNextDay();
      return;
    }

    this.translateY = 0;
  }

  private animatePreviousDay(): void {

    this.isAnimating = true;

    this.translateY = this.containerHeight;

    setTimeout(() => {

      this.selectedDate =
        this.addDays(this.selectedDate, -1);

      this.translateY = 0;
      this.isAnimating = false;

    }, 250);
  }

  private animateNextDay(): void {

    this.isAnimating = true;

    this.translateY = -this.containerHeight;

    setTimeout(() => {

      this.selectedDate =
        this.addDays(this.selectedDate, 1);

      this.translateY = 0;
      this.isAnimating = false;

    }, 250);
  }

  private updateContainerHeight(): void {

    this.containerHeight =
      this.swipeContainer.nativeElement.clientHeight;
  }

  private addDays(
    date: Date,
    days: number
  ): Date {

    const result = new Date(date);

    result.setDate(
      result.getDate() + days
    );

    return result;
  }

  trackByDate(
    _: number,
    date: Date
  ): number {

    return date.getTime();
  }
}