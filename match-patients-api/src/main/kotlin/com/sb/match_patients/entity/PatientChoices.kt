package com.sb.match_patients.entity

class PatientChoices(
) {
    // constructor for testing
    constructor(
        areasOfConcern: List<String> = listOf(),
        treatmentModalities: List<String> = listOf(),
        selectedOriginGroup: String = "",
        selectedReligiousFaith: String = "",
        selectedSexualOrientation: String = "",
        selectedTherapistOriginGroup: String = "",
        selectedTherapistSexualOrientation: String = "",
        selectedTherapistReligiousFaith: String = "",
        location: StateName = StateName(name = "", abbreviation = ""),
        paymentMethod: String = "",
    ) : this() {
        this.areasOfConcern = areasOfConcern
        this.treatmentModalities = treatmentModalities
        this.selectedOriginGroup = selectedOriginGroup
        this.selectedReligiousFaith = selectedReligiousFaith
        this.selectedSexualOrientation = selectedSexualOrientation
        this.selectedTherapistOriginGroup = selectedTherapistOriginGroup
        this.selectedTherapistSexualOrientation = selectedTherapistSexualOrientation
        this.selectedTherapistReligiousFaith = selectedTherapistReligiousFaith
        this.location = location
        this.paymentMethod = paymentMethod
    }

    var areasOfConcern: List<String> = listOf()
    var treatmentModalities: List<String> = listOf()
    var selectedOriginGroup: String? = null
    var selectedReligiousFaith: String? = null
    var selectedSexualOrientation: String? = null
    var selectedTherapistOriginGroup: String? = null
    var selectedTherapistSexualOrientation: String? = null
    var selectedTherapistReligiousFaith: String? = null
    var location: StateName? = null
    var paymentMethod: String? = null

}
