package com.sb.match_patients.entity

import com.opencsv.bean.CsvBindAndSplitByName
import com.opencsv.bean.CsvBindByName

class Provider(
) {
    // constructor for testing
    constructor(
        firstName: String = "",
        lastName: String = "",
        ethnicIdentity: List<String> = listOf(),
        genderIdentity: String = "",
        numberOfClientsAbleToTake: Int = -1,
        aLanguage: List<String> = listOf(),
        aLocation: List<String> = listOf(),
        aBio: String = "",
        sexualOrientation: List<String> = listOf(),
        religiousBackground: String = "",
        treatmentModality: List<String> = listOf(),
        areasOfSpecialization: List<String> = listOf()
    ) : this() {
        this.first_name = firstName
        this.last_name = lastName
        this.ethnic_identity = ethnicIdentity
        this.gender_identity = genderIdentity
        this.number_of_clients_able_to_take = numberOfClientsAbleToTake
        this.language = aLanguage
        this.location = aLocation
        this.bio = aBio
        this.sexual_orientation = sexualOrientation
        this.religious_background = religiousBackground
        this.treatment_modality = treatmentModality
        this.areas_of_specialization = areasOfSpecialization
    }

    @CsvBindByName(column = "First Name")
    var first_name: String = ""

    @CsvBindByName(column = "Last Name")
    var last_name: String = ""

    @CsvBindAndSplitByName(
        column = "Ethnic Identity",
        splitOn = ",",
        elementType = String::class,
        collectionType = List::class
    )
    var ethnic_identity: List<String> = listOf()

    @CsvBindByName(column = "Gender Identity")
    var gender_identity: String = ""

    @CsvBindByName(column = "No Of Clients Able To Take On")
    var number_of_clients_able_to_take: Int? = -1

    @CsvBindAndSplitByName(
        column = "Language",
        splitOn = ",",
        elementType = String::class,
        collectionType = List::class
    )
    var language: List<String> = listOf()

    @CsvBindAndSplitByName(
        column = "Location",
        splitOn = ",",
        elementType = String::class,
        collectionType = List::class
    )
    var location: List<String> = listOf()

    @CsvBindByName(column = "Bio")
    var bio: String = ""

    @CsvBindAndSplitByName(
        column = "Sexual Orientation",
        splitOn = "/",
        elementType = String::class,
        collectionType = List::class
    )
    var sexual_orientation: List<String> = listOf()

    @CsvBindByName(column = "Religious Background")
    var religious_background: String = ""

    @CsvBindAndSplitByName(
        column = "Treatment Modality",
        splitOn = ",|\n",
        elementType = String::class,
        collectionType = List::class
    )
    var treatment_modality: List<String> = listOf()

    @CsvBindAndSplitByName(
        column = "Areas of Specialization",
        splitOn = ",|\n",
        elementType = String::class,
        collectionType = List::class
    )
    var areas_of_specialization: List<String> = listOf()
}
