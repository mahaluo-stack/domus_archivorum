import { Pipe, PipeTransform } from '@angular/core';
import { inject, LOCALE_ID } from '@angular/core';

@Pipe({
  name: 'longDate',
  standalone: true
})
export class LongDatePipe implements PipeTransform {

  private readonly locale = inject(LOCALE_ID);
  transform(date: Date | null | undefined): string {

    if (!date) {
      return '';
    }

    return new Intl.DateTimeFormat(
      this.locale,
      {
        weekday: 'long',
        year: 'numeric',
        month: 'long',
        day: 'numeric'
      }
    ).format(date);
  }
}