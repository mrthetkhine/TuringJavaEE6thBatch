import { TestBed } from '@angular/core/testing';

import { ServiceThreeService } from './service-three.service';

describe('ServiceThreeService', () => {
  let service: ServiceThreeService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ServiceThreeService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
