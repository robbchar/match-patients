package com.sb.match_patients

import com.sb.match_patients.entity.Provider

class ProviderData {
    object AllProviders {
        val providerMockData = readCsvToBean(ClassLoader.getSystemResource("providers-data.csv").path)
        val areasOfConcernToProviders = HashMap<String, MutableList<Provider>>()
        val treatmentModalitiesToProviders = HashMap<String, MutableList<Provider>>()
        val religiousFaithToProviders = HashMap<String, MutableList<Provider>>()
        val sexualOrientationToProviders = HashMap<String, MutableList<Provider>>()
        val locationsToProviders = HashMap<String, MutableList<Provider>>()
        val originGroupsToProviders = HashMap<String, MutableList<Provider>>()

        init {
            RawData.areasOfConcern.forEach { area ->
                providerMockData.forEach { provider ->
                    provider.areas_of_specialization.forEach { areaOfSpecialization ->
                        if (areaOfSpecialization.trim().lowercase() == area) {
                            areasOfConcernToProviders.getOrPut(area) { mutableListOf() }.add(provider)
                        }
                    }
                }
            }

            RawData.treatmentModalities.forEach { modality ->
                providerMockData.forEach { provider ->
                    provider.treatment_modality.forEach { treatmentModality ->
                        if (treatmentModality.trim().lowercase() == modality) {
                            treatmentModalitiesToProviders.getOrPut(modality) { mutableListOf() }
                                .add(provider)
                        }
                    }
                }
            }

            RawData.religiousFaith.forEach { faith ->
                providerMockData.forEach { provider ->
                    if (provider.religious_background.trim().lowercase() == faith) {
                        religiousFaithToProviders.getOrPut(faith) { mutableListOf() }.add(provider)
                    }
                }
            }

            RawData.sexualOrientations.forEach { orientation ->
                providerMockData.forEach { provider ->
                    provider.sexual_orientation.forEach { providerOrientation ->
                        if (providerOrientation.trim().lowercase() == orientation) {
                            sexualOrientationToProviders.getOrPut(orientation) { mutableListOf() }
                                .add(provider)
                        }
                    }
                }
            }

            RawData.locations.forEach { loc ->
                providerMockData.forEach { provider ->
                    provider.location.forEach { providerLocation ->
                        if (providerLocation.trim().lowercase() == loc) {
                            locationsToProviders.getOrPut(loc) { mutableListOf() }.add(provider)
                        }
                    }
                }
            }

            RawData.originGroupsToCountries.forEach { originGroupName, countries ->
                countries.forEach { country ->
                    providerMockData.forEach { provider ->
                        provider.ethnic_identity.forEach { ethnicIdentity ->
                            if (ethnicIdentity.trim().lowercase().contains(country)) {
                                originGroupsToProviders.getOrPut(originGroupName) { mutableListOf() }.add(provider)
                            }
                        }
                    }
                }
            }
        }

        object RawData {

            //; source: https://api-gbv.org/wp-content/uploads/2019/06/API-demographics-identities-May-2019.pdf
            val originGroupsToCountries = hashMapOf(
                "central asia" to listOf(
                    "afghani",
                    "armenian",
                    "azerbaijani",
                    "georgians",
                    "kazakh",
                    "kyrgyz",
                    "mongolian",
                    "tajik",
                    "turkmen",
                    "uzbek"
                ),
                "east asia" to listOf("chinese", "japanese", "korean", "okinawan", "taiwanese", "tibetan"),
                "hawai’i and pacific islands" to listOf(
                    "carolinian",
                    "chamorro",
                    "chuukese",
                    "fijian",
                    "guamanian",
                    "hawaiian",
                    "kosraean",
                    "marshallese",
                    "native hawaiian",
                    "niuean",
                    "palauan",
                    "papua new guinean",
                    "pohnpeian",
                    "samoan",
                    "tokelauan",
                    "tongan",
                    "yapese"
                ),
                "southeast asia" to listOf(
                    "bruneian",
                    "burmese",
                    "cambodian",
                    "filipino (also regarded as pacific islanders)",
                    "hmong",
                    "indonesian",
                    "laotian",
                    "malaysian",
                    "mien",
                    "singaporean",
                    "timorese",
                    "thai",
                    "vietnamese"
                ),
                "south asia" to listOf(
                    "bangladeshi",
                    "bhutanese",
                    "indian",
                    "maldivians",
                    "nepali",
                    "pakistani",
                    "sri lankan"
                ),
                "west asia (middle east)" to listOf(
                    "bahrain",
                    "iran",
                    "iraq",
                    "israel",
                    "jordan",
                    "kuwait",
                    "lebanon",
                    "oman",
                    "palestine",
                    "qatar",
                    "saudi arabia",
                    "syria",
                    "turkey",
                    "united arab emirates",
                    "yemen"
                ),
            )

            val areasOfConcern: List<String> = listOf(
                "anxiety",
                "depression",
                "racial identity related issues",
                "academic stress",
                "trauma-related stress",
                "work-related stress",
                "insomnia",
                "low self esteem",
                "lgbtq+ related concerns",
                "low self-esteem",
                "occupation-related stress",
                "social fears",
                "interpersonal problems",
                "relationship difficulties",
                "sexual concerns",
                "panic attacks",
                "worry",
                "culturally-responsive treatments",
                "major life transitions",
                "sleep problems",
                "ocd",
                "attention deficit hyperactivity disorder (add/adhd)",
                "autism",
                "anger management",
                "mood disorder",
                "personality disorders",
                "post-traumatic stress disorder (ptsd)",
                "race-based trauma",
                "substance use disorder",
                "trauma therapy",
                "eating disorders"
            )

            val treatmentModalities: List<String> = listOf(
                "cognitive behavioral therapy (cbt)",
                "dialectical behavioral therapy (dbt)",
                "acceptance and commitment therapy (act)",
                "emdr",
                "motivational interviewing",
                "psychodynamic therapy",
                "mindfulness-based (mbct)",
                "person centered therapy",
                "art therapy",
                "narrative therapy",
                "contextual therapy",
                "family systems therapy",
                "mi",
                "prolonged exposure therapy",
                "therapist\'s recommendation",
                "trauma focused cbt",
                "relational-cultural therapy",
                "emotionally focused therapy",
                "restoration therapy",
                "cbt",
                "mi",
                "dbt",
                "mbct"
            )

            val religiousFaith: List<String> = listOf(
                "christian",
                "hindu",
                "buddhist",
                "muslim",
                "unaffiliated"
            )

            val sexualOrientations: List<String> = listOf(
                "bisexual",
                "pansexual",
                "queer",
                "gay",
                "heterosexual",
                "bisexual",
                "demisexual",
                "lesbian",
                "aromatic",
                "allosexual"
            )

            val locations: List<String> = listOf("ca", "ny", "fl", "wa")
        }
    }
}