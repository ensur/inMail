package pandao.ru.components;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CardImageComponent {
    private WebDriver driver = null;
    public CardImageComponent(WebDriver driver){
        this.driver = driver;
    }

    @FindBy(xpath = "//div[contains(@class, 'photo')]")//Основное фото
    private List<WebElement> cardImage;

    @FindBy(xpath = "//div[contains(@class, 'hide')]//div[contains(@class, 'color-sel')]")//Миниатюры в режиме планшета
    private List<WebElement> cardMiniatureTablet;

    @FindBy(xpath = "//div[contains(@class, 'product-right')]//div[contains(@class, 'color-sel')]")//Миниатюры в полноэкранном режиме
    private List<WebElement> cardMiniatureRight;


    public boolean isTabletActive(){//Активен ли планшетный режим
        if (cardMiniatureTablet.get(0).isDisplayed()){
            return true;
        }
        else {
            return false;
        }
    }

    public boolean checkImage(){//проверка основного изображения
        return cardImage.get(0).isDisplayed();
    }

    public boolean checkImageSwitch(){//проверка связи миниатюр и основного изображения
        if (isTabletActive()) {
            cardMiniatureTablet.get(2).click();
            return cardImage.get(2).isDisplayed();
        }
        else {
            cardMiniatureRight.get(2).click();
            return cardImage.get(2).isDisplayed();
        }
    }
}
