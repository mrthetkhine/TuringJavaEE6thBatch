import {Component, inject, TemplateRef, ViewChild} from '@angular/core';
import {MovieService} from "../../../../core/services/movie.service";
import {Movie} from "../../../../core/model/movie.model";
import {MoviesUIComponent} from "../movies-ui/movies-ui.component";
import {BsModalRef, BsModalService, ModalModule} from "ngx-bootstrap/modal";
import {CommonModule} from "@angular/common";
import {FormArray, FormBuilder, FormGroup, ReactiveFormsModule, Validators} from "@angular/forms";
import Swal from 'sweetalert2'
import {MoviesFormComponent} from "../movies-form/movies-form.component";
@Component({
  selector: 'app-movies-page',
  standalone: true,
  imports: [
    MoviesUIComponent,
    ModalModule,
    MoviesFormComponent,
  ],

  templateUrl: './movies-page.component.html',
  styleUrl: './movies-page.component.css'
})
export class MoviesPageComponent {
  movies:Movie[] =[];

  @ViewChild(MoviesFormComponent)
  movieForm!: MoviesFormComponent;

  constructor(private movieService:MovieService
              ) {
  }

  ngOnInit()
  {
    this.movieService.movies.subscribe(movies=>{
      console.log('Movies services subscribed ',movies.length);
      this.movies = movies;
    });
    this.movieService.loadAllMovies();
  }
  openNewMovieModal()
  {
    //console.log('Call Api ',this.movieForm);
    this.movieForm.openNewMovieModal();
  }

}
