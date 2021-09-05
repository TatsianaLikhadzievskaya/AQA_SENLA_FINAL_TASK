import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class JobCategoryPage {

    SelenideElement adminId = $(By.id("menu_admin_viewAdminModule"));
    SelenideElement menuAdminJobButton = $(By.id("menu_admin_Job"));
    SelenideElement jobCategoriesListButton = $(By.id("menu_admin_jobCategory"));
    SelenideElement addJobCategoryButton = $(By.name("btnAdd"));
    SelenideElement jobCategoryField = $(By.name("jobCategory[name]"));
    SelenideElement saveJobCategoryButton = $(By.name("btnSave"));

}
