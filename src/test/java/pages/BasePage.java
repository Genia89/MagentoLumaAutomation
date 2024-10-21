package pages;

import org.openqa.selenium.support.PageFactory;
import utilities.DriverUtils;

public class BasePage {
    public BasePage(){
        PageFactory.initElements(DriverUtils.getDriver(), this);}

        public void logIn(String string){
            String url = "https://" + System.getenv("username") + ":" + System.getenv("password") +
                "@magento.softwaretestingboard.com";
            DriverUtils.getDriver().get(url);
        }
    }

