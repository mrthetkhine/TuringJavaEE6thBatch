import {Component, input} from '@angular/core';
import Swal from "sweetalert2";
import {Movie} from "../../../../core/model/movie.model";
import {Router} from "@angular/router";
import {MovieService} from "../../../../core/services/movie.service";

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
              private movieService:MovieService,
              ) {
  }
  gotoDetails()
  {
    console.log('Movies Details ',this.movie()?.id);
    this.router.navigate(['/movies',this.movie()?.id]);
  }
  deleteMovie()
  {
    console.log('Delete Movie');
    Swal.fire({
      title: "Do you want to delete movie?",
      showDenyButton: true,
      confirmButtonText: "Delete",

    }).then((result) => {
      /* Read more about isConfirmed, isDenied below */
      if (result.isConfirmed) {
        this.movieService.deleteMovie(this.movie(),(mv:Movie)=>{
          Swal.fire("Movie Deleted!", "", "success");
        })

      }
    });
  }

}
