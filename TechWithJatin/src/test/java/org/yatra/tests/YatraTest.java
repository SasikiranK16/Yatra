package org.yatra.tests;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import org.yatra.bases.YatraBase;

public class YatraTest extends YatraBase {
	@BeforeSuite
	public void launch() {
		getProperties();
		System.out.println(getProperties().getProperty("url"));
		System.out.println(getProperties().getProperty("browser"));
		optBrowser(getProperties().getProperty("browser"),getProperties().getProperty("url"));
		commonDrivers(driver);
		yatraAdvertisement.closeAdd();
	}
	@Test
	public void testOne() throws Exception {
		yatraHomePage.clickCalander();
		yatraHomePage.clickSpecificDepatureDate("20");
		yatraHomePage.checkFlightPrices();
	}
	@Test
	public void testTwo() throws Exception {
		yatraHomePage.clickCalander();
		driver.findElement(By.xpath("(//*[starts-with(@aria-label,'MAHA SHIVARATHIRI')])[37]")).click();
		yatraHomePage.clickSearch();
		yatraHomePage.checkFlightPrices();
	}
}
