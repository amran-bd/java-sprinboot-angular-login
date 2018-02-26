import { Component, Input } from '@angular/core';

import { User } from '../user';
import { DataService } from '../data.service';

@Component({
  selector: 'user-detail',
  templateUrl: './user-details.component.html',
  styleUrls: ['./user-details.component.css'],
  providers: [DataService]
})

export class UserDetailsComponent {

  @Input() user: User;

  constructor(private dataService: DataService) {}

  delete(): void {
    this.dataService.delete(this.user.id).then(() => this.goBack());
  }

  goBack(): void {
    window.location.replace('');
  }
}
