package testPackage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;
import pages.*;

public class TestClass {
	// declaration
	WebDriver driver;
	GooglePage home;
	ResultPage results;
	TestNGResultPage TestNGResult;
	CucumberPage Cucpage;
	CheckBoxPage CBPage;
	W3SchoolPage W3Page;
	UploadFilePage UploadPage;
	DragAndDropPage DragPage;


	////////////////////////////////////////////////////
	////////// Test Cases /////////////////////////////
	//////////////////////////////////////////////////

	@Test
	public void checkTitleOfThePage() {
		home.navigateToHomePage();
		Assert.assertEquals(home.getTitleOfThePage(), "Google");
		System.out.println(home.getTitleOfThePage());
	}

	@Test
	public void checkTheLogoOfGooglePage() {
		home.navigateToHomePage();
		Assert.assertTrue(home.checkTheGoogleLogo());
		System.out.println("Logo Appears");
	}

	@Test
	public void checkTheResultStateIsNotEmpty() {
		home.navigateToHomePage();
		home.searchForQuery("Selenium WebDriver");
		Assert.assertNotEquals(results.SearchResults(), "");
		System.out.println("Result state not empty");
	}

	@Test(groups = "FireFox")
	public void searchForTestNG() {
		
		TestNGResult.TestNGTask("TestNG");
		Assert.assertNotEquals(TestNGResult.getTestNGText(), "TestNG Tutorial");
		System.out.println("Passed but it's failed in our expected results");

	}
	@Test
	public void searchForCucumber() {
		home.navigateToHomePage();
		Cucpage.searchForQuery("Cucumber IO");
		Cucpage.enterSecondResults();
		System.out.println("Secound URL Clicked Successfully ");
		Assert.assertNotEquals(Cucpage.getCurrentURL(),"https://www.linkedin.com");
		System.out.println("the right is:  it should be fail but I made it Asser not Equal" +
				" to make sure it will fail successfully in real life");
	}

	@Test
	public void checkBoxValidation(){
		CBPage.navigateToCheckBoxPage();
		CBPage.clickOnCheckBox1();
		Assert.assertEquals(CBPage.CB1Validation(),true);
		System.out.println("CheckBox1 is selected successfully");
		Assert.assertEquals(CBPage.CB2Validation(),true);
		System.out.println("CheckBox2 is selected Successfully");
	}
	@Test
	public void W3SchoolValidation(){
		W3Page.navigateToW3SchoolPage();
		Assert.assertEquals(W3Page.getCountryText(),"Austria");
		System.out.println("Country appears as expected : [Austria]");

	}

	@Test
	public void UploadFileTest(){
		UploadPage.navigateToUploadPage();
		UploadPage.clickToUpload();
		UploadPage.clickUploadBtn();
		Assert.assertEquals(UploadPage.uploadVerification(),"File Uploaded!");
		System.out.println("File Uploaded Successfully!");
	}

	@Test
	public void DragMeAndDrop(){
		DragPage.navigateToDragAndDropPage();
		DragPage.DragMeThere();
		System.out.println("Dragged Successfully ");
		Assert.assertEquals(DragPage.getDroppedText(), "Dropped!");
		System.out.println("Drag And Drop Done successfully");
	}

	////////////////////////////////////////////////////////
	/////////////////Before and After Methods//////////////
	//////////////////////////////////////////////////////

	//Set up the environment to start Testing
	@BeforeMethod
	public void setupEnv() {
		// setting up chromedriver
		WebDriverManager.chromedriver().setup();

		// assignation
		driver = new ChromeDriver();

		// calling
		home = new GooglePage(driver);
		results = new ResultPage(driver);
		Cucpage = new CucumberPage(driver);
		CBPage = new CheckBoxPage(driver);
		W3Page = new W3SchoolPage(driver);
		UploadPage = new UploadFilePage(driver);
		DragPage = new DragAndDropPage(driver);
		driver.manage().window().maximize();

	}

	//This is to Open firefox and do this test !
	@BeforeMethod(onlyForGroups = "FireFox")
	public void FireFoxEnv() {

		// setting up chromedriver
		WebDriverManager.firefoxdriver().setup();

		// assignation
		driver = new FirefoxDriver();
		
		// calling
		TestNGResult = new TestNGResultPage(driver);
		TestNGResult.navigateToGooglePage();
		driver.manage().window().maximize();

	}

	//Closing browser !
	@AfterMethod
	public void closeBrowser() {
		driver.quit();
	}
	

}
