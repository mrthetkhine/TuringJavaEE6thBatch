import { Component } from '@angular/core';
import {UnlessDirective} from "../unless.directive";

@Component({
  selector: 'app-unless-demo',
  standalone: true,
  imports: [
    UnlessDirective
  ],
  templateUrl: './unless-demo.component.html',
  styleUrl: './unless-demo.component.css'
})
export class UnlessDemoComponent {
  condition = false;

  toggle()
  {
    this.condition = ! this.condition;
  }
}
