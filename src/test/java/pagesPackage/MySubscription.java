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
import org.testng.Assert;

import com.aventstack.extentreports.Status;

import testPackage.BaseClass;
import utilityPackage.ScreenShot;

public class MySubscription extends BaseClass
{

public  MySubscription()
{
PageFactory.initElements(BrowserFactory.driver, this);
}

@FindBy(how=How.XPATH,using="//*[@id=\"banner-account-links\"]/ul/li[2]/div/button/svg[2]")
static WebElement User;
@FindBy(how=How.XPATH,using="//*[@id=\"user-nav-account\"]/li[4]/a")
static WebElement MySub;
@FindBy(how=How.XPATH,using=".//*[@id='site_subscription_manager_subscriptions_site_subscription_9']")
static WebElement Exper;
@FindBy(how=How.XPATH,using=".//*[@id='site_subscription_manager_subscriptions_site_subscription_15']")
static WebElement Bottle;
@FindBy(how=How.XPATH,using=".//*[@id='site_subscription_manager_subscriptions_site_subscription_174']")
static WebElement  Booknow;
@FindBy(how=How.XPATH,using=".//*[@id='site_subscription_manager_specials_specials']")
static WebElement Promotion;
@FindBy(how=How.XPATH,using=".//*[@id='change-subscriptions-submit']")
static WebElement Save ;

public void Verifysubscription() throws HeadlessException, AWTException, IOException

{
	User.click();
	MySub.click();
	Exper.click();
	Bottle.click();
	Booknow.click();
	Promotion.click();
	Save.click();
    ValidateMysub();
}
public void ValidateMysub()throws HeadlessException, AWTException, IOException
{
	try
	{
	String msg = "your changes have been made";
    String Actualmsg = BrowserFactory.driver.findElement(By.xpath(".//*[@id='site_subscription_manager_specials_specials']")).getText();

    if (msg == Actualmsg)
    
	{
		testLog.log(Status.PASS, "My Subscrition page is  updated successfully");
	}
	else
	{
		//Capture screenshot of the fail page
		ScreenShot.captureScreenshot(BrowserFactory.driver, "Failed home page");
		//Get the failure log
		testLog.log(Status.FAIL, "My Subscrition page is not updated successfully");
		//Set an assertion of failure
		Assert.fail("Failed to launch GrabOne home page");
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
