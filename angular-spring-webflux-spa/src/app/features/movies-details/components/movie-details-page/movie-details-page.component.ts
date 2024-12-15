import { Component } from '@angular/core';
import {ActivatedRoute, Router} from "@angular/router";
import {MovieService} from "../../../../core/services/movie.service";
import {Movie} from "../../../../core/model/movie.model";

import {MovieDetailsUIComponent} from "../movie-details-ui/movie-details-ui.component";

@Component({
  selector: 'app-movie-details-page',
  standalone: true,
  imports: [
    MovieDetailsUIComponent,
  ],
  templateUrl: './movie-details-page.component.html',
  styleUrl: './movie-details-page.component.css'
})
export class MovieDetailsPageComponent {
  movieId :string='';
  movie!:Movie;
  constructor(private route: ActivatedRoute,
              private router: Router,
              private movieService:MovieService) {
  }
  ngOnInit()
  {
    this.route.paramMap.subscribe(params => {
      this.movieId = params.get("id")??'';
      console.log('Movie id ',this.movieId);
      this.movie = this.movieService.getMovieById(this.movieId);
    })

  }
  back()
  {
    this.router.navigate(['/movies']);
  }

}
