import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import {HelloWorldComponent} from "./hello-world/hello-world.component";
import {ListItemComponent} from "./list-item/list-item.component";
import {UserAccountComponent} from "./user-account/user-account.component";

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [
    RouterOutlet,
    HelloWorldComponent,
    ListItemComponent,
    UserAccountComponent,
  ],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'frontend';
}
