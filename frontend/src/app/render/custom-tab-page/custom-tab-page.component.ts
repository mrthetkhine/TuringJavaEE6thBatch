import {Component, TemplateRef, ViewChild} from '@angular/core';

@Component({
  selector: 'app-custom-tab-page',
  standalone: true,
  imports: [],
  templateUrl: './custom-tab-page.component.html',
  styleUrl: './custom-tab-page.component.css'
})
export class CustomTabPageComponent {
  @ViewChild('content') content: TemplateRef<any> | null = null;
}
