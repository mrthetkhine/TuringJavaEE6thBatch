import { Component } from '@angular/core';
import {HellWorldService} from "../services/hell-world.service";

@Component({
  selector: 'app-di-demo',
  standalone: true,
  imports: [],
  templateUrl: './di-demo.component.html',
  styleUrl: './di-demo.component.css'
})
export class DiDemoComponent {
  constructor(private helloWorldService: HellWorldService) {
    console.log('DiDemo created');
  }
  callApi()
  {
    console.log(this.helloWorldService.api());
  }
}
