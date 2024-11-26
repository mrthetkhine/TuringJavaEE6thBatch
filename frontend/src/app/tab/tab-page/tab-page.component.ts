import { Component } from '@angular/core';

@Component({
  selector: 'app-tab-page',
  standalone: true,
  imports: [],
  templateUrl: './tab-page.component.html',
  styleUrl: './tab-page.component.css'
})
export class TabPageComponent {
  hide = false;

  hideTabPage()
  {
    this.hide = true;
  }
  showTabPage()
  {
    this.hide = false;
  }
}
