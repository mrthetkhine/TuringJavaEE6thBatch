import { Component } from '@angular/core';
import {NgFor, NgIf} from "@angular/common";

@Component({
  selector: 'app-if-demo',
  standalone: true,
  imports: [
    NgIf,
    NgFor,
  ],
  templateUrl: './if-demo.component.html',
  styleUrl: './if-demo.component.css'
})
export class IfDemoComponent {
  flag = true;
  items = ['Apple','orange','Banana']
  toggle()
  {
    this.flag = !this.flag;
  }
}
