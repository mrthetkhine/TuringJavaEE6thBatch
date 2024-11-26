import {afterNextRender, afterRender, Component, HostListener, input, SimpleChanges} from '@angular/core';

@Component({
  selector: 'app-life-cycle-demo',
  standalone: true,
  imports: [],
  templateUrl: './life-cycle-demo.component.html',
  styleUrl: './life-cycle-demo.component.css'
})
export class LifeCycleDemoComponent {

  @HostListener('click', ['$event'])
  mouseclick(event: MouseEvent) {
    console.log('Click ',event);
  }

  data=input<number>();
  constructor() {
    console.log('LifeCycleDemoComponent created');
    afterNextRender(()=>console.log('AfterNextRender'));
    afterRender(()=>{
      console.log('After render');
    });
  }
  ngOnInit()
  {
    console.log('ngOnInit Run once');
  }
  ngOnChanges(changes: SimpleChanges)
  {
    console.log('ngOnChanges ',changes);
  }
  ngDoCheck()
  {
    console.log('ngDoCheck');
  }
  ngAfterContentInit()
  {
    console.log('ngAfterContentInit');
  }
  ngAfterContentChecked()
  {
    console.log('ngAfterContentChecked');
  }

}
