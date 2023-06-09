package lesson_01;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class C01_Launch_Browser {
    public static void main(String[] args) {

        Playwright playwright = Playwright.create();
        Browser browser= playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false)); // seleniumdaki chromeDriver.newChromeDriver gibi
        Page page = browser.newPage();
        page.navigate("https://www.amazon.com"); // JS de goto deniyor, burada navigate

        System.out.println(page.title());  //seleniumdaki getTitle ozelligi


        page.close();
        browser.close();
        playwright.close();

        // playwright default olarak headless modda calisir. bu herhangi bir interface acmadan calismasi demektir
        // ancak yukaridaki launch parantezinin icerisini yazarsak bize gorunur bi pencere acar

        // chromium yerine firefox vb yazilabilir

    }
}
