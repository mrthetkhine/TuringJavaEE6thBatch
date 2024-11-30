import { ComponentFixture, TestBed } from '@angular/core/testing';

import { LeaftComponentComponent } from './leaft-component.component';

describe('LeaftComponentComponent', () => {
  let component: LeaftComponentComponent;
  let fixture: ComponentFixture<LeaftComponentComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [LeaftComponentComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(LeaftComponentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
