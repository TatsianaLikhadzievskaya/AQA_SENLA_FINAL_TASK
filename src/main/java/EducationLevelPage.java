import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class EducationLevelPage {

    SelenideElement adminId = $(By.id("menu_admin_viewAdminModule"));
    SelenideElement menuAdminQualificationsButton = $(By.id("menu_admin_Qualifications"));
    SelenideElement educationLevelListButton = $(By.id("menu_admin_viewEducation"));
    SelenideElement addEducationLevelButton = $(By.id("btnAdd"));
    SelenideElement educationLevelField = $(By.name("education[name]"));
    SelenideElement saveEducationLevelButton = $(By.name("btnSave"));
    SelenideElement searchEducationLevelResult = $(By.xpath("//a[text()='Doctoral Degree']"));

}
