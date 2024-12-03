import { ComponentFixture, TestBed } from '@angular/core/testing';

import { IfDemoComponent } from './if-demo.component';

describe('IfDemoComponent', () => {
  let component: IfDemoComponent;
  let fixture: ComponentFixture<IfDemoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [IfDemoComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(IfDemoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
