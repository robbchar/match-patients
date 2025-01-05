package com.sb.match_patients

import com.sb.match_patients.entity.Provider

class PatientMatcher {
    companion object {

        fun matchAreasOfConcern(
            patientAreasOfConcern: List<String>,
            providerMatches: HashMap<Provider, Int>
        ): HashMap<Provider, Int> {
            patientAreasOfConcern.forEach { areaOfConcern ->
                providerMatches.forEach { (provider) ->
                    val providersWithSpecialities = ProviderData.AllProviders.areasOfConcernToProviders.getOrDefault(
                        areaOfConcern.lowercase(),
                        listOf()
                    ).toMutableList()
                    if (provider in providersWithSpecialities) {
                        providerMatches[provider] = providerMatches[provider]!! + 1
                    }
                }
            }

            return providerMatches
        }

        fun matchModalities(
            patientModalities: List<String>,
            providerMatches: HashMap<Provider, Int>
        ): HashMap<Provider, Int> {
            patientModalities.forEach { modality ->
                providerMatches.forEach { (provider) ->
                    val providersWithModality = ProviderData.AllProviders.treatmentModalitiesToProviders.getOrDefault(
                        modality.lowercase(),
                        listOf()
                    ).toMutableList()
                    if (provider in providersWithModality) {
                        providerMatches[provider] = providerMatches[provider]!! + 1
                    }
                }
            }

            return providerMatches
        }

        fun matchRequestedOrientation(
            patientRequestedOrientation: String,
            providerMatches: HashMap<Provider, Int>
        ): HashMap<Provider, Int> {
            providerMatches.forEach { (provider) ->
                val providersWithOrientation = ProviderData.AllProviders.sexualOrientationToProviders.getOrDefault(
                    patientRequestedOrientation.lowercase(),
                    listOf()
                ).toMutableList()
                if (provider in providersWithOrientation) {
                    providerMatches[provider] = providerMatches[provider]!! + 1
                }
            }

            return providerMatches
        }

        fun matchRequestedReligiousFaith(
            patientRequestedReligiousFaith: String,
            providerMatches: HashMap<Provider, Int>
        ): HashMap<Provider, Int> {
            providerMatches.forEach { (provider) ->
                val providersWithReligiousFaith = ProviderData.AllProviders.religiousFaithToProviders.getOrDefault(
                    patientRequestedReligiousFaith.lowercase(),
                    listOf()
                ).toMutableList()
                if (provider in providersWithReligiousFaith) {
                    providerMatches[provider] = providerMatches[provider]!! + 1
                }
            }

            return providerMatches
        }

        fun matchRequestedOriginGroup(
            patientRequestedOriginGroup: String,
            providerMatches: HashMap<Provider, Int>
        ): HashMap<Provider, Int> {
            providerMatches.forEach { (provider) ->
                val providersWithOriginGroup = ProviderData.AllProviders.originGroupsToProviders.getOrDefault(
                    patientRequestedOriginGroup.lowercase(),
                    listOf()
                ).toMutableList()
                if (provider in providersWithOriginGroup) {
                    providerMatches[provider] = providerMatches[provider]!! + 1
                }
            }

            return providerMatches
        }

        fun matchPatientToTherapistReligiousFaith(
            patientReligiousFaith: String,
            providerMatches: HashMap<Provider, Int>
        ): HashMap<Provider, Int> {
            providerMatches.forEach { (provider) ->
                val providersWithReligiousFaith = ProviderData.AllProviders.religiousFaithToProviders.getOrDefault(
                    patientReligiousFaith.lowercase(),
                    listOf()
                ).toMutableList()
                if (provider in providersWithReligiousFaith) {
                    providerMatches[provider] = providerMatches[provider]!! + 1
                }
            }

            return providerMatches
        }

        fun matchPatientToTherapistSexualOrientation(
            patientSexualOrientation: String,
            providerMatches: HashMap<Provider, Int>
        ): HashMap<Provider, Int> {
            providerMatches.forEach { (provider) ->
                val providersWithReligiousFaith = ProviderData.AllProviders.sexualOrientationToProviders.getOrDefault(
                    patientSexualOrientation.lowercase(),
                    listOf()
                ).toMutableList()
                if (provider in providersWithReligiousFaith) {
                    providerMatches[provider] = providerMatches[provider]!! + 1
                }
            }

            return providerMatches
        }
    }
}