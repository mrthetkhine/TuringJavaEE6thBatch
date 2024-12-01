import { Component } from '@angular/core';
import {UserBioComponent} from "../user-bio/user-bio.component";
import {BioComponent} from "../bio/bio.component";
import {NgComponentOutlet} from "@angular/common";

@Component({
  selector: 'app-lazy-loading-demo',
  standalone: true,
  imports: [
    NgComponentOutlet,
    BioComponent,
  ],
  templateUrl: './lazy-loading-demo.component.html',
  styleUrl: './lazy-loading-demo.component.css'
})
export class LazyLoadingDemoComponent {
  //advancedSettings: {new(): BioComponent} |undefined = undefined;
  advancedSettings: any = undefined;

  async loadAdvanced() {
    //const {BioComponent} = await import('./../bio/bio.component.js');
    this.advancedSettings = await import('./../bio/bio.component.js');
    console.log('Component ',this.advancedSettings);
  }
}
