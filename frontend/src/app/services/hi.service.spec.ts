import { TestBed } from '@angular/core/testing';

import { HiService } from './hi.service';

describe('HiService', () => {
  let service: HiService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(HiService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
