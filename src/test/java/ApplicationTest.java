import com.codeborne.selenide.*;

import io.qameta.allure.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.openqa.selenium.By;
import utils.Log;

import java.io.IOException;

import static com.codeborne.selenide.Selenide.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)

public class ApplicationTest {

    @BeforeEach
    public void loginTest() throws IOException {

        Log.info("Open orangehrmlive.com");
        LoginPage loginPage = new LoginPage();
        loginPage.openLoginPage();

        Log.info("User login");
        loginPage.login();

        Log.info("Check user logon to succeed");
        String currentUrl = WebDriverRunner.getWebDriver().getCurrentUrl();
        Assertions.assertEquals("https://opensource-demo.orangehrmlive.com/index.php/dashboard", currentUrl, "User logon failed");
    }

    @AfterEach
    public void tearDown() {
        Log.info("Close the current browser page");
        closeWebDriver();
    }

    @Step("Add a new employee to Employee List and a new user to system users")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Add new employee and user test")
    @Feature("New employee and user adding")
    @Story("Add")
    @Epic("Employee List and System users list")
    @Issue("TC-001")
    @Test
    @Order(1)
   public void addEmployeeAndUser() {
        //According to user manual for OrangeHRM an employee list needs to be created first
        // under the PIM Module to create user logins

        Log.info("Add a new employee to the system");

        EmployeePage employeePage = new EmployeePage();
        employeePage.pimButton.click();
        employeePage.addEmployeeButton.click();

        employeePage.firstNameEmployeeField.sendKeys("Marianne");
        employeePage.lastNameEmployeeField.sendKeys("Campbell");
        employeePage.employeeId.clear();
        employeePage.employeeId.sendKeys("0985");
        employeePage.createLoginDetails.click();

        employeePage.userNameEmployeeField.sendKeys("maricamp");
        employeePage.userEmployeePassword.sendKeys("***maricamp1990");
        employeePage.userEmployeeConfirmPassword.sendKeys("***maricamp1990");

        employeePage.employeeStatus.click();
        employeePage.employeeEnabledStatus.click();
        employeePage.employeeSaveButton.click();

        Log.info("Check if a new employee is saved to the system");
        String expectedURL = "https://opensource-demo.orangehrmlive.com/index.php/pim/viewPersonalDetails/empNumber/";
        String currentUrl = WebDriverRunner.getWebDriver().getCurrentUrl();
        Assertions.assertTrue(currentUrl.contains(expectedURL));

        Log.info("Add a system user");

        AddUserPage addUserPage = new AddUserPage();

        addUserPage.adminId.click();
        addUserPage.userManagementButton.click();
        addUserPage.usersButton.click();
        addUserPage.addUserButton.click();

        Log.info("Check system user form's fields");

        Assertions.assertNotNull(addUserPage.userType);
        Assertions.assertNotNull(addUserPage.employeeName);
        Assertions.assertNotNull(addUserPage.userName);
        Assertions.assertNotNull(addUserPage.userStatus);
        Assertions.assertNotNull(addUserPage.systemUserPassword);
        Assertions.assertNotNull(addUserPage.systemUserConfirmPassword);

        Log.info("Fill system user form's fields");

        addUserPage.userType.selectOptionContainingText("ESS");
        addUserPage.employeeName.sendKeys("Marianne Campbell");
        addUserPage.userName.sendKeys("maricampbell");
        addUserPage.userStatus.selectOptionContainingText("Enabled");
        addUserPage.systemUserPassword.sendKeys("19marianne90camp*");
        addUserPage.systemUserConfirmPassword.sendKeys("19marianne90camp*");
        addUserPage.saveUserButton.click();

        Log.info("Search system user by username");
        Selenide.sleep(4000);
        addUserPage.searchSystemUser.sendKeys("maricampbell");
        addUserPage.searchUserButton.click();
        Selenide.sleep(4000);
        String Result=addUserPage.searchUserResult.getText();
        Assertions.assertEquals("maricampbell",Result);

    }

