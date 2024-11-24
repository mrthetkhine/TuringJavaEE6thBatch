import {Component, input} from '@angular/core';

@Component({
  selector: 'app-life-cycle-demo',
  standalone: true,
  imports: [],
  templateUrl: './life-cycle-demo.component.html',
  styleUrl: './life-cycle-demo.component.css'
})
export class LifeCycleDemoComponent {

  data=input<number>();
  constructor() {
    console.log('LifeCycleDemoComponent created');
  }
  ngOnInit()
  {
    console.log('ngOnInit Run once');
  }
  ngOnChanges()
  {
    console.log('ngOnChanges ');
  }
}
