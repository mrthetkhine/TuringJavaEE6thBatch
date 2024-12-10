import { Component } from '@angular/core';
import {MovieService} from "../../../../core/services/movie.service";
import {Movie} from "../../../../core/model/movie.model";
import {MoviesUIComponent} from "../movies-ui/movies-ui.component";

@Component({
  selector: 'app-movies-page',
  standalone: true,
  imports: [
    MoviesUIComponent,
  ],
  templateUrl: './movies-page.component.html',
  styleUrl: './movies-page.component.css'
})
export class MoviesPageComponent {
  movies:Movie[] =[];
  constructor(private movieService:MovieService) {
  }
  ngOnInit()
  {
    this.movieService.movies.subscribe(movies=>{
      console.log('Movies services subscribed ',movies.length);
      this.movies = movies;
    });
    this.movieService.loadAllMovies();
  }
}
