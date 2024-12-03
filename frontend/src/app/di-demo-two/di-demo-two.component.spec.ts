import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DiDemoTwoComponent } from './di-demo-two.component';

describe('DiDemoTwoComponent', () => {
  let component: DiDemoTwoComponent;
  let fixture: ComponentFixture<DiDemoTwoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [DiDemoTwoComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(DiDemoTwoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
