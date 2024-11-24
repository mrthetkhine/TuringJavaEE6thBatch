import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SignalUnTrackComponent } from './signal-un-track.component';

describe('SignalUnTrackComponent', () => {
  let component: SignalUnTrackComponent;
  let fixture: ComponentFixture<SignalUnTrackComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [SignalUnTrackComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(SignalUnTrackComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
