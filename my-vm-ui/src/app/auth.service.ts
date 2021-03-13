import { Injectable } from '@angular/core';
@Injectable({ providedIn: 'root' })
export class AuthService {

    validate(username, password) {
        if (username == 'thrinod@test.com' && password == '123456') {
            return true;
        }
        return false;
    }

}