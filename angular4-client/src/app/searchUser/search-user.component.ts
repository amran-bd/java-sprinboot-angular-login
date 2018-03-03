import {Component, OnInit} from '@angular/core';
import {User} from '../user';
import {DataService} from '../data.service';

@Component({
  selector: 'search-user',
  templateUrl: './search-user.component.html',
  styleUrls: ['./search-user.component.css']
})

export class SearchUserComponent implements OnInit {
  id: number;
  users: User[];

  constructor(private dataService: DataService) {}

  ngOnInit() {
    this.id;
  }

  private searchUsers() {
    this.dataService.getUserById(this.id).then(users => this.users = users);
  }

  onSubmit() {
    this.searchUsers();
  }

}
export class style{}
