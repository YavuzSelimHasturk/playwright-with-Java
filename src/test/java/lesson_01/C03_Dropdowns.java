package lesson_01;

import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.SelectOption;

public class C03_Dropdowns {
    public static void main(String[] args) throws InterruptedException {

        Playwright playwright = Playwright.create();
        BrowserType.LaunchOptions headless = new BrowserType.LaunchOptions().setHeadless(false);

        Page page = playwright.chromium().launch(headless).newPage();
        page.navigate("https://amazon.com");

        // 1. yontem
        page.selectOption("#searchDropdownBox","search-alias=baby-products-intl-ship");

        // 2. yontem
        Locator locator = page.locator("#searchDropdownBox");
        locator.selectOption(new SelectOption().setLabel("Baby"));
        locator.selectOption(new SelectOption().setIndex(4));

        // Dropdownda kac adet secenek oldugunu bulma ve yazdirma
        Locator options = locator.locator("option");
        int count = options.count();
        System.out.println("len: "+count);

        // Baska yontemlerde mevcut. documentationdan bakilabilir

        // textContent seleniumdaki gettext gibi dusunulebilir
        String textContent = page.locator("#searchDropdownBox").textContent();

        Thread.sleep(3000);

        playwright.close();



    }
}
