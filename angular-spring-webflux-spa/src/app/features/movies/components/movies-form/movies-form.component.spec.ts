import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MoviesFormComponent } from './movies-form.component';

describe('MoviesFormComponent', () => {
  let component: MoviesFormComponent;
  let fixture: ComponentFixture<MoviesFormComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [MoviesFormComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(MoviesFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
