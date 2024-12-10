import { Routes } from '@angular/router';
import {MoviesPageComponent} from "./features/movies/components/movies-page/movies-page.component";
import {MovieDetailsPageComponent} from "./features/movies-details/components/movie-details-page/movie-details-page.component";
import {MovieCountPageComponent} from "./features/movies-details/components/movie-count-page/movie-count-page.component";

export const routes: Routes = [
  { path: 'movies', component: MoviesPageComponent ,title:'Movies'},
  { path: 'movies-count', component: MovieCountPageComponent ,title:'Movies Count'},
  { path: 'movies/:id', component: MovieDetailsPageComponent,title:'Movies Details' },
];
