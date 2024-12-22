import { HttpInterceptorFn } from '@angular/common/http';
import {inject} from "@angular/core";
import {Router} from "@angular/router";
import {AuthService} from "../services/auth.service";

export const tokenInterceptorInterceptor: HttpInterceptorFn = (req, next) => {
  const router = inject(Router);
  const authService =inject(AuthService);
  //console.log('Intercepted');
  //console.log('tokenInterceptorInterceptor Req ',req);

  if(authService.isAuthenticated())
  {
    req = req.clone({
      setHeaders: {
        Authorization: `Bearer ${authService.token}`,
      }
    })
  }

  return next(req);
};
