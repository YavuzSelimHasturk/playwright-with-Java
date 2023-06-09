package lesson_01;

import com.microsoft.playwright.*;

import java.nio.file.Paths;

public class C07_RecordVideo {

    public static void main(String[] args) {

        Playwright playwright = Playwright.create();
        BrowserType browserType = playwright.chromium();
        BrowserType.LaunchOptions headless = new BrowserType.LaunchOptions().setHeadless(false);
        Browser browser = browserType.launch(headless);
        BrowserContext context = browser.newContext(new Browser.NewContextOptions()
                .setRecordVideoDir(Paths.get("videos/"))  // videonun kaydedilecegi yeri sectik
                .setRecordVideoSize(1280,720));    // videonun kalitesini belirledik. default olarak 840 li biseyler

        Page page = context.newPage();
        page.navigate("https://www.ikea.com.tr");
        page.locator("#ctl00_ctrlHeader_rptMenuBars_ctl00_anchorMenuBar").click();
        page.locator("#ctl00_ctrlHeader_rptHeadlines_ctl01_headlineAnchor").click();

        System.out.println(page.title());

        context.close(); // contexti kapatmazsak video kaydi surer
        playwright.close();


    }
}
