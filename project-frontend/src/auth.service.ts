import { Injectable } from '@angular/core';
import {Observable} from 'rxjs';
import {HttpClient} from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  private authUrl:string = 'http://localhost:8080/auth/signIn'

  constructor(private http: HttpClient) { }

  login(username: String, password: String) : Observable<any>{
    return this.http.post(this.authUrl, {username, password: password}, {responseType:'text'})
  }

}
