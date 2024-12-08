import {Component, inject} from '@angular/core';
import {FormArray, FormBuilder, ReactiveFormsModule, Validators} from "@angular/forms";
import {startWithCapitalLetter} from "../reactive-form-demo/reactive-form-demo.component";

@Component({
  selector: 'app-dynamic-form-demo',
  standalone: true,
  imports: [
    ReactiveFormsModule,
  ],
  templateUrl: './dynamic-form-demo.component.html',
  styleUrl: './dynamic-form-demo.component.css'
})
export class DynamicFormDemoComponent {
  private formBuilder = inject(FormBuilder);
  profileForm = this.formBuilder.group({
      username: ['',[
        Validators.required,
        Validators.minLength(4)],

      ],
      phones: this.formBuilder.array([this.formBuilder.control('',[Validators.required])]),

  });
  get username()
  {
    return this.profileForm.controls.username;
  }
  get phones()
  {
    return this.profileForm.get('phones') as FormArray;
  }
  getPhone(i:number)
  {
    //return this.profileForm.get('phones')[i];
  }
  addPhone()
  {
    this.phones.push(this.formBuilder.control('',[Validators.required]));
  }
  onSubmit()
  {
    console.log('Form submit ',this.profileForm.value);
  }
}
