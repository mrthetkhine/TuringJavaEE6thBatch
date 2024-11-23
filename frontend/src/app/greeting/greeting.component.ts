import {Component, input} from '@angular/core';

function toUpper(value: string | undefined): string {
  console.log('ToUpper ',value);
  return value?.toUpperCase() ?? '';
}
@Component({
  selector: 'app-greeting',
  standalone: true,
  imports: [],
  templateUrl: './greeting.component.html',
  styleUrl: './greeting.component.css'
})
export class GreetingComponent {

  message = input('',{
    transform:toUpper,
    alias:'msg'
  });
}
