package com.ariat.Tests.Addresses.Countries.DeleteAddress;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.ariat.Enums.EUCountries;
import com.ariat.Enums.Environments;
import com.ariat.Pages.HomePagesCountries.HomePage;
import com.ariat.Pages.HomePagesCountries.HomePageUK;
import com.ariat.Pages.Main.AddAddressesPage;
import com.ariat.Pages.Main.AddressesPage;
import com.ariat.Pages.Main.MyAccountPage;
import com.ariat.Tests.Base.BaseTest;
import com.ariat.Pages.Header.SignInPage;
import com.ariat.Utils.GenerateRandomDataUtils;
import com.ariat.Utils.KillChrome;


/**
 * Delete address test United Kingdom
 * 
 * @author aila.bogasieru@ariat.com
 *
 */

public class DeleteAddressUKTest extends BaseTest {

	private HomePage homePage;
	private HomePageUK homePageUK;
	private SignInPage signInPage;
	private MyAccountPage myAccountPage;
	private AddAddressesPage addAddressPage;
	private AddressesPage addressesPage;
	private Environments environment;
	private EUCountries euCountry;

	public static final String ADDRESS = GenerateRandomDataUtils.generateRandomString(5);
	public static final String CITY = GenerateRandomDataUtils.generateRandomString(5);
	public static final String POST_CODE = GenerateRandomDataUtils.generateRandomNumber(5);
	public static final String PHONE = GenerateRandomDataUtils.generateRandomNumber(7);
	public static final String ADDRESS_ID = GenerateRandomDataUtils.generateRandomAlphaNumeric(5);
	private static final String EMAIL = "aila.bogasieru@ariat.com";
	private static final String PASSWORD = "Parola12345!";
	public static final String RELATIV_PATH = "/src/test/resources/chromedriver/chromedriver.exe";
    public static final String ABSOLUTE_PATH = System.getProperty("user.dir")+ RELATIV_PATH;
			
	@BeforeTest
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", ABSOLUTE_PATH);
	}
	
	@Test(priority=0)
	public void addAddressUKTest() {
		logger.info("Starting add address UK test");
		homePage = new HomePage(new ChromeDriver());
		homePage.load(environment.DEVELOPMENT.getURL());
		homePageUK = (HomePageUK) homePage.chooseEULocation(euCountry.UK, euCountry.UK.getCurrencyISO());
		signInPage = homePageUK.returnSignInPage();
		signInPage.returningCustomer(EMAIL, "EnglishUK");
		signInPage.returningPassword(PASSWORD);
		myAccountPage = signInPage.returnMyAccountPage();
		addAddressPage = myAccountPage.returnAddAddressesPageMiddleNav();
		addAddressPage.enterFName("A");
		addAddressPage.enterLName("B");
		addAddressPage.enterAddress1("Oxford Street");
		addAddressPage.enterCity(CITY);
		addAddressPage.selectCountry("United Kingdom");
		addAddressPage.enterPostCode(POST_CODE);
		addAddressPage.enterPhone(PHONE);
		addAddressPage.enterAddressId(ADDRESS_ID);
		addressesPage = addAddressPage.returnAddressesPageWithoutScroll();
		addressesPage.checkAddress(ADDRESS_ID);
		logger.info("Finishing add address UK test");
	}
	
	@Test(priority=1)
	public void deleteAddressTestUK() {
		logger.info("Starting deleting address UK test");
		homePage = new HomePage(new ChromeDriver());
		homePage.load(environment.DEVELOPMENT.getURL());
		homePageUK = (HomePageUK) homePage.chooseEULocation(euCountry.UK, euCountry.UK.getCurrencyISO());
		signInPage = homePageUK.returnSignInPage();
		signInPage.returningCustomer(EMAIL, "EnglishUK");
		signInPage.returningPassword(PASSWORD);
		myAccountPage = signInPage.returnMyAccountPage();
		addressesPage = myAccountPage.returnAddressesPageMiddleNav();
		addressesPage.deleteAddressCreatedNo(ADDRESS_ID);
		addressesPage.deleteAddressCreatedYes(ADDRESS_ID);
		logger.info("Finishing deleting address UK test");
	}
	
	@Test(priority=2)
	public void addAddressUKTestAfterDeletionUK() {
			logger.info("Starting add address UK test");
			homePage = new HomePage(new ChromeDriver());
			homePage.load(environment.DEVELOPMENT.getURL());
			homePageUK = (HomePageUK) homePage.chooseEULocation(euCountry.UK, euCountry.UK.getCurrencyISO());
			signInPage = homePageUK.returnSignInPage();
			signInPage.returningCustomer(EMAIL, "EnglishUK");
			signInPage.returningPassword(PASSWORD);
			myAccountPage = signInPage.returnMyAccountPage();
			addAddressPage = myAccountPage.returnAddAddressesPageMiddleNav();
			addAddressPage.enterFName("A");
			addAddressPage.enterLName("B");
			addAddressPage.enterAddress1("Oxford Street");
			addAddressPage.enterCity(CITY);
			addAddressPage.selectCountry("United Kingdom");
			addAddressPage.enterPostCode(POST_CODE);
			addAddressPage.enterPhone(PHONE);
			addAddressPage.enterAddressId(ADDRESS_ID);
			addressesPage = addAddressPage.returnAddressesPageWithoutScroll();
			addressesPage.checkAddress(ADDRESS_ID);
			logger.info("Finishing add address UK test");
		}
	

	@AfterTest
	public void clearBrowserSession() {
		homePage.quit();
		homePageUK.quit();
		signInPage.quit();
		myAccountPage.quit();
		addressesPage.quit();
		KillChrome kill = new KillChrome();
		kill.killChrome();
    }
}