    @Step("Assign leave to the relevant employee to Leave List")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Assign leave test")
    @Feature("Assigning leave to employee")
    @Story("Assign")
    @Epic("Leave List")
    @Issue("TC-002")
    @Test
    @Order(2)
    public void assignLeaveToEmployee(){

        Log.info("Assign leave to the relevant employee");

        AssignLeavePage leavePage = new AssignLeavePage();

        leavePage.leaveMenuButton.click();
        leavePage.assignLeaveButton.click();

        Log.info("Check assign leave form's fields");

        Assertions.assertNotNull(leavePage.assignLeaveEmployeeNameField);
        Assertions.assertNotNull(leavePage.assignLeaveTypeField);
        Assertions.assertNotNull(leavePage.assignLeaveBalanceField);
        Assertions.assertNotNull(leavePage.assignLeaveFromDateField);
        Assertions.assertNotNull(leavePage.assignLeaveToDateField);
        Assertions.assertNotNull(leavePage.assignLeaveCommentField);

        Log.info("Fill assign leave form's fields");

        leavePage.assignLeaveEmployeeNameField.sendKeys("Marianne Campbell");
        leavePage.assignLeaveTypeField.selectOptionContainingText("US - Vacation");
        leavePage.assignLeaveFromDateField.click();
        leavePage.assignLeaveFromDate.click();
        leavePage.assignLeaveToDateField.click();
        leavePage.assignLeaveToDate.click();
        leavePage.assignLeavePartialDays.selectOptionContainingText("Start Day Only");
        leavePage.assignLeaveDuration.selectOptionContainingText("Half Day");
        leavePage.assignLeaveFirstDuration.selectOptionContainingText("Morning");
        leavePage.assignLeaveCommentField.sendKeys("First part of annual leave");
        leavePage.assignLeaveEmployeeButton.click();
        leavePage.confirmLeaveAssignmentButton.click();

        Log.info("Check if leave request is added ");

        leavePage.leaveListButton.click();
        leavePage.showLeaveStatus.click();
        leavePage.employeeLeaveListField.sendKeys("Marianne Campbell");
        leavePage.searchLeaveListButton.click();
        String employeeResult=leavePage.searchEmployeeLeaveListResult.getText();
        Assertions.assertEquals("Marianne Campbell",employeeResult);

    }

    @Step("Add a new candidate to candidate's list")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Add new candidate test")
    @Feature("New candidate adding")
    @Story("Add")
    @Epic("Candidate's list")
    @Issue("TC-003")
    @Test
    @Order(3)
    public void addNewCandidate(){

        Log.info("Add a new candidate to candidate's list");

        CandidatePage candidatePage = new CandidatePage();

        candidatePage.recruitmentModule.click();
        candidatePage.viewCandidatesButton.click();
        candidatePage.addCandidatesButton.click();

        candidatePage.firstNameCandidateField.sendKeys("Jonathan");
        candidatePage.lastNameCandidateField.sendKeys("Roy");
        candidatePage.emailCandidateField.sendKeys("johny.roy@gmail.com");
        candidatePage.contactNumberCandidateField.sendKeys("+1-541-754-3010");

        candidatePage.candidateVacancySelect.selectOptionContainingText("Sales Representative");
        candidatePage.candidateKeyWordsField.sendKeys("Communication, negotiation, public speaking skills");

        candidatePage.candidateAppliedDate.click();
        candidatePage.candidateStateDate.click();
        candidatePage.keepDataButton.click();
        candidatePage.saveCandidateButton.click();

        String currUrl = WebDriverRunner.getWebDriver().getCurrentUrl();
        String expectedURL = "https://opensource-demo.orangehrmlive.com/index.php/recruitment/addCandidate/id/";
        Assertions.assertTrue(currUrl.contains(expectedURL));

    }

    @Step("Check elements on Dashboard")
    @Severity(SeverityLevel.NORMAL)
    @Description("Check Dashboard elements test")
    @Feature("Dashboard elements check")
    @Story("Check")
    @Epic("Dashboard")
    @Issue("TC-004")
    @Test
    @Order(4)
    public void checkDashboardElements(){

        Log.info("Check dashboard elements");

        DashboardPage dashboardPage = new DashboardPage();
        dashboardPage.dashboardMenuButton.click();

        Assertions.assertEquals("Assign Leave", dashboardPage.assignLeaveQuickLaunch.getText());
        Assertions.assertEquals("Leave List", dashboardPage.leaveListQuickLaunch.getText());
        Assertions.assertEquals("Timesheets", dashboardPage.timeSheetsQuickLaunch.getText());
        Assertions.assertEquals("Apply Leave", dashboardPage.applyLeaveQuickLaunch.getText());
        Assertions.assertEquals("My Leave", dashboardPage.myLeaveQuickLaunch.getText());
        Assertions.assertEquals("My Timesheet", dashboardPage.myTimeSheetLaunch.getText());

    }

