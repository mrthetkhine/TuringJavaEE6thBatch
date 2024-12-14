import {Component, input} from '@angular/core';
import {Actor} from "../../../../core/model/actor.model";

@Component({
  selector: 'app-actor-ui',
  standalone: true,
  imports: [],
  templateUrl: './actor-ui.component.html',
  styleUrl: './actor-ui.component.css'
})
export class ActorUIComponent {
  actor = input.required<Actor>();
}
