import { TestBed } from '@angular/core/testing';

import { HellWorldService } from './hell-world.service';

describe('HellWorldService', () => {
  let service: HellWorldService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(HellWorldService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
