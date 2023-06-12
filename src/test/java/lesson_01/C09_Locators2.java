package lesson_01;

import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class C09_Locators2 {
    public static void main(String[] args) {

        Playwright playwright = Playwright.create();
        BrowserType.LaunchOptions setHeadless = new BrowserType.LaunchOptions().setHeadless(false);
        Page page =playwright.chromium().launch(setHeadless).newPage();

        page.navigate("https://letcode.in/test");

    //    page.locator("'Click'").click();     // text alirken anchor olan varsa (basi a) kisaca bulma yontemi
        page.locator("text=Click").click();   // bu da uzun yontem
        System.out.println(page.url());

        page.locator("button:has-text('Goto Home')").click();  // tag name i button olanin texti Goto Home olani seciyoruz
        System.out.println(page.url());

        page.locator("nav : text('Product')").click(); // nav barda yer alan product isimli urune tiklamak icin yaptik
                                                                // spresifik bir alanda belirli tag name altinda olanlara uygulanabilir

       // nth bir onceki derste bahsettik


        page.navigate("https://letcode.in/edit");
        page.locator("#fullName, #name").type("yavuz");   // burada bazen locate edilecek yer css vs diger gorunumlerde farkli
                                                                     // farkli isimlendiriliyor olabilir. bunun icin "this or that" ile locate alabiliriz
                                                                     // burada fullname yada name olan locate i al dedik


        playwright.close();





    }

}
