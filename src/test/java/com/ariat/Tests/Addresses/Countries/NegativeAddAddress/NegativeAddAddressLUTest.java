package com.ariat.Tests.Addresses.Countries.NegativeAddAddress;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.ariat.Enums.EUCountries;
import com.ariat.Enums.Environments;
import com.ariat.Pages.HomePagesCountries.HomePage;
import com.ariat.Pages.HomePagesCountries.HomePageLU;
import com.ariat.Pages.HomePagesCountries.HomePageUK;
import com.ariat.Pages.Main.AddAddressesPage;
import com.ariat.Pages.Main.AddressesPage;
import com.ariat.Pages.Main.MyAccountPage;
import com.ariat.Tests.Base.BaseTest;
import com.ariat.Pages.Header.SignInPage;
import com.ariat.Utils.GenerateRandomDataUtils;


/**
 * Adds negative address and checks the address was created for Luxembourg
 * 
 * @author aila.bogasieru@ariat.com
 *
 */

public class NegativeAddAddressLUTest extends BaseTest {

	private HomePage homePage;
	private HomePageUK homePageUK;
	private HomePageLU homePageLU;
	private SignInPage signInPage;
	private MyAccountPage myAccountPage;
	private AddAddressesPage addAddressPage;
	private AddressesPage addressesPage;
	private EUCountries euCountry;
	private Environments environment;

	public static final String ADDRESS = GenerateRandomDataUtils.generateRandomNumber(5);
	public static final String CITY = GenerateRandomDataUtils.generateRandomNumber(5);
	
	public static final String POST_CODE = GenerateRandomDataUtils.generateRandomString(5);
	public static final String PHONE = GenerateRandomDataUtils.generateRandomString(7);
	public static final String ADDRESS_ID = GenerateRandomDataUtils.generateRandomNumber(5);
	private static final String EMAIL = "aila.bogasieru@ariat.com";
	private static final String PASSWORD = "Parola12345!";
	
	public static final String ADDRESSWILD = GenerateRandomDataUtils.generateRandomNumber(5);
	public static final String CITYWILD = GenerateRandomDataUtils.generateRandomNumber(5);
	
	public static final String POST_CODEWILD = GenerateRandomDataUtils.generateRandomString(5);
	public static final String PHONEWILD = GenerateRandomDataUtils.generateRandomString(7);
	public static final String ADDRESS_IDWILD = GenerateRandomDataUtils.generateRandomNumber(5);
	public static final String filePath= "\\Users\\Aila\\eclipse-workspace\\ariat-regression\\src\\test\\resources\\chromedriver\\chromedriver.exe";
	
	@BeforeTest
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", filePath);
	}

	@Test(priority=0)
	public void negativeAddAddressLUTest() {
		logger.info("Starting add negative address LU test");
		homePage = new HomePage(new ChromeDriver());
		homePage.load(environment.DEVELOPMENT.getURL());
		homePageUK = (HomePageUK) homePage.chooseEULocation(euCountry.UK, euCountry.UK.getCurrencyISO());
		homePageLU = (HomePageLU) homePage.chooseEULocation(euCountry.LU, euCountry.LU.getCurrencyISO());
		signInPage = homePageLU.returnSignInPage();
		signInPage.returningCustomer(EMAIL, "EnglishUK");
		signInPage.returningPassword(PASSWORD);
		myAccountPage = signInPage.returnMyAccountPage();
		addAddressPage = myAccountPage.returnAddAddressesPageMiddleNav();
		addAddressPage.enterFName("444");
		addAddressPage.enterLName("B4444");
		addAddressPage.enterAddress1(ADDRESS);
		addAddressPage.enterCity(CITY);
		addAddressPage.selectCountry("Luxembourg");
		addAddressPage.enterPostCode(POST_CODE);
		addAddressPage.enterPhone(PHONE);
		addAddressPage.enterAddressId(ADDRESS_ID);
		addressesPage = addAddressPage.returnAddressesPage();
		logger.info("Finishing add negative address LU test");
	}
	
	@Test(priority=1)
	public void negativeAddAddressLUTestWildcards() {
		logger.info("Starting add negative address LU test");
		homePage = new HomePage(new ChromeDriver());
		homePage.load(environment.DEVELOPMENT.getURL());
		homePageUK = (HomePageUK) homePage.chooseEULocation(euCountry.UK, euCountry.UK.getCurrencyISO());
		homePageLU = (HomePageLU) homePage.chooseEULocation(euCountry.LU, euCountry.LU.getCurrencyISO());
		signInPage = homePageLU.returnSignInPage();
		signInPage.returningCustomer(EMAIL, "EnglishUK");
		signInPage.returningPassword(PASSWORD);
		myAccountPage = signInPage.returnMyAccountPage();
		addAddressPage = myAccountPage.returnAddAddressesPageMiddleNav();
		addAddressPage.enterFName("444");
		addAddressPage.enterLName("B4444");
		addAddressPage.enterAddress1(ADDRESSWILD);
		addAddressPage.enterCity(CITYWILD);
		addAddressPage.selectCountry("Luxembourg");
		addAddressPage.enterPostCode(POST_CODEWILD);
		addAddressPage.enterPhone(PHONEWILD);
		addAddressPage.enterAddressId(ADDRESS_IDWILD);
		addressesPage = addAddressPage.returnAddressesPage();
		logger.info("Finishing add negative address LU test");
	}
	
	@Test(priority=2)
	public void negativeAddAddressLUTestMissingValues() {
		logger.info("Starting add negative address LU test");
		homePage = new HomePage(new ChromeDriver());
		homePage.load(environment.DEVELOPMENT.getURL());
		homePageUK = (HomePageUK) homePage.chooseEULocation(euCountry.UK, euCountry.UK.getCurrencyISO());
		homePageLU = (HomePageLU) homePage.chooseEULocation(euCountry.LU, euCountry.LU.getCurrencyISO());
		signInPage = homePageLU.returnSignInPage();
		signInPage.returningCustomer(EMAIL, "EnglishUK");
		signInPage.returningPassword(PASSWORD);
		myAccountPage = signInPage.returnMyAccountPage();
		addAddressPage = myAccountPage.returnAddAddressesPageMiddleNav();
		addAddressPage.enterAddress1(ADDRESS);
		addAddressPage.enterCity(CITY);
		addAddressPage.selectCountry("Luxembourg");
     	addressesPage = addAddressPage.returnAddressesPage();
		logger.info("Finishing add negative address LU test");
	}
	
	@AfterTest
	public void tearDown() {
		homePage.quit();
		homePageUK.quit();
		homePageLU.quit();
		signInPage.quit();
		addAddressPage.quit();
		addressesPage.quit();
	}
}