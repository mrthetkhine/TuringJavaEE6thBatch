import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import { BehaviorSubject } from 'rxjs';

import {BASE_URL} from "../Config";
import {Movie} from "../model/movie.model";
import ApiResponse from "../model/ApiResponse";
@Injectable({
  providedIn: 'root'
})
export class MovieService {

  moviesData:Movie[]=[];//store movie data
  moviesSubject = new BehaviorSubject<Movie[]>(this.moviesData);
  _movies = this.moviesSubject.asObservable();

  constructor(private httpClient:HttpClient) { }

  get movies()
  {
    return this._movies;
  }
  loadAllMovies()
  {
    this.httpClient.get<ApiResponse<Movie[]>>(BASE_URL+'/movies')
      .subscribe(response=>{
        let movies = response.data;
        console.log('loadAllMovies response ',movies);
        this.moviesData = movies;
        this.moviesSubject.next(this.moviesData);

      });

  }
  addMovie()
  {
    const movie:Movie = {
      name:"Movie",
      year:2010,
      director:"None",
      genres:['Drama '],
      details: {
        details:"Good movies"
      }
    }
    this.moviesData.push(movie);
    this.moviesSubject.next(this.moviesData);
  }
}
