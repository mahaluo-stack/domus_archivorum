import {
  Component,
  EventEmitter,
  Input,
  Output,
} from '@angular/core';
import { EditorOption } from '../../../../../../core/models/interfaces/ui/editor.option.interface';
import { EditorSelectComponent } from '../../../../../components/responsive/editor-select/editor-select.component';

@Component({
  selector: 'editor-overlay',
  standalone: true,
  imports: [
    EditorSelectComponent
  ],
  templateUrl: './editor-overlay.component.html',
  styleUrls: ['./editor-overlay.component.scss']
})
export class EditorOverlayComponent {

  @Input({ required: true })
  selectedCount = 0;

  @Input()
  expanded = false;

  @Output()
  expandedChange = new EventEmitter<boolean>();

  @Input({ required: true })
  relationshipOptions: EditorOption<string>[] = [];

  @Input()
  selectedRelationship?: string;

  @Output()
  selectedRelationshipChange = new EventEmitter<string>();

  @Input({ required: true })
  sourceOptions: EditorOption<string>[] = [];

  @Input()
  selectedSource?: string;

  @Output()
  selectedSourceChange = new EventEmitter<string>();

  @Output()
  save = new EventEmitter<void>();

  protected toggleExpanded(): void {

    this.expanded = !this.expanded;

    this.expandedChange.emit(this.expanded);

  }

  protected relationshipChanged(value: string): void {

    this.selectedRelationship = value;

    this.selectedRelationshipChange.emit(value);

  }

  protected sourceChanged(value: string): void {

    this.selectedSource = value;

    this.selectedSourceChange.emit(value);

  }

  protected onSave(): void {

    this.save.emit();

  }

}