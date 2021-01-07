import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class MakerService {

  constructor(private http: HttpClient) { }

  getMakerInfo() {
    console.log(environment.backendUrl + '/vaccine/maker');
    return this.http.get(environment.backendUrl + '/vaccine/maker');
  }

}


