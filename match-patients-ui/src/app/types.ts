export interface State {
  name: string;
  abbreviation: string;
}

export class PatientChoices {
  areasOfConcern: string[];
  treatmentModalities: string[];
  location: State;
  paymentMethod: string;

  selectedOriginGroup: string;
  selectedReligiousFaith: string;
  selectedSexualOrientation: string;
  selectedTherapistOriginGroup: string;
  selectedTherapistReligiousFaith: string;
  selectedTherapistSexualOrientation: string;

  constructor(
    areasOfConcern: string[],
    treatmentModalities: string[],
    location: State,
    paymentMethod: string,
    selectedOriginGroup: string,
    selectedReligiousFaith: string,
    selectedSexualOrientation: string,
    selectedTherapistOriginGroup: string,
    selectedTherapistReligiousFaith: string,
    selectedTherapistSexualOrientation: string,
  ) {
    this.areasOfConcern = areasOfConcern;
    this.treatmentModalities = treatmentModalities;
    this.location = location;
    this.paymentMethod = paymentMethod;
    this.selectedOriginGroup = selectedOriginGroup;
    this.selectedReligiousFaith = selectedReligiousFaith;
    this.selectedSexualOrientation = selectedSexualOrientation;
    this.selectedTherapistOriginGroup = selectedTherapistOriginGroup;
    this.selectedTherapistReligiousFaith = selectedTherapistReligiousFaith;
    this.selectedTherapistSexualOrientation =
      selectedTherapistSexualOrientation;
  }
}

export class Provider {
  first_name?: string;

  last_name?: string;

  ethnic_identity?: string[];

  gender_identity?: string;

  number_of_clients_able_to_take?: number;

  language?: string[];

  location?: string[];

  bio?: string;

  sexual_orientation?: string[];

  religious_background?: string;

  treatment_modality?: string[];

  areas_of_specialization?: string[];
}
