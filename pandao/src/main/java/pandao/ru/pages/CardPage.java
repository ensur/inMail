package pandao.ru.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CardPage {
    private WebDriver driver = null;
    public CardPage(WebDriver driver){
        this.driver = driver;
    }
    public void open(){
        driver.get(System.getProperty("url"));
    }
}
