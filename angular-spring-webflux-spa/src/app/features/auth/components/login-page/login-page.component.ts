import {Component, inject} from '@angular/core';
import {FormBuilder, ReactiveFormsModule, Validators} from "@angular/forms";
import {CommonModule} from "@angular/common";
import {AuthService} from "../../../../core/services/auth.service";
import {LoginRequest} from "../../../../core/model/login-request.model";
import {ActivatedRoute, Router} from "@angular/router";
import Swal from "sweetalert2";

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
  redirectUrl ='';

  private formBuilder = inject(FormBuilder);
  loginForm = this.formBuilder.group({

    username: ['',[Validators.required,],

    ],
    password: ['',[Validators.required,]
    ],

  });
  constructor(
              private route: ActivatedRoute,
              private router: Router,
              private authService:AuthService,
              ) {
  }
  ngOnInit() {
    this.route.queryParams.subscribe(params => {
      this.redirectUrl = params['redirectUrl'];
      console.log('Redirect url ',this.redirectUrl);
    });
  }
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
    let loginRequest:LoginRequest = {
      ...this.loginForm.value
    } as LoginRequest;
    this.authService.login(loginRequest)
      .subscribe(resp=>{
          //console.log('Login Response ',resp);
          this.authService.setToken(resp.data.token);
          if(this.redirectUrl)
          {
            this.router.navigate([this.redirectUrl]);
          }
          else
          {
            this.router.navigate(['home']);
          }

      },error=>{
        //console.log('Invalid login ',error);
        Swal.fire({
          icon: "error",
          title: "Invalid login",
          text: "Login failed,invalid username or password",

        });
      });
  }
}
