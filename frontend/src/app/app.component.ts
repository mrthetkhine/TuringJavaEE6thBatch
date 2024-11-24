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
import {SignalImmutableDemoComponent} from "./signal-immutable-demo/signal-immutable-demo.component";
import {SignalObjectComponent} from "./signal-object/signal-object.component";
import {SignalUnTrackComponent} from "./signal-un-track/signal-un-track.component";
import {ContentDemoComponent} from "./content-demo/content-demo.component";
import {ContentHeaderComponent} from "./content-header/content-header.component";
import {LayoutDemoComponent} from "./layout-demo/layout-demo.component";
import {LayoutHeaderComponent} from "./layout-header/layout-header.component";
import {LayoutFooterComponent} from "./layout-footer/layout-footer.component";
import {HostElementDemoComponent} from "./host-element-demo/host-element-demo.component";
import {LifeCycleDemoComponent} from "./life-cycle-demo/life-cycle-demo.component";
import {LifeCycleParentComponent} from "./life-cycle-parent/life-cycle-parent.component";

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
    SignalImmutableDemoComponent,
    SignalObjectComponent,
    SignalUnTrackComponent,
    ContentDemoComponent,
    ContentHeaderComponent,
    LayoutDemoComponent,
    LayoutHeaderComponent,
    LayoutFooterComponent,
    HostElementDemoComponent,
    /*LifeCycleDemoComponent,*/
    LifeCycleParentComponent,
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
