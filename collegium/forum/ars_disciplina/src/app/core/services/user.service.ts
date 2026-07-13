import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs';
import { User } from '../models/user.interface';

@Injectable({
    providedIn: 'root'
})
export class UserService {

    readonly currentUser = new BehaviorSubject<User | null>(null);

    setCurrentUser(user: User | null): void {
        this.currentUser.next(user);
    }
}