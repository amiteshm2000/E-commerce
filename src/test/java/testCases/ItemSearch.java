package testCases;

import org.testng.annotations.Test;

import Utilities.DataProviders;
import pageObjects.SearchPage;
import testBase.BaseClass;

public class ItemSearch extends BaseClass{

	@Test(priority=0, dataProvider="SearchData", dataProviderClass=DataProviders.class)
	public void search(String item, String count) {
		logger.info("*********Searching for Mobiles**********");
		System.out.println("888888888888888888888888888888876543333333333333333");
		SearchPage search = new SearchPage(driver);
		search.typeSearchBox(item);
		search.search();
	}
	
	@Test(priority=1, groups="regression")
	public void setFilter() {
		SearchPage search = new SearchPage(driver);
		search.setFilter();
	}
}
