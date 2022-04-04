package co.com.client.webproject.test.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactUsPage {

    @FindBy(xpath = "/html/body/div/div[1]/header/div[2]/div/div/nav/div[3]/a")
    @CacheLookup
    WebElement contactUsButton;

    @FindBy(xpath = "/html/body/div/div[1]/header/div[2]/div/div/nav/div[2]/a")
    @CacheLookup
    WebElement contactUsSecondButton;

    @FindBy(xpath = "/html/body/div/div[2]/div/div[3]/div/form/fieldset/div[1]/div[1]/div[1]/div")
    @CacheLookup
    WebElement chooseList;

    @FindBy(xpath = "/html/body/div/div[2]/div/div[3]/div/form/fieldset/div[1]/div[1]/div[1]/div/select/option[2]")
    @CacheLookup
    WebElement customerService;

    @FindBy(xpath = "/html/body/div/div[2]/div/div[3]/div/form/fieldset/div[2]/button/span")
    @CacheLookup
    WebElement sendButton;

    @FindBy(xpath = "/html/body/div/div[2]/div/div[3]/div/form/fieldset/div[1]/div[2]/div/textarea")
    @CacheLookup
    WebElement textArea;

    @FindBy(xpath = "/html/body/div/div[2]/div/div[3]/div/p")
    @CacheLookup
    WebElement successText;

    @FindBy(xpath = "/html/body/div/div[2]/div/div[3]/div/div/ol/li")
    @CacheLookup
    WebElement errorText;

    public WebElement getContactUsButton() {
        return contactUsButton;
    }

    public WebElement getchooseList(){return chooseList;}

    public WebElement getcustomerService(){return customerService;}

    public WebElement gettextArea(){return textArea;}

    public WebElement getsendButton(){return sendButton;}

    public WebElement getSuccessText(){return successText;}

    public WebElement getErrorText(){return errorText;}

    public WebElement getContactUsSecondButton(){return contactUsSecondButton;}

    public ContactUsPage(WebDriver driver) {
        PageFactory.initElements(driver,this);
    }
}
