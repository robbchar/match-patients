package com.sb.match_patients

import com.opencsv.bean.CsvToBeanBuilder
import com.sb.match_patients.entity.Provider
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration
import org.springframework.boot.runApplication
import java.io.FileReader

@SpringBootApplication(exclude = [DataSourceAutoConfiguration::class])
class Application

fun main(args: Array<String>) {
    runApplication<Application>(*args)
}

fun readCsvToBean(filePath: String): List<Provider> {
    return CsvToBeanBuilder<Provider>(FileReader(filePath))
        .withType(Provider::class.java)
        .build()
        .parse()
}
