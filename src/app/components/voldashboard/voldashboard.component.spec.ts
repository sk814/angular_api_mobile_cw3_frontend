import { ComponentFixture, TestBed } from '@angular/core/testing';

import { VoldashboardComponent } from './voldashboard.component';

describe('VoldashboardComponent', () => {
  let component: VoldashboardComponent;
  let fixture: ComponentFixture<VoldashboardComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ VoldashboardComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(VoldashboardComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
