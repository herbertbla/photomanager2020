import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PmTreeComponent } from './pm-tree.component';

describe('PmTreeComponent', () => {
  let component: PmTreeComponent;
  let fixture: ComponentFixture<PmTreeComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PmTreeComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(PmTreeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
