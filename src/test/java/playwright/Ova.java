package playwright;


import com.microsoft.playwright.*;
import org.junit.jupiter.api.Test;

import java.nio.file.Paths;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class Ova {

    @Test
    void openPage() {
        Playwright playwright = Playwright.create();

        Browser browser = playwright.chromium().launch(
                new BrowserType.LaunchOptions().setHeadless(true));

        Page page = browser.newPage();

        String fileUrl = Paths.get("C:/Users/Erfani/Downloads/Register Basketball/Register.html").toUri().toString();
        page.navigate(fileUrl);

        page.locator("#dp").pressSequentially("13/05/1994", new Locator.PressSequentiallyOptions().setDelay(100));
        page.locator("#dp").press("Tab");
        page.locator("#member_firstname").fill("Vahid");
        page.locator("#member_lastname").fill("Erfani");
        page.locator(".form-control[name='EmailAddress']").fill("Vahid_Erfani23@hotmail.com");
        page.locator("#member_confirmemailaddress").fill("Vahid_Erfani23@hotmail.com");
        page.locator("#signupunlicenced_password").fill("hejhej123");
        page.locator("#signupunlicenced_confirmpassword").fill("hejhej123");

        page.getByText("Fan", new Page.GetByTextOptions().setExact(true)).click();
        page.locator("#sign_up_25").check(new Locator.CheckOptions().setForce(true));
        page.locator("#sign_up_26").check(new Locator.CheckOptions().setForce(true));
        page.locator("#fanmembersignup_agreetocodeofethicsandconduct").check(new Locator.CheckOptions().setForce(true));
        page.locator(".btn.btn-big").click();

        assertThat(page).hasURL("file:///C:/Users/Erfani/Downloads/Register%20Basketball/Success.html");
        assertThat(page.getByText("Your Basketball England Membership Number is:")).isVisible();


    }
}
