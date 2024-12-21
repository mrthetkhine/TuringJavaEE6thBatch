import {Component, inject} from '@angular/core';
import {FormBuilder, ReactiveFormsModule, Validators} from "@angular/forms";
import {CommonModule} from "@angular/common";

@Component({
  selector: 'app-login-page',
  standalone: true,
  imports: [
    CommonModule,
    ReactiveFormsModule,
  ],
  templateUrl: './login-page.component.html',
  styleUrl: './login-page.component.css'
})
export class LoginPageComponent {
  private formBuilder = inject(FormBuilder);
  loginForm = this.formBuilder.group({

    username: ['',[Validators.required,],

    ],
    password: ['',[Validators.required,]
    ],

  });
  get username()
  {
    return this.loginForm.controls.username;
  }
  get password()
  {
    return this.loginForm.controls.password;
  }
  onSubmit()
  {

  }
}
