import { Component, Input } from '@angular/core';

import { User } from './app.module.user';
import { DataService } from './app.data.service';

@Component({
  selector: 'app.user-detail',
  templateUrl: './app.user-details.component.html',
  styleUrls: ['./app.user-details.component.css'],
  providers: [DataService]
})

export class AppUserDetailsComponent {

  @Input() user: User;

  constructor(private dataService: DataService) {}

  delete(): void {
    this.dataService.delete(this.user.id).then(() => this.goBack());
  }

  goBack(): void {
    window.location.replace('');
  }
}
