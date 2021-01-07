import { error } from '@angular/compiler/src/util';
import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators, AbstractControl, FormBuilder } from '@angular/forms';
import { Router } from '@angular/router';
import { throwError } from 'rxjs';
import { catchError } from 'rxjs/operators';
import { AuthService } from 'src/app/services/auth.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  errorMsg: string = '';
  submitted = false;
  ngOnInit(): void {
  }
  constructor(private router: Router, private authService: AuthService, private formBuilder: FormBuilder) {

  }

  loginForm = new FormGroup({
    email: new FormControl('', Validators.required),
    password: new FormControl('', Validators.required)
  });

  login() {
    console.log('I Was clicked')

    this.errorMsg = '';

    this.authService.login(this.loginForm.value)
    // .pipe(
    //   catchError(err => {
    //     console.log('Handling error locally and rethrowing it...', err);
    //     return throwError(err);
    // })
    // )
    .subscribe(resData => {
      this.authService.setVolToken(resData)
      console.log(resData);
      // if(resData != 'null'){
      //   // this.router.navigate(["voldashboard",])}
      console.log('resData:',resData);
      console.log(resData);
    },
      error => {
        console.log('oops',error);
        this.errorMsg = JSON.stringify(error?.error?.error);
      },
      () =>{
        this.router.navigate(["voldashboard",])
      }
    );



  }
}


