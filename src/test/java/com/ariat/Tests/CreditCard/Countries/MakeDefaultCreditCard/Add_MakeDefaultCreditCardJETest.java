package com.ariat.Tests.CreditCard.Countries.MakeDefaultCreditCard;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.ariat.Enums.Environments;
import com.ariat.Enums.GlobalCountries;
import com.ariat.Enums.ListOfCreditCards;
import com.ariat.Pages.HomePagesCountries.HomePage;
import com.ariat.Pages.HomePagesCountries.HomePageJE;
import com.ariat.Pages.Main.AddACreditCardPage;
import com.ariat.Pages.Main.MyAccountPage;
import com.ariat.Pages.Main.PaymentInformationPage;
import com.ariat.Tests.Base.BaseTest;
import com.ariat.Pages.Header.SignInPage;

import io.github.bonigarcia.wdm.ChromeDriverManager;

/**
 * Tests for add & make default credit card Jersey
 * @author aila.bogasieru@ariat.com
 *
 */


public class Add_MakeDefaultCreditCardJETest extends BaseTest{
	
	private HomePage homePage;
	private HomePageJE homePageJE;
	private SignInPage signInPage;
	private MyAccountPage myAccountPage;
	private AddACreditCardPage addACreditCardPage;
	private PaymentInformationPage paymentInfoPage;
	private Environments environment;
	private GlobalCountries country;
	private ListOfCreditCards typeCard;
	
	private static final String EMAIL = "aila.bogasieru@yahoo.com";
	private static final String PASSWORD = "Parola12345!";
	private static final String CARD_ID = "XX";
	private static final String defaultCredit = "DEFAULT | ";
	private static final String CARD_OWNER = "Aila B";
	private static final String YEAR = "2023";
	private static final String MONTH = "December";
	
	@BeforeTest
	public void setUp() {
		ChromeDriverManager.getInstance().setup();
	}

	@Test
	public void add_makeDefaultCreditCardJETest() {
		String expirationDate = "MONTH/YEAR";
		logger.info("Starting add credit card & make it default Jersey test");
		homePage = new HomePage(new ChromeDriver());
		homePage.load(environment.DEVELOPMENT.getURL());
		homePageJE = (HomePageJE) homePage.chooseGlobalLocation(country.JE, country.JE.getCurrencyISO());
		signInPage = homePageJE.returnSignInPage();
		signInPage.returningCustomer(EMAIL, "EnglishUS");
		signInPage.returningPassword(PASSWORD);
		myAccountPage = signInPage.returnMyAccountPage();
		addACreditCardPage = myAccountPage.returnAddACreditCardMiddleNav();
		addACreditCardPage.enterCardId(CARD_ID);
		addACreditCardPage.enterCardOwner(CARD_OWNER);
		addACreditCardPage.selectTypeCard(typeCard.MASTER_CARDSpace.getName());
		addACreditCardPage.enterCardNo(typeCard.MASTER_CARDSpace.getNumber());
		addACreditCardPage.enterSecurityCode(typeCard.MASTER_CARDSpace.getCvs());
		addACreditCardPage.selectExpirationYearCard(YEAR);
		addACreditCardPage.selectExpirationMonthCard(MONTH);
		paymentInfoPage = addACreditCardPage.returnPaymentInformationPage();
		paymentInfoPage.makeDefaultCreditCard(CARD_OWNER, typeCard.MASTER_CARDSpace.getName(), expirationDate);
		//paymentInfoPage.assertMakeDefaultCreditCard(defaultCredit.concat(CARD_ID));
		logger.info("Finishing add credit card & make it default Jersey test");
  } 
	
	@AfterTest
	public void tearDown() {
		homePage.quit();
		homePageJE.quit();
		signInPage.quit();
		addACreditCardPage.quit();
		paymentInfoPage.quit();
		myAccountPage.quit();
		
	}
}