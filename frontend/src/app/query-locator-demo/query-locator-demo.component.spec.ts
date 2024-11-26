import { ComponentFixture, TestBed } from '@angular/core/testing';

import { QueryLocatorDemoComponent } from './query-locator-demo.component';

describe('QueryLocatorDemoComponent', () => {
  let component: QueryLocatorDemoComponent;
  let fixture: ComponentFixture<QueryLocatorDemoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [QueryLocatorDemoComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(QueryLocatorDemoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
