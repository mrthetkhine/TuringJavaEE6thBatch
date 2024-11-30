import { Component } from '@angular/core';
import {ViewContainerRefDemoComponent} from "../view-container-ref-demo/view-container-ref-demo.component";

@Component({
  selector: 'app-outer-container',
  standalone: true,
  imports: [
    ViewContainerRefDemoComponent
  ],
  templateUrl: './outer-container.component.html',
  styleUrl: './outer-container.component.css'
})
export class OuterContainerComponent {

}
