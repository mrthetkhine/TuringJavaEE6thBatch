import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CustomSliderComponent } from './custom-slider.component';

describe('CustomSliderComponent', () => {
  let component: CustomSliderComponent;
  let fixture: ComponentFixture<CustomSliderComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [CustomSliderComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(CustomSliderComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
