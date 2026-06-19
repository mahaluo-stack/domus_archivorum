import { inject } from '@angular/core';
import { Router } from '@angular/router';
import { UserService } from '../services/user.service';
import { filter, map } from 'rxjs';
import { User } from '../models/interfaces/user.interface';

export const AuthGuard = () => {

  const userService: UserService = inject(UserService);
  const router: Router = inject(Router);

  return userService.currentUser
    .pipe(
      filter((user): user is User => user !== null),
      map(currentUser => currentUser))
    .subscribe((currentUser) => {
      if (currentUser.name === '') {
        router.navigateByUrl("/log in");
        return false;
      }
      else {
        return true;
      }
    });
}