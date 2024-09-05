package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {

	WebDriver driver;
	public CartPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//a[@title='Cart']")
	WebElement goToCart;
	
	@FindBy(xpath="//div[text()='Your cart is empty!' or text()='Missing Cart items?']")
	WebElement isCartEmpty;
	
	public void goToCart() {
		goToCart.click();
	}
	
	public String isCartEmpty() {
		return isCartEmpty.getText();
	}
}
