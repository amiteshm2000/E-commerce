package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class SearchPage {

	WebDriver driver;
	public SearchPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//input[@placeholder='Search for Products, Brands and More']")
	WebElement searchBox;
	

	@FindBy(xpath="//button[@type='submit']")
	WebElement search;
	
	@FindBy(xpath="//div[@class='tKgS7w']/select[@class='Gn+jFg']")
	WebElement setFilter;
	
	public void typeSearchBox(String item) {
		searchBox.sendKeys(item);
	}
	
	public void search() {
		search.click();
	}
	
	public void setFilter() {
		Select drop = new Select(setFilter);
		drop.selectByValue("30000");
	}
}
