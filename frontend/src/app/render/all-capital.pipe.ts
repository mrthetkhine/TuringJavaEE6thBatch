import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'allCapital',
  standalone: true
})
export class AllCapitalPipe implements PipeTransform {

  transform(value: string): string {
    return value.toUpperCase();
  }

}
