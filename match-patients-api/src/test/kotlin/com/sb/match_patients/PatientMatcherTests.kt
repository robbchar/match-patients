package com.sb.match_patients

import com.sb.match_patients.entity.Provider
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest(classes = [PatientMatcher::class, ProviderData::class])
class PatientMatcherTests {

    @Test
    fun areasOfConcern() {
        val areasOfConcern = listOf("anxiety", "worry")
        val providerToTest = ProviderData.AllProviders.providerMockData[1]
        val providerMatches: HashMap<Provider, Int> = hashMapOf(providerToTest to 0)
        PatientMatcher.matchAreasOfConcern(areasOfConcern, providerMatches)

        Assertions.assertEquals(providerMatches[providerToTest], 2)
    }

    @Test
    fun areasOfConcernMultipleProviders() {
        val areasOfConcern = listOf("anxiety", "worry")
        val firstProvider = ProviderData.AllProviders.providerMockData[0]
        val secondProvider = ProviderData.AllProviders.providerMockData[1]
        val providerMatches: HashMap<Provider, Int> = hashMapOf(firstProvider to 0, secondProvider to 0)
        PatientMatcher.matchAreasOfConcern(areasOfConcern, providerMatches)

        Assertions.assertEquals(providerMatches[firstProvider], 0)
        Assertions.assertEquals(providerMatches[secondProvider], 2)
    }

    @Test
    fun areasOfConcernNegative() {
        val areasOfConcern = listOf("blah", "blech")
        val providerToTest = ProviderData.AllProviders.providerMockData[1]
        val providerMatches: HashMap<Provider, Int> = hashMapOf(providerToTest to 0)
        PatientMatcher.matchAreasOfConcern(areasOfConcern, providerMatches)

        Assertions.assertEquals(providerMatches[providerToTest], 0)
    }

    @Test
    fun modalities() {
        val modalities = listOf("cognitive behavioral therapy (cbt)", "dialectical behavioral therapy (dbt)")
        val providerToTest = ProviderData.AllProviders.providerMockData[1]
        val providerMatches: HashMap<Provider, Int> = hashMapOf(providerToTest to 0)
        PatientMatcher.matchModalities(modalities, providerMatches)

        Assertions.assertEquals(providerMatches[providerToTest], 2)
    }

    @Test
    fun modalitiesMultipleProviders() {
        val modalities = listOf("cognitive behavioral therapy (cbt)", "dialectical behavioral therapy (dbt)", "CBT")
        val firstProvider = ProviderData.AllProviders.providerMockData[0]
        val secondProvider = ProviderData.AllProviders.providerMockData[1]
        val providerMatches: HashMap<Provider, Int> = hashMapOf(firstProvider to 0, secondProvider to 0)
        PatientMatcher.matchModalities(modalities, providerMatches)

        Assertions.assertEquals(providerMatches[firstProvider], 1)
        Assertions.assertEquals(providerMatches[secondProvider], 2)
    }

    @Test
    fun modalitiesNegative() {
        val modalities = listOf("blah", "blech")
        val providerToTest = ProviderData.AllProviders.providerMockData[1]
        val providerMatches: HashMap<Provider, Int> = hashMapOf(providerToTest to 0)
        PatientMatcher.matchModalities(modalities, providerMatches)

        Assertions.assertEquals(providerMatches[providerToTest], 0)
    }

    @Test
    fun orientation() {
        val orientations = "heterosexual"
        val providerToTest = ProviderData.AllProviders.providerMockData[1]
        val providerMatches: HashMap<Provider, Int> = hashMapOf(providerToTest to 0)
        PatientMatcher.matchRequestedOrientation(orientations, providerMatches)

        Assertions.assertEquals(providerMatches[providerToTest], 1)
    }

    @Test
    fun orientationMultipleProviders() {
        val orientation = "heterosexual"
        val firstProvider = ProviderData.AllProviders.providerMockData[0]
        val secondProvider = ProviderData.AllProviders.providerMockData[1]
        val providerMatches: HashMap<Provider, Int> = hashMapOf(firstProvider to 0, secondProvider to 0)
        PatientMatcher.matchRequestedOrientation(orientation, providerMatches)

        Assertions.assertEquals(providerMatches[firstProvider], 0)
        Assertions.assertEquals(providerMatches[secondProvider], 1)
    }

    @Test
    fun orientationNegative() {
        val orientations = "blah"
        val providerToTest = ProviderData.AllProviders.providerMockData[1]
        val providerMatches: HashMap<Provider, Int> = hashMapOf(providerToTest to 0)
        PatientMatcher.matchRequestedOrientation(orientations, providerMatches)

        Assertions.assertEquals(providerMatches[providerToTest], 0)
    }

