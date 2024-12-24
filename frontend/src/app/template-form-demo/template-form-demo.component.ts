import { Component } from '@angular/core';
import {Actor} from "../actor.model";
import {FormsModule, NgModel} from "@angular/forms";
import {NgFor} from "@angular/common";

@Component({
  selector: 'app-template-form-demo',
  standalone: true,
  imports: [
    FormsModule,
    NgFor,
  ],
  templateUrl: './template-form-demo.component.html',
  styleUrl: './template-form-demo.component.css'
})
export class TemplateFormDemoComponent {
  skills = ['Method Acting', 'Singing', 'Dancing', 'Swordfighting'];
  model = new Actor(18, 'Tom Cruise', this.skills[3], 'CW Productions');
  submitted = false;


  heroine(): Actor {
    const myActress = new Actor(42, 'Marilyn Monroe', 'Singing');
    console.log('My actress is called ' + myActress.name); // "My actress is called Marilyn"
    return myActress;
  }

  showFormControls(form: any) {
    return form && form.controls.name && form.controls.name.value; // Tom Cruise
  }
  onSubmit()
  {
    console.log('Formsubmit ',this.model);
    this.submitted = true;
  }
  newActor() {
    this.model = new Actor(42, '', '');
  }
}
