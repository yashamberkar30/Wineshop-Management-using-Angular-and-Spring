import { TestBed } from '@angular/core/testing';

import { WineshopService } from './wineshop.service';

describe('WineshopService', () => {
  let service: WineshopService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(WineshopService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
