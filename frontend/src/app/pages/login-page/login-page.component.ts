import { Component } from '@angular/core';
import {AuthService} from "../../services/auth.service";
import {ActivatedRoute} from "@angular/router";

@Component({
  selector: 'app-login-page',
  standalone: true,
  imports: [],
  templateUrl: './login-page.component.html',
  styleUrl: './login-page.component.css'
})
export class LoginPageComponent {
  redirectUrl ='';
  constructor(
    private route: ActivatedRoute,
    private authService:AuthService,) {
  }
  ngOnInit() {
    this.route.queryParams.subscribe(params => {
      this.redirectUrl = params['redirectUrl'];
      console.log('Redirect url ',this.redirectUrl);
    });
  }
  login()
  {
    this.authService.login();
  }
}
