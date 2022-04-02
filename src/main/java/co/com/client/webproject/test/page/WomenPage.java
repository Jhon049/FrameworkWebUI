package co.com.client.webproject.test.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WomenPage {

    @FindBy(xpath = "/html/body/div/div[1]/header/div[3]/div/div/div[6]/ul/li[1]/a")
    @CacheLookup
    WebElement womenButton;

    @FindBy(xpath = "/html/body/div/div[2]/div/div[3]/div[2]/ul/li[1]/div/div[1]/div/a[1]/img")
    @CacheLookup
    WebElement productImage;

    @FindBy(xpath = "/html/body/div/div[2]/div/div[3]/div[2]/ul/li[1]/div/div[2]/div[2]/a[1]/span")
    @CacheLookup
    WebElement addToCartButton;

    @FindBy(xpath = "/html/body/div/div[1]/header/div[3]/div/div/div[4]/div[1]/div[2]/div[4]/a/span")
    @CacheLookup
    WebElement proceed1;

    public WebElement getwomenButton() {return womenButton;}

    public WebElement getproductImage() {return productImage;}

    public WebElement getaddToCartButton() {return addToCartButton;}

    public WebElement getproceed1() {return proceed1;}

    public WomenPage(WebDriver driver) {
        PageFactory.initElements(driver,this);
    }
}
