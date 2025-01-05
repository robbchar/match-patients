package com.sb.match_patients

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.sb.match_patients.RestController.MatchingUtilities
import com.sb.match_patients.entity.PatientChoices
import com.sb.match_patients.entity.Provider
import com.sb.match_patients.entity.StateName
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@WebMvcTest(RestController::class)
class RestControllerTests {

    @Autowired
    private lateinit var mockMvc: MockMvc

    @Test
    fun findProvidersEndpoint() {
        val patientChoices = PatientChoices(
            areasOfConcern = listOf(
                "anxiety",
                "worry",
                "panic attacks",
                "depression",
                "low self-esteem",
                "academic stress",
                "social fears",
                "sleep problems",
                "lgbtq+ related concerns"
            ),
            treatmentModalities = listOf(
                "dialectical behavioral therapy (dbt)",
                "acceptance and commitment therapy (act)"
            ),
            selectedOriginGroup = "central asia",
            selectedReligiousFaith = "christian",
            selectedSexualOrientation = "pansexual",
            selectedTherapistOriginGroup = "central asia",
            selectedTherapistSexualOrientation = "bisexual",
            selectedTherapistReligiousFaith = "christian",
            location = StateName(name = "California", abbreviation = "CA"),
            paymentMethod = "aetna"
        )
        val gson = Gson()
        val result = mockMvc.perform(
            put("/api/match-patient")
                .contentType(MediaType.APPLICATION_JSON) // Set content type to JSON
                .content(gson.toJson(patientChoices)) // Set the request body
        )
            .andExpect(status().isOk)
            .andReturn()

        val responseBody = result.response.contentAsString
        val receivedProviders: List<Provider> =
            gson.fromJson(responseBody, object : TypeToken<List<Provider>>() {}.type)

        Assertions.assertEquals(receivedProviders.size, 3)
        Assertions.assertEquals(receivedProviders[0].first_name, "Alice")
        Assertions.assertEquals(receivedProviders[1].first_name, "Nancy")
        Assertions.assertEquals(receivedProviders[2].first_name, "Van")
    }

    @Test
    fun top3ReturnsCorrectlyThreeInReverseOrder() {
        val testedProvider = Provider("three")
        val hashMap: HashMap<Provider, Int> =
            hashMapOf(Provider("first") to 1, Provider("second") to 2, testedProvider to 3)
        val newList = MatchingUtilities.returnTopThreeOrTies(hashMap)

        Assertions.assertEquals(newList[0], testedProvider)
    }

    @Test
    fun top3ReturnsCorrectlySizedReturn() {
        val testedProvider = Provider("four")
        val hashMap: HashMap<Provider, Int> =
            hashMapOf(Provider("first") to 1, Provider("second") to 2, Provider("three") to 3, testedProvider to 4)
        val newList = MatchingUtilities.returnTopThreeOrTies(hashMap)

        Assertions.assertEquals(newList.size, 3)
    }

    @Test
    fun top3ReturnsCorrectlyGivenFourThreeWithCorrectOrder() {
        val testedProvider = Provider("four")
        val hashMap: HashMap<Provider, Int> =
            hashMapOf(Provider("first") to 1, Provider("second") to 2, Provider("three") to 3, testedProvider to 4)
        val newList = MatchingUtilities.returnTopThreeOrTies(hashMap)

        Assertions.assertEquals(newList[0], testedProvider)
    }
}
