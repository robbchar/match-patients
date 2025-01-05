package com.sb.match_patients

import com.sb.match_patients.entity.Provider
import com.sb.match_patients.entity.PatientChoices
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api")
class RestController {

    @PutMapping("/match-patient")
    fun findProviders(@RequestBody patientChoices: PatientChoices): List<Provider> {
        val providers: List<Provider> =
            ProviderData.AllProviders.locationsToProviders[patientChoices.location!!.abbreviation.lowercase()] as List<Provider>
        val providerMatches: HashMap<Provider, Int> = hashMapOf()
        providers.forEach { provider -> providerMatches[provider] = 0 }

        // if there are more than three providers left then we need to check requested preferences
        if (providers.size > 3) {
            PatientMatcher.matchAreasOfConcern(patientChoices.areasOfConcern, providerMatches)

            PatientMatcher.matchModalities(patientChoices.treatmentModalities, providerMatches)

            PatientMatcher.matchRequestedOrientation(
                patientChoices.selectedTherapistSexualOrientation!!,
                providerMatches
            )

            PatientMatcher.matchRequestedReligiousFaith(
                patientChoices.selectedTherapistReligiousFaith!!,
                providerMatches
            )

            PatientMatcher.matchRequestedOriginGroup(patientChoices.selectedTherapistOriginGroup!!, providerMatches)
        }

        val top3OrTies = MatchingUtilities.returnTopThreeOrTies(providerMatches)

        // after match to the requested values if there are still more than 3 then match to demographics as a tiebreaker
        if (top3OrTies.size > 3) {
            PatientMatcher.matchPatientToTherapistReligiousFaith(
                patientChoices.selectedReligiousFaith!!,
                providerMatches
            )

            PatientMatcher.matchPatientToTherapistSexualOrientation(
                patientChoices.selectedSexualOrientation!!,
                providerMatches
            )

            PatientMatcher.matchRequestedOriginGroup(patientChoices.selectedOriginGroup!!, providerMatches)
        }

        // by this time we have matched against what the patient requested,
        // what they submitted as their demographics (as a tiebreaker)
        // if that is not down to three we just take the top three
        return MatchingUtilities.returnTopThreeOrTies(providerMatches).take(3)
    }

    object MatchingUtilities {
        fun returnTopThreeOrTies(providerMatches: HashMap<Provider, Int>): List<Provider> {
            val sortedProviders =
                providerMatches.entries.sortedByDescending { it.value }.associate { it.toPair() }.keys.toList()
            val sortedMatches =
                providerMatches.entries.sortedByDescending { it.value }.associate { it.toPair() }.values.toList()
            if (sortedProviders.size <= 3) {
                return sortedProviders
            }

            val top3 = mutableListOf<Provider>()
            top3.add(sortedProviders[0])
            top3.add(sortedProviders[1])
            top3.add(sortedProviders[2])

            for (i in 3 until sortedProviders.size) {
                if (sortedMatches[i] == sortedMatches[2]) {
                    top3.add(sortedProviders[i])
                } else {
                    break
                }
            }

            return top3
        }
    }
}