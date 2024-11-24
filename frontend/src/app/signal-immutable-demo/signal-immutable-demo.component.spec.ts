import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SignalImmutableDemoComponent } from './signal-immutable-demo.component';

describe('SignalImmutableDemoComponent', () => {
  let component: SignalImmutableDemoComponent;
  let fixture: ComponentFixture<SignalImmutableDemoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [SignalImmutableDemoComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(SignalImmutableDemoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
