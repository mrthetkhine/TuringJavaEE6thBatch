import { Routes } from '@angular/router';
import {MoviesPageComponent} from "./features/movies/components/movies-page/movies-page.component";
import {MovieDetailsPageComponent} from "./features/movies-details/components/movie-details-page/movie-details-page.component";
import {MovieCountPageComponent} from "./features/movies-details/components/movie-count-page/movie-count-page.component";
import {LoginPageComponent} from "./features/auth/components/login-page/login-page.component";
import {LogoutPageComponent} from "./features/auth/components/logout-page/logout-page.component";
import {HomePageComponent} from "./features/home/components/home-page/home-page.component";
import {authGuard} from "./core/guards/auth.guard";

export const routes: Routes = [
  { path: 'home',
    component: HomePageComponent ,
    title:'Home',
    canActivate: [authGuard]
  },
  { path: 'login', component: LoginPageComponent ,title:'Login'},
  {
    path: 'logout',
    component: LogoutPageComponent ,
    title:'Logout',
    canActivate: [authGuard],
  },
  {
    path: 'movies',
    component: MoviesPageComponent ,
    title:'Movies',
    canActivate: [authGuard],
  },
  {
    path: 'movies/:id',
    component: MovieDetailsPageComponent,
    title:'Movies Details',
    canActivate: [authGuard],
  },
  {
    path: 'movies-count',
    component: MovieCountPageComponent ,
    title:'Movies Count',
    canActivate: [authGuard],
  },

];
