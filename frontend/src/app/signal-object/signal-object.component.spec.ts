import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SignalObjectComponent } from './signal-object.component';

describe('SignalObjectComponent', () => {
  let component: SignalObjectComponent;
  let fixture: ComponentFixture<SignalObjectComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [SignalObjectComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(SignalObjectComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
