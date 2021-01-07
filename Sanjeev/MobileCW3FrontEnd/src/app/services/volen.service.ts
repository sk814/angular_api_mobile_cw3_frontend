import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class VolenService {

  constructor(private http: HttpClient) { }

  addVolData(formValue: any) {
    console.log(formValue);
    return this.http
      .post(
        environment.backendUrl + '/vaccine/volunteers',
        formValue
      );
  }

}
