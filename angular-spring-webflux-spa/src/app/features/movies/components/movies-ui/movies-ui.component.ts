import {Component, input} from '@angular/core';
import {Movie} from "../../../../core/model/movie.model";
import {Router} from "@angular/router";

@Component({
  selector: 'app-movies-ui',
  standalone: true,
  imports: [],
  templateUrl: './movies-ui.component.html',
  styleUrl: './movies-ui.component.css'
})
export class MoviesUIComponent {
  movie = input.required<Movie>();
  showDetails = input<boolean>();
  constructor(private router: Router,
              ) {
  }
  gotoDetails()
  {
    console.log('Movies Details ',this.movie()?.id);
    this.router.navigate(['/movies',this.movie()?.id]);
  }

}
