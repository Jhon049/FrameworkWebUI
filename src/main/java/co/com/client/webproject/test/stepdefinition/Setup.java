package co.com.client.webproject.test.stepdefinition;

import co.com.client.webproject.test.data.objects.TestInfo;
import co.com.sofka.test.automationtools.selenium.Browser;
import org.openqa.selenium.chrome.ChromeOptions;

public class Setup {
    protected TestInfo testInfo;

    public Browser browser(){
        Browser browserConfiguration = new Browser();
        browserConfiguration.setBrowser(Browser.Browsers.CHROME);
        browserConfiguration.setIncognito(true);
        browserConfiguration.setAutoDriverDownload(true);
        //browserConfiguration.setDriverVersion("95.0.4638.54");
        browserConfiguration.setChromeOptions(chomeOptions());

        return browserConfiguration;
    }

    private ChromeOptions chomeOptions(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        return options;
    }
}
