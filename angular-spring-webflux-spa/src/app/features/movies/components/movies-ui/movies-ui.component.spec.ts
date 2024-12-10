import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MoviesUIComponent } from './movies-ui.component';

describe('MoviesUIComponent', () => {
  let component: MoviesUIComponent;
  let fixture: ComponentFixture<MoviesUIComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [MoviesUIComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(MoviesUIComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
