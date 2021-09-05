import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class AssignLeavePage {

    SelenideElement leaveMenuButton = $(By.id("menu_leave_viewLeaveModule"));
    SelenideElement assignLeaveButton = $(By.id("menu_leave_assignLeave"));
    SelenideElement assignLeaveEmployeeNameField = $(By.name("assignleave[txtEmployee][empName]"));
    SelenideElement assignLeaveTypeField = $(By.name("assignleave[txtLeaveType]"));
    SelenideElement assignLeaveBalanceField = $(By.id("assignleave_leaveBalance"));
    SelenideElement assignLeaveFromDateField = $(By.id("assignleave_txtFromDate"));
    SelenideElement assignLeaveToDateField = $(By.id("assignleave_txtToDate"));
    SelenideElement assignLeaveCommentField = $(By.name("assignleave[txtComment]"));

    SelenideElement assignLeaveFromDate = $(By.xpath("//a[text()='20']"));
    SelenideElement assignLeaveToDate = $(By.xpath("//a[text()='29']"));

    SelenideElement assignLeavePartialDays = $(By.name("assignleave[partialDays]"));
    SelenideElement assignLeaveDuration = $(By.id("assignleave_firstDuration_duration"));
    SelenideElement assignLeaveFirstDuration = $(By.id("assignleave_firstDuration_ampm"));
    SelenideElement assignLeaveEmployeeButton = $(By.id("assignBtn"));
    SelenideElement confirmLeaveAssignmentButton = $(By.id("confirmOkButton"));

    SelenideElement leaveListButton = $(By.id("menu_leave_viewLeaveList"));
    SelenideElement employeeLeaveListField = $(By.name("leaveList[txtEmployee][empName]"));
    SelenideElement searchLeaveListButton = $(By.id("btnSearch"));
    SelenideElement searchEmployeeLeaveListResult = $(By.xpath("//a[text()='Marianne Campbell']"));
    SelenideElement showLeaveStatus = $(By.id("leaveList_chkSearchFilter_checkboxgroup_allcheck"));

}
