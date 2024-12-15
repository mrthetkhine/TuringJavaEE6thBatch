import { HttpInterceptorFn } from '@angular/common/http';
import {inject} from "@angular/core";
import {Router} from "@angular/router";

export const tokenInterceptorInterceptor: HttpInterceptorFn = (req, next) => {
  const router = inject(Router);

  console.log('Intercepted');
  console.log('tokenInterceptorInterceptor Req ',req);
  /*req = req.clone({
    setHeaders: {
      //Authorization: `Bearer ${authService.getToken()}`
      'Access-Control-Allow-Origin':'*'
    }
  });*/
  return next(req);
};
