import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators, AbstractControl, FormBuilder } from '@angular/forms';
import { Router } from '@angular/router';
import { AuthService } from 'src/app/services/auth.service';

@Component({
  selector: 'app-signin',
  templateUrl: './signin.component.html',
  styleUrls: ['./signin.component.css']
})
export class SigninComponent implements OnInit {
  form: FormGroup;
  errorMsg: any= null;
  isVolLoggedIn: boolean = false;
  isMakerLoggedIn: boolean = false;
  isSignUp: boolean=false;
  submitted: boolean=false;

  constructor(private formbuinder : FormBuilder, private router : Router, private authService: AuthService) {

    this.form = this.formbuinder.group({
      email:['',[Validators.required,Validators.email]],
      password:['',Validators.required],
      name:['',Validators.required],
      age:['',[Validators.required,this.ageValidation]],
      address:['',Validators.required],
    })
  }

  ngOnInit(): void {}

  signin()
  {
      this.submitted=true;
      this.errorMsg='';
   if(!this.form.valid)
   return;

   this.authService.signin(this.form.value).subscribe(responseData =>{
     console.log(responseData);
    this.isSignUp = true;
    this.router.navigate(["login"]);
   },error=>{
     console.log(error);
     
     this.errorMsg="USER ALREADY EXIST!";
   })
  }

  ageValidation(control:AbstractControl):{key:string,value:boolean} | null
  {
      const age:number= control.value
      if(age < 18){
        return {key:"invalidAge",value:true}
      }
    return null;
  }
}
