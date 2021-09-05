import org.openqa.selenium.By;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class LoginPage {

    SelenideElement loginField = $(By.id("txtUsername"));
    SelenideElement passwordField = $(By.id("txtPassword"));
    SelenideElement signInButton = $(By.name("Submit"));

    void login() throws IOException {

        InputStream input = new FileInputStream("src/main/resources/user.properties");
        Properties prop = new Properties();
        prop.load(input);
        loginField.sendKeys(prop.getProperty("user.username"));
        passwordField.sendKeys(prop.getProperty("user.password"));
        signInButton.click();

    }
    public void openLoginPage(){
        open("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
    }
}

