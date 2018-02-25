import { User} from './app.module.user';
import {DataService} from './app.data.service';
import {Component, OnInit} from '@angular/core';
import {Location} from '@angular/common';

@Component({
  selector: 'app-create-user',
  templateUrl: './app.create-user.component.html',
  styleUrls: ['./app.create-user.component.css']
})

export class AppCreateUserComponent implements OnInit {
  user = new User;
  submitted = false;
  constructor(private dataService: DataService,
              private location: Location) {}

  ngOnInit() {
  }

  newUser(): void {
    this.submitted = false;
    this.user = new User();
  }

  private save(): void {
    this.dataService.create(this.user);
  }

  onSubmit() {
    this.submitted = true;
    this.save();
  }

  goBack(): void {
    this.location.back();
  }
}
