import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ContentDemoComponent } from './content-demo.component';

describe('ContentDemoComponent', () => {
  let component: ContentDemoComponent;
  let fixture: ComponentFixture<ContentDemoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ContentDemoComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(ContentDemoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
