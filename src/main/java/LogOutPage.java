import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class LogOutPage {
    SelenideElement welcomeButton = $(By.id("welcome"));
    SelenideElement logOutButton = $("a[href='/index.php/auth/logout']");
}
