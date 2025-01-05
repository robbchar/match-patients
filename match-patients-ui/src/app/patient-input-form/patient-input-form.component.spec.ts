import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PatientInputFormComponent } from './patient-input-form.component';

describe('PatientInputFormComponent', () => {
  let component: PatientInputFormComponent;
  let fixture: ComponentFixture<PatientInputFormComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [PatientInputFormComponent],
    }).compileComponents();

    fixture = TestBed.createComponent(PatientInputFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
