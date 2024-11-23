import {Component, computed, Signal, signal} from '@angular/core';

@Component({
  selector: 'app-counter',
  standalone: true,
  imports: [],
  templateUrl: './counter.component.html',
  styleUrl: './counter.component.css'
})
export class CounterComponent {
  count = signal(0);
  doubleCount: Signal<number> = computed(() => this.count() * 2);
  inc()
  {
    console.log('Inc');
    this.count.update(oldValue=>oldValue+1);
  }
  dec()
  {
    console.log('Dec');
    this.count.update(oldValue=>oldValue-1);
  }
  reset()
  {
    console.log('reset');
    this.count.set(0);
  }
}
