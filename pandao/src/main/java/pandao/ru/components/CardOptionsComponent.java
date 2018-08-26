package pandao.ru.components;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CardOptionsComponent {
    private WebDriver driver = null;
    public CardOptionsComponent(WebDriver driver){
        this.driver = driver;
    }
    @FindBy(xpath = "//h1[contains(@class, 'product-title')]")
    WebElement title;

    @FindBy(xpath = "//input[@value= 'Купить сейчас']")
    WebElement buyButton;

    public boolean checkTitle(){//проверка наличия заголовка
        return !title.getText().isEmpty();
    }

    public String getCardUrl(){//урл карточки
        return driver.getCurrentUrl();
    }

    public void clickBuyButton(){
        buyButton.click();
    }



}
