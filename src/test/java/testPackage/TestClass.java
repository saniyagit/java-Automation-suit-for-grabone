package testPackage;

import java.awt.AWTException;
import java.awt.HeadlessException;
import java.io.IOException;

import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import pagesPackage.GrabOneHomePage;
import pagesPackage.MyAccount;
import pagesPackage.MyProfile;
import pagesPackage.MySubscription;


public class TestClass extends BaseClass{
	
	/*Both user stories have 6 test cases each for different combinations of Interest rate and duration.
	Please refer to the TestData_AutoCalc.xlsx file to see the test case combination*/
	
	@Test(description = "Test to login", priority=1)
	public void Login() throws HeadlessException, AWTException, IOException
	{
		testLog.log(Status.INFO, "Login test started");
		
		//Launch and validate GrabOne home page
		GrabOneHomePage GO_HomePage=new GrabOneHomePage();
		GO_HomePage.VerifyHomePage();
		
		int ID=1;//Tester can choose which set of data in "Login" sheet in the TestData excel file to test by providing ID
		GO_HomePage.Login(ID);
		
		
	}
	@Test(description = "Test to validate my subscription", priority=2)
	public void subscription() throws HeadlessException, AWTException, IOException
	{
		testLog.log(Status.INFO, "my subscription test started");
		GrabOneHomePage GO_HomePage=new GrabOneHomePage();
		GO_HomePage.VerifyHomePage();
		
		int ID=1;//Tester can choose which set of data in "Login" sheet in the TestData excel file to test by providing ID
		GO_HomePage.Login(ID);
		MySubscription subs = new MySubscription();
		subs.Verifysubscription();
	}
	 
	@Test(description = "Test to validate my Account", priority=3)
	public void Account() throws HeadlessException, AWTException, IOException
	{
		testLog.log(Status.INFO, "my account test started");
		GrabOneHomePage GO_HomePage=new GrabOneHomePage();
		GO_HomePage.VerifyHomePage();
		
		int ID=1;//Tester can choose which set of data in "Login" sheet in the TestData excel file to test by providing ID
		GO_HomePage.Login(ID);
		
		MyAccount acct = new MyAccount();
		acct.VerifyAccount();
	}
	@Test(description = "Test to validate my profile", priority=3)
	public void profile() throws HeadlessException, AWTException, IOException
	{
		testLog.log(Status.INFO, "my profile test started");
		GrabOneHomePage GO_HomePage=new GrabOneHomePage();
		GO_HomePage.VerifyHomePage();
		
		int ID=1;//Tester can choose which set of data in "Login" sheet in the TestData excel file to test by providing ID
		GO_HomePage.Login(ID);
		
		MyProfile prof = new MyProfile();
		prof.Verifyprofile();
	}
}



	
