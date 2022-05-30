
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DotaTest {

    WebDriver driver ;
    WebDriverWait webDriverWait;
    DotaPage dotaPage;

    private final static String SUCCESS_XPATH_LOCATOR = "//img[@alt='Anti-Mage']";

    @BeforeAll
    static void driverRegister() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void initDriver() {
        driver = new ChromeDriver();
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(5));
        dotaPage = new DotaPage(driver);

    }

    @Test
    public void displayHeroOnInputText() {
        driver.get("https://dotatools.ru/");
        dotaPage.focusInput();
        dotaPage.inputText("a");

        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(SUCCESS_XPATH_LOCATOR)));

        Assertions.assertTrue(dotaPage.SelectedHero.isDisplayed());
    }

//    @AfterEach
//    void tearDown() {
//        driver.quit();
//    }


}
