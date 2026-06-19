import { inject } from '@angular/core';
import {
    CanActivateFn,
    Router
} from '@angular/router';

import { UserService } from '../services/user.service';
import { Role } from '../models/constants/roles.enum';

export const AdminGuard: CanActivateFn = () => {

    const userService = inject(UserService);
    const router = inject(Router);

    const user = userService.currentUser.value;

    if (!user) {
        return router.createUrlTree(['/login']);
    }

    if (
        !user.roles.includes(Role.Administrator)
    ) {
        return router.createUrlTree(['/atrium']);
    }

    return true;
};