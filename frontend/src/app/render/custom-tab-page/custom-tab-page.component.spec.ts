import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CustomTabPageComponent } from './custom-tab-page.component';

describe('CustomTabPageComponent', () => {
  let component: CustomTabPageComponent;
  let fixture: ComponentFixture<CustomTabPageComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [CustomTabPageComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(CustomTabPageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
