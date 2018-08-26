package pandao.ru.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage {
    private WebDriver driver = null;
    public CartPage(WebDriver driver){
        this.driver = driver;
    }

    @FindBy(xpath = "//p[@class= 'cart-description']//a")//товар в корзине
    WebElement cartProduct;

    public String getCartUrl(){
        return driver.getCurrentUrl();
    }

    public String getCartProduct(){//урл товара в корзине(для проверки добавления в корзину)
        return cartProduct.getAttribute("href");
    }
}
