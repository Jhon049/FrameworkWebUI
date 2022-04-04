package co.com.client.webproject.test.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShoppingPage {

    @FindBy(xpath = "/html/body/div/div[2]/div/div[3]/div/p[2]/a[1]/span")
    @CacheLookup
    WebElement proceed2;

    @FindBy(xpath = "/html/body/div/div[2]/div/div[3]/div/form/p/button/span")
    @CacheLookup
    WebElement proceed3;

    @FindBy(xpath = "/html/body/div/div[2]/div/div[3]/div/div/form/div/p[2]/div/span/input")
    @CacheLookup
    WebElement checkbox;

    @FindBy(xpath = "/html/body/div/div[2]/div/div[3]/div/div/form/p/button/span")
    @CacheLookup
    WebElement proceed4;

    @FindBy(xpath = "/html/body/div/div[2]/div/div[3]/div/div/div[3]/div[1]/div/p/a/span")
    @CacheLookup
    WebElement payButton;

    @FindBy(xpath = "/html/body/div/div[2]/div/div[3]/div/form/p/button/span")
    @CacheLookup
    WebElement confirmButton;

    @FindBy(xpath = "/html/body/div/div[2]/div/div[3]/div/div/p/strong")
    @CacheLookup
    WebElement textSuccess;

    @FindBy(xpath = "/html/body/div/div[2]/div/div[3]/div/div[2]/table/tbody/tr/td[5]/div/a[1]")
    @CacheLookup
    WebElement deleteButton;

    @FindBy(xpath = "//p[@class='alert alert-warning']")
    @CacheLookup
    WebElement emptyMessage;

    public WebElement getproceed2() {return proceed2;}

    public WebElement getproceed3() {return proceed3;}

    public WebElement getcheckbox() {return checkbox;}

    public WebElement getproceed4() {return proceed4;}

    public WebElement getpayButton() {return payButton;}

    public WebElement getconfirmButton() {return confirmButton;}

    public WebElement gettextSuccess(){return textSuccess;}

    public WebElement getdeleteButton(){return deleteButton;}

    public WebElement getemptyMessage(){return emptyMessage;}

    public ShoppingPage(WebDriver driver) {
        PageFactory.initElements(driver,this);
    }
}
