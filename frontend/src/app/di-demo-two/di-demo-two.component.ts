import { Component } from '@angular/core';
import {HellWorldService} from "../services/hell-world.service";
import {HiService} from "../services/hi.service";
import {ServiceThreeService} from "../services/service-three.service";

@Component({
  selector: 'app-di-demo-two',
  standalone: true,
  imports: [],
  templateUrl: './di-demo-two.component.html',
  styleUrl: './di-demo-two.component.css'
})
export class DiDemoTwoComponent {
  constructor(private helloWorldService: HellWorldService,
              private hiService:HiService,
              private serviceThree: ServiceThreeService) {
    console.log('DiDemoTwo  created');
  }
  callApi()
  {
    console.log('HelloWorld ',this.helloWorldService.api());
    console.log('Hiservice ',this.hiService.api());
  }
}
