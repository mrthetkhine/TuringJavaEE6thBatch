import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TimesDemoComponent } from './times-demo.component';

describe('TimesDemoComponent', () => {
  let component: TimesDemoComponent;
  let fixture: ComponentFixture<TimesDemoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [TimesDemoComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(TimesDemoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
