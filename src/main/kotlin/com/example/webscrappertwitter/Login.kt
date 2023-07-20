package com.example.webscrappertwitter

import org.openqa.selenium.By
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.support.ui.ExpectedConditions
import org.openqa.selenium.support.ui.WebDriverWait
import java.time.Duration

class Login(private val driver: ChromeDriver) {
    suspend fun login() {
        val driverLocation = "/Users/filipkonkowski/code/webscrapper-twitter/src/main/resources/chromedriver"
        System.setProperty("webdriver.chrome.driver", driverLocation);

        driver.get("https://twitter.com/i/flow/login")

        WebDriverWait(driver, Duration.ofSeconds(10)).until(
            ExpectedConditions.presenceOfElementLocated(
                By.className("r-1niwhzg")
            )
        )

        val inputField = driver.findElement(By.xpath("//*[@id=\"layers\"]/div/div/div/div/div/div/div[2]/div[2]/div/div/div[2]/div[2]/div/div/div/div[5]/label/div/div[2]/div/input"))
        inputField.sendKeys("hereemail")

        val nextButton = driver.findElement(By.xpath("//span[text()='Next']"))
        nextButton.click()

        val wait =  WebDriverWait(driver, Duration.ofSeconds(10))
        // Wait for JavaScript to finish loading
        WebDriverWait(driver, Duration.ofSeconds(10)).until(
            ExpectedConditions.presenceOfElementLocated(
                By.className("r-30o5oe")
            )
        )

        val username = driver.findElement(By.className("r-30o5oe"))
        username.sendKeys("here username")

        val nextButton2 = driver.findElement(By.xpath("//span[text()='Next']"))
        nextButton2.click()

        wait.until(
            ExpectedConditions.presenceOfElementLocated(
                By.className("r-30o5oe")
            )
        )
        val inputPassword = driver.findElement(By.xpath("//*[@id=\"layers\"]/div/div/div/div/div/div/div[2]/div[2]/div/div/div[2]/div[2]/div[1]/div/div/div[3]/div/label/div/div[2]/div[1]/input"))
        inputPassword.sendKeys("here password")

        val loginButton = driver.findElement(By.xpath("//*[@id=\"layers\"]/div/div/div/div/div/div/div[2]/div[2]/div/div/div[2]/div[2]/div[2]/div/div[1]/div/div/div/div"))
        loginButton.click()
    }
}
