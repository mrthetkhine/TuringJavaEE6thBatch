import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ViewContainerRefDemoComponent } from './view-container-ref-demo.component';

describe('ViewContainerRefDemoComponent', () => {
  let component: ViewContainerRefDemoComponent;
  let fixture: ComponentFixture<ViewContainerRefDemoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ViewContainerRefDemoComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(ViewContainerRefDemoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
