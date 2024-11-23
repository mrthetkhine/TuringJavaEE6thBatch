import {Component, computed, input} from '@angular/core';
import {Todo} from "../todo.model";

@Component({
  selector: 'app-todo-item',
  standalone: true,
  imports: [],
  templateUrl: './todo-item.component.html',
  styleUrl: './todo-item.component.css'
})
export class TodoItemComponent {
  todo = input.required<Todo>();

}
