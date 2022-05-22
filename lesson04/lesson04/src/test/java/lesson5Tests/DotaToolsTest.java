package lesson5Tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DotaToolsTest {
    WebDriver driver = new ChromeDriver();
    WebDriverWait webDriverWait;

    @BeforeAll
    static void driverRegister() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void initDriver() {
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(5));
        driver.get("https://dotatools.ru/");
    }

    @Test
    public void DotaToolsTest() {

        driver.findElement(By.xpath("//input[@placeholder='Начните вводить имя героя...']")).click();

        driver.findElement(By.xpath("//input[@placeholder='Начните вводить имя героя...']")).sendKeys("a");

        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[@alt='Anti-Mage']")));

        Assertions.assertEquals(driver.findElement(By.xpath("//img[@alt='Anti-Mage']")).isDisplayed(), true);
    }

    @Test
    public void openMenu() {
     

    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }
}
