package lesson_01;

import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

import java.util.List;

public class C12_Window_Handling {
    public static void main(String[] args) {

        Playwright playwright = Playwright.create();
        BrowserType.LaunchOptions setHeadless = new BrowserType.LaunchOptions().setHeadless(false);
        Page page = playwright.chromium().launch(setHeadless).newPage();
        page.navigate("https://letcode.in/windows");

        // windowlar yuklenirken gecikme yasarsa sorun olabiliyor. Onceden kac adet window acacagimizi biliyorsak:

        page.waitForPopup(new Page.WaitForPopupOptions().setPredicate(
                p -> p.context().pages().size() == 3), () -> {
            page.locator("id=multi").click();
        });

        List<Page> pages = page.context().pages();
        for (Page tabs : pages) {
            tabs.waitForLoadState();
            System.out.println(tabs.url());
        }
        Page alertPage = pages.get(1);
        Page dropdownPage = pages.get(2);

        System.out.println("Alert page : " + alertPage.textContent("h1"));
        System.out.println( "Dropdown page : " + dropdownPage.textContent("h1"));

        playwright.close();



    }
}
