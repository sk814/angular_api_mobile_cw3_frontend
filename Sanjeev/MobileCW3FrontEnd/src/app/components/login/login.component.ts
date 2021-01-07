import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators, AbstractControl, FormBuilder } from '@angular/forms';
import { Router } from '@angular/router';
import { AuthService } from 'src/app/services/auth.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  errorMsg:string='';
  submitted  =  false;
  ngOnInit(): void {
  }
  constructor(private router : Router,private authService:AuthService,private formBuilder : FormBuilder) {

  }
  
  loginForm= new FormGroup({
    email: new FormControl('',Validators.required),
    password: new FormControl('',Validators.required)
  });

  login()
  {
    console.log('I Was clicked')

    this.errorMsg='';
    if(this.loginForm.valid)
    {
      this.authService.login(this.loginForm.value).subscribe(responseData => {
           this.authService.setVolToken(responseData)
           console.log(responseData);
          this.router.navigate(["voldashboard"])
          console.log("YAHI se call ho rha hai bhai!");
         },
         error => {this.errorMsg= error?.error?.error_message;
        }
         ); 
  }

  }


}

// public signin(){
//   this.submitted = true;
//   this.errorMessage = null;
//   if(this.signinForm.invalid){
//     return;
//   }
//   this.authService.signin(this.signinForm.value).subscribe(resp =>{
//     this.authService.setToken(resp);
//     this.router.navigate(["/dashboard"])
//   },error=>{
//      this.errorMessage= error?.error?.error_message;
//   });
// }


// makerlogin()
// {
//   this.errorMsg='';
//   this.submitted = true;
  
//   if(this.makerloginForm.valid)
//   {
//     this.authService.mLogin(this.makerloginForm.value).subscribe(
//       responseData => {
//         this.authService.setToken(responseData)
//        this.router.navigate(["makerdashboard"])
//       },
//       error => {this.errorMsg = "Invalid Credentials!"}
//       ) 

// }
// }


