import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class EmployeePage {

    SelenideElement pimButton = $(By.id("menu_pim_viewPimModule"));
    SelenideElement addEmployeeButton = $(By.id("menu_pim_addEmployee"));

    SelenideElement firstNameEmployeeField = $(By.id("firstName"));
    SelenideElement lastNameEmployeeField = $(By.id("lastName"));
    SelenideElement employeeId = $(By.id("employeeId"));

    SelenideElement createLoginDetails = $("input[type='checkbox']");
    SelenideElement userNameEmployeeField = $(By.id("user_name"));

    SelenideElement userEmployeePassword = $(By.name("user_password"));
    SelenideElement userEmployeeConfirmPassword = $(By.name("re_password"));

    SelenideElement employeeStatus = $(By.name("status"));
    SelenideElement employeeEnabledStatus = $("option[value='Enabled']");
    SelenideElement employeeSaveButton = $(By.id("btnSave"));

}
