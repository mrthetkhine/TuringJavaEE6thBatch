import {Component, HostBinding, HostListener, signal} from '@angular/core';

@Component({
  selector: 'app-host-element-demo',
  standalone: true,
  imports: [],
  templateUrl: './host-element-demo.component.html',
  styleUrl: './host-element-demo.component.css',
  host: {
    'role': 'slider',
    /*'[attr.aria-valuenow]': 'value',*/
    '[class.active]': 'isActive()',
    '[tabIndex]': 'disabled ? -1 : 0',
    '(keydown)': 'updateValue($event)',
  },
})
export class HostElementDemoComponent {
  @HostBinding('attr.aria-valuenow')
  value: number = 0;

  //value: number = 0;
  disabled: boolean = false;
  isActive = signal(false);

  updateValue(event: KeyboardEvent) {
    console.log('Key Down ',event);
  }
  @HostListener('click', ['$event'])
  mouseclick(event: MouseEvent) {
    console.log('Click ',event);
  }
}
