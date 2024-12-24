import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Review} from "../model/review.model";
import ApiResponse from "../model/ApiResponse";
import {Movie} from "../model/movie.model";
import {BASE_URL} from "../Config";
import {BehaviorSubject} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class ReviewService {

  reviewData:Review[]=[];//store Review data
  reviewsSubject = new BehaviorSubject<Review[]>(this.reviewData);
  _reviews = this.reviewsSubject.asObservable();
  constructor(private httpClient:HttpClient) { }

  get review()
  {
    return this._reviews;
  }
  resetReview()
  {
    this.reviewData = [];
    this.reviewsSubject.next(this.reviewData);
  }
  loadAllReview(movieId:string)
  {
    this.resetReview();
    this.httpClient.get<ApiResponse<Review[]>>(BASE_URL+`/movies/${movieId}/reviews`)
      .subscribe(response=>{
        let reviews = response.data;
        console.log('loadAllReview response ',reviews);
        this.reviewData = reviews;
        this.reviewsSubject.next(this.reviewData);

      });

  }
  saveReview(review:Review,callback:(r:Review)=>void)
  {

    this.httpClient.post<ApiResponse<Review>>(BASE_URL+`/movies/${review.movie}/reviews`,review)
      .subscribe(response=>{
        let savedReview = response.data;
        console.log('Save review response ',savedReview);
        this.reviewData.push(savedReview);
        this.reviewsSubject.next(this.reviewData);
        callback(savedReview);
      });
  }
  updateReview(review:Review,callback:(rv:Review)=>void)
  {
    this.httpClient.put<ApiResponse<Review>>(BASE_URL+`/movies/reviews/${review.id}`,review)
      .subscribe(response=>{
        let updatedReview = response.data;
        console.log('Update movie response ',updatedReview);
        this.reviewData = this.reviewData.map(r=>r.id==updatedReview.id? updatedReview: r);
        this.reviewsSubject.next(this.reviewData);
        callback(updatedReview);
      });
  }
  deleteReview(review:Review,callback:(rv:Review)=>void)
  {
    this.httpClient.delete<ApiResponse<Review>>(BASE_URL+`/movies/reviews/${review.id}`)
      .subscribe(response=>{
        let deletedReview = response.data;
        console.log('Delete movie response ',deletedReview);
        this.reviewData = this.reviewData.filter(m=>m.id != deletedReview.id);
        this.reviewsSubject.next(this.reviewData);
        callback(deletedReview);
      });
  }
}
