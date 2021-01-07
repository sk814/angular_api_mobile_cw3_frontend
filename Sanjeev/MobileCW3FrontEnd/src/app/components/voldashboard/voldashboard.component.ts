import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { AuthService } from 'src/app/services/auth.service';
import { VolenService } from 'src/app/services/volen.service';

@Component({
  selector: 'app-voldashboard',
  templateUrl: './voldashboard.component.html',
  styleUrls: ['./voldashboard.component.css']
})
export class VoldashboardComponent implements OnInit {

  volDataForm:FormGroup;
  groups=['A','B']
  doses=[1,0.5]
  submitted:boolean=false;
  errorMsg:string='';
  
  
  
  
  constructor(private fb : FormBuilder,private authService:AuthService, private volenService: VolenService, private router: Router) { 
    
   
    this.volDataForm = this.fb.group({
   
      group:[null,Validators.required],
      dose:[null,Validators.required],   
  })
  }


  ngOnInit(): void {
  }

  public volDataForms(){
    this.errorMsg='';
    this.submitted=true;
  }

  logout() {
    this.authService.removeToken();
  }

  sendPositiveData()
  {
 
  var formValue = this.volDataForm.value;

  formValue['positive'] = true
  console.log(formValue)
  this.volenService.addVolData(formValue).subscribe(responseData => {
    console.log(responseData);
    this.router.navigate([""])
  });

  }

  sendNegativeData()
  {
    const formValue = this.volDataForm.value;
  this.volenService.addVolData(formValue).subscribe(responseData => {
    console.log(responseData);
    this.router.navigate([""])
  });

  }

}
