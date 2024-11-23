import {Component, ViewEncapsulation} from '@angular/core';

@Component({
  selector: 'app-list-item',
  standalone: true,
  imports: [],
  templateUrl: './list-item.component.html',
  styleUrl: './list-item.component.css',
  /*encapsulation: ViewEncapsulation.None,*/
})
export class ListItemComponent {
    items:string[];
    constructor() {
      this.items = ['apple','Orange',"Banana"];
    }
}
