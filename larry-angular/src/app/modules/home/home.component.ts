import {Component, NgModule, OnInit} from '@angular/core';
import {Http, HttpModule, Response} from "@angular/http";
import 'rxjs/add/operator/map';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})

export class HomeComponent implements OnInit{
  title = 'home';

  //判断是否登录系统
  constructor(private http: Http){
    // this.http.get('/api/demo')
    //   .subscribe((res: Response) => {
    //     console.log(res.json())
    //   });
  }

  ngOnInit(){
    // this.http.get("/api/demo").subscribe((res:Response)=>{
    //   console.info(res.json())
    // });
  }
}
