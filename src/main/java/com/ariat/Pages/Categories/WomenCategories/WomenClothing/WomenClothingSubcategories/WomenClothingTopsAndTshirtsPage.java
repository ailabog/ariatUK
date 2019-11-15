package com.ariat.Pages.Categories.WomenCategories.WomenClothing.WomenClothingSubcategories;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.ariat.Pages.Main.BasePage;
import com.ariat.Pages.Products.RebarTopProductPage;
import com.ariat.Pages.Products.TriFactorTopProductPage;

import org.openqa.selenium.support.ui.ExpectedConditions;
import com.ariat.Utils.WebDriverUtils;

/**
 * Implements Women Clothing Tops And Tshirts Page
 * 
 * @author aila.bogasieru@ariat.com
 *
 */

public class WomenClothingTopsAndTshirtsPage extends BasePage {

	
	private By rebarTShirt = By.xpath("//img[@alt='Rebar Sunstopper Top']");
	private By rebarTShirtText = By.xpath("//*contains[text(), 'Rebar Sunstopper Top']");
	
	public WomenClothingTopsAndTshirtsPage(WebDriver driver) {
		super(driver);
	}

		
	public RebarTopProductPage returnRebarToptPage() {
		WebDriverUtils.clickOnElementWithWait(driver, rebarTShirt);
		WebDriverUtils.waitUntil(driver, WebDriverUtils.WAIT_40_SECONDS,
				ExpectedConditions.invisibilityOfElementLocated(rebarTShirtText));
		return new RebarTopProductPage(driver);

	}
}
