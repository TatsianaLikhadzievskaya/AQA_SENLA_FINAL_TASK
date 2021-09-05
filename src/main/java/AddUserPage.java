import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class AddUserPage {

    SelenideElement adminId = $(By.id("menu_admin_viewAdminModule"));
    SelenideElement userManagementButton = $(By.id("menu_admin_UserManagement"));
    SelenideElement usersButton = $(By.id("menu_admin_viewSystemUsers"));
    SelenideElement addUserButton = $(By.name("btnAdd"));

    SelenideElement userType = $(By.id("systemUser_userType"));
    SelenideElement employeeName = $(By.id("systemUser_employeeName_empName"));
    SelenideElement userName = $(By.name("systemUser[userName]"));
    SelenideElement userStatus = $(By.name("systemUser[status]"));
    SelenideElement systemUserPassword = $(By.name("systemUser[password]"));
    SelenideElement systemUserConfirmPassword = $(By.name("systemUser[confirmPassword]"));
    SelenideElement saveUserButton = $(By.name("btnSave"));

    SelenideElement searchSystemUser = $(By.name("searchSystemUser[userName]"));
    SelenideElement searchUserButton = $(By.name("_search"));
    SelenideElement searchUserResult = $(By.xpath("//a[text()='maricampbell']"));
}

