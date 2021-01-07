import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { AuthService } from 'src/app/services/auth.service';

@Component({
  selector: 'app-makerlogin',
  templateUrl: './makerlogin.component.html',
  styleUrls: ['./makerlogin.component.css']
})
export class MakerloginComponent implements OnInit {
  makerloginForm: FormGroup;
  errorMsg:string='';
  submitted  =  false;
  ngOnInit(): void {
  }
  constructor(private router : Router,private authService:AuthService,private formBuilder : FormBuilder) {
    this.makerloginForm  =  this.formBuilder.group({
      username: ['', Validators.required],
      password: ['', Validators.required]
  });

  }

  makerlogin()
  {
    this.errorMsg='';
    this.submitted = true;
    
    if(this.makerloginForm.valid)
    {
      this.authService.mLogin(this.makerloginForm.value).subscribe(
        responseData => {
          this.authService.setToken(responseData);
         this.router.navigate(["makerdashboard"]);
         console.log(responseData);
        },
        error => {this.errorMsg = "Invalid Credentials!";}
        ) 

}
  }
}
