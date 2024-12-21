import { Routes } from '@angular/router';
import {MoviesPageComponent} from "./features/movies/components/movies-page/movies-page.component";
import {MovieDetailsPageComponent} from "./features/movies-details/components/movie-details-page/movie-details-page.component";
import {MovieCountPageComponent} from "./features/movies-details/components/movie-count-page/movie-count-page.component";
import {LoginPageComponent} from "./features/auth/components/login-page/login-page.component";
import {LogoutPageComponent} from "./features/auth/components/logout-page/logout-page.component";

export const routes: Routes = [
  { path: 'login', component: LoginPageComponent ,title:'Login'},
  { path: 'logout', component: LogoutPageComponent ,title:'Logout'},
  { path: 'movies', component: MoviesPageComponent ,title:'Movies'},
  { path: 'movies/:id', component: MovieDetailsPageComponent,title:'Movies Details' },
  { path: 'movies-count', component: MovieCountPageComponent ,title:'Movies Count'},

];
