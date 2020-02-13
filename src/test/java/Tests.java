
import io.qameta.allure.Description;
import org.junit.jupiter.api.*;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.title;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)

public class Tests extends TestBase{

    @Test
    @Description("Login User test")
    @Order(1)
    public void LoginUserTest(){
        LoginPage loginPage = open(loginPageURL, LoginPage.class);
        loginPage.loginUser(adminEmail, adminPassword);
        Assertions.assertEquals("Welcome - Open eShop", title());
    }

    @Test
    @Description("Add new coupon test")
    @Order(2)
    public void addNewCouponTest(){
        LoginPage loginPage = open(loginPageURL, LoginPage.class);
        AdminPanelMainPage adminPanelMainPage = loginPage.loginUser(adminEmail, adminPassword);
        adminPanelMainPage.addNewCoupon(couponNameField, couponDateField, couponCountField);
    }

    @Test
    @Description("Search and delete coupon test")
    @Order(3)
    public void searchAndDeleteCouponTest(){
        LoginPage loginPage = open(loginPageURL, LoginPage.class);
        loginPage.loginUser(adminEmail, adminPassword);
        AdminPanelMainPage adminPanelMainPage = open(couponsPageURL, AdminPanelMainPage.class);
        adminPanelMainPage.couponSearch(couponNameField);
        adminPanelMainPage.couponDelete();
    }

    @Test
    @Description("Logout test")
    @Order(4)
    public void logoutTest(){
        LoginPage loginPage = open(loginPageURL, LoginPage.class);
        AdminPanelMainPage adminPanelMainPage = loginPage.loginUser(adminEmail, adminPassword);
        adminPanelMainPage.logoutUser();
    }
}
