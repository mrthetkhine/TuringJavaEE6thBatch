import {Component, input} from '@angular/core';
import {Review} from "../../../../core/model/review.model";
import {RatingModule} from "ngx-bootstrap/rating";
import {FormsModule} from "@angular/forms";

@Component({
  selector: 'app-review',
  standalone: true,
  imports: [
    RatingModule,
    FormsModule,
  ],
  templateUrl: './review.component.html',
  styleUrl: './review.component.css'
})
export class ReviewComponent {
  review =input.required<Review>();
  isReadonly = true;
}
