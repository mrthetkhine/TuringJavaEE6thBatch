import { Component } from '@angular/core';
import {MovieService} from "../../../../core/services/movie.service";

@Component({
  selector: 'app-movie-count-page',
  standalone: true,
  imports: [],
  templateUrl: './movie-count-page.component.html',
  styleUrl: './movie-count-page.component.css'
})
export class MovieCountPageComponent {
  count :number =0;
  constructor(private movieService:MovieService) {
  }
  ngOnInit()
  {
    this.movieService.movies.subscribe(movies=>{
      console.log('MovieCountPageComponent Subscribe ');
      this.count = movies.length;
    })
  }
  add()
  {
    this.movieService.addMovie();
  }
}
