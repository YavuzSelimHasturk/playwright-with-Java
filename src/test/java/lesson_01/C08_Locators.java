package lesson_01;

import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.AriaRole;

public class C08_Locators {
    public static void main(String[] args) {

        Playwright playwright = Playwright.create();
        BrowserType.LaunchOptions setHeadless = new BrowserType.LaunchOptions().setHeadless(false);
        Page page =playwright.chromium().launch(setHeadless).newPage();

        page.navigate("https://bookcart.azurewebsites.net/");

        // getBy... ile gelen bu kullanimlar incele ekraninda elementi temsil eden atamalar

        page.getByText("Login").click();        // acilan sayfada text i Login olan elementi aldi
        page.getByLabel("Username").type("yavuz"); // labelda span icindeki text.
        page.getByLabel("Password").type("123456");

        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions()
                        .setName("Login")).last().click(); // burada iki tane elementin texti ayni.
                                                           // sonuncusunu secmek icin last dedik, daha fazla olsaydi
                                                            //  .nth(1) ile index belirtirdik

        // searh kutusuna bisey yazdigimizda alttaki seceneklerden secmek icin option u kullandik
        page.getByPlaceholder("Search books or authors").fill("HP");
        page.getByRole(AriaRole.OPTION).first().click();

        page.getByAltText("Book cover image").click();   // alttext ile sectik
        System.out.println(page.url());





        playwright.close();



    }
}
