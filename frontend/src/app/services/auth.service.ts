import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  isAuthenticated = false;
  constructor() { }

  login()
  {
    this.isAuthenticated = true;
    console.log('Loginned successfully');
  }

}
