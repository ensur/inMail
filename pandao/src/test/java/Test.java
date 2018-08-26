import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import pandao.ru.components.CardImageComponent;
import pandao.ru.components.CardOptionsComponent;
import pandao.ru.driver.DriverProvider;
import pandao.ru.pages.CardPage;
import pandao.ru.pages.CartPage;

import static org.junit.Assert.assertTrue;

public class Test {
    private DriverProvider driverProvider = null;
    @Before
    public void initDriver(){
        driverProvider = new DriverProvider();
    }
    @After
    public void closeDriver(){
        driverProvider.closeDriver();
    }
    @org.junit.Test
    public void test1(){
        Wait<WebDriver> wait = new WebDriverWait(driverProvider.getDriver(), 5, 1000);
        CardPage cardPage = PageFactory.initElements(driverProvider.getDriver(), CardPage.class);
        cardPage.open();
        CardImageComponent cardImage = PageFactory.initElements(driverProvider.getDriver(), CardImageComponent.class);

        assertTrue("Image error", cardImage.checkImage());//проверка наличия картинки

        assertTrue("Switch error", cardImage.checkImageSwitch());//проверка смены картинки

        CardOptionsComponent cardOpt = PageFactory.initElements(driverProvider.getDriver(), CardOptionsComponent.class);

        assertTrue("No title", cardOpt.checkTitle());//Проверка наименования товара

        String cardName = cardOpt.getCardUrl();

        cardOpt.clickBuyButton();
        CartPage cart = PageFactory.initElements(driverProvider.getDriver(), CartPage.class);

        assertTrue("Incorrect URL", cart.getCartUrl().equals("https://pandao.ru/cart"));//Проверка УРЛА

        assertTrue("incorrect product", cart.getCartProduct().equals(cardName));//проверка наличия товара в корзине
    }




}
