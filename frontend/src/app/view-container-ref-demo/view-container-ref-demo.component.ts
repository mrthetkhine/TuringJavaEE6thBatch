import {Component, ViewContainerRef} from '@angular/core';
import {LeaftComponentComponent} from "../leaft-component/leaft-component.component";
import {HelloWorldComponent} from "../hello-world/hello-world.component";

@Component({
  selector: 'app-view-container-ref-demo',
  standalone: true,
  imports: [
    LeaftComponentComponent,
    HelloWorldComponent,
  ],
  templateUrl: './view-container-ref-demo.component.html',
  styleUrl: './view-container-ref-demo.component.css'
})
export class ViewContainerRefDemoComponent {
  constructor(private viewContainer: ViewContainerRef) {}
  loadContent() {
    this.viewContainer.createComponent(LeaftComponentComponent);
  }
  loadContent2()
  {
    this.viewContainer.createComponent(HelloWorldComponent);
  }
}
