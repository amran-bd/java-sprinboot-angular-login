import {AppCreateUserComponent} from './createUser/app.create-user.component';
import {UserComponent} from './user/app.user.component';
import {AppSearchUserComponent} from './searchUser/app.search-user.component';

import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';

const routes: Routes = [
  {path: '', redirectTo: 'user', pathMatch: 'full'},
  {path: 'user', component: UserComponent},
  {path: 'add', component: AppCreateUserComponent},
  {path: 'findbylastname', component: AppSearchUserComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})

export class AppRoutingModule {}
