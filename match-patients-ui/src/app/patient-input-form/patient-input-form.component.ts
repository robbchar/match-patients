import { Component, EventEmitter, Output } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';

import { NgSelectComponent } from '@ng-select/ng-select';
import { State, PatientChoices } from '../types';

@Component({
  selector: 'app-patient-input-form',
  imports: [CommonModule, NgSelectComponent, FormsModule, ReactiveFormsModule],
  templateUrl: './patient-input-form.component.html',
  styleUrl: './patient-input-form.component.scss',
})
export class PatientInputFormComponent {
  errorText = '';
  patientChoices!: PatientChoices;

  areasOfConcern: Array<string> = [
    'anxiety',
    'depression',
    'racial identity related issues',
    'academic stress',
    'Trauma-related stress',
    'Work-related stress',
    'insomnia',
    'low self esteem',
    'LGBTQ+ related concerns',
    'Low self-esteem',
    'Occupation-related stress',
    'Social fears',
    'Interpersonal problems',
    'Relationship difficulties',
    'Sexual concerns',
    'Panic attacks',
    'Worry',
    'Culturally-responsive treatments',
    'Major life transitions',
    'Sleep problems',
    'OCD',
    'Attention Deficit Hyperactivity Disorder (ADD/ADHD)',
    'Autism',
    'Anger management',
    'Mood disorder',
    'Personality disorders',
    'Post-Traumatic Stress Disorder (PTSD)',
    'Race-based trauma',
    'Substance use disorder',
    'Trauma therapy',
    'Eating Disorders',
  ];
  selectedAreasOfConcern: Array<string> = [];
  treatmentModalities: Array<string> = [
    'cognitive behavioral therapy (CBT)',
    'Dialectical Behavioral Therapy (DBT)',
    'Acceptance and Commitment Therapy (ACT)',
    'EMDR',
    'Motivational Interviewing',
    'Psychodynamic therapy',
    'Mindfulness-Based (MBCT)',
    'Person Centered Therapy',
    'Art Therapy',
    'Narrative Therapy',
    'Contextual Therapyy',
    'Family Systems Therapy',
    'MI',
    'Prolonged Exposure Therapy',
    "Therapist's Recommendation",
    'Trauma Focused CBT',
    'Relational-Cultural Therapy',
    'Emotionally Focused Therapy',
    'Restoration Therapy',
    'CBT',
    'MI',
    'DBT',
    'MBCT',
  ];
  selectedTreatmentModalities: Array<string> = [];
  originGroup: Array<string> = [
    'Central Asia',
    'East Asia',
    'Hawai’i and Pacific Islands',
    'Southeast Asia',
    'South Asia',
    'West Asia (Middle East)',
  ];
  selectedOriginGroup = '';
  religiousFaith: Array<string> = [
    'Christian',
    'Hindu',
    'Buddhist',
    'Muslim',
    'Unaffiliated',
  ];
  selectedReligiousFaith = '';
  sexualOrientations: Array<string> = [
    'Bisexual',
    'Pansexual',
    'Queer',
    'Gay',
    'Heterosexual',
    'Demisexual',
    'Lesbian',
    'Aromatic',
    'Allosexual',
  ];
  selectedSexualOrientation = '';

  therapistOriginGroup: Array<string> = [
    'Central Asia',
    'East Asia',
    'Hawai’i and Pacific Islands',
    'Southeast Asia',
    'South Asia',
    'West Asia (Middle East)',
  ];
  selectedTherapistOriginGroup = '';
  therapistReligiousFaith: Array<string> = [
    'Christian',
    'Hindu',
    'Buddhist',
    'Muslim',
    'Unafilliated',
  ];
  selectedTherapistReligiousFaith = '';
  therapistSexualOrientations: Array<string> = [
    'Bisexual',
    'Pansexual',
    'Queer',
    'Gay',
    'Heterosexual',
    'Demisexual',
    'Lesbian',
    'Aromatic',
    'Allosexual',
  ];
  selectedTherapistSexualOrientation = '';

  locations: Array<State> = [
    { name: 'California', abbreviation: 'CA' },
    { name: 'New York', abbreviation: 'NY' },
    { name: 'Florida', abbreviation: 'Fl' },
    { name: 'Washington', abbreviation: 'WA' },
  ];
  selectedLocation!: State;
  paymentMethods: Array<string> = ['Aetna', 'Magellan', 'Anthem', 'Self-pay'];
  selectedPaymentMethod = '';

  @Output() buttonClicked = new EventEmitter<PatientChoices>();
  onSave() {
    // quick validation
    if (
      this.selectedAreasOfConcern.length === 0 ||
      this.selectedTreatmentModalities.length === 0 ||
      this.selectedLocation === undefined ||
      this.selectedPaymentMethod === '' ||
      this.selectedOriginGroup === '' ||
      this.selectedReligiousFaith === '' ||
      this.selectedSexualOrientation === '' ||
      this.selectedTherapistOriginGroup === '' ||
      this.selectedTherapistReligiousFaith === '' ||
      this.selectedTherapistSexualOrientation === ''
    ) {
      this.errorText = 'Please fill out all the fields';
      return;
    }
    this.errorText = '';
    this.patientChoices = new PatientChoices(
      this.selectedAreasOfConcern,
      this.selectedTreatmentModalities,
      this.selectedLocation,
      this.selectedPaymentMethod,
      this.selectedOriginGroup,
      this.selectedReligiousFaith,
      this.selectedSexualOrientation,
      this.selectedTherapistOriginGroup,
      this.selectedTherapistReligiousFaith,
      this.selectedTherapistSexualOrientation,
    );
    this.buttonClicked.emit(this.patientChoices);
  }
}
