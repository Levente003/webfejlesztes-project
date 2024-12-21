import { Component } from '@angular/core';
import {FormsModule} from '@angular/forms';
import {MatCardModule} from '@angular/material/card';
import {MatFormFieldModule} from '@angular/material/form-field';
import {MatInputModule} from '@angular/material/input';
import {MatButtonModule} from '@angular/material/button';
import {AuthService} from '../../auth.service';
import {Router} from '@angular/router';

@Component({
  selector: 'app-login',
  imports: [FormsModule, MatCardModule, MatFormFieldModule, MatInputModule, MatButtonModule],
  templateUrl: './login.component.html',
  styleUrl: './login.component.css',
  standalone: true
})
export class LoginComponent {
  username = '';
  password = '';
  constructor(private authService: AuthService, private router: Router) {}

  onLogin(){
    this.authService.login(this.username, this.password).subscribe(
      (response: any) => {
        localStorage.setItem('token', response);
        localStorage.setItem('user', this.username);
        console.log('Successfully logged in!');
        this.router.navigate(['/characters'])
      },
      error => {
        console.log('Ran into an error while logging in!', error);
      }
    );
  }

  onReset() {
    this.username = "";
    this.password = "";
  }
}
