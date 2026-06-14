import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs';

@Injectable({
    providedIn: 'root'
})
export class UserService {

    currentUser = new BehaviorSubject({ id: '', name: '' });

    constructor() {
        this.currentUser.subscribe((value) => {
            this.currentUser.value.id = value.id;
            this.currentUser.value.name = value.name;
        });
    }

    setCurrentUser(currentUserName: string | null) {
        if (currentUserName === '' || currentUserName === null) { this.currentUser.next({ id: '', name: '' }); }
        else { this.currentUser.next({ id: '1', name: currentUserName }); }
    }
}