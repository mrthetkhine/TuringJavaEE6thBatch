import { Component } from '@angular/core';
import {Router} from "@angular/router";
import {TodoService} from "../../services/todo.service";
import {Todo} from "../../todo.model";

@Component({
  selector: 'app-todos-page',
  standalone: true,
  imports: [],
  templateUrl: './todos-page.component.html',
  styleUrl: './todos-page.component.css'
})
export class TodosPageComponent {
  todos:Todo[] = []

  constructor(private router: Router,
              private todoService: TodoService) {
  }

  ngOnInit()
  {
    console.log('NgOnInit');
    this.todoService.getAllTodo().subscribe(todos=>{
      this.todos = todos;
    });
  }
  gotoDetails(todo:Todo)
  {
    console.log('Index ',todo);
    this.router.navigate(['todos',todo?.id]);
  }
}
