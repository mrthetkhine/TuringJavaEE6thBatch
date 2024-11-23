import { ComponentFixture, TestBed } from '@angular/core/testing';

import { InputWithGetterSetterComponent } from './input-with-getter-setter.component';

describe('InputWithGetterSetterComponent', () => {
  let component: InputWithGetterSetterComponent;
  let fixture: ComponentFixture<InputWithGetterSetterComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [InputWithGetterSetterComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(InputWithGetterSetterComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
