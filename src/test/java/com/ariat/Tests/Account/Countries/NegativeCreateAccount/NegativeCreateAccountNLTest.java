package com.ariat.Tests.Account.Countries.NegativeCreateAccount;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.ariat.Enums.EUCountries;
import com.ariat.Enums.Environments;
import com.ariat.Pages.HomePagesCountries.HomePage;
import com.ariat.Pages.HomePagesCountries.HomePageNL;
import com.ariat.Pages.HomePagesCountries.HomePageUK;
import com.ariat.Pages.Main.CreateAccountPage;
import com.ariat.Pages.Main.MyAccountPage;
import com.ariat.Tests.Base.BaseTest;
import com.ariat.Pages.Header.SignInPage;
import com.ariat.Utils.GenerateRandomDataUtils;
import io.github.bonigarcia.wdm.ChromeDriverManager;

/**
 * Test negative create account by instantiating the browser, go to Home page,
 * and calls all the methods such as: create account, login, check order status
 * for Netherlands
 * 
 * @author aila.bogasieru@ariat.com
 *
 */

public class NegativeCreateAccountNLTest extends BaseTest {

	private Environments environment;
	private EUCountries euCountry;
	private CreateAccountPage createAccountPage;
	private HomePage homePage;
	private HomePageUK homePageUK;
	private HomePageNL homePageNL;
	private SignInPage signInPage;
	private MyAccountPage myAccountPage;
	private String loggingMessage = "The email address is invalid.";
	private String missingLoggingValue = "The email address is required.";

	public static final String FIRST_NAME = GenerateRandomDataUtils.generateRandomNumber(5);
	public static final String LAST_NAME = GenerateRandomDataUtils.generateRandomNumber(7);
	public static final String BIRTH_MONTH = "March";
	public static final String BIRTH_DAY = "02";

	public static final String EMAIL = GenerateRandomDataUtils.generateRandomNumber(12);
	public static final String PASSWORD = GenerateRandomDataUtils.generateRandomString(10);

	public static final String FIRST_NAME1 = "@#$%^&*()";
	public static final String LAST_NAME1 = "@#$%^&*()";
	public static final String EMAIL1 = "@#$%^&*()";

	@BeforeTest
	public void setUp() {
		ChromeDriverManager.getInstance().setup();
	}

	@Test(priority = 0)
	public void negativeCreateAccountTest() {
		logger.info("Starting create negative account test");
		homePage = new HomePage(new ChromeDriver());
		homePage.load(environment.DEVELOPMENT.getURL());
		homePageUK = (HomePageUK) homePage.chooseEULocation(euCountry.UK, euCountry.UK.getCurrencyISO());
		homePageNL = (HomePageNL) homePage.chooseEULocation(euCountry.NL, euCountry.NL.getCurrencyISO());
		signInPage = homePageNL.returnSignInPage();
		createAccountPage = signInPage.returnCreateAccountPage();
		createAccountPage.firstName(FIRST_NAME);
		createAccountPage.lastNameInfo(LAST_NAME);
		createAccountPage.selectBirthMonth(BIRTH_MONTH);
		createAccountPage.selectBirthDay(BIRTH_DAY);
		createAccountPage.GenderFemale();
		createAccountPage.enterEmail(EMAIL);
		createAccountPage.confirmEmail(EMAIL);
		createAccountPage.enterPassword(PASSWORD);
		createAccountPage.confirmPassword(PASSWORD);
		createAccountPage.addMeToAriatEmail();
		createAccountPage.createAccountClick();
		createAccountPage.assertWrongNameCreateAccount(loggingMessage);
		logger.info("Finishing negative create account test...");
	}

	@Test(priority = 1)
	public void negativeCreateAccountTestWildcards() {
		logger.info("Starting create negative account test");
		homePage = new HomePage(new ChromeDriver());
		homePage.load(environment.DEVELOPMENT.getURL());
		homePageUK = (HomePageUK) homePage.chooseEULocation(euCountry.UK, euCountry.UK.getCurrencyISO());
		homePageNL = (HomePageNL) homePage.chooseEULocation(euCountry.NL, euCountry.NL.getCurrencyISO());
		signInPage = homePageNL.returnSignInPage();
		createAccountPage = signInPage.returnCreateAccountPage();
		createAccountPage.firstName(FIRST_NAME1);
		createAccountPage.lastNameInfo(LAST_NAME1);
		createAccountPage.selectBirthMonth(BIRTH_MONTH);
		createAccountPage.selectBirthDay(BIRTH_DAY);
		createAccountPage.GenderFemale();
		createAccountPage.enterEmail(EMAIL1);
		createAccountPage.confirmEmail(EMAIL1);
		createAccountPage.enterPassword(PASSWORD);
		createAccountPage.confirmPassword(PASSWORD);
		createAccountPage.addMeToAriatEmail();
		createAccountPage.createAccountClick();
		createAccountPage.assertWrongNameCreateAccount(loggingMessage);
		logger.info("Finishing negative create account test...");
	}

	@Test(priority = 2)
	public void negativeCreateAccountTestMissingValues() {
		logger.info("Starting create negative account test");
		homePage = new HomePage(new ChromeDriver());
		homePage.load(environment.DEVELOPMENT.getURL());
		homePageUK = (HomePageUK) homePage.chooseEULocation(euCountry.UK, euCountry.UK.getCurrencyISO());
		homePageNL = (HomePageNL) homePage.chooseEULocation(euCountry.NL, euCountry.NL.getCurrencyISO());
		signInPage = homePageNL.returnSignInPage();
		createAccountPage = signInPage.returnCreateAccountPage();
		createAccountPage.firstName(FIRST_NAME);
		createAccountPage.lastNameInfo(LAST_NAME);
		myAccountPage = createAccountPage.returnMyAccountPage();
		createAccountPage.asserCreateAccountMissingValues(missingLoggingValue);
		logger.info("Finishing negative create account test...");
	}

	@AfterTest
	public void tearDown() {
		homePage.quit();
		homePageUK.quit();
		homePageNL.quit();
		signInPage.quit();
		myAccountPage.quit();
		createAccountPage.quit();
	}
}
