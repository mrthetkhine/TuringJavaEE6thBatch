import { Routes } from '@angular/router';
import {HomePageComponent} from "./pages/home-page/home-page.component";
import {TodosPageComponent} from "./pages/todos-page/todos-page.component";

export const routes: Routes = [
  { path: 'home', component: HomePageComponent },
  { path: 'todos', component: TodosPageComponent },
];
