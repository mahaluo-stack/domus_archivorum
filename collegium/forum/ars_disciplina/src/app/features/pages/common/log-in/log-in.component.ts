import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { FormBuilder, ReactiveFormsModule, Validators } from '@angular/forms';
import { UserService } from '../../../../core/services/user.service';
import { Role } from '../../../../core/models/constants/roles.enum';

@Component({
  selector: 'app-login',
  standalone: true,
  imports: [ReactiveFormsModule],
  templateUrl: './log-in.component.html',
  styleUrls: ['./log-in.component.scss']
})
export class LoginComponent {

  isSubmitted: boolean = false;

  loginForm = this.formBuilder.nonNullable.group({
    email: [localStorage.getItem("rememberMe") ?? '', [Validators.required, Validators.email]],
    password: ['', Validators.required],
    rememberMe: [localStorage.getItem("rememberMe") ? true : false]
  });

  constructor(
    private formBuilder: FormBuilder,
    private userService: UserService,
    private route: Router
  ) { }

  onSubmit(): void {
    if (!this.loginForm.invalid) {
      localStorage.setItem("token", "tokenation tokeroo");
      const form = this.loginForm.getRawValue();

      if (this.loginForm.value.rememberMe) {
        localStorage.setItem("rememberMe", form.email);
      }
      else {
        localStorage.removeItem("rememberMe");
      }

      this.userService.setCurrentUser({
        id: 1,
        name: 'test',
        email: form.email,
        roles: [Role.Administrator]
      });

      this.loginForm.reset();
      this.route.navigateByUrl("atrium");
    }
    this.isSubmitted = true;
  }
}