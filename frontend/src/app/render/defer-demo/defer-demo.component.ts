import { Component } from '@angular/core';
import {DeferContainerComponent} from "../defer-container/defer-container.component";

@Component({
  selector: 'app-defer-demo',
  standalone: true,
  imports: [DeferContainerComponent],
  templateUrl: './defer-demo.component.html',
  styleUrl: './defer-demo.component.css'
})
export class DeferDemoComponent {

}
