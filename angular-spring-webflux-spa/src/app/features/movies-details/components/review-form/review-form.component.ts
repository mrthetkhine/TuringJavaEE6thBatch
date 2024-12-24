import {Component, ContentChild, ElementRef, inject, input, output, TemplateRef, ViewChild} from '@angular/core';
import {MovieService} from "../../../../core/services/movie.service";
import {BsModalRef, BsModalService, ModalModule} from "ngx-bootstrap/modal";
import {FormBuilder, FormsModule, ReactiveFormsModule, Validators} from "@angular/forms";
import {CommonModule} from "@angular/common";
import {RatingComponent, RatingModule} from "ngx-bootstrap/rating";
import {Review} from "../../../../core/model/review.model";
import {Movie} from "../../../../core/model/movie.model";
import {ReviewService} from "../../../../core/services/review.service";
import Swal from "sweetalert2";

@Component({
  selector: 'app-review-form',
  standalone: true,
  imports: [
    CommonModule,
    ReactiveFormsModule,
    RatingModule,
    FormsModule,
  ],
  providers: [BsModalService],
  templateUrl: './review-form.component.html',
  styleUrl: './review-form.component.css'
})
export class ReviewFormComponent {
  movieId = input.required<string>();
  reviewToEdit = input<Review>();

  modalRef?: BsModalRef;
  @ViewChild('reviewFormDlg', { read: TemplateRef }) reviewFormDlgTemplate!:TemplateRef<any>;

  private formBuilder = inject(FormBuilder);

  model:Review = {
    movie:'',
    review:'',
    rating:0,

  };
  rating = 0;
  constructor(private movieService:MovieService,
              private modalService: BsModalService,
              private reviewService:ReviewService,) {
  }
  ngOnInit()
  {
    console.log('ngOnInit fired');
    if(this.reviewToEdit()!=undefined)
    {
      let review:any = this.reviewToEdit();
      this.model = {
        ...review,
      };
      this.model.movieId = this.movieId();
      this.rating = this.model.rating;
    }
  }
  openModal(template: TemplateRef<void>) {
    this.modalRef = this.modalService.show(template);
  }
  public openNewReviewModal()
  {
    this.reset();
    this.modalRef  = this.modalService.show(this.reviewFormDlgTemplate, Object.assign({}, { class: 'modal-lg' }));
    console.log('ModelRef ',this.modalRef);

  }
  public openEditReviewModal()
  {

    console.log('Model ',this.model);
    this.modalRef  = this.modalService.show(this.reviewFormDlgTemplate, Object.assign({}, { class: 'modal-lg' }));
    console.log('ModelRef ',this.modalRef);

  }
  reset()
  {
    this.model = {
      movie:'',
      review:'',
      rating:0,
    };
    this.rating =0;
  }
  onSubmit()
  {

    this.model.rating = this.rating;
    if(this.reviewToEdit())
    {
      console.log('Review to edit input ',this.reviewToEdit());
      //update
      this.model.movie = this.movieId()??'';
      this.model.movieId = this.reviewToEdit()?.movieId;
      console.log('Review to update',this.model);

      this.reviewService.updateReview(this.model,(review:Review)=>{
        this.modalRef?.hide();
        Swal.fire("Review successfully updated");

      });
    }
    else{

      this.model.movie = this.movieId()??'';

      //this.reviewAdded.emit(this.model);
      this.model.movieId = this.model.movie;
      this.reviewService.saveReview(this.model,(review:Review)=>{
        this.modalRef?.hide();
        Swal.fire("Review successfully saved");

      });
    }

  }
}
