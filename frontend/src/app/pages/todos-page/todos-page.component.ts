import { Component } from '@angular/core';
import {Router} from "@angular/router";

@Component({
  selector: 'app-todos-page',
  standalone: true,
  imports: [],
  templateUrl: './todos-page.component.html',
  styleUrl: './todos-page.component.css'
})
export class TodosPageComponent {
  todos =['Task1','Task2','Task3']

  constructor(private router: Router  ) {
  }
  gotoDetails(index:number)
  {
    console.log('Index ',index);
    this.router.navigate(['todos',index]);
  }
}
