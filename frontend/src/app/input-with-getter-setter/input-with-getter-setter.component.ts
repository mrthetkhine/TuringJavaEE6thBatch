import {Component, input, Input} from '@angular/core';

@Component({
  selector: 'app-input-with-getter-setter',
  standalone: true,
  imports: [],
  templateUrl: './input-with-getter-setter.component.html',
  styleUrl: './input-with-getter-setter.component.css'
})
export class InputWithGetterSetterComponent {
  data=input<string>();

  @Input()
  get value(): number {
    return this.internalValue;
  }
  set value(newValue: number)
  {
    console.log('Setter newValue ',newValue);
    this.internalValue = newValue;
  }
  private internalValue = 0;

}
