import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import org.openqa.selenium.By;

import java.util.concurrent.TimeUnit;

import static com.codeborne.selenide.Selenide.*;

public class AdminPanelMainPage {

    private By eShopAccordion = By.cssSelector("a[href=\"#collapseOne\"]");
    private By couponsAccordion = By.cssSelector("a[title=\"Coupons\"]");
    private By newCouponBtn = By.cssSelector("a[href=\"http://open-eshop.stqa.ru/oc-panel/Coupon/create\"]");
    private By couponName = By.cssSelector("input[name=\"name\"]");
    private By validDate = By.cssSelector("input[name=\"valid_date\"]");
    private By numberOfCoupons = By.cssSelector("input[name=\"number_coupons\"]");
    private By submitNewCouponBtn = By.cssSelector("button[name=\"submit\"]");
    private By couponSearchBox = By.cssSelector("input[name=\"name\"]");
    private By couponSearchBtn = By.cssSelector("form[method=\"get\"] button");
    private By couponDeleteBtn = By.cssSelector("a[href*=\"oc-panel/Coupon/delete\"]");
    private By couponDeleteConfirmBtn = By.cssSelector("button.confirm");
    private By userDropDownMenuBtn = By.cssSelector("a[data-toggle=\"dropdown\"] > span.caret");
    private By userLogOutBtn = By.cssSelector("a[href*=\"logout\"]");
    private By tableCell = By.cssSelector("div.table-responsive td");
    private By tableSearchResultHeaders = By.cssSelector("table.table.table-striped > thead tr");
    private By tableSearchResultRow = By.cssSelector("table.table.table-striped > tbody tr");
    private By fixedDiscountTab = By.xpath("//div//a[contains(text(), 'Fixed')]");
    private By couponCreationSuccessMsg = By.cssSelector("div.alert.alert-success");



    public String adminPanelMainPageTitle(){
        return title();
    }

    public AdminPanelMainPage addNewCoupon(String name, String date, String count){
        $(eShopAccordion).click();
        $(couponsAccordion).click();
        $(newCouponBtn).click();
        $(couponName).shouldBe(Condition.appears).setValue(name);
        $(validDate).setValue(date);
        $(numberOfCoupons).setValue(count);
        $(submitNewCouponBtn).click();
        return  page(AdminPanelMainPage.class);
    }

    public AdminPanelMainPage couponSearch(String name){
        $(couponSearchBox).setValue(name);
        $(couponSearchBtn).click();
        return  page(AdminPanelMainPage.class);
    }

    public AdminPanelMainPage couponDelete(){
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
        }
        $(couponDeleteBtn).click();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
        }
        $(couponDeleteConfirmBtn).click();
        $(tableCell).shouldBe(Condition.hidden);
        return  page(AdminPanelMainPage.class);
    }

    public AdminPanelMainPage logoutUser(){
        $(userDropDownMenuBtn).click();
        $(userLogOutBtn).click();
        return  page(AdminPanelMainPage.class);
    }
}
