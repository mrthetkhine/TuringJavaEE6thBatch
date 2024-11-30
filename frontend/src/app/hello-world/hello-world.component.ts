import { Component } from '@angular/core';
import {GreetComponent} from "../greet/greet.component";

@Component({
  selector: 'app-hello-world',
  standalone: true,
  imports: [
    GreetComponent,
  ],
  templateUrl: './hello-world.component.html',
  styleUrl: './hello-world.component.css'
})
export class HelloWorldComponent {
  name:string="<h1>hi World</h1>";
}
