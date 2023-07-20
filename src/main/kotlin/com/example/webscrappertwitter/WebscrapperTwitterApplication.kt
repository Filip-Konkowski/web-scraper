package com.example.webscrappertwitter

import kotlinx.coroutines.runBlocking
import org.openqa.selenium.chrome.ChromeDriver
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class WebscrapperTwitterApplication

fun main(args: Array<String>) {

    runBlocking {
        val driver = ChromeDriver()
        Login(driver).login()

        driver.quit()
    }

    runApplication<WebscrapperTwitterApplication>(*args)


}
