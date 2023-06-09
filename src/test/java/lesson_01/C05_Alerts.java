package lesson_01;

import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class C05_Alerts {
    public static void main(String[] args) {
        Playwright playwright = Playwright.create();
        Page page = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false)).newPage();

        page.navigate("https://letcode.in/alert");
/*
        // playwright da seleniumdan farkli olarak alert de handle i tiklamadan once yapmamiz lazim
        page.onDialog(dialog -> {
            System.out.println(dialog.message());
            dialog.accept();
        });
        // id= accept olan alerte tikliyor
        page.locator("#accept").click();
*/
        // prompt alert icin
        page.onDialog(dialog -> {
            System.out.println(dialog.message());
            dialog.accept("yavuz");
        });

        page.locator("id=prompt").click();
        System.out.println(page.locator("#myName").textContent());


       // page.close();

    }
}
