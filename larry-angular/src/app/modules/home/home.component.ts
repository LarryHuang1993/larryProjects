import {Component, OnInit} from '@angular/core';
import {Http} from "@angular/http";
import 'rxjs/add/operator/map';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit{
  title = 'home';

  //判断是否登录系统
  constructor(private http: Http){ }

  ngOnInit(){
    this.http.get("/api/demo").subscribe(res=>res.json());
  }
}
