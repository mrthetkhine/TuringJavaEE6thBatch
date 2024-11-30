import {Component, signal, ViewContainerRef} from '@angular/core';
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
import {ViewChildDemoComponent} from "./view-child-demo/view-child-demo.component";
import {TabComponent} from "./tab/tab/tab.component";
import {TabPageComponent} from "./tab/tab-page/tab-page.component";
import {QueryLocatorDemoComponent} from "./query-locator-demo/query-locator-demo.component";
import {DomDemoComponent} from "./dom-demo/dom-demo.component";
import {BioComponent} from "./render/bio/bio.component";
import {User} from "./user.model";
import {AdminBioComponent} from "./render/admin-bio/admin-bio.component";
import {UserBioComponent} from "./render/user-bio/user-bio.component";
import {ViewContainerRefDemoComponent} from "./view-container-ref-demo/view-container-ref-demo.component";
import {OuterContainerComponent} from "./outer-container/outer-container.component";
import {LazyLoadingDemoComponent} from "./render/lazy-loading-demo/lazy-loading-demo.component";
import {BindingComponent} from "./template-demo/binding/binding.component";
import {TwoWayBindingComponent} from "./template-demo/two-way-binding/two-way-binding.component";

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
    ViewChildDemoComponent,
    TabComponent,
    TabPageComponent,
    QueryLocatorDemoComponent,
    DomDemoComponent,
    BioComponent,
   /* AdminBioComponent,
    UserBioComponent,*/
    ViewContainerRefDemoComponent,
    OuterContainerComponent,
   /* LazyLoadingDemoComponent,*/
    BindingComponent,
    TwoWayBindingComponent,
  ],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'frontend';
  message= "Hello";
  slideValue=0;// =  signal(100);

  tabHeaders= ["Tab1","Tab2","Tab3"];
  user:User;

  constructor() {
    this.user = {
      isAdmin:false,
      userName:"User"
    }
  }
  valueOnChange ()
  {
    console.log('Child slide value change ',this.slideValue);
  }
}
