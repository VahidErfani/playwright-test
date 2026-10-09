import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.junit.Assert.assertEquals;

import java.time.Duration;

public class OvningVNio {


    @Test

    public void verify() throws InterruptedException {

        WebDriver driver = new ChromeDriver();

        driver.get("https://duckduckgo.com");

        WebElement searchbox = driver.findElement(By.cssSelector("[data-ssg-id='ai-searchbox-input']"));
        searchbox.sendKeys("regnjacka");
        searchbox.submit();
        Thread.sleep(2000);

        driver.findElement(By.cssSelector("#r1-2")).click();


        String actualTitle = driver.getTitle();

        String expectedTitle = "Regnjackor | Köp online | Naturkompaniet";

        assertEquals(expectedTitle, actualTitle);


    }
}