    @Step("Add Job Title from Job Title List")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Add Job Title test")
    @Feature("Job title adding to Job Title List")
    @Story("Add")
    @Epic("Job Title List")
    @Issue("TC-005")
    @ParameterizedTest
    @Order(5)
    @ValueSource(strings = {"System Administrator", "Business Analyst", "Technical Support Specialist"})
    public void addJobTitleTest(String jobTitle) {

        Log.info("Add Job Title");

        JobTitlePage jobTitlePage = new JobTitlePage();

        jobTitlePage.adminId.click();
        jobTitlePage.menuAdminJobButton.click();
        jobTitlePage.jobTitleListButton.click();

        jobTitlePage.addJobTitleButton.click();
        jobTitlePage.jobTitleField.sendKeys(jobTitle);
        jobTitlePage.saveJobTitleButton.click();

        Log.info("Parameter: " + jobTitle);
        SelenideElement searchJobTitleResult = $(By.xpath("//a[text()='" + jobTitle + "']"));
        Log.info("Result: " + searchJobTitleResult.getText());
        Assertions.assertEquals(jobTitle, searchJobTitleResult.getText());
    }

    @Step("Delete Job Title from Job Title List")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Delete Job Title test")
    @Feature("Job title deletion from Job Title List")
    @Story("Delete")
    @Epic("Job Title List")
    @Issue("TC-006")
    @ParameterizedTest
    @Order(6)
    @ValueSource(strings = {"System Administrator", "Business Analyst", "Technical Support Specialist"})
    public void deleteJobTitleTest(String jobTitle) {

        Log.info("Delete Job Title");

        JobTitlePage jobTitlePage = new JobTitlePage();

        jobTitlePage.adminId.click();
        jobTitlePage.menuAdminJobButton.click();
        jobTitlePage.jobTitleListButton.click();

        Log.info("Parameter: " + jobTitle);

        SelenideElement searchJobTitle = $(By.xpath("//a[text()='" + jobTitle + "']"));
        String href = searchJobTitle.getAttribute("href");
        String id = href.substring(href.indexOf("=") + 1);

        Log.info("Id: " + id);

        SelenideElement jobTitleCheckbox= $(By.id("ohrmList_chkSelectRecord_" + id));

        jobTitleCheckbox.click();
        jobTitlePage.jobTitleDeleteButton.click();
        jobTitlePage.jobTitleConfirmDeleteButton.click();

       searchJobTitle = $(By.xpath("//a[text()='" + jobTitle + "']"));
       Assertions.assertFalse(searchJobTitle.exists());
    }

    @Step("Add a new job category to Job Category List")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Add Job Category test")
    @Feature("New Job Category adding")
    @Story("Add")
    @Epic("Job Category List")
    @Issue("TC-007")
    @ParameterizedTest
    @Order(7)
    @ValueSource(strings = {"Information Technology workers", "Educational professionals",
            "Architecture and construction workers"})
    public void addJobCategory(String jobCategory){

        Log.info("Add a new job category to Job Category List");

        JobCategoryPage jobCategoryPage = new JobCategoryPage();

        jobCategoryPage.adminId.click();
        jobCategoryPage.menuAdminJobButton.click();
        jobCategoryPage.jobCategoriesListButton.click();

        jobCategoryPage.addJobCategoryButton.click();
        jobCategoryPage.jobCategoryField.sendKeys(jobCategory);
        jobCategoryPage.saveJobCategoryButton.click();

        Log.info("Parameter: " + jobCategory);
        SelenideElement searchJobCategoryResult = $(By.xpath("//a[text()='" + jobCategory + "']"));
        Log.info("Result: " + searchJobCategoryResult.getText());
        Assertions.assertEquals(jobCategory, searchJobCategoryResult.getText());
    }

