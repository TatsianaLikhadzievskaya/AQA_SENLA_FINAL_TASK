import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;


public class DashboardPage {

    SelenideElement dashboardMenuButton = $(By.id("menu_dashboard_index"));
    SelenideElement assignLeaveQuickLaunch = $(By.xpath("//span[text()='Assign Leave']"));
    SelenideElement leaveListQuickLaunch = $(By.xpath("//span[text()='Leave List']"));
    SelenideElement timeSheetsQuickLaunch = $(By.xpath("//span[text()='Timesheets']"));
    SelenideElement applyLeaveQuickLaunch = $(By.xpath("//span[text()='Apply Leave']"));
    SelenideElement myLeaveQuickLaunch = $(By.xpath("//span[text()='My Leave']"));
    SelenideElement myTimeSheetLaunch = $(By.xpath("//span[text()='My Timesheet']"));

}