    @Test
    fun religiousFaith() {
        val religiousFaith = "buddhist"
        val providerToTest = ProviderData.AllProviders.providerMockData[1]
        val providerMatches: HashMap<Provider, Int> = hashMapOf(providerToTest to 0)
        PatientMatcher.matchRequestedReligiousFaith(religiousFaith, providerMatches)

        Assertions.assertEquals(providerMatches[providerToTest], 1)
    }

    @Test
    fun religiousFaithMultipleProviders() {
        val religiousFaith = "buddhist"
        val firstProvider = ProviderData.AllProviders.providerMockData[0]
        val secondProvider = ProviderData.AllProviders.providerMockData[1]
        val providerMatches: HashMap<Provider, Int> = hashMapOf(firstProvider to 0, secondProvider to 0)
        PatientMatcher.matchRequestedReligiousFaith(religiousFaith, providerMatches)

        Assertions.assertEquals(providerMatches[firstProvider], 0)
        Assertions.assertEquals(providerMatches[secondProvider], 1)
    }

    @Test
    fun religiousFaithNegative() {
        val religiousFaith = "blah"
        val providerToTest = ProviderData.AllProviders.providerMockData[1]
        val providerMatches: HashMap<Provider, Int> = hashMapOf(providerToTest to 0)
        PatientMatcher.matchRequestedReligiousFaith(religiousFaith, providerMatches)

        Assertions.assertEquals(providerMatches[providerToTest], 0)
    }

    @Test
    fun patientToTherapistReligiousFaith() {
        val religiousFaith = "buddhist"
        val providerToTest = ProviderData.AllProviders.providerMockData[1]
        val providerMatches: HashMap<Provider, Int> = hashMapOf(providerToTest to 0)
        PatientMatcher.matchPatientToTherapistReligiousFaith(religiousFaith, providerMatches)

        Assertions.assertEquals(providerMatches[providerToTest], 1)
    }

    @Test
    fun patientToTherapistReligiousFaithMultipleProviders() {
        val religiousFaith = "buddhist"
        val firstProvider = ProviderData.AllProviders.providerMockData[0]
        val secondProvider = ProviderData.AllProviders.providerMockData[1]
        val providerMatches: HashMap<Provider, Int> = hashMapOf(firstProvider to 0, secondProvider to 0)
        PatientMatcher.matchPatientToTherapistReligiousFaith(religiousFaith, providerMatches)

        Assertions.assertEquals(providerMatches[firstProvider], 0)
        Assertions.assertEquals(providerMatches[secondProvider], 1)
    }

    @Test
    fun patientToTherapistReligiousFaithNegative() {
        val religiousFaith = "blah"
        val providerToTest = ProviderData.AllProviders.providerMockData[1]
        val providerMatches: HashMap<Provider, Int> = hashMapOf(providerToTest to 0)
        PatientMatcher.matchPatientToTherapistReligiousFaith(religiousFaith, providerMatches)

        Assertions.assertEquals(providerMatches[providerToTest], 0)
    }

    @Test
    fun originGroup() {
        val originGroup = "east asia"
        val providerToTest = ProviderData.AllProviders.providerMockData[1]
        val providerMatches: HashMap<Provider, Int> = hashMapOf(providerToTest to 0)
        PatientMatcher.matchRequestedOriginGroup(originGroup, providerMatches)

        Assertions.assertEquals(providerMatches[providerToTest], 1)
    }

    @Test
    fun originGroupMultipleProviders() {
        val originGroup = "east asia"
        val firstProvider = ProviderData.AllProviders.providerMockData[0]
        val secondProvider = ProviderData.AllProviders.providerMockData[1]
        val providerMatches: HashMap<Provider, Int> = hashMapOf(firstProvider to 0, secondProvider to 0)
        PatientMatcher.matchRequestedOriginGroup(originGroup, providerMatches)

        Assertions.assertEquals(providerMatches[firstProvider], 1)
        Assertions.assertEquals(providerMatches[secondProvider], 1)
    }

    @Test
    fun originGroupNegative() {
        val originGroup = "South Asia"
        val providerToTest = ProviderData.AllProviders.providerMockData[1]
        val providerMatches: HashMap<Provider, Int> = hashMapOf(providerToTest to 0)
        PatientMatcher.matchRequestedOriginGroup(originGroup, providerMatches)

        Assertions.assertEquals(providerMatches[providerToTest], 0)
    }

}