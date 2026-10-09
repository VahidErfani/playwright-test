package playwright;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.SelectOption;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertTrue;

public class PlaywrightTest {

    //Skapa ett Selenium-skript som skriver ut texten av
// länkarna under ”Categories” på sidan https://demowebshop.tricentis.com/.
// Plocka ut elementen genom att loopa
// igenom de returnerade WebElement-objekten för att extrahera och skriva ut texten.
    @Test
    public void testLoopPlaywright() {

        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
            Page page = browser.newPage();

            page.navigate("https://demowebshop.tricentis.com/");

            Locator categories = page.locator("[class*='category-navigation'] a");

            List<String> allTexts = categories.allInnerTexts();

            for (int i = 0; i < allTexts.size(); i++) {
                System.out.println(allTexts.get(i));
            }

            browser.close();

        }

    }

    @Test
    public void searchEbayTest() {

        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
            Page page = browser.newPage();

            page.navigate("https://www.ebay.com");

            page.selectOption("#gh-cat", new SelectOption().setLabel("Art"));

            page.fill("#gh-ac", "van Gogh");

            page.click("#gh-search-btn");

            String titel = page.title();

            System.out.println("Ttitlen = " + titel);

            assertTrue(titel.contains(" Van Gogh"));

        }


    }


}
