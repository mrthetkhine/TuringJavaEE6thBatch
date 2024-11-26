import {Component, contentChild, contentChildren, input, viewChildren} from '@angular/core';
import {TabPageComponent} from "../tab-page/tab-page.component";

@Component({
  selector: 'app-tab',
  standalone: true,
  imports: [TabPageComponent],
  templateUrl: './tab.component.html',
  styleUrl: './tab.component.css'
})
export class TabComponent {
  headers= input<string[]>();
  //pages = viewChildren(TabPageComponent);
  pages = contentChildren(TabPageComponent);

  activeIndex = 0;
  ngAfterViewInit()
  {
    console.log('Pages ',this.pages());
    let len = this.pages().length;
    for(let i=0;i< len;i++)
    {
      console.log('Hide ',i);
      this.pages()[i].hideTabPage();
    }
    this.pages()[0].showTabPage();
  }
  tabHeaderClick(index:number)
  {
    this.activeIndex = index;
    console.log('Tab Header index ',index);
    let len = this.pages().length;
    for(let i=0;i< len;i++)
    {
        console.log('Hide ',i);
        this.pages()[i].hideTabPage();
    }
    console.log('Index ',index);
    this.pages()[index].showTabPage();
  }
}
