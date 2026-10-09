import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class testEtt {


    @Test

    public void locatorOvning() throws InterruptedException {

        WebDriver driver = new ChromeDriver();

        driver.get("https://demowebshop.tricentis.com/");
        Thread.sleep(1000);

        WebElement element1 = driver.findElement(By.xpath("/html/body/div[4]/div[1]/div[2]/ul[1]/li[1]/a"));

        String actual = element1.getText();
        String expected = "BOOKS";

        Assert.assertEquals(expected, actual);

        System.out.println(expected);


        driver.quit();

    }


    @Test

    public void ovningTva() throws InterruptedException {

        WebDriver driver = new ChromeDriver();

        driver.get("https://demowebshop.tricentis.com/");
        Thread.sleep(1000);

        WebElement element2 = driver.findElement(By.className("topic-html-content-header"));


        String actual = element2.getText();
        String expected = "Welcome to our store";

        Assert.assertEquals(expected, actual);

        System.out.println(expected);


        driver.quit();

    }


    @Test

    public void ovningTre() throws InterruptedException {

        WebDriver driver = new ChromeDriver();

        driver.get("https://demowebshop.tricentis.com/");
        Thread.sleep(1000);

        WebElement element3 = driver.findElement(By.id("newsletter-email"));


        String actual = element3.getText();
        String expected = "";

        Assert.assertEquals(expected, actual);

        System.out.println(expected);


        driver.quit();

    }


//Övning – Locators
//Försök att använda så många olika typer av By på sidan https://demowebshop.tricentis.com/ som du kan
//Hitta locatorn och hämta texten ifrån locatorn med getText()
//By.id x
//By.name
//By.className x
//By.tagName
//By.linkText
//By.partialLinkText
//By.xpath x

//Övning – Flöde
//
//Navigera till sidan: https://demowebshop.tricentis.com/
//Använd sökfunktionen för att söka efter en produkt.
//Kontrollera att sökresultaten innehåller produkten du sökte efter genom att hämta titlarna på resultaten och jämföra med söktermen.


    @Test

    public void ovningFyra() throws InterruptedException {

        WebDriver driver = new ChromeDriver();

        driver.get("https://demowebshop.tricentis.com/");
        Thread.sleep(1000);

        WebElement element4 = driver.findElement(By.id("small-searchterms"));
        element4.sendKeys("Laptop");

        driver.findElement(By.className("search-box-button")).click();


        WebElement resultat = driver.findElement(By.className("product-title"));

        String actual = resultat.getText();
        String expected = "14.1-inch Laptop";

        Assert.assertEquals(expected, actual);

        System.out.println(expected);


        driver.quit();

        //Objektet: Du skapar ChromeDriver-objektet som öppnar själva webbläsaren.
        //Hitta & Skriva: Med By.id("small-searchterms") pekar du på rätt ruta och använder sendKeys för att skriva "Laptop".
        //Klicka: Med By.className("search-box-button") hittar du knappen och utför själva sökningen med .click().
        //Spara resultatet: Du skapar ett nytt WebElement som heter resultat. Det är här du hittar rubriken på den produkt som dök upp efter sökningen genom att titta på dess klass product-title.
        //Hämta texten: resultat.getText() går in i HTML-koden och hämtar den synliga texten "14.1-inch Laptop" och sparar den i din actual-variabel.
        //Jämföra: Assert.assertEquals kollar om din actual (verkligheten) är exakt samma som din expected (ditt facit).


    }

    @Test

    public void RegistreringOvning() throws InterruptedException {

        WebDriver driver = new ChromeDriver();

        driver.get("https://demowebshop.tricentis.com/register");

        driver.findElement(By.id("gender-male")).click();

        driver.findElement(By.id("FirstName")).sendKeys("Vahid");
        Thread.sleep(1000);
        driver.findElement(By.id("LastName")).sendKeys("Erfani");


        driver.findElement(By.id("Email")).sendKeys("MercedesAMG@hotmail.com");
        Thread.sleep(1000);
        driver.findElement(By.id("Password")).sendKeys("okej55");
        Thread.sleep(1000);
        driver.findElement(By.id("ConfirmPassword")).sendKeys("okej55");


        driver.findElement(By.id("register-button")).click();

        WebElement message = driver.findElement(By.className("result"));

        String actual = message.getText();
        String expected = "Your registration completed";

        Assert.assertEquals(expected, actual);


        driver.quit();


    }


    @Test

    public void felMeddelande() throws InterruptedException {

        WebDriver driver = new ChromeDriver();

        driver.get("https://demowebshop.tricentis.com/register");

        driver.findElement(By.id("gender-male")).click();

        driver.findElement(By.id("FirstName")).sendKeys("Vahid");

        driver.findElement(By.id("LastName")).sendKeys("Erfani");

        driver.findElement(By.id("Email")).sendKeys("MercedesAMG@hotmail.com");

        driver.findElement(By.id("Password")).sendKeys("okej");

        driver.findElement(By.id("ConfirmPassword")).click();

        Thread.sleep(1000);


        WebElement message = driver.findElement(By.className("field-validation-error"));



        String actual = message.getText();
        String expected = "The password should have at least 6 characters.";

        Assert.assertEquals(expected, actual);


        driver.quit();


    }
//Navigera till en produktkategori, t.ex. "Books".
//Hämta priset för alla produkter i kategorin och kontrollera
// att de ligger inom ett rimligt intervall (t.ex. 0–500).

@Test
public void booksTest() throws InterruptedException {

        WebDriver driver = new ChromeDriver();

    driver.get("https://demowebshop.tricentis.com/books");

    Thread.sleep(1000);

    List<WebElement> priser = driver.findElements(By.className("actual-price"));

    for (int i = 0; i < priser.size(); i++) {

        WebElement pekare = priser.get(i);

        String text = pekare.getText();

        double priset = Double.parseDouble(text);

        if (priset < 0 || priset > 500) {
            Assert.fail("Fel pris " + priset);
        } else {
            System.out.println("Pris nummer " + i + " är ok: " + priset);
        }
      }
    }

//Övning – Flöde
//Navigera till inloggningssidan: https://demowebshop.tricentis.com/login
//Logga in med ett testkonto.
//Verifiera att du är inloggad
//Logga ut och verifiera att du är utloggad

    @Test
  public void verifyLogIn() {

   WebDriver driver = new ChromeDriver();

   driver.get("https://demowebshop.tricentis.com/login");

   driver.findElement(By.id("Email")).sendKeys("vahid_erfani@hotmail.com");
   driver.findElement(By.id("Password")).sendKeys("okej55");
   driver.findElement(By.className("login-button")).click();

   WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

   WebElement mail = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("account")));

   String actualMail = mail.getText();
   String expected = "vahid_erfani@hotmail.com";

   Assert.assertEquals(expected, actualMail);







    }

}