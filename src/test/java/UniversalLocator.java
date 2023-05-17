import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class UniversalLocator {

    public void androidButtonClick(String name){
        $(By.xpath("//android.widget.Button[@content-desc= \""+ name + "\"]"))
                .should(Condition.visible)
                .click();
    }
}
