package lesson_01;

import com.microsoft.playwright.*;

public class C06_Browser_Context {
    public static void main(String[] args) {

        Playwright playwright= Playwright.create();
        BrowserType browserType = playwright.chromium();
        Browser browser= browserType.launch(new BrowserType.LaunchOptions().setHeadless(false));
        BrowserContext context = browser.newContext();
        Page page = context.newPage();

        // context ve pageler farkli seyler. bir senaryo da birden fazla context icinde birden fazla sayfa acilmasini
        // isteyebilir. bu konuda pratik ve faydali

        //bookcart sitesine gidip bir kullanici adi ve sifre ile login oluyoruz
        page.navigate("https://bookcart.azerewebsites.net/");
        page.click("//span[text()='Login']/..");page.locator("input[formcontrolname='username']").type("ortoni");
        page.locator("input[formcontrolname='password']").type("Pass1234$");
        page.locator("button[color='primary']").click();
        String userName = page.locator("//button[contains(@class,'mat-focus-indicator mat-menu-trigger')]//span[1]").textContent();
        System.out.println(userName.split(" ")[1].split(" ")[0]);


        BrowserContext context2 = browser.newContext(); //yeni bir otomasyon penceresi aciyor
        Page newPage = context2.newPage(); // yeni bir page aciyor. context2 demeseydik onceki contextte bir sekme acacakti
        newPage.navigate("https://bookcart.azerewebsites.net/");
        userName = newPage.locator("//button[contains(@class,'mat-focus-indicator mat-menu-trigger')]//span[1]").textContent();
        System.out.println(userName.split(" ")[1].split(" ")[0]);
        newPage.close();
		context2.close();


        page.bringToFront(); // arkada kalan contexti one getiriyor
        page.locator("input[type='search']").type("HP3");

        playwright.close(); // hepsini kapatiyor



    }
}
