import {Component, TemplateRef, ViewChild} from '@angular/core';
import {NgTemplateOutlet} from "@angular/common";

@Component({
  selector: 'app-ng-template-demo',
  standalone: true,
  imports: [NgTemplateOutlet],
  templateUrl: './ng-template-demo.component.html',
  styleUrl: './ng-template-demo.component.css'
})
export class NgTemplateDemoComponent {
  count = 100;
  @ViewChild('myFragment', {read: TemplateRef}) myFragment: TemplateRef<unknown> | undefined;

  show()
  {
    console.log('Template ',this.myFragment);
  }
}
