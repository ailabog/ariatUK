package com.ariat.Tests.Product.WomenCategory.WriteReview;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.ariat.Enums.EUCountries;
import com.ariat.Enums.Environments;
import com.ariat.Pages.Categories.WomenCategories.WomenCategoryPage;
import com.ariat.Pages.Categories.WomenCategories.WomenAccessories.WomenAccessoriesSubcategories.GlovesProductPage;
import com.ariat.Pages.Categories.WomenCategories.WomenAccessories.WomenAccessoriesSubcategories.WomenAccessoriesGlovesPage;
import com.ariat.Pages.Categories.WomenCategories.WomenSubcategories.BreechProductPage;
import com.ariat.Pages.Categories.WomenCategories.WomenSubcategories.WomenAccessoriesPage;
import com.ariat.Pages.Categories.WomenCategories.WomenSubcategories.WomenClothingPage;
import com.ariat.Pages.HomePagesCountries.HomePage;
import com.ariat.Pages.HomePagesCountries.HomePageIE;
import com.ariat.Pages.HomePagesCountries.HomePageUK;
import com.ariat.Tests.Base.BaseTest;

import io.github.bonigarcia.wdm.ChromeDriverManager;

/**
 * Product page - > Women Category test write review on Glove product
 * 
 * @author aila.bogasieru@ariat.com
 *
 */

public class ProductWriteReviewWomenCategoryIETest extends BaseTest {

	private Environments environment;
	private HomePage homePage;
	private HomePageUK homePageUK;
	private HomePageIE homePageIE;
	private WomenAccessoriesGlovesPage womenAccessoriesGlovesPage;
	private GlovesProductPage gloveProductPage;
	private WomenAccessoriesPage womenAccessoriesPage;
	private WomenCategoryPage womenCategoryPage;
	private WomenClothingPage womenClothingPage;
	private BreechProductPage breechProductPage;
	private EUCountries euCountry;
	
	private static final String titleReview = "This is my review";
	private static final String contentReview = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nam a porttitor nisl, id rhoncus massa. Nunc imperdiet luctus porta. Sed consequat eros quis pellentesque pulvinar. Nulla facilisi. Vestibulum at dui ac elit laoreet suscipit. Suspendisse erat turpis, aliquet id mauris vitae, viverra iaculis massa. Proin ullamcorper enim quis orci tempor consectetur quis vel augue. Aliquam rutrum nibh arcu, at vestibulum urna blandit at. Quisque at dapibus erat. Donec id sapien eu massa interdum laoreet a non libero. Nunc finibus, odio quis laoreet pretium, velit ante imperdiet nisl, id volutpat elit nisl sit amet mi. Aenean aliquet, elit tincidunt ullamcorper suscipit, nisi felis malesuada eros, in vehicula ipsum urna ac felis.";

	@BeforeTest
	public void setUp() {
		ChromeDriverManager.getInstance().setup();
	}

	@Test
	public void productPageWomenCategoryWriteReviewYesRecommendTest() {
		logger.info("Starting product page -> Women Category write review recommend product for Glove product test...");
		homePage = new HomePage(new ChromeDriver());
		homePage.load(environment.DEVELOPMENT.getURL());
		homePageUK = (HomePageUK) homePage.chooseEULocation(euCountry.UK, euCountry.UK.getCurrencyISO());
		homePageIE = (HomePageIE) homePage.chooseEULocation(euCountry.IE, euCountry.IE.getCurrencyISO());
		womenAccessoriesPage = homePageIE.returnAccessoriesCategoryPage();
		womenAccessoriesGlovesPage = womenAccessoriesPage.returnWomenAccessoriesGlovesCategoryleftNavPage();
		gloveProductPage = womenAccessoriesGlovesPage.returnGlovesProductPagePage();
		gloveProductPage.writeReviewClick();
		gloveProductPage.writeReviewContent(titleReview, contentReview);
		gloveProductPage.writeReviewStar("Excellent");
		gloveProductPage.recommendProductYes();
		gloveProductPage.userInfoReview("aila", "London", "aila.bogasieru@gmail.com");
		gloveProductPage.postReview();
		logger.info("Finishing product page -> Women Category write review recommend product for Glove product test.");
	}

@Test
	public void productPageWomenCategoryWriteReviewNoRecommendTest() {
		logger.info("Starting product page -> Women Category write review don't recommend product for Breech product test...");
		homePage = new HomePage(new ChromeDriver());
		homePage.load(environment.DEVELOPMENT.getURL());
		homePageUK = (HomePageUK) homePage.chooseEULocation(euCountry.UK, euCountry.UK.getCurrencyISO());
		homePageIE = (HomePageIE) homePage.chooseEULocation(euCountry.IE, euCountry.IE.getCurrencyISO());
		womenCategoryPage = homePageIE.returnWomenCategoryPage();
		womenClothingPage = womenCategoryPage.returnWomenClothingCategoryLeftNavPage();
		breechProductPage = womenClothingPage.returnBreechProductPage();
		breechProductPage.writeReviewClick();
		breechProductPage.writeReviewContent(titleReview, contentReview);
		breechProductPage.writeReviewStar("Poor");
		//breechProductPage.recommendProductNo();
		breechProductPage.userInfoReview("aila", "London", "aila.bogasieru.gmail.com");
		breechProductPage.postReview();
		logger.info("Finishing product page -> Women Category don't recommend product for Breech product test.");
	}

	@AfterTest
	public void tearDown() {
		homePage.quit();
		homePageUK.quit();
		homePageIE.quit();
		womenAccessoriesPage.quit();
		womenAccessoriesGlovesPage.quit();
		gloveProductPage.quit();
		breechProductPage.quit();
	}
}