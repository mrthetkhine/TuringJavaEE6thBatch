import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DiDemoComponent } from './di-demo.component';

describe('DiDemoComponent', () => {
  let component: DiDemoComponent;
  let fixture: ComponentFixture<DiDemoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [DiDemoComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(DiDemoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
