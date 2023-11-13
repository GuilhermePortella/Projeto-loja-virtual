import { TestBed } from '@angular/core/testing';

import { shopFormService } from './shop-form.service';

describe('shopFormService', () => {
  let service: shopFormService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(shopFormService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
