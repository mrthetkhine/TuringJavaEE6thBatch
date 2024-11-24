import {Component, computed, effect, OnChanges, Signal, signal, SimpleChanges, untracked} from '@angular/core';

@Component({
  selector: 'app-counter',
  standalone: true,
  imports: [],
  templateUrl: './counter.component.html',
  styleUrl: './counter.component.css'
})
export class CounterComponent implements OnChanges {
  count = signal(0);
  doubleCount: Signal<number> = computed(() => this.count() * 2);

  constructor() {
    effect(()=>{
      console.log('Effect run ',this.count(), 'double count ',untracked(this.doubleCount));
    });
  }
  ngOnChanges(changes:SimpleChanges)
  {
    console.log('Component changed');
  }
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
