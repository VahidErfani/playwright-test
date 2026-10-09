import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class supporterAccount {

    @Test

    public void account () {

        WebDriver driver = new ChromeDriver();

        driver.get("file:///C:/Users/Erfani/Documents/Skola/Register.html");

        driver.findElement(By.cssSelector(".custom-date")).sendKeys("13051994");

        driver.findElement(By.cssSelector("#member_firstname")).sendKeys("Vahid");

        driver.findElement(By.cssSelector("#member_lastname")).sendKeys("Erfani");

        driver.findElement(By.cssSelector("#member_emailaddress")).sendKeys("vahid_erfani@hotmail.com");

        driver.findElement(By.cssSelector("[name='ConfirmEmailAddress']")).sendKeys("vahid_erfani@hotmail.com");

        driver.findElement(By.cssSelector("[name='Password']")).sendKeys("okej55");

        driver.findElement(By.cssSelector("[name='ConfirmPassword']")).sendKeys("okej55");

        driver.findElement(By.cssSelector("label[for='sign_up_25']")).click();

        driver.findElement(By.cssSelector("label[for='sign_up_26']")).click();

        driver.findElement(By.cssSelector("label[for='fanmembersignup_agreetocodeofethicsandconduct']")).click();

        driver.findElement(By.cssSelector(".btn-big")).click();



    }

}


