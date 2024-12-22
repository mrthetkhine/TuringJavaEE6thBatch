import {Component, inject, TemplateRef, ViewChild} from '@angular/core';
import {MovieService} from "../../../../core/services/movie.service";
import {BsModalRef, BsModalService, ModalModule} from "ngx-bootstrap/modal";
import {FormBuilder, ReactiveFormsModule, Validators} from "@angular/forms";
import {CommonModule} from "@angular/common";

@Component({
  selector: 'app-review-form',
  standalone: true,
  imports: [
    CommonModule,
    ReactiveFormsModule,

  ],
  providers: [BsModalService],
  templateUrl: './review-form.component.html',
  styleUrl: './review-form.component.css'
})
export class ReviewFormComponent {
  modalRef?: BsModalRef;
  @ViewChild('reviewFormDlg', { read: TemplateRef }) reviewFormDlgTemplate!:TemplateRef<any>;

  private formBuilder = inject(FormBuilder);
  reviewForm = this.formBuilder.group({
    id: [''],
    review: ['',[Validators.required,],

    ],
    rating: [0]

  });
  constructor(private movieService:MovieService,
              private modalService: BsModalService) {
  }
  openModal(template: TemplateRef<void>) {
    this.modalRef = this.modalService.show(template);
  }
  public openNewReviewModal()
  {
    this.reviewForm.reset();

    this.modalRef  = this.modalService.show(this.reviewFormDlgTemplate, Object.assign({}, { class: 'modal-lg' }));
    console.log('ModelRef ',this.modalRef);

  }
  get review()
  {
    return this.reviewForm.controls.review;
  }
  onSubmit()
  {

  }
}
