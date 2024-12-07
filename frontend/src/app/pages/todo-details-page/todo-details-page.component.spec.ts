import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TodoDetailsPageComponent } from './todo-details-page.component';

describe('TodoDetailsPageComponent', () => {
  let component: TodoDetailsPageComponent;
  let fixture: ComponentFixture<TodoDetailsPageComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [TodoDetailsPageComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(TodoDetailsPageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
