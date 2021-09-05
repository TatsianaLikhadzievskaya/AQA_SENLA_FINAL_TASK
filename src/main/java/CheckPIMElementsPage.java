import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class CheckPIMElementsPage {

    SelenideElement pimButton = $(By.id("menu_pim_viewPimModule"));
    SelenideElement employeeListButton = $(By.id("menu_pim_viewEmployeeList"));
    SelenideElement employeeNameField = $(By.name("empsearch[employee_name][empName]"));
    SelenideElement searchEmployeeButton = $(By.id("searchBtn"));
    SelenideElement openEmployeeProfile = $(By.xpath("//a[text()='Marianne']"));

    SelenideElement personalDetailsButton = $(By.xpath("//a[text()='Personal Details']"));

    SelenideElement personalDetailsFirstNameField = $(By.name("personal[txtEmpFirstName]"));
    SelenideElement personalDetailsMidNameField = $(By.name("personal[txtEmpMiddleName]"));
    SelenideElement personalDetailsLastNameField = $(By.name("personal[txtEmpLastName]"));

    SelenideElement personalDetailsIdField = $(By.name("personal[txtEmployeeId]"));
    SelenideElement personalDetailsDrLicNumField = $(By.name("personal[txtLicenNo]"));
    SelenideElement personalDetailsSSNNumField = $(By.name("personal[txtNICNo]"));
    SelenideElement personalDetailsOtherIdField = $(By.name("personal[txtOtherID]"));
    SelenideElement personalDetailsLicExpDateField = $(By.name("personal[txtLicExpDate]"));
    SelenideElement personalDetailsSINNumField = $(By.name("personal[txtSINNo]"));

    SelenideElement personalDetailsMaleGenderField = $(By.id("personal_optGender_1"));
    SelenideElement personalDetailsFemaleGenderField = $(By.id("personal_optGender_2"));

    SelenideElement personalDetailsNickNameField = $(By.name("personal[txtEmpNickName]"));
    SelenideElement personalDetailsMilitaryServiceField = $(By.name("personal[txtMilitarySer]"));
    SelenideElement personalDetailsDateOfBirthField = $(By.name("personal[DOB]"));
    SelenideElement personalDetailsSmokeFlagField = $(By.name("personal[chkSmokeFlag]"));
    SelenideElement personalDetailsBloodTypeField = $(By.name("custom1"));

}
