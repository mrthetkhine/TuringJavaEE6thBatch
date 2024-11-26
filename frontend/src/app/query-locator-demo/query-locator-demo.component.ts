import {Component, ElementRef, viewChild} from '@angular/core';

@Component({
  selector: 'app-query-locator-demo',
  standalone: true,
  imports: [],
  templateUrl: './query-locator-demo.component.html',
  styleUrl: './query-locator-demo.component.css'
})
export class QueryLocatorDemoComponent {
  btnOk = viewChild<ElementRef<HTMLButtonElement>>('btnOk');

  cancelClick()
  {
    console.log('BtnOK ',this.btnOk());
  }
}
