import { Component,OnInit } from '@angular/core';
import {HttpClient} from '@angular/common/http'; // <-- Ajoutez cette ligne

@Component({
  selector: 'app-roles',
  templateUrl: './roles.component.html',
  styleUrl: './roles.component.css'
})
export class RolesComponent implements OnInit{
  public Roles : any;
  constructor(private http : HttpClient) {
  }
  ngOnInit(){
    this.http.get("http://localhost:8090/api/roles").subscribe({
      next : data=>{
        this.Roles=data;
      },
      error : err => {
        console.log(err);
      }
    })
}
}
