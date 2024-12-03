import { Injectable } from '@angular/core';
import {HiService} from "./hi.service";

@Injectable({
  providedIn: 'root'
})
export class ServiceThreeService {

  constructor(private hiService:HiService) {
    console.log('Service three created');
  }
  api():string
  {
    return 'servicee three'+this.hiService.api();
  }
}
