import {Component, viewChild} from '@angular/core';
import {ExampleChildComponent} from "../example-child/example-child.component";

@Component({
  selector: 'app-view-child-demo',
  standalone: true,
  imports: [ExampleChildComponent],
  templateUrl: './view-child-demo.component.html',
  styleUrl: './view-child-demo.component.css'
})
export class ViewChildDemoComponent {
  exampleChild = viewChild(ExampleChildComponent);

  clickHandler()
  {
    this.exampleChild()?.api();
  }
}
