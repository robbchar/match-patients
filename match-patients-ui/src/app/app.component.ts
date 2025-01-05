import { HttpClient } from '@angular/common/http';
import { Component, inject } from '@angular/core';
import { CommonModule } from '@angular/common';

import { PatientInputFormComponent } from './patient-input-form/patient-input-form.component';
import { ProviderProfileComponent } from './provider-profile/provider-profile.component';
import { PatientChoices, Provider } from './types';

@Component({
  selector: 'app-root',
  imports: [ProviderProfileComponent, PatientInputFormComponent, CommonModule],
  templateUrl: './app.component.html',
  styleUrl: './app.component.scss',
})
export class AppComponent {
  title = 'angular-app';
  http = inject(HttpClient);

  providers: Array<Provider> = [];

  onButtonClicked(patientSelections: PatientChoices) {
    this.http
      .put<Provider[]>('/api/match-patient', patientSelections)
      .subscribe((providers) => {
        this.providers = providers;
      });
  }
}
