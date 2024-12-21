import {ChangeDetectorRef, Component, ViewChild} from '@angular/core';
import {ActivatedRoute, Router} from "@angular/router";
import {MovieService} from "../../../../core/services/movie.service";
import {Movie} from "../../../../core/model/movie.model";

import {MovieDetailsUIComponent} from "../movie-details-ui/movie-details-ui.component";
import {MoviesFormComponent} from "../../../movies/components/movies-form/movies-form.component";

@Component({
  selector: 'app-movie-details-page',
  standalone: true,
  imports: [
    MovieDetailsUIComponent,
    MoviesFormComponent,
  ],
  templateUrl: './movie-details-page.component.html',
  styleUrl: './movie-details-page.component.css'
})
export class MovieDetailsPageComponent {
  movieId :string='';
  movie!:Movie;

  @ViewChild(MoviesFormComponent)
  movieForm!: MoviesFormComponent;

  constructor(private route: ActivatedRoute,
              private router: Router,
              private movieService:MovieService,
              private ref: ChangeDetectorRef) {
  }

  ngOnInit()
  {
    this.route.paramMap.subscribe(params => {
      this.movieId = params.get("id")??'';
      console.log('Movie id ',this.movieId);
      this.movieService.getMovieById(this.movieId)
        .subscribe(response=>{
          this.movie = response.data;
        });
    })

  }
  movieUpdatedCallback(updatedMovie:Movie)
  {
    console.log('MovieDetails Page movie update callback',updatedMovie);
    this.movie = updatedMovie;
    this.ref.detectChanges();
  }
  showEditDialog()
  {
    console.log('Show edit');
    this.movieForm.openEditMovieModal(this.movieUpdatedCallback.bind(this));
  }

  back()
  {
    this.router.navigate(['/movies']);
  }

}
