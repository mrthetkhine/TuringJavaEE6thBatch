import { Component } from '@angular/core';

@Component({
  selector: 'app-binding',
  standalone: true,
  imports: [],
  templateUrl: './binding.component.html',
  styleUrl: './binding.component.css'
})
export class BindingComponent {

  formValid = false;
  useTheme = false;
  useAnother = false;

  fontSize = 12;
  classGroup = {
    'theme':true,
    'another':false,
  };
  constructor() {
    console.log('Class Group ',this.classGroup);
  }
  ngDoCheck()
  {
    console.log('ngDoCheck Class Group ',this.classGroup);
  }
  validateForm()
  {
    this.formValid =true;
  }
  setTheme()
  {
    this.useTheme = true;
    this.classGroup= {
      'theme':this.useTheme,
      'another':this.useAnother,
    };
  }
  toggle()
  {
    this.useAnother = !this.useAnother;
    this.classGroup= {
      'theme':this.useTheme,
      'another':this.useAnother,
    };
  }
  incFontSize()
  {
    this.fontSize += 2;
  }
  updateField(event: KeyboardEvent): void {
    console.log(`The user pressed: ${event.key}`);
  }
}
