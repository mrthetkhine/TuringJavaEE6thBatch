import { Component } from '@angular/core';

type Status ='loading'|'success'|'failed'
@Component({
  selector: 'app-switch-demo',
  standalone: true,
  imports: [],
  templateUrl: './switch-demo.component.html',
  styleUrl: './switch-demo.component.css'
})
export class SwitchDemoComponent {
  status :Status= 'loading';

  changeTo(type:Status)
  {
      this.status= type;
  }
}
