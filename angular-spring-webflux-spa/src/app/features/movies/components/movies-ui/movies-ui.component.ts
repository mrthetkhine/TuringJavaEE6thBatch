import {Component, input} from '@angular/core';
import {Movie} from "../../../../core/model/movie.model";

@Component({
  selector: 'app-movies-ui',
  standalone: true,
  imports: [],
  templateUrl: './movies-ui.component.html',
  styleUrl: './movies-ui.component.css'
})
export class MoviesUIComponent {
  movie = input.required<Movie>();
}
