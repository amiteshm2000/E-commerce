package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.CartPage;
import pageObjects.SearchPage;
import testBase.BaseClass;

public class VerifyCartIsEmpty extends BaseClass{
		
		@Test(groups="regression")
		public void verifyCartIsEmpty() {
		logger.info("*********Going to Cart**********");
		CartPage cart= new CartPage(driver);
		cart.goToCart();
		Assert.assertEquals("Missing Cart items?", cart.isCartEmpty());
		logger.info("*********Cart is Empty**********");
		
	}
		
}
