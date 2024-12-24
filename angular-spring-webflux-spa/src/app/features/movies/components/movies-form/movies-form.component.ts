import {Component, inject, input, output, TemplateRef, ViewChild} from '@angular/core';
import {CommonModule} from "@angular/common";
import {FormArray, FormBuilder, FormGroup, ReactiveFormsModule, Validators} from "@angular/forms";
import {BsModalRef, BsModalService} from "ngx-bootstrap/modal";
import {MovieService} from "../../../../core/services/movie.service";
import {Movie} from "../../../../core/model/movie.model";
import Swal from "sweetalert2";

@Component({
  selector: 'app-movies-form',
  standalone: true,
  imports: [
    CommonModule,
    ReactiveFormsModule,

  ],
  providers: [BsModalService],
  templateUrl: './movies-form.component.html',
  styleUrl: './movies-form.component.css'
})
export class MoviesFormComponent {
  movieToEdit = input<Movie>();

  movieUpdated = output<Movie>();
  modalRef?: BsModalRef;
  @ViewChild('movieFormDlg', { read: TemplateRef }) movieFormDlgTemplate!:TemplateRef<any>;

  private formBuilder = inject(FormBuilder);

  movieForm = this.formBuilder.group({
    id: [''],
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
  public openNewMovieModal()
  {
    this.movieForm.reset();
    console.log('New movie modal dialog ',this.movieFormDlgTemplate);
    this.modalRef  = this.modalService.show(this.movieFormDlgTemplate, Object.assign({}, { class: 'modal-lg' }));
    console.log('ModelRef ',this.modalRef);

  }
  public openEditMovieModal()
  {

    this.movieForm.reset();
    let formData:any = this.movieToEdit();
    console.log('PatchValue ',formData);
    for(let i=0;i< formData.actors.length;i++)
    {
      this.addActor();
    }
    this.movieForm.patchValue(formData);
    this.details.setValue(formData.details.details);
    console.log('Movie to edit actors ',formData.actors);

    console.log('Edit movie modal dialog ',this.movieFormDlgTemplate);
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
  deleteGenre(index:number)
  {
    this.genres.removeAt(index);
  }
  addActor()
  {
    let actor = this.formBuilder.group( {
      id: [''],
      firstName: ['',[Validators.required]],
      lastName: ['',[Validators.required]]
    });
    this.actors.push(actor);
    //console.log('Actors.control ',this.actors.controls);

  }
  getFormGroupAtIndex(index: number) {
    return (this.actors.controls[index] as FormGroup);
  }
  removeActor(index:number)
  {
    console.log('Remove at ',index);
    this.actors.removeAt(index);
  }
  onSubmit()
  {
    console.log('Form submit ',this.movieForm.value);
    if(this.movieToEdit() )
    {
      this.updateMovie();
    }
    else {
      this.saveNewMovie();
    }

  }

  private updateMovie() {
    //update
    console.log('Movie update details ', this.movieToEdit()?.details);

    let movie: any = {
      ...this.movieForm.value,
      details: {
        details: this.movieForm.value.details
      }
    }
    console.log('Update movie ', movie);
    let callback = (movie: Movie) => {
      console.log('Movie update callback ', movie);
      this.modalRef?.hide();
      Swal.fire("Movie successfully updated");
      this.movieUpdated.emit(movie);
    };
    this.movieService.updateMovie(movie,callback);
  }

  private saveNewMovie() {
    let movie: any = {
      ...this.movieForm.value,
      details: {
        details: this.movieForm.value.details
      }
    }
    let callback = (movie: Movie) => {
      console.log('Movie saved callback ', movie);
      this.modalRef?.hide();
      Swal.fire("Movie successfully saved");
    };
    this.movieService.saveMovie(movie, callback);
  }
}
