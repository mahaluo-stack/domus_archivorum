import {
  Component,
  EventEmitter,
  Input,
  Output
} from '@angular/core';
import { Region } from '../../../../core/models/types/anatomy.types';

@Component({
  selector: 'anatomia',
  standalone: true,
  templateUrl: './anatomia.component.html',
  styleUrls: ['./anatomia.component.scss']
})
export class AnatomiaComponent {

  @Input({ required: true }) regions: Region[] = [];
  @Input({ required: true }) viewBox = '';
  @Input() transform = {
    x: 0,
    y: 0,
    scale: 1
  };
  @Input() selectedIds = new Set<string>();
  @Output() regionClicked = new EventEmitter<Region>();

  click(region: Region) {
    this.regionClicked.emit(region);
  }

  protected isSelected(id: string): boolean {
    return this.selectedIds.has(id);
  }

  trackRegion(_: number, region: Region) {
    return region.id;
  }
}