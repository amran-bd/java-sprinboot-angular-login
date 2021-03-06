import { Component, OnInit } from '@angular/core';
import { User } from '../user';
import { DataService } from '../data.service';

@Component({
  selector: 'users-list',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css'],
})

export class UserComponent implements OnInit {
  users: User[];
  selectedUser: User;

  constructor(private dataService: DataService) {}

  getUsers() {
    this.dataService.getUsers().then(users => this.users = users);
  }

  ngOnInit(): void {
    this.getUsers();
  }

  onSelect(usr: User): void {
    this.selectedUser = usr;
  }
}
export class style{}
