import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;


public class JobTitlePage {

    SelenideElement adminId = $(By.id("menu_admin_viewAdminModule"));
    SelenideElement menuAdminJobButton = $(By.id("menu_admin_Job"));
    SelenideElement jobTitleListButton = $(By.id("menu_admin_viewJobTitleList"));
    SelenideElement addJobTitleButton = $(By.name("btnAdd"));
    SelenideElement jobTitleField = $(By.name("jobTitle[jobTitle]"));
    SelenideElement saveJobTitleButton = $(By.name("btnSave"));
    SelenideElement jobTitleDeleteButton= $(By.name("btnDelete"));
    SelenideElement jobTitleConfirmDeleteButton= $(By.id("dialogDeleteBtn"));

}
