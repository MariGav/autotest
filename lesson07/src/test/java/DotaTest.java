
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.TmsLink;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

@Epic("Набор команды")
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
        driver = new EventFiringDecorator(new CustomLogger()).decorate(new ChromeDriver());
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(5));
        dotaPage = new DotaPage(driver);

    }

    @Test
    @Feature("Набор команды")
    @Story("Выбор героя")
    @TmsLink("123")

    public void displayHeroOnInputText() {
        driver.get("https://dotatools.ru/");
        dotaPage.focusInput();
        dotaPage.inputText("a");

        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(SUCCESS_XPATH_LOCATOR)));

        Assertions.assertTrue(dotaPage.SelectedHero.isDisplayed());
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }


}
