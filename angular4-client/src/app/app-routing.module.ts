import {CreateUserComponent} from './createUser/create-user.component';
import {UserComponent} from './user/user.component';
import {SearchUserComponent} from './searchUser/search-user.component';

import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';

const routes: Routes = [
  {path: '', redirectTo: 'user', pathMatch: 'full'},
  {path: 'user', component: UserComponent},
  {path: 'add', component: CreateUserComponent},
  {path: 'findUserById', component: SearchUserComponent},
  {path: 'user/edit/:id', component: SearchUserComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})

export class AppRoutingModule {}
