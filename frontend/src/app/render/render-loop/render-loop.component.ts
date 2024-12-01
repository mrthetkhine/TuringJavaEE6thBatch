import { Component } from '@angular/core';
import {Todo} from "../../todo.model";

@Component({
  selector: 'app-render-loop',
  standalone: true,
  imports: [],
  templateUrl: './render-loop.component.html',
  styleUrl: './render-loop.component.css'
})
export class RenderLoopComponent {
  todos:Todo[]= []

  load()
  {
    this.todos = [{
      id:1,
      title:'Task1'
    },
      {
        id:2,
        title:'Task 2'
      },
    ]
  }
}
