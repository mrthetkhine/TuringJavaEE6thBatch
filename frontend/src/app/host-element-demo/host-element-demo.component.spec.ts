import { ComponentFixture, TestBed } from '@angular/core/testing';

import { HostElementDemoComponent } from './host-element-demo.component';

describe('HostElementDemoComponent', () => {
  let component: HostElementDemoComponent;
  let fixture: ComponentFixture<HostElementDemoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [HostElementDemoComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(HostElementDemoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
