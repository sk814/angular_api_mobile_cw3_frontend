import { TestBed } from '@angular/core/testing';

import { VolenService } from './volen.service';

describe('VolenService', () => {
  let service: VolenService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(VolenService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
