import {Component, input} from '@angular/core';
import {User} from "../../user.model";
import {AdminBioComponent} from "../admin-bio/admin-bio.component";
import {UserBioComponent} from "../user-bio/user-bio.component";
import {NgComponentOutlet} from "@angular/common";

@Component({
  selector: 'app-bio',
  standalone: true,
  imports: [
    NgComponentOutlet,
    /*AdminBioComponent,
    UserBioComponent,*/
  ],
  templateUrl: './bio.component.html',
  styleUrl: './bio.component.css'
})
export class BioComponent {
  user = input.required<User>();

  constructor() {
  }
  getBioComponent()
  {
    return this.user()?.isAdmin?AdminBioComponent: UserBioComponent;
  }
}
