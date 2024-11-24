import {Component, effect, signal, untracked} from '@angular/core';

@Component({
  selector: 'app-signal-un-track',
  standalone: true,
  imports: [],
  templateUrl: './signal-un-track.component.html',
  styleUrl: './signal-un-track.component.css'
})
export class SignalUnTrackComponent {
  itemOne = signal(1);
  itemTwo = signal(2);

  constructor() {
    effect((onCleanup)=>{
      console.log('Effect ItemOne ',this.itemOne(), ' Item two ',untracked(this.itemTwo));

      const timer = setTimeout(() => {
        console.log(`1 second ago, the user became ${this.itemOne()}`);
      }, 1000);
      onCleanup(() => {
        clearTimeout(timer);
      });
    });
  }

  incOne()
  {
    this.itemOne.update(old=>old+2);

  }
  incTwo()
  {
    this.itemTwo.update(old=>old+3);
  }
}
