import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TemplateVariableDemoComponent } from './template-variable-demo.component';

describe('TemplateVariableDemoComponent', () => {
  let component: TemplateVariableDemoComponent;
  let fixture: ComponentFixture<TemplateVariableDemoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [TemplateVariableDemoComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(TemplateVariableDemoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
