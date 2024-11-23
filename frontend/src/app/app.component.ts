import {Component, signal} from '@angular/core';
import { RouterOutlet } from '@angular/router';
import {HelloWorldComponent} from "./hello-world/hello-world.component";
import {ListItemComponent} from "./list-item/list-item.component";
import {UserAccountComponent} from "./user-account/user-account.component";
import {TodoListComponent} from "./todo-list/todo-list.component";
import {GreetingComponent} from "./greeting/greeting.component";
import {CustomSliderComponent} from "./custom-slider/custom-slider.component";
import {GreetComponent} from "./greet/greet.component";
import {InputWithGetterSetterComponent} from "./input-with-getter-setter/input-with-getter-setter.component";
import {CounterComponent} from "./counter/counter.component";

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [
    RouterOutlet,
    HelloWorldComponent,
    ListItemComponent,
    UserAccountComponent,
    TodoListComponent,
    GreetingComponent,
    CustomSliderComponent,
    GreetComponent,
    InputWithGetterSetterComponent,
    CounterComponent,
  ],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'frontend';
  message= "Hello";
  slideValue=0;// =  signal(100);

  valueOnChange ()
  {
    console.log('Child slide value change ',this.slideValue);
  }
}
