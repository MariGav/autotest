

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;



public class AutomationPractice {

    public static void main(String[] args)throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        WebDriver driver = new ChromeDriver(chromeOptions);

        driver.get("https://diary.ru/");

        Cookie authCookie = new Cookie("_identity_","87ad58acbc75553365a40b437f0b86974b2de628771a3660c633b8ed5e6dedcda%3A2%3A%7Bi%3A0%3Bs%3A10%3A%22_identity_%22%3Bi%3A1%3Bs%3A52%3A%22%5B3566605%2C%22kB-vlashJxqWp6OXfjzDV4eG20PI4wbt%22%2C2592000%5D%22%3B%7D");
        driver.manage().addCookie(authCookie);
        driver.navigate().refresh();

        driver.findElement(By.xpath("//li[@class='avatar']")).click();
        Thread.sleep(5000);

        driver.findElement(By.xpath("//a[@title='Мой дневник']")).click();

        driver.findElement(By.xpath("//input[@id='newblogform-title']")).click();
        Thread.sleep(5000);

        driver.findElement(By.id("newblogform-title")).sendKeys("дневник");
        Thread.sleep(5000);

        driver.findElement(By.xpath("//button[@type='submit' and contains(., 'Далее')]")).click();

    }
}
