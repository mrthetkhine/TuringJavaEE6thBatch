import {Component, inject, TemplateRef, ViewChild} from '@angular/core';
import {MovieService} from "../../../../core/services/movie.service";
import {Movie} from "../../../../core/model/movie.model";
import {MoviesUIComponent} from "../movies-ui/movies-ui.component";
import {BsModalRef, BsModalService, ModalModule} from "ngx-bootstrap/modal";
import {CommonModule} from "@angular/common";
import {FormArray, FormBuilder, FormGroup, ReactiveFormsModule, Validators} from "@angular/forms";

@Component({
  selector: 'app-movies-page',
  standalone: true,
  imports: [
    MoviesUIComponent,
    ModalModule,
    CommonModule,
    ReactiveFormsModule,
  ],
  providers: [BsModalService],
  templateUrl: './movies-page.component.html',
  styleUrl: './movies-page.component.css'
})
export class MoviesPageComponent {
  movies:Movie[] =[];
  modalRef?: BsModalRef;
  @ViewChild('movieFormDlg', { read: TemplateRef }) movieFormDlgTemplate!:TemplateRef<any>;

  private formBuilder = inject(FormBuilder);
  movieForm = this.formBuilder.group({
    name: ['',[Validators.required,],

    ],
    year: ['',[Validators.required,]
    ],
    director: ['',[Validators.required,]
    ],
    details: ['',[Validators.required,]
    ],
    genres: this.formBuilder.array([this.formBuilder.control('',[Validators.required])]),
    actors: this.formBuilder.array([]),
  });

  constructor(private movieService:MovieService,
              private modalService: BsModalService) {
  }



  openModal(template: TemplateRef<void>) {
    this.modalRef = this.modalService.show(template);
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
    console.log('New movie modal dialog ',this.movieFormDlgTemplate);
    this.modalRef  = this.modalService.show(this.movieFormDlgTemplate, Object.assign({}, { class: 'modal-lg' }));
    console.log('ModelRef ',this.modalRef);
  }
  get name()
  {
    return this.movieForm.controls.name;
  }
  get year()
  {
    return this.movieForm.controls.year;
  }
  get director()
  {
    return this.movieForm.controls.director;
  }
  get details()
  {
    return this.movieForm.controls.details;
  }
  get genres()
  {
    return this.movieForm.get('genres') as FormArray;
  }
  get actors()
  {
    //console.log('Get actors ');
    return this.movieForm.get('actors') as FormArray;
  }
  addGenre()
  {
    this.genres.push(this.formBuilder.control('',[Validators.required]));
  }
  addActor()
  {
    let actor = this.formBuilder.group( {
      firstName: ['',[Validators.required]],
      lastName: ['',[Validators.required]]
    });
    this.actors.push(actor);
    //console.log('Actors.control ',this.actors.controls);

  }
  getFormGroupAtIndex(index: number) {
    return (this.actors.controls[index] as FormGroup);
  }

  onSubmit()
  {
    console.log('Form submit ',this.movieForm.value);
  }
}
