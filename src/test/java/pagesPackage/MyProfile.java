package pagesPackage;

import java.awt.AWTException;
import java.awt.HeadlessException;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.aventstack.extentreports.Status;

import testPackage.BaseClass;
import utilityPackage.BrowserFactory;
import utilityPackage.CustomWait;
import utilityPackage.ScreenShot;

public class MyProfile extends BaseClass
{
public MyProfile()
{
	PageFactory.initElements(BrowserFactory.driver, this);
}

@FindBy(how=How.XPATH,using="//*[@id=\"banner-account-links\"]/ul/li[2]/div/button")
static WebElement User;
@FindBy(how=How.XPATH,using="//*[@id=\"user-nav-account\"]/li[3]/a")
static WebElement profilebutt;
@FindBy(how=How.XPATH,using="//*[@id=\"profile_gender\"]")
static WebElement Gender;
@FindBy(how=How.XPATH,using="//*[@id=\"profile_birthday_day\"]")
static WebElement Birth;
@FindBy(how=How.XPATH,using="//*[@id=\"profile_area_id-3\"]")
static WebElement region;
@FindBy(how=How.XPATH,using="//*[@id=\"profile_is_home_owner_1\"]")
static WebElement background;
@FindBy(how=How.XPATH,using="//*[@id=\"profile\"]/form/fieldset/div[17]/span/input")
static WebElement update;

public void Verifyprofile() throws HeadlessException, AWTException, IOException
{
	User.click();
	profilebutt.click();
	Select gen = new Select(Gender);
	String genvalue = "Male";
	gen.selectByVisibleText(genvalue);
	
	Select bir = new Select(Birth);
	String birthvalue = "10";
	bir.selectByVisibleText( birthvalue);
	Select reg = new Select(region);
	String regvalue = "Wellington";
	reg.selectByVisibleText(regvalue);
	background.click();
	update.click();
	Validateprofile();
}
public void Validateprofile() throws HeadlessException, AWTException, IOException
{
	try
	{
	String msg = "your profile was saved";
	CustomWait.wait(".//*[@id='account_first_name']", 5, 1);
    String Actualmsg = BrowserFactory.driver.findElement(By.xpath("//*[@id=\"content\"]/div[1]/p")).getText();

    if (msg == Actualmsg)
    
	{
		testLog.log(Status.PASS, "Myprofile has been updated successfully");
	}
	
	else
	{
		//Capture screenshot of the fail page
		ScreenShot.captureScreenshot(BrowserFactory.driver, "Failed to update myprofile page");
		//Get the failure log
		testLog.log(Status.FAIL, "My profile is not updated successfully");
		//Set an assertion of failure
		Assert.fail("Failed to update myprofile page");
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

