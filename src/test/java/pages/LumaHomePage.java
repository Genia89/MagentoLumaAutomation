package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class LumaHomePage extends BasePage{
    private static final Logger log = LoggerFactory.getLogger(LumaHomePage.class);

    @FindBy(xpath = "(//a[contains(text(),'Sign In')])[1]")
    public WebElement logIn;

    @FindBy(xpath = "(//a[text()='Create an Account'])[1]")
    public WebElement createAccount;

    @FindBy(xpath = "//*[@id='ui-id-3']")
    public WebElement whatsNew;

    @FindBy(xpath = "//*[@id='ui-id-4']")
    public WebElement womenDropdown;

    @FindBy(xpath = "//*[@id='ui-id-5']")
    public WebElement menDropdown;

    @FindBy(xpath = "//*[@id='ui-id-6']")
    public WebElement gearDropdown;

    @FindBy(xpath = "//*[@id='ui-id-7']")
    public WebElement trainingDropdown;

    @FindBy(xpath = "//*[@id='ui-id-8']")
    public WebElement sale;



    public void clickSignIn() {
        logIn.click();
    }

    public void clickCreateAccount() {
        createAccount.click();
    }

    public void clickWhatsNew() {
        log.info("Clicking on 'What's New' link");
        whatsNew.click();
    }

    public void clickWomenDropdown() {
        womenDropdown.click();
    }

    public void clickMenDropdown() {
        menDropdown.click();
    }

    public void clickGearDropdown() {
        gearDropdown.click();
    }

    public void clickTrainingDropdown() {
        trainingDropdown.click();
    }

    public void clickSale() {
        sale.click();
    }


}
