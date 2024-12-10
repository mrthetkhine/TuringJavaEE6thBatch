import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MovieCountPageComponent } from './movie-count-page.component';

describe('MovieCountPageComponent', () => {
  let component: MovieCountPageComponent;
  let fixture: ComponentFixture<MovieCountPageComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [MovieCountPageComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(MovieCountPageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
