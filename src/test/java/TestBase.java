import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;

import static com.codeborne.selenide.Selenide.open;

public class TestBase {
    LoginPage loginPage;
    AdminPanelMainPage adminPanelMainPage;

    // URLs
    String loginPageURL = "http://open-eshop.stqa.ru/oc-panel/auth/login/";
    String adminPanelURL = "http://open-eshop.stqa.ru/oc-panel";
    String couponsPageURL = "http://open-eshop.stqa.ru/oc-panel/coupon";

    // Admin credentials
    String adminEmail = "demo@open-eshop.com";
    String adminPassword = "demo";

    // Coupon data
    String couponNameField = "coupon32324";
    String couponDateField = "2021-01-03";
    String couponCountField = "3";

    @BeforeAll
    public static void setUp() {
        Configuration.headless = true;
        Configuration.browserSize = "1920x1080";
        Configuration.fastSetValue = true;
/*        System.setProperty("wdm.proxy", "proxy:port");
        System.setProperty("wdm.proxyUser", "login");
        System.setProperty("wdm.proxyPass", "pass");*/
    }

    @AfterEach
    public void tearDown(){
        Selenide.closeWebDriver();
    }
}
