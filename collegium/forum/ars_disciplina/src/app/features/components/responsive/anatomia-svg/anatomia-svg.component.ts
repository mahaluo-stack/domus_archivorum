import {
  Component,
  EventEmitter,
  Input,
  Output
} from '@angular/core';
import { Region } from '../../../../core/models/types/anatomy.types';
import { MusclePart } from '../../../../core/models/interfaces/muscle/muscle.part.interface';

@Component({
  selector: 'anatomia-svg',
  standalone: true,
  templateUrl: './anatomia-svg.component.html',
  styleUrls: ['./anatomia-svg.component.scss']
})
export class AnatomiaSvgComponent {

  @Input({ required: true }) regions: Region[] = [];
  @Input({ required: true }) viewBox = '';
  @Input() transform = {
    x: 0,
    y: 0,
    scale: 1
  };
  @Input() selectedIds = new Set<string>();
  @Input() muscleParts = new Set<MusclePart>();
  @Output() regionClicked = new EventEmitter<Region>();

  click(region: Region) {
    console.log('region:', region)
    this.regionClicked.emit(region);
  }

  protected isSelected(id: string): boolean {
    return this.selectedIds.has(id);
  }

  trackRegion(_: number, region: Region) {
    return region.id;
  }
}