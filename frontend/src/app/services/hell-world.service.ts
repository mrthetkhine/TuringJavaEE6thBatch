import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class HellWorldService {

  constructor() {
    console.log('Instantiated HelloWorld service');
  }
  public api(){
    return "Hello";
  }
}
