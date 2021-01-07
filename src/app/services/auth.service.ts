import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  constructor(private http: HttpClient) { }

  public login(credentials: any) {
    const headers = new HttpHeaders({
      'Content-Type': 'application/json; charset=utf-8'
    });
    console.log('IM CALLED from auth service');
    console.log(credentials)
    return this.http
      .post(
        environment.backendUrl + '/vaccine/login',
        credentials,
        {
          headers: headers
        }
      )
  }

  public mLogin(credentials: any) {
    console.log(credentials)

    const headers = new HttpHeaders({
      'Content-Type': 'application/json; charset=utf-8'
    });

    return this.http
      .post(
        environment.backendUrl + '/vaccine/adminlogin',
        credentials,
        {
          headers: headers
        }
      )
  }

  public signin(signIn:any){
    console.log(signIn);
    return this.http.post(environment.backendUrl + "/vaccine/signup",
    signIn);
  }


  public setToken(token: any) {
    localStorage.setItem("token", token.token);
  }

  public setVolToken(token: any) {
    localStorage.setItem("token", token.token);
  }


  public removeToken() {
    localStorage.clear();
  }

  public getToken() {
    return localStorage.getItem("token");
  }

}