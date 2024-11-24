import {Component, signal} from '@angular/core';
import {single} from "rxjs";
import {Todo} from "../todo.model";

@Component({
  selector: 'app-signal-object',
  standalone: true,
  imports: [],
  templateUrl: './signal-object.component.html',
  styleUrl: './signal-object.component.css'
})
export class SignalObjectComponent {

    profile = signal<Todo>({
      id :1,
      title : "Task 1"
    });

    updateTodo()
    {
      this.profile.set({
        ... this.profile(),
        title:'Update'
      })
    }
}
