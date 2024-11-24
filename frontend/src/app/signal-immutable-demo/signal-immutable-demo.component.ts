import {Component, computed, effect, Signal, signal} from '@angular/core';

@Component({
  selector: 'app-signal-immutable-demo',
  standalone: true,
  imports: [],
  templateUrl: './signal-immutable-demo.component.html',
  styleUrl: './signal-immutable-demo.component.css'
})
export class SignalImmutableDemoComponent {
  list = signal([10,20,30]);
  listSize: Signal<number> = computed(() => this.list().length);
  constructor() {
    effect(()=>{
      let item= this.list();

      console.log('Item length ',this.list());
    });
  }
  addItem()
  {
    this.list.set([... this.list(),100]);
  }
}
