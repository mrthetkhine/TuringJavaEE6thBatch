import { Component } from '@angular/core';
import {TimesDirective} from "../times.directive";

@Component({
  selector: 'app-times-demo',
  standalone: true,
  imports: [
    TimesDirective
  ],
  templateUrl: './times-demo.component.html',
  styleUrl: './times-demo.component.css'
})
export class TimesDemoComponent {

}
