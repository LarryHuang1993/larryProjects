import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppComponent } from './app.component';
import { appRouting } from "./app.router";
import {BsDropdownModule} from "ngx-bootstrap/dropdown";
import { LoginComponent } from './modules/login/login.component';
import { HomeComponent} from "./modules/home/home.component";
import {HttpModule} from "@angular/http";

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    LoginComponent
  ],
  imports: [
    BrowserModule,
    appRouting,
    BsDropdownModule.forRoot(),
    HttpModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
