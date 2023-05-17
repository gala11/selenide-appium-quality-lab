package androidProvider;

import com.codeborne.selenide.WebDriverProvider;

import javax.annotation.Nonnull;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;

import javax.annotation.CheckReturnValue;
import javax.annotation.ParametersAreNonnullByDefault;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

@ParametersAreNonnullByDefault
public class AndroidDriverWithEmail implements WebDriverProvider {
    @Override
    @CheckReturnValue
    @Nonnull
    public WebDriver createDriver(Capabilities capabilities) {
        UiAutomator2Options options = new UiAutomator2Options();
        options.merge(capabilities);
        options.setPlatformVersion("13.0");
        options.setAppActivity("com.google.android.gm.ConversationListActivityGmail");
        options.setAppPackage("com.google.android.gm");
        options.setNewCommandTimeout(Duration.ofSeconds(11));
        options.setFullReset(false);


        try {
            return new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), options);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}
