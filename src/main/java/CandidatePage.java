import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class CandidatePage {

    SelenideElement recruitmentModule = $(By.id("menu_recruitment_viewRecruitmentModule"));
    SelenideElement viewCandidatesButton = $(By.id("menu_recruitment_viewCandidates"));
    SelenideElement addCandidatesButton = $(By.id("btnAdd"));

    SelenideElement firstNameCandidateField = $(By.id("addCandidate_firstName"));
    SelenideElement lastNameCandidateField = $(By.id("addCandidate_lastName"));
    SelenideElement emailCandidateField = $(By.name("addCandidate[email]"));
    SelenideElement contactNumberCandidateField = $(By.name("addCandidate[contactNo]"));

    SelenideElement candidateVacancySelect = $(By.name("addCandidate[vacancy]"));
    SelenideElement candidateKeyWordsField = $(By.name("addCandidate[keyWords]"));

    SelenideElement candidateAppliedDate = $("input[id='addCandidate_appliedDate']");
    SelenideElement candidateStateDate = $(By.xpath("//a[text()='1']"));
    SelenideElement keepDataButton = $(By.id("addCandidate_consentToKeepData"));
    SelenideElement saveCandidateButton = $(By.id("btnSave"));

}
