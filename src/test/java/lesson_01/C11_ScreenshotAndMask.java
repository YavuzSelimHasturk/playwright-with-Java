package lesson_01;

import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

import java.nio.file.Paths;
import java.util.Arrays;

public class C11_ScreenshotAndMask {

    public static void main(String[] args) {

        Playwright playwright = Playwright.create();
        BrowserType.LaunchOptions setHeadless = new BrowserType.LaunchOptions().setHeadless(false);
        Page page =playwright.chromium().launch(setHeadless).newPage();

        page.navigate("https://www.ikea.com.tr");

        // o anda ekranin gorundugu alan kadar ss almak icin
        page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("snaps/screenshot.png")));

        // sayfanin tamaminin ekran goruntusunu almak icin
        page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("snaps/screenshotfull.png")).setFullPage(true));

        // bir locate in  ss ini almak icin
        Locator searchLocator = page.getByPlaceholder("Ürün Ara");
        searchLocator.screenshot(new Locator.ScreenshotOptions().setPath(Paths.get("snaps/locateScreenshot.png")));

        // screenshotta pek cok cesit mevcut. orn; arama cubugunda imlecin gozukup gozukmeme durumunu ayarlayabiliyoruz
        // yahut resimin kalitesini 0-100 araliginda belirleyebildigimiz secenekler mevcut

        // mask yontemi ile test sirasinda girdigimiz bilgilerin gorulmesini istemiyorsak onlari kapatiyoruz
        page.screenshot(new Page.ScreenshotOptions().setMask(Arrays.asList(searchLocator))
                .setPath(Paths.get("snaps/maskLocate.png")));




        playwright.close();

    }

}
