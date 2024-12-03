import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DeferDemoComponent } from './defer-demo.component';

describe('DeferDemoComponent', () => {
  let component: DeferDemoComponent;
  let fixture: ComponentFixture<DeferDemoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [DeferDemoComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(DeferDemoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
