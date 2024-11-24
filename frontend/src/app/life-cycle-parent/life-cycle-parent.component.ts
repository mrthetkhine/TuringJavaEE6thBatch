import { Component } from '@angular/core';
import {LifeCycleDemoComponent} from "../life-cycle-demo/life-cycle-demo.component";

@Component({
  selector: 'app-life-cycle-parent',
  standalone: true,
  imports: [LifeCycleDemoComponent],
  templateUrl: './life-cycle-parent.component.html',
  styleUrl: './life-cycle-parent.component.css'
})
export class LifeCycleParentComponent {
  data =0;

  update()
  {
    this.data++;
  }
}
