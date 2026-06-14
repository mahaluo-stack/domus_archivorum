import { inject } from '@angular/core';
import { Router } from '@angular/router';
import { UserService } from '../services/user.service';

export const AuthGuard = () => {

  const userService: UserService = inject(UserService);
  const router: Router = inject(Router);

  return userService.currentUser.subscribe((currentUser) => {
    if (currentUser.name === '') {
      router.navigateByUrl("/log in");
      return false;
    }
    else {
      return true;
    }
  })
}