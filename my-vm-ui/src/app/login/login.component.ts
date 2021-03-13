import { Component, OnInit } from '@angular/core';
import { User } from '../User';

import { Router, ActivatedRoute } from '@angular/router';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { AuthService } from '../auth.service';
@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  loginform: FormGroup;
  constructor(private authService: AuthService,
              private router: Router) { }
  model = new User('', '');
  badlogin = false;
  ngOnInit(): void {
    this.loginform.disabled;
  }

  onSubmit() { 
    if(this.authService.validate(this.model.name  ,this.model.password)){
      console.log('Redirect to home');
      this.router.navigate(['/home']);
    }else{
      this.badlogin =true;
    }
   }

}
