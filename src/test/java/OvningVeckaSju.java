import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;


public class OvningVeckaSju {


    //Använd CSS-selector. Försök att skriva en så stabil och enkel CSS-selector som möjligt.
//Navigera till sidan boardgamegeek.com
//I sökfältet sök efter Things in Rings
//Öppna sidan för Things in Rings
//Klicka på ”Images”
//Verifiera titeln på sidan
    @Test

    public void verifyTitle() throws InterruptedException {

        WebDriver driver = new ChromeDriver();

        driver.get("https://boardgamegeek.com/");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement cookies = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".fc-button")));
        cookies.click();

        WebElement search = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[type='search']")));

        search.sendKeys("Things in Rings", Keys.ENTER);

        Thread.sleep(2000);

        driver.findElement(By.cssSelector("a[href*='things-in-rings']")).click();


        driver.findElement(By.cssSelector("a[ui-sref*='images']")).click();
        //a (Det är en länk)
        //[ (Nu ska vi titta på ett attribut).
        //ui-sref (Namnet på attributet från din bild).
        //*= (Betyder: "Innehåller").
        //'images' (Texten vi letar efter).
        //] (Stäng sökningen).

        String expected = "Things in Rings | Board Game | BoardGameGeek";
        String actual = driver.getTitle();

        Assert.assertEquals(expected, actual);

        driver.quit();

    }


//Skapa ett Selenium-skript som skriver ut texten av
// länkarna under ”Categories” på sidan https://demowebshop.tricentis.com/.
// Plocka ut elementen genom att loopa
// igenom de returnerade WebElement-objekten för att extrahera och skriva ut texten.


    @Test

    public void testLoop() {

        WebDriver driver = new ChromeDriver();

        driver.get("https://demowebshop.tricentis.com/");

        List<WebElement> categories = driver.findElements(By.cssSelector("[class*='category-navigation'] a"));

        for (int i = 0; i < categories.size(); i++) {

            String text = categories.get(i).getText();
            System.out.println(text);

        }
    }

    @Test
    public void Loopa() {

        WebDriver driver = new ChromeDriver();

        driver.get("https://demowebshop.tricentis.com/");

        List<WebElement> kategorier = driver.findElements(By.cssSelector(".block-category-navigation a"));

        for (WebElement s : kategorier) {
            System.out.println(s.getText());


        }

    }

    //Skapa ett skript som besöker en ebay.com och söker efter ”van Gogh” under kategorin ”Art”.
    //Verifiera något på sidan du landar på
    //Försök att använda de två olika varianterna av Select
    //ID
    //Starta med [
    //Namnet på attributet (name)
    //Likhetstecken och fnuttar (='sgnBt')
    //Stäng med ]
    @Test

    public void ebayTest() throws InterruptedException {

        WebDriver driver = new ChromeDriver();

        driver.get("https://www.ebay.com/");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement searchBox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".gh-search-input")));
        searchBox.sendKeys("van Gogh");

        WebElement dropDown = driver.findElement(By.cssSelector(".gh-search-categories"));

        Select dropDownElement = new Select(dropDown);

        dropDownElement.selectByVisibleText("Art");

        driver.findElement(By.cssSelector(".gh-search-button__label")).click();

        WebElement resultat = driver.findElement(By.cssSelector(".srp-controls__count-heading"));

        String expected = resultat.getText();
        String actual = "21,000+ results for van Gogh";

        Assert.assertEquals(expected, actual);


    }

    //Skriv ett skript som navigerar till en webbsida med dynamiskt innehåll. T.ex.
// https://en.wikipedia.org/wiki/Main_Page
//Skriv in något i sökfältet på Wikipedia och klicka på det översta alternativet.
// Använd Explicit wait för att vänta på att alternativet laddas
//Skapa en privat metod som utför detta
    @Test

    public void wiki() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://en.wikipedia.org/wiki/Main_Page");

        searchAndClick(driver, "AMG");

        driver.get("https://en.wikipedia.org/wiki/Main_Page");

        searchAndClick(driver, "BMW");

    }

    private void searchAndClick(WebDriver driver, String search) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement searchBox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[name='search']")));
        searchBox.sendKeys(search);

        Thread.sleep(1000);

        WebElement firstResult = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".cdx-menu-item")));
        firstResult.click();

        //ElementNotInteractableException- Vi hittar elementet, men kan inte klicka/skriva till det
        //NoSuchElementException - Vi hittar inte elementet (antingen fel locator eller att elementet inte har dykt upp på sidan)


    }


    public void SkrivIn(WebDriver driver, String selector, String text) {
        driver.findElement(By.cssSelector(selector)).sendKeys(text);


    }

    public void click (WebDriver driver, String selector) {
        driver.findElement(By.cssSelector(selector)).click();


    }


    @Test
    public void demoWeb() {

        WebDriver driver = new ChromeDriver();

        driver.get("https://demowebshop.tricentis.com/register");

        SkrivIn(driver,"#FirstName", "Vahid");

        click(driver, "#gender-male");



    }
}
