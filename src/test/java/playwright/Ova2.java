package playwright;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import org.junit.jupiter.api.Test;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;


public class Ova2 {
    @Test
    void openPage() {
        Playwright playwright = Playwright.create();

        Browser browser = playwright.chromium().launch(
                new BrowserType.LaunchOptions().setHeadless(true));

        Page page = browser.newPage();


        page.navigate("https://www.google.com");


        assertThat(page).hasTitle("Google");

        browser.close();
        playwright.close();
    }

}