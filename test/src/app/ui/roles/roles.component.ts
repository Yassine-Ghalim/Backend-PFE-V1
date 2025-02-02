import { Component,OnInit } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import { CommonModule } from '@angular/common'; // Importer CommonModule

@Component({
  selector: 'app-roles',
  templateUrl: './roles.component.html',
  styleUrl: './roles.component.css',
  imports:[CommonModule],
  standalone: true,
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
