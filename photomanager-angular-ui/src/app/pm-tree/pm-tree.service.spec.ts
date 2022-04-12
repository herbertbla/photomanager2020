import { TestBed } from '@angular/core/testing';

import { PmTreeStore } from './pm-tree.store';

describe('pmTreeStore', () => {
  let service: PmTreeStore;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(PmTreeStore);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