    @Step("Add Education Level to Education Level List")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Add Education Level test")
    @Feature("New Education Level adding")
    @Story("Add")
    @Epic("Education Level List")
    @Issue("TC-008")
    @Test
    @Order(8)
    public void addEducationLevel(){

        Log.info("Add Education Level to Education Level List");

        EducationLevelPage educationLevelPage = new EducationLevelPage();

        educationLevelPage.adminId.click();
        educationLevelPage.menuAdminQualificationsButton.click();
        educationLevelPage.educationLevelListButton.click();
        educationLevelPage.addEducationLevelButton.click();
        educationLevelPage.educationLevelField.sendKeys("Doctoral Degree");
        educationLevelPage.saveEducationLevelButton.click();

        Log.info("Check if Education Level is added to Education Level List");

        String educationLevelResult=educationLevelPage.searchEducationLevelResult.getText();
        Assertions.assertEquals("Doctoral Degree",educationLevelResult);
    }


    @Step("Check elements on PIM profile page")
    @Severity(SeverityLevel.NORMAL)
    @Description("Check PIM profile elements test")
    @Feature("PIM profile check")
    @Story("Check")
    @Epic("PIM profile page")
    @Issue("TC-009")
    @Test
    @Order(9)
    public void checkPIMProfileElements() {

       Log.info("Open Employee Profile");

       CheckPIMElementsPage pimElementsPage = new CheckPIMElementsPage();

       pimElementsPage.pimButton.click();
       pimElementsPage.employeeListButton.click();
       pimElementsPage.employeeNameField.sendKeys("Marianne Campbell");
       pimElementsPage.searchEmployeeButton.click();

       String employeeNameResult = pimElementsPage.openEmployeeProfile.getText();
       Assertions.assertEquals("Marianne", employeeNameResult);

       pimElementsPage.openEmployeeProfile.click();

       Log.info("Check Employee Profile fields");

       pimElementsPage.personalDetailsButton.click();

       Assertions.assertNotNull(pimElementsPage.personalDetailsFirstNameField);
       Assertions.assertNotNull(pimElementsPage.personalDetailsMidNameField);
       Assertions.assertNotNull(pimElementsPage.personalDetailsLastNameField);

       Assertions.assertNotNull(pimElementsPage.personalDetailsIdField);
       Assertions.assertNotNull(pimElementsPage.personalDetailsDrLicNumField);
       Assertions.assertNotNull(pimElementsPage.personalDetailsSSNNumField);
       Assertions.assertNotNull(pimElementsPage.personalDetailsOtherIdField);
       Assertions.assertNotNull(pimElementsPage.personalDetailsLicExpDateField);
       Assertions.assertNotNull(pimElementsPage.personalDetailsSINNumField);

       Assertions.assertNotNull(pimElementsPage.personalDetailsMaleGenderField);
       Assertions.assertNotNull(pimElementsPage.personalDetailsFemaleGenderField);

       Assertions.assertNotNull(pimElementsPage.personalDetailsNickNameField);
       Assertions.assertNotNull(pimElementsPage.personalDetailsMilitaryServiceField);
       Assertions.assertNotNull(pimElementsPage.personalDetailsDateOfBirthField);
       Assertions.assertNotNull(pimElementsPage.personalDetailsSmokeFlagField);
       Assertions.assertNotNull(pimElementsPage.personalDetailsBloodTypeField);

       Log.info("Check Employee Profile fields data");

       Assertions.assertEquals("Marianne", pimElementsPage.personalDetailsFirstNameField.getValue());
       Assertions.assertEquals("Campbell", pimElementsPage.personalDetailsLastNameField.getValue());
       Assertions.assertEquals("0985", pimElementsPage.personalDetailsIdField.getValue());

       }

    @Step("Log out from orangehrmlive.com")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Log out test")
    @Feature("Logging out check")
    @Story("Log out")
    @Epic("User logout")
    @Link("https://opensource-demo.orangehrmlive.com/index.php/auth/login")
    @Issue("TC-010")
    @Test
    @Order(10)
    public void logOutTest() {

        Log.info("Logout from orangehrmlive.com");

        LogOutPage logOut = new LogOutPage();
        logOut.welcomeButton.click();
        logOut.logOutButton.click();

        String currentUrl = WebDriverRunner.getWebDriver().getCurrentUrl();
        Assertions.assertEquals("https://opensource-demo.orangehrmlive.com/index.php/auth/login", currentUrl, "could not sign out");

    }

}

