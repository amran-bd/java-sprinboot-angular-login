import {AppRoutingModule} from './app-routing.module';
import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';
import {FormsModule} from '@angular/forms';
import {HttpModule} from '@angular/http';

import {AppComponent} from './app.component';
import {UserDetailsComponent} from './userDetails/user-details.component';
import {UserComponent} from './user/user.component';
import {DataService} from './data.service';
import {CreateUserComponent} from './createUser/create-user.component';

import {enableProdMode} from '@angular/core';
import {SearchUserComponent} from './searchUser/search-user.component';

@NgModule({
  declarations: [
    AppComponent,
    UserDetailsComponent,
    UserComponent,
    CreateUserComponent,
    SearchUserComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule,
    AppRoutingModule
  ],
  providers: [DataService],
  bootstrap: [AppComponent]
})

export class AppModule {}
