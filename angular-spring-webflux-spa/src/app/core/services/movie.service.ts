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
  getMovieById(movieId:string)
  {
    return this.httpClient.get<ApiResponse<Movie>>(BASE_URL+'/movies/'+movieId);

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
  saveMovie(movie:Movie,callback:(mv:Movie)=>void)
  {
    this.httpClient.post<ApiResponse<Movie>>(BASE_URL+'/movies',movie)
      .subscribe(response=>{
        let movie = response.data;
        console.log('Save movie response ',movie);
        this.moviesData.push(movie);
        this.moviesSubject.next(this.moviesData);
        callback(movie);
      });
  }
  updateMovie(movie:Movie,callback:(mv:Movie)=>void)
  {
    this.httpClient.put<ApiResponse<Movie>>(BASE_URL+`/movies/${movie.id}`,movie)
      .subscribe(response=>{
        let movie = response.data;
        console.log('Update movie response ',movie);
        this.moviesData = this.moviesData.map(m=>m.id==movie.id? movie: m);
        this.moviesSubject.next(this.moviesData);
        callback(movie);
      });
  }
  deleteMovie(movie:Movie,callback:(mv:Movie)=>void)
  {
    this.httpClient.delete<ApiResponse<Movie>>(BASE_URL+`/movies/${movie.id}`)
      .subscribe(response=>{
        let movie = response.data;
        console.log('Delete movie response ',movie);
        this.moviesData = this.moviesData.filter(m=>m.id != movie.id);
        this.moviesSubject.next(this.moviesData);
        callback(movie);
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
