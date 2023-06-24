package lesson_01;

import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.assertions.PlaywrightAssertions.*;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class C13_Assertions {

    // playwright assertion avantajlari => assertion destekli oto-waits ve pek cok method olmasi
    // dezavantajlari => soft assert yok

    // default olarak 5000 ms otowaits var

    public static void main(String[] args) {

        Playwright playwright = Playwright.create();
        BrowserType.LaunchOptions setHeadless = new BrowserType.LaunchOptions().setHeadless(false);
        Page page = playwright.chromium().launch(setHeadless).newPage();
        page.navigate("https://letcode.in/edit");

        Locator header = page.locator("h1");
        assertThat(header).hasText("Input"); // farkli farkli assertion yontemleri var

        assertThat(page).hasTitle("Interact with Input fields"); // has url de var

        assertThat(page.locator("#join")).hasAttribute("value","I am good");

        playwright.close();


    }
}
