import {Component, input, ViewChild} from '@angular/core';
import {Review} from "../../../../core/model/review.model";
import {RatingModule} from "ngx-bootstrap/rating";
import {FormsModule} from "@angular/forms";
import {ReviewFormComponent} from "../review-form/review-form.component";
import Swal from "sweetalert2";
import {Movie} from "../../../../core/model/movie.model";
import {ReviewService} from "../../../../core/services/review.service";

@Component({
  selector: 'app-review',
  standalone: true,
  imports: [
    RatingModule,
    FormsModule,
    ReviewFormComponent,
  ],
  templateUrl: './review.component.html',
  styleUrl: './review.component.css'
})
export class ReviewComponent {
  review =input.required<Review>();
  isReadonly = true;

  @ViewChild(ReviewFormComponent)
  reviewForm!: ReviewFormComponent;

  constructor(private reviewService:ReviewService) {
  }
  showEditRatingDialog()
  {
    console.log('Show new rating dialog');
    this.reviewForm.openEditReviewModal();
  }
  deleteReview()
  {
    console.log('deleteReview ');
    Swal.fire({
      title: "Do you want to delete Review?",
      showDenyButton: true,
      confirmButtonText: "Delete",

    }).then((result) => {
      /* Read more about isConfirmed, isDenied below */
      if (result.isConfirmed) {
        this.reviewService.deleteReview(this.review(),(mv:Review)=>{
          Swal.fire("Review Deleted!", "", "success");
        })

      }
    });
  }
}
