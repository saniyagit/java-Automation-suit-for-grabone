package pagesPackage;

import java.awt.AWTException;
import java.awt.HeadlessException;
import java.io.IOException;

import utilityPackage.BrowserFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.aventstack.extentreports.Status;

import testPackage.BaseClass;
import utilityPackage.ConfigReader;
import utilityPackage.CustomWait;
import utilityPackage.ExcelDataConfig;
import utilityPackage.ScreenShot;

public class MyAccount extends BaseClass
{
	public MyAccount()
	{
		PageFactory.initElements(BrowserFactory.driver, this); 
	}
	@FindBy(how=How.XPATH,using=".//*[@id='banner-account-links']/ul/li[2]/div/button")
	static WebElement User;
	@FindBy(how=How.XPATH,using=".//*[@id='user-nav-account']/li[4]/a")
	static WebElement  MyAcc;
	@FindBy(how=How.XPATH,using=".//*[@id='my-account']/div[1]/fieldset/form[1]/div[1]/div[1]/a[1]")
	static WebElement NameCh;
	@FindBy(how=How.XPATH,using=".//*[@id='account_first_name']")
	static WebElement Firstname;
	@FindBy(how=How.XPATH,using=".//*[@id='account_last_name']")
	static WebElement Lastname;
	@FindBy(how=How.XPATH,using=".//*[@id='my-account']/div[1]/fieldset/form[1]/div[1]/div[2]/div[3]/span/input")
	static WebElement Submitname;
	@FindBy(how=How.XPATH,using=".//*[@id='my-account']/div[1]/fieldset/form[2]/div/div[1]/a[1]")
	static WebElement ChangeRegion;
	@FindBy(how=How.XPATH,using=".//*[@id='region_default_area_id']")
	static WebElement Region;
	@FindBy(how=How.XPATH,using=".//*[@id='my-account']/div[1]/fieldset/form[2]/div/div[2]/div[2]/span/input")
	static WebElement SubmitRegion;
	
	public void VerifyAccount() throws HeadlessException, AWTException, IOException
	{
		 User.click();
         MyAcc.click();
         NameCh.click();
        // ExcelDataConfig excel=new ExcelDataConfig(ConfigReader.getExcelPath());
         Firstname.clear();
         CustomWait.wait(".//*[@id='account_first_name']", 5, 1);
         Firstname.sendKeys("saniya");
         Lastname.clear();
         Lastname.sendKeys("domini");
         Submitname.click();
         ChangeRegion.click();
         Select reg = new Select(Region);
         String regionval = "Taranaki";
         reg.selectByVisibleText(regionval);
         SubmitRegion.click();
         ValidateMyAcct();
	}
	public void ValidateMyAcct()throws HeadlessException, AWTException, IOException
	{
		try
		{
		String msg = "your region has been updated";
	    String Actualmsg = BrowserFactory.driver.findElement(By.xpath(".//*[@id='content']/div[1]/p")).getText();

	    if (msg == Actualmsg)
	    
		{
			testLog.log(Status.PASS, "My Account has been updated successfully");
		}
		else
		{
			//Capture screenshot of the fail page
			ScreenShot.captureScreenshot(BrowserFactory.driver, "Failed myaccount page");
			//Get the failure log
			testLog.log(Status.FAIL, "My Account is not updated successfully");
			//Set an assertion of failure
			Assert.fail("Failed to update myaccount page");
		}		
		}
		catch (Exception e)
	    {
			//Capture screenshot of the fail page
				ScreenShot.captureScreenshot(BrowserFactory.driver, "Failed to update myprofile page");
				//Get the failure log
				testLog.log(Status.FAIL, "My profile is not updated successfully");
				//Set an assertion of failure
				Assert.fail("Failed to update myprofile page");
		}
	}
}

