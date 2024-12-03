import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class HiService {

  constructor() {
    console.log('Hi service instantiated');
  }
  api()
  {
    return "Hi";
  }
}
