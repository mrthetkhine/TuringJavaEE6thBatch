import {ResolveFn, Routes} from '@angular/router';
import {HomePageComponent} from "./pages/home-page/home-page.component";
import {TodosPageComponent} from "./pages/todos-page/todos-page.component";
import {HelloWorldComponent} from "./hello-world/hello-world.component";
import {NotFoundPageComponent} from "./pages/not-found-page/not-found-page.component";
import {NestedRouteDemoComponent} from "./pages/nested-route-demo/nested-route-demo.component";
import {ChildAComponent} from "./pages/child-a/child-a.component";
import {ChildBComponent} from "./pages/child-b/child-b.component";
import {TodoDetailsPageComponent} from "./pages/todo-details-page/todo-details-page.component";
import {LoginPageComponent} from "./pages/login-page/login-page.component";
import {authGuard} from "./guards/auth-guard.guard";
const resolvedChildATitle: ResolveFn<string> = () => Promise.resolve('child a');


export const routes: Routes = [

  { path: 'home', component: HomePageComponent ,title:'Home'},
  { path: 'login', component: LoginPageComponent ,title:'Login'},
  {
    path: 'todos',
    component: TodosPageComponent,
    title:'Todos',
    canActivate: [authGuard],
  },
  { path: 'todos/:id', component: TodoDetailsPageComponent,title:'Todos Details' },
  { path: '',   redirectTo: '/home', pathMatch: 'full' },
  { path: 'lazy',  loadComponent: () => import('./pages/lazy-page/lazy-page.component').then(c => c.LazyPageComponent),title:'Todos' },
  {
    path: 'nested-route',
    component: NestedRouteDemoComponent, // this is the component with the <router-outlet> in the template
    canActivate: [authGuard],
    children: [
      {
        path: 'child-a', // child route path
        component: ChildAComponent, // child route component that the router renders
        title:resolvedChildATitle,
      },
      {
        path: 'child-b',
        component: ChildBComponent, // another child route component that the router renders
        title :'Child B',
      },
    ],
  },
  { path: '**', component: NotFoundPageComponent },

];

