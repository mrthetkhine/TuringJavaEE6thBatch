import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DeferContainerComponent } from './defer-container.component';

describe('DeferContainerComponent', () => {
  let component: DeferContainerComponent;
  let fixture: ComponentFixture<DeferContainerComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [DeferContainerComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(DeferContainerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
