import { Routes } from '@angular/router';
import {CustomersComponent} from './ui/customers/customers.component';
import {RolesComponent} from './ui/roles/roles.component';


export const routes: Routes = [
  { path: 'customers', component: CustomersComponent, canActivate: [AuthGuard] },
  { path: 'roles', component: RolesComponent, canActivate: [AuthGuard] },
  { path: '', redirectTo: '/customers', pathMatch: 'full' }
];
