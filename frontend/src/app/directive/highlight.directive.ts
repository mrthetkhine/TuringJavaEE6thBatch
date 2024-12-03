import {Directive, ElementRef, HostListener, Input} from '@angular/core';

@Directive({
  selector: '[appHighlight]',
  standalone: true
})
export class HighlightDirective {

  @Input() appHighlight = '';

  constructor(private el: ElementRef) {
    console.log('El ',this.el);
    this.el.nativeElement.style.backgroundColor = 'yellow';
  }
  @HostListener('mouseenter') onMouseEnter() {
    console.log('mouse enter ',this.appHighlight);
    this.highlight(this.appHighlight);
  }
  @HostListener('mouseleave') onMouseLeave() {
    this.highlight(this.appHighlight);
  }
  private highlight(color: string) {
    this.el.nativeElement.style.backgroundColor = color;
  }

}
