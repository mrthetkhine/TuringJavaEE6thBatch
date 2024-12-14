import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ActorUIComponent } from './actor-ui.component';

describe('ActorUIComponent', () => {
  let component: ActorUIComponent;
  let fixture: ComponentFixture<ActorUIComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ActorUIComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(ActorUIComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
