import {Component, Input} from '@angular/core';

@Component({
  selector: 'app-greet',
  standalone: true,
  imports: [],
  templateUrl: './greet.component.html',
  styleUrl: './greet.component.css'
})
export class GreetComponent {
  @Input() message="";

}
