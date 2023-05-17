import androidProvider.AndroidDriverWithEmail;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;
import data.Variables;


import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class EmailTest extends UniversalLocator {
    @BeforeEach
    void setUp() {
        closeWebDriver();
        Configuration.browserSize = null;
        Configuration.browser = AndroidDriverWithEmail.class.getName();
        WebDriverRunner.addListener(new AbstractWebDriverEventListener() {
        });
        open();
    }

    @Test
    void sendTextToEmail() {
        androidButtonClick("Написать");
        $(By.xpath(Variables.whom)).shouldBe(visible).setValue(Variables.email);
        $(By.xpath(Variables.whom)).shouldHave(text(Variables.email));
        $(By.id("com.google.android.gm:id/peoplekit_listview_contact_name")).shouldBe(visible).click();
        $(By.xpath(Variables.topic)).shouldBe(visible).click();
        $(By.xpath(Variables.topic)).shouldBe(visible).setValue("test").shouldHave(text("test"));
        $(By.xpath(Variables.textMessage)).shouldBe(visible).clear();
        androidButtonClick("Отправить");
        sleep(5000);
    }
}

