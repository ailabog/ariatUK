package com.ariat.Tests.Product.NegativeWriteReview;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.ariat.Enums.EUCountries;
import com.ariat.Enums.Environments;
import com.ariat.Pages.Categories.WomenCategories.WomenAccessories.WomenAccessoriesSubcategories.WomenAccessoriesBagsPage;
import com.ariat.Pages.Categories.WomenCategories.WomenSubcategories.WomenAccessoriesPage;
import com.ariat.Pages.HomePagesCountries.HomePage;
import com.ariat.Pages.HomePagesCountries.HomePageDK;
import com.ariat.Pages.HomePagesCountries.HomePageUK;
import com.ariat.Pages.Products.BagsProductPage;
import com.ariat.Tests.Base.BaseTest;
import com.ariat.Utils.GenerateRandomDataUtils;

/**
 * Product page - > Women Category test negative write review on Glove product
 * 
 * @author aila.bogasieru@ariat.com
 *
 */

public class NegativeProductWriteReviewWomenCategoryDKTest extends BaseTest {

	private Environments environment;
	private HomePage homePage;
	private HomePageUK homePageUK;
	private HomePageDK homePageDK;
	private BagsProductPage bagsProductPage;
	private WomenAccessoriesBagsPage womenAccessoriesBagsPage;
	private WomenAccessoriesPage womenAccessoriesPage;
	private EUCountries euCountry;
	
    
    private static final String TITLE_REVIEW =  GenerateRandomDataUtils.generateRandomNumber(10);
	private static final String CONTENT_REVIEW = GenerateRandomDataUtils.generateRandomNumber(50);
    private static final String USER = GenerateRandomDataUtils.generateRandomNumber(5);
    private static final String EMAIL = "aila.bogasieru@gmail.com";
    private static final String CITY = "London";
    public static final String filePath= "\\Users\\Aila\\eclipse-workspace\\ariat-regression\\src\\test\\resources\\chromedriver\\chromedriver.exe";
	
	@BeforeTest
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", filePath);
	}

	@Test
	public void productPageWomenCategoryWriteReviewYesRecommendTest() {
		logger.info("Starting product page -> Women Category write negative review product for Glove product test...");
		homePage = new HomePage(new ChromeDriver());
		homePage.load(environment.DEVELOPMENT.getURL());
		homePageUK = (HomePageUK) homePage.chooseEULocation(euCountry.UK, euCountry.UK.getCurrencyISO());
		homePageDK = (HomePageDK) homePage.chooseEULocation(euCountry.DK, euCountry.DK.getCurrencyISO());
		womenAccessoriesPage = homePageDK.returnAccessoriesCategoryPage();
		womenAccessoriesBagsPage = womenAccessoriesPage.returnWomenAccessoriesBagsCategoryPage();
		bagsProductPage = womenAccessoriesBagsPage.returnBagsProductPage();
		bagsProductPage.writeReviewClick();
		bagsProductPage.userInfoReview(USER, CITY, EMAIL);
		bagsProductPage.postReview();
		logger.info("Finishing product page -> Women Category write negative review recommend product for Glove product test.");
	}


	@AfterTest
	public void tearDown() {
		homePage.quit();
		homePageUK.quit();
		homePageDK.quit();
		womenAccessoriesPage.quit();
		womenAccessoriesBagsPage.quit();
		bagsProductPage.quit();
	}
}
