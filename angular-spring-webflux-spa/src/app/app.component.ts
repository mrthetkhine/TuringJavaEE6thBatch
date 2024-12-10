import { Component } from '@angular/core';
import {RouterLink, RouterLinkActive, RouterOutlet} from '@angular/router';
import {CommonModule, NgIf} from "@angular/common";

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [
    CommonModule,
    RouterLink,
    RouterLinkActive,
    NgIf,
    RouterOutlet,


  ],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'angular-spring-webflux-spa';
}
