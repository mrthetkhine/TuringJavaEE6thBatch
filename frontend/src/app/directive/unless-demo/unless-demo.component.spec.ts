import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UnlessDemoComponent } from './unless-demo.component';

describe('UnlessDemoComponent', () => {
  let component: UnlessDemoComponent;
  let fixture: ComponentFixture<UnlessDemoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [UnlessDemoComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(UnlessDemoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
