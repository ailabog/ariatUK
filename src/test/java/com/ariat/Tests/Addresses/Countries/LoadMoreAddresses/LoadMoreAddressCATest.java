package com.ariat.Tests.Addresses.Countries.LoadMoreAddresses;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.ariat.Enums.Environments;
import com.ariat.Enums.GlobalCountries;
import com.ariat.Pages.HomePagesCountries.HomePage;
import com.ariat.Pages.HomePagesCountries.HomePageCA;
import com.ariat.Pages.Main.AddressesPage;
import com.ariat.Pages.Main.LogoutPage;
import com.ariat.Pages.Main.MyAccountPage;
import com.ariat.Tests.Base.BaseTest;
import com.ariat.Pages.Header.SignInPage;
import com.ariat.Utils.GenerateRandomDataUtils;


/**
 * Load addresses test Canada
 * 
 * @author aila.bogasieru@ariat.com
 *
 */

public class LoadMoreAddressCATest extends BaseTest {

	private HomePage homePage;
	private HomePageCA homePageCA;
	private SignInPage signInPage;
	private MyAccountPage myAccountPage;
	private AddressesPage addressesPage;
	private LogoutPage logoutPage;
	private Environments environment;
	private GlobalCountries country;

	public static final String ADDRESS = GenerateRandomDataUtils.generateRandomString(5);
	public static final String CITY = GenerateRandomDataUtils.generateRandomString(5);
	public static final String POST_CODE = GenerateRandomDataUtils.generateRandomNumber(5);
	public static final String PHONE = GenerateRandomDataUtils.generateRandomNumber(7);
	public static final String ADDRESS_ID = GenerateRandomDataUtils.generateRandomAlphaNumeric(5);
	private static final String EMAIL = "aila.bogasieru@yahoo.com";
	private static final String PASSWORD = "Parola12345!";
	public static final String filePath= "\\Users\\Aila\\eclipse-workspace\\ariat-regression\\src\\test\\resources\\chromedriver\\chromedriver.exe";
	
	@BeforeTest
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", filePath);
	}

	@Test(priority = 0)
	public void loadMoreAddressesFromEditCATest() {
		logger.info("Starting load more addresses Canada test");
		homePage = new HomePage(new ChromeDriver());
		homePage.load(environment.DEVELOPMENT.getURL());
		homePageCA = (HomePageCA) homePage.chooseGlobalLocation(country.CA, country.CA.getCurrencyISO());
		signInPage = homePageCA.returnSignInPage();
		signInPage.returningCustomer(EMAIL, "EnglishUS");
		signInPage.returningPassword(PASSWORD);
		myAccountPage = signInPage.returnMyAccountPage();
		addressesPage = myAccountPage.returnAddressesPageMiddleNav();
		addressesPage.loadMoreAddesses();
		logger.info("Finishing load more addresses Canada test");
	}
	
	@Test(priority = 1)
	public void loadMoreAddressesLeftNavigationCATest() {
		logger.info("Starting load more addresses left navigation Canada test");
		homePage = new HomePage(new ChromeDriver());
		homePage.load(environment.DEVELOPMENT.getURL());
		homePageCA = (HomePageCA) homePage.chooseGlobalLocation(country.CA, country.CA.getCurrencyISO());
		signInPage = homePageCA.returnSignInPage();
		signInPage.returningCustomer(EMAIL, "EnglishUS");
		signInPage.returningPassword(PASSWORD);
		myAccountPage = signInPage.returnMyAccountPage();
		addressesPage = myAccountPage.returnAddressesPageLeftNav();
		addressesPage.loadMoreAddesses();
		logger.info("Finishing load more addresses lef navigation Canada test");
	}
	
	@AfterTest
	public void tearDown() {
		homePage.quit();
		homePageCA.quit();
		signInPage.quit();
		myAccountPage.quit();
		addressesPage.quit();
	}
}