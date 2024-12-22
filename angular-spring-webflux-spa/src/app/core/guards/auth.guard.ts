import {CanActivateFn, Router} from '@angular/router';
import {inject} from "@angular/core";
import {AuthService} from "../services/auth.service";

export const authGuard: CanActivateFn = (route, state) => {
  //console.log('Route ',route, ' state ', state);
  const router = inject(Router);
  const authService = inject(AuthService);
  if(authService.isAuthenticated())
  {
    return true;
  }
  else
  {
    router.navigate(['login'],
      { queryParams: { redirectUrl: route.url[0].path} });
    return false;
  }
};
