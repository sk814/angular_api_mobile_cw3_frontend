import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LoginComponent } from './components/login/login.component';
import { MakerdashboardComponent } from './components/makerdashboard/makerdashboard.component';
import { MakerloginComponent } from './components/makerlogin/makerlogin.component';
import { SigninComponent } from './components/signin/signin.component';
import { VoldashboardComponent } from './components/voldashboard/voldashboard.component';

const routes: Routes = [
  { path: "login", component: LoginComponent},
  { path: "", component: SigninComponent},
  { path: "makerlogin", component: MakerloginComponent},
  { path: "voldashboard", component: VoldashboardComponent},
  { path: "makerdashboard", component: MakerdashboardComponent},
];
@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
