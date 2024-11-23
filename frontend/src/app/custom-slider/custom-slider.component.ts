import {Component, model} from '@angular/core';

@Component({
  selector: 'app-custom-slider',
  standalone: true,
  imports: [],
  templateUrl: './custom-slider.component.html',
  styleUrl: './custom-slider.component.css'
})
export class CustomSliderComponent {
  value = model(0);

  increment() {
    // Update the model input with a new value, propagating the value to any bindings.
    console.log('Increment ');
    this.value.update(oldValue => oldValue + 10);
  }
}
