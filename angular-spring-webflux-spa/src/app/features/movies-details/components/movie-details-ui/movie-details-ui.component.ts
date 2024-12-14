import {Component, input} from '@angular/core';
import {Movie} from "../../../../core/model/movie.model";
import {ActorUIComponent} from "../../../movies/components/actor-ui/actor-ui.component";

@Component({
  selector: 'app-movie-details-ui',
  standalone: true,
  imports: [
    ActorUIComponent,
  ],
  templateUrl: './movie-details-ui.component.html',
  styleUrl: './movie-details-ui.component.css'
})
export class MovieDetailsUIComponent {
  movie = input.required<Movie>();

  ngOnInit()
  {
    console.log('Movie in movies details ',this.movie());
  }
}
