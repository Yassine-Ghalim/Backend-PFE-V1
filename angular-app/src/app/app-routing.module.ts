import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {RolesComponent} from './ui/roles/roles.component';
import {CustomersComponent} from './ui/customers/customers.component';
import { AuthGuard } from './guards/auth.guard';

const routes: Routes = [
  {path : "roles", component : RolesComponent, canActivate : [AuthGuard], data : {roles : ["ADMIN"]}},
  {path : "customers", component : CustomersComponent, canActivate : [AuthGuard], data : {roles : ["uSER"]}}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
