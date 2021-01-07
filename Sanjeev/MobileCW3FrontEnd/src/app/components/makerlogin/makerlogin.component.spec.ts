import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MakerloginComponent } from './makerlogin.component';

describe('MakerloginComponent', () => {
  let component: MakerloginComponent;
  let fixture: ComponentFixture<MakerloginComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ MakerloginComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(MakerloginComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
