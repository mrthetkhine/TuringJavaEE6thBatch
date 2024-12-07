import { Component } from '@angular/core';
import {ActivatedRoute} from "@angular/router";

@Component({
  selector: 'app-todo-details-page',
  standalone: true,
  imports: [],
  templateUrl: './todo-details-page.component.html',
  styleUrl: './todo-details-page.component.css'
})
export class TodoDetailsPageComponent {
  todoId!:string;

  constructor(private route: ActivatedRoute) {}
  ngOnInit() {
    this.todoId = this.route.snapshot.paramMap.get('id')||'';

  }
}
