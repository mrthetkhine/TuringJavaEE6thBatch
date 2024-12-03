import { Component } from '@angular/core';

@Component({
  selector: 'app-template-variable-demo',
  preserveWhitespaces: true,
  standalone: true,
  imports: [],
  templateUrl: './template-variable-demo.component.html',
  styleUrl: './template-variable-demo.component.css'
})
export class TemplateVariableDemoComponent {

  get complexExp()
  {
    return 1+2*3/5;
  }

}
