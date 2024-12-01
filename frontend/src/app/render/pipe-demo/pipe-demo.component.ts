import { Component } from '@angular/core';
import {CurrencyPipe, DatePipe, TitleCasePipe, UpperCasePipe} from "@angular/common";
import {AllCapitalPipe} from "../all-capital.pipe";

@Component({
  selector: 'app-pipe-demo',
  standalone: true,
  imports: [CurrencyPipe, DatePipe, TitleCasePipe,UpperCasePipe,AllCapitalPipe],
  templateUrl: './pipe-demo.component.html',
  styleUrl: './pipe-demo.component.css'
})
export class PipeDemoComponent {
  now:Date;
  amount = 123.45;
  company = 'acme corporation';
  constructor() {
    this.now = new Date();

  }


}
