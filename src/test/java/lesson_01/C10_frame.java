package lesson_01;

import com.microsoft.playwright.*;

import java.util.List;

public class C10_frame {

    public static void main(String[] args) {


        Playwright playwright = Playwright.create();
        BrowserType.LaunchOptions setHeadless = new BrowserType.LaunchOptions().setHeadless(false);
        Page page =playwright.chromium().launch(setHeadless).newPage();

        page.navigate("https://letcode.in/frame");

        //1. yontem

        // iframe sayfa icerisine yerlestirilmis baska html kodlari oldugunu gosterir.

        List<Frame> frames = page.frames();     // sayfadaki tum iframeleri bir liste atayip oradan kullanabiliyoruz
        System.out.println(frames.size());


        Frame frame = page.frame("firstFr");
        frame.getByPlaceholder("Enter name").type("yavuz"); // firstFr isimli iframe icindeki isim bolumune
                                                                        // placaholderdan yola cikip isim girdik.

        // bu iframe icerisinde baska bir iframe de olabilir.(parent frame-child frame denilir) o durumda:
        List<Frame> childFrames = frame.childFrames();
        System.out.println(childFrames.size());

        // childframeleri loop ile url ine gore yazdiriyoruz
        childFrames.forEach(f ->{
            System.out.println("child frameler : "+f.url());
        });

        Frame innerFrame= page.frameByUrl("https://letcode.in/innerFrame");
        innerFrame.getByPlaceholder("Enter email").type("asdasd@gmail.com");

        // burda ayrica inner frame icerisindeyken parent framede degisiklik de yapabiliyoruz. playwright basitliginden kaynaklaniyor

        // 2. yontem
        FrameLocator frameLocator = page.frameLocator("#firstFr");
        frameLocator.getByPlaceholder("Enter name").type("yavuz");
        frameLocator.getByPlaceholder("Enter email").type("selim");

        FrameLocator childframe = frameLocator.frameLocator("iframe.has-background-white");
        childframe.getByPlaceholder("Enter email").type("selim");

        playwright.close();
    }
}
