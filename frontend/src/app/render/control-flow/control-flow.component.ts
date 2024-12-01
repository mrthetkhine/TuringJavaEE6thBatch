import { Component } from '@angular/core';
import {FormsModule} from "@angular/forms";

interface User
{
  profile : {
    setting :{
      startDate :Date
    }
  }
}
@Component({
  selector: 'app-control-flow',
  standalone: true,
  imports: [FormsModule],
  templateUrl: './control-flow.component.html',
  styleUrl: './control-flow.component.css'
})
export class ControlFlowComponent {
  flag = true;

  price = 0;
  quantity = 0;

  user:User;
  constructor() {
    this.user = {
      profile:{
        setting:{
          startDate:new Date()
        }
      }
    }
  }
  toggle()
  {
    this.flag = !this.flag;
  }
}
