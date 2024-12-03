import {Directive, Input, TemplateRef, ViewContainerRef} from '@angular/core';

@Directive({
  selector: '[appTimes]',
  standalone: true
})
export class TimesDirective {

  constructor(
    private templateRef: TemplateRef<any>,
    private viewContainer: ViewContainerRef,
  ) {}
  @Input() set appTimes(times: number) {
    for(let i=0;i<times;i++)
    {
      this.viewContainer.createEmbeddedView(this.templateRef);
    }

  }
}
