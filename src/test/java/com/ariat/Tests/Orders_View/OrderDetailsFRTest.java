package com.ariat.Tests.Orders_View;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.ariat.Enums.EUCountries;
import com.ariat.Enums.Environments;
import com.ariat.Pages.Header.SignInPage;
import com.ariat.Pages.HomePagesCountries.HomePage;
import com.ariat.Pages.HomePagesCountries.HomePageFR;
import com.ariat.Pages.HomePagesCountries.HomePageUK;
import com.ariat.Pages.Main.MyOrdersPage;
import com.ariat.Pages.Main.OrderDetailsPage;
import com.ariat.Tests.Base.BaseTest;

import io.github.bonigarcia.wdm.ChromeDriverManager;

/**
 * Test Order details from different type of navigation and checks values from
 * order
 * 
 * @author aila.bogasieru@ariat.com
 *
 */

public class OrderDetailsFRTest extends BaseTest {

	private Environments environment;
	private HomePage homePage;
	private SignInPage signInPage;
	private OrderDetailsPage orderDetailsPage;
	private com.ariat.Pages.Main.MyAccountPage myAccountPage;
	private MyOrdersPage myOrdersPage;
	private HomePageUK homePageUK;
	private HomePageFR homePageFR;
	private EUCountries euCountry;

	public static final String EMAIL = "aila.bogasieru@ariat.com";
	public static final String PASSWORD = "Parola12345!";
    public static final String filePath= "\\Users\\Aila\\eclipse-workspace\\ariat-regression\\src\\test\\resources\\chromedriver\\chromedriver.exe";
	
	@BeforeTest
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", filePath);
	}

	@Test(priority = 0)
	public void ordersChecksViewAllOrdersTest() {
		logger.info("Starting order details checks - View all orders test");
		homePage = new HomePage(new ChromeDriver());
		homePage.load(environment.DEVELOPMENT.getURL());
		homePageUK = (HomePageUK) homePage.chooseEULocation(euCountry.UK, euCountry.UK.getCurrencyISO());
		homePageFR = (HomePageFR) homePage.chooseEULocation(euCountry.FR, euCountry.FR.getCurrencyISO());
		signInPage = homePageFR.returnSignInPage();
		signInPage.returningCustomer(EMAIL, "Francais");
		signInPage.returningPassword(PASSWORD);
		myAccountPage = signInPage.returnMyAccountPage();
		myAccountPage.returnMyOrdersPageViewAllMiddleNavFR();
		orderDetailsPage = myAccountPage.returnOrderDetailsMyOrdersPageMiddleNav();
		orderDetailsPage.returnMyOrdersBackFromOrderDetailsPage();
		logger.info("Finishing order details checks - View all orders test...");
	}

	@Test(priority = 1)
	public void orderChecksMyAccountMiddleNavTest() {
		logger.info("Starting order details checks - My account view test");
		homePage = new HomePage(new ChromeDriver());
		homePage.load(environment.DEVELOPMENT.getURL());
		homePageUK = (HomePageUK) homePage.chooseEULocation(euCountry.UK, euCountry.UK.getCurrencyISO());
		homePageFR = (HomePageFR) homePage.chooseEULocation(euCountry.FR, euCountry.FR.getCurrencyISO());
		signInPage = homePageFR.returnSignInPage();
		signInPage.returningCustomer(EMAIL, "Francais");
		signInPage.returningPassword(PASSWORD);
		myAccountPage = signInPage.returnMyAccountPage();
		orderDetailsPage = myAccountPage.returnOrderDetailsMyAccountPageMiddleNav();
		orderDetailsPage.returnMyOrdersBackFromOrderDetailsPage();
		logger.info("Finishing order details checks - My account view test...");
	}

	@Test(priority = 2)
	public void orderChecksMyAccountTopNavTest() {
		logger.info("Starting orders check information orders test");
		homePage = new HomePage(new ChromeDriver());
		homePage.load(environment.DEVELOPMENT.getURL());
		homePageUK = (HomePageUK) homePage.chooseEULocation(euCountry.UK, euCountry.UK.getCurrencyISO());
		homePageFR = (HomePageFR) homePage.chooseEULocation(euCountry.FR, euCountry.FR.getCurrencyISO());
		signInPage = homePageFR.returnSignInPage();
		signInPage.returningCustomer(EMAIL, "Francais");
		signInPage.returningPassword(PASSWORD);
		myAccountPage = signInPage.returnMyAccountPage();
		myOrdersPage = myAccountPage.returnMyOrdersPageTopNavFR();
		logger.info("Finishing orders check information orders test.");
	}
}
