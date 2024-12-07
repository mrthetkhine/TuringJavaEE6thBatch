import {Component, inject} from '@angular/core';
import {FormBuilder, ReactiveFormsModule} from '@angular/forms';
@Component({
  selector: 'app-reactive-form-demo',
  standalone: true,
  imports: [ReactiveFormsModule],
  templateUrl: './reactive-form-demo.component.html',
  styleUrl: './reactive-form-demo.component.css'
})
export class ReactiveFormDemoComponent {
  private formBuilder = inject(FormBuilder);

  profileForm = this.formBuilder.group({
    username: [''],
    email: [''],
  });
  onSubmit()
  {
    console.log('Form data ',this.profileForm.value)
  }
  get username()
  {
    return this.profileForm.controls.username.value;
  }
  set username(value)
  {
    this.profileForm.controls.username.setValue(value);
  }
  updateName()
  {
    this.username = 'Updated';
  }
  updateProfile()
  {
    this.profileForm.patchValue({
      ...this.profileForm.value,
      username: 'Updated',
      //email: 'update@email.com'
    });
  }
}
