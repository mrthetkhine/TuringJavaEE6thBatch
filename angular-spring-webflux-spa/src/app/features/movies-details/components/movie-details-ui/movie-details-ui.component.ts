import {Component, input, ViewChild} from '@angular/core';
import {Movie} from "../../../../core/model/movie.model";
import {ActorUIComponent} from "../../../movies/components/actor-ui/actor-ui.component";
import {MoviesFormComponent} from "../../../movies/components/movies-form/movies-form.component";

@Component({
  selector: 'app-movie-details-ui',
  standalone: true,
  imports: [
    ActorUIComponent,
    MoviesFormComponent,
  ],
  templateUrl: './movie-details-ui.component.html',
  styleUrl: './movie-details-ui.component.css'
})
export class MovieDetailsUIComponent {
  movie = input.required<Movie>();

  @ViewChild(MoviesFormComponent)
  movieForm!: MoviesFormComponent;

  ngOnInit()
  {
    console.log('Movie in movies details ',this.movie());
  }
  showEditDialog()
  {
    console.log('Show edit');
    this.movieForm.openEditMovieModal();
  }

}
