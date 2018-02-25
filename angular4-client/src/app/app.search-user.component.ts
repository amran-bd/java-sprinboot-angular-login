import {Component, OnInit} from '@angular/core';
import {User} from './app.module.user';
import {DataService} from './app.data.service';

@Component({
  selector: 'app-search-user',
  templateUrl: './app.search-user.component.html',
  styleUrls: ['./app.search-user.component.css']
})

export class AppSearchUserComponent implements OnInit {
  lastName: string;
  users: User[];

  constructor(private dataService: DataService) {}

  ngOnInit() {
    this.lastName = "";
  }

  private searchUsers() {
    this.dataService.getUserByLastName(this.lastName).then(users => this.users = users);
  }

  onSubmit() {
    this.searchUsers();
  }

}
