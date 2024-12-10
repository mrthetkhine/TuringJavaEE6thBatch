import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Todo} from "../todo.model";

const BASE_URL = "https://jsonplaceholder.typicode.com/"
@Injectable({
  providedIn: 'root'
})
export class TodoService {

  constructor(private httpClient:HttpClient) { }

  getAllTodo()
  {
    return this.httpClient.get<Todo[]>(BASE_URL+'/todos');
  }
  getTodo(id:string)
  {
    return this.httpClient.get<Todo>(BASE_URL+`/todos/${id}`);

  }
}
