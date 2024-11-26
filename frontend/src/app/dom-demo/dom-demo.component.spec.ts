import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DomDemoComponent } from './dom-demo.component';

describe('DomDemoComponent', () => {
  let component: DomDemoComponent;
  let fixture: ComponentFixture<DomDemoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [DomDemoComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(DomDemoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
