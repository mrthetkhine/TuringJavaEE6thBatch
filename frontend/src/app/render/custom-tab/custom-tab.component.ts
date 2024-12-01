import {
  Component,
  ContentChildren,
  contentChildren,
  input,
  QueryList,
  TemplateRef,
  ViewContainerRef
} from '@angular/core';
import {TabPageComponent} from "../../tab/tab-page/tab-page.component";
import {CustomTabPageComponent} from "../custom-tab-page/custom-tab-page.component";
import {NgTemplateOutlet} from "@angular/common";

@Component({
  selector: 'app-custom-tab',
  standalone: true,
  imports: [NgTemplateOutlet],
  templateUrl: './custom-tab.component.html',
  styleUrl: './custom-tab.component.css'
})
export class CustomTabComponent {
  headers= input<string[]>();
  activeIndex = 0;


  pages = contentChildren(CustomTabPageComponent);
  currentPage !:any ;

  constructor() {}
  ngAfterContentInit() {
    this.currentPage = this.pages()[0];

  }

  tabHeaderClick(index:number)
  {
    console.log('Tab Header click ',index);
    this.activeIndex = index;
    console.log('Pages ',this.pages());
    this.currentPage = this.pages()[this.activeIndex];
    console.log('Current Page ',this.currentPage);
  }
}
