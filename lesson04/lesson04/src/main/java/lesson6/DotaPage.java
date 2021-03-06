package lesson6;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DotaPage {
    WebDriver driver;
    WebDriverWait webDriverWait;
    Actions actions;


    public DotaPage (WebDriver driver) {
        this.driver = driver;
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(5));
        actions = new Actions(driver);
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//input[@placeholder='Начните вводить имя героя...']")
     public WebElement NameHeroInput;

    @FindBy(xpath = "//img[@alt='Anti-Mage']")
     public WebElement SelectedHero;

    public void focusInput() {
        actions.moveToElement(NameHeroInput)
                .build().perform();
        NameHeroInput.click();
    }

    public void inputText(String text) {
     NameHeroInput.sendKeys(text);
    }

}
