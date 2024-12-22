import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {LoginRequest} from "../model/login-request.model";
import ApiResponse from "../model/ApiResponse";
import {Movie} from "../model/movie.model";
import {BASE_URL} from "../Config";
import {LoginResponse} from "../model/login-response.model";

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  _token: string = '';

  constructor(private httpClient: HttpClient) {

  }

  login(request: LoginRequest) {
    return this.httpClient.post<ApiResponse<LoginResponse>>(BASE_URL + '/login', request);
  }

  setToken(token: string) {
    this._token = token;
  }

  isAuthenticated() {
    return !!this._token;
  }

  get token():string
  {
    return this._token;
  }
  logout()
  {
    this._token='';
  }
}
