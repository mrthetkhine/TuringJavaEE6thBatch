import { Component } from '@angular/core';
import {AuthService} from "../../../../core/services/auth.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-logout-page',
  standalone: true,
  imports: [],
  templateUrl: './logout-page.component.html',
  styleUrl: './logout-page.component.css'
})
export class LogoutPageComponent {

  constructor(private authService:AuthService,
              private router: Router,) {
  }
  logout()
  {
    this.authService.logout();
    this.router.navigate(['login']);
  }
}
