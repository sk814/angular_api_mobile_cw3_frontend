import { Component, OnInit } from '@angular/core';
import { catchError, retry } from 'rxjs/operators';
import { MakerService } from 'src/app/services/maker.service';
import { AuthService } from 'src/app/services/auth.service';

@Component({
  selector: 'app-makerdashboard',
  templateUrl: './makerdashboard.component.html',
  styleUrls: ['./makerdashboard.component.css']
})
export class MakerdashboardComponent implements OnInit {

  public doughnutChartLabels = ['Total Vollentries', 'Positive'];
  public doughnutChartData = [0,];
  public doughnutChartType = 'doughnut' as const;
  public detailsData: any=null;
  public totalPositive: any=null;
  // declare var something: string;
  // eval("something = 'testing';")
  

  constructor(private makerService: MakerService, private authService: AuthService) { }

  ngOnInit(): void {
    this.fetchDetails();
  }
    

  public fetchDetails() {
    
    
    console.log("Fetch Data")
    this.makerService.getMakerInfo()
    .subscribe(details =>
      {
        console.log(details);
        this.detailsData = details;
        this.doughnutChartData= [this.detailsData['totalVolunteer'], this.detailsData['totalPositive']];
        this.totalPositive= this.detailsData['totalPositive'];
      }
      );
   // 
  }

  logout() {
    this.authService.removeToken();
  }

}
