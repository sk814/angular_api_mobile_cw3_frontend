import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MakerdashboardComponent } from './makerdashboard.component';

describe('MakerdashboardComponent', () => {
  let component: MakerdashboardComponent;
  let fixture: ComponentFixture<MakerdashboardComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ MakerdashboardComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(MakerdashboardComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
