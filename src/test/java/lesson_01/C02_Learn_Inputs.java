package lesson_01;

import com.microsoft.playwright.*;

public class C02_Learn_Inputs {

    public static void main(String[] args) {
        Playwright playwright = Playwright.create();
        Browser browser= playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false)); // seleniumdaki chromeDriver.newChromeDriver gibi
        Page page = browser.newPage();

        page.navigate("https://www.amazon.com");

        // seleniumda web  element olarak geciyordu. burada locator olarak geciyor
        // xpath,lintext,css vs ne olursa olasun locator ile elementi secebiliyoruz

        page.locator("#twotabsearchtextbox").type("xiaomi");
        page.locator("#twotabsearchtextbox").fill("vaio");
        page.locator("#twotabsearchtextbox").type("xiaomi");

        // type ile yaparken mevcut yazi varsa sonrasina ekler. fill de yaziyi silip ekler
        // type da harf harf yazar ama fillde girilen metni direk kopyalar
/*
        Locator locator = page.locator("#twotabsearchtextbox");
        locator.press("End");
        locator.type(" computer");
        locator.press("Enter");
*/
        // bir baska yontem ise once locator sonra aranacak kelimeyi girmek
        page.type("#twotabsearchtextbox","microphone");

        // elementin degerini getirmek icin
        String value = page.locator("id=twotabsearchtextbox").getAttribute("value");
        System.out.println(value);

        // yazilani silmek icin
        page.locator("id=twotabsearchtextbox").clear();


        page.close();
        browser.close();
        playwright.close();
    }
}
