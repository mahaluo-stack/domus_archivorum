import { Component } from '@angular/core';
import { DatePipe } from '@angular/common';

@Component({
  selector: 'atrium-date-scroll',
  standalone: true,
  imports: [DatePipe],
  templateUrl: './atrium-date-scroll.component.html',
  styleUrl: './atrium-date-scroll.component.scss'
})
export class AtriumDateScrollComponent {

  selectedDate = new Date();

  touchStartY = 0;
  translateY = 0;

  isAnimating = false;

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

    this.translateY =
      currentY - this.touchStartY;
  }

  onTouchEnd(): void {

    if (this.isAnimating) {
      return;
    }

    const threshold = window.innerHeight * 0.15;

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

    this.translateY = window.innerHeight;

    setTimeout(() => {

      this.selectedDate =
        this.addDays(this.selectedDate, -1);

      this.translateY = 0;

      this.isAnimating = false;

    }, 250);
  }

  private animateNextDay(): void {

    this.isAnimating = true;

    this.translateY = -window.innerHeight;

    setTimeout(() => {

      this.selectedDate =
        this.addDays(this.selectedDate, 1);

      this.translateY = 0;

      this.isAnimating = false;

    }, 250);
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