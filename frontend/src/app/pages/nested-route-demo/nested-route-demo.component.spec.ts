import { ComponentFixture, TestBed } from '@angular/core/testing';

import { NestedRouteDemoComponent } from './nested-route-demo.component';

describe('NestedRouteDemoComponent', () => {
  let component: NestedRouteDemoComponent;
  let fixture: ComponentFixture<NestedRouteDemoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [NestedRouteDemoComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(NestedRouteDemoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
