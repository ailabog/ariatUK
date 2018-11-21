package com.ariat.Tests.CountriesCreditCard.UK;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.ariat.Enums.Environments;
import com.ariat.Enums.ListOfCreditCards;
import com.ariat.Pages.HomePage;
import com.ariat.Pages.LogoutPage;
import com.ariat.Pages.MyAccountPage;
import com.ariat.Pages.PaymentInformationPage;
import com.ariat.Pages.SignInPage;
import com.ariat.Tests.BaseTest;

import io.github.bonigarcia.wdm.ChromeDriverManager;

/**
 * Tests for delete credit card UK
 * @author aila.bogasieru@ariat.com
 *
 */


public class DeleteCreditCardUKTest extends BaseTest{
	
	private HomePage homePage;
	private SignInPage signInPage;
	private MyAccountPage myAccountPage;
	private LogoutPage logoutPage;
	private PaymentInformationPage paymentInfoPage;
	private Environments environment;
	private ListOfCreditCards typeCard;
	
	private static final String EMAIL = "aila.bogasieru@yahoo.com";
	private static final String PASSWORD = "Parola12345!";
	
	
	@BeforeTest
	public void setUp() {
		ChromeDriverManager.getInstance().setup();
	}

	@Test
	public void deleteCreditCardFromPaymentInfoUKTest() {
		logger.info("Starting delete credit card from Payment Info UK test");
		homePage = new HomePage(new ChromeDriver());
		homePage.load(environment.DEVELOPMENT.getURL());
		homePage.UKlocation();
		signInPage = homePage.returnSignInPage();
		signInPage.returningCustomer(EMAIL);
		signInPage.returningPassword(PASSWORD);
		myAccountPage = signInPage.returnMyAccountPage();
		paymentInfoPage = myAccountPage.returnPaymentInformationPageAddDeleteCardMiddleNav();
	    paymentInfoPage.deleteCreditCardNo("name",typeCard.VISA.getName() , "01/2029");
	    paymentInfoPage.deleteCreditCardYes("name", typeCard.VISA.getName(), "01/2029");
		logoutPage = myAccountPage.returnLogoutFromMyAccountPageTopNav();
		logger.info("Finishing delete credit card from Payment info UK test");
		
  }
	@AfterTest
	public void tearDown() {
		homePage.quit();
		signInPage.quit();
		paymentInfoPage.quit();
		myAccountPage.quit();
		logoutPage.quit();
	}
}