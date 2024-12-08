import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DynamicFormDemoComponent } from './dynamic-form-demo.component';

describe('DynamicFormDemoComponent', () => {
  let component: DynamicFormDemoComponent;
  let fixture: ComponentFixture<DynamicFormDemoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [DynamicFormDemoComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(DynamicFormDemoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
