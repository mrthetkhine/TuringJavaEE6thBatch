import { Component } from '@angular/core';
import {ActivatedRoute} from "@angular/router";
import {Observable} from "rxjs";
import {Todo} from "../../todo.model";
import {TodoService} from "../../services/todo.service";
import {AsyncPipe} from "@angular/common";

@Component({
  selector: 'app-todo-details-page',
  standalone: true,
  imports: [
    AsyncPipe
  ],
  templateUrl: './todo-details-page.component.html',
  styleUrl: './todo-details-page.component.css'
})
export class TodoDetailsPageComponent {
  todoId!:string;

  todo$!: Observable<Todo>;
  constructor(private route: ActivatedRoute,
              private todoService:TodoService) {}
  ngOnInit() {
    this.todoId = this.route.snapshot.paramMap.get('id')||'';
    this.todo$ = this.todoService.getTodo(this.todoId);

  }
}
