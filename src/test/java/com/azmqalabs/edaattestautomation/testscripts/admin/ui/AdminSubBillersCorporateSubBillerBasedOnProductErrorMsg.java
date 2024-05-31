/**
*
* Test Script Name                   : AdminSubBillersCorporateSubBillerBasedOnProductErrorMsg 
* Test data sheet Name               : AdminSubBillerBasedOnProduct
* Objective                          : 1.Verify Add SubBiller Based on the Product Error Message of Select Product dropdown under subbiller Module.
                                       2.Verify Add SubBiller Based on the Product Error Messages of Fixed Value and Percentage Text filed under subbiller Module.
                                       3.Verify Add SubBiller Based on the Product Error Message of IBAN Number text field under subbiller Module.
                                       4.Verify Add SubBiller Based on the Product Error Message of of Invalid IBAN Number text field under subbiller Module.
                                       5.Verify Add SubBiller Based on the Product Error Message of Beneficiary Name text field under subbiller Module.
                                       6.Verify Add SubBiller Based on the Product Error Message of Attach IBAN Image under subbiller Module.
* Version                            : 1.0
* Author                             : Kathirvelu Mohan
* Created Date                       : 
* Last Updated on                    : N/A
* Updated By                         : Kalpana I R
* Pre-Conditions                     : 1)Admin login credentials.
* Epic Details                       : N/A
* User Story Details                 : N/A
* 
**/

package com.azmqalabs.edaattestautomation.testscripts.admin.ui;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Factory;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.azmqalabs.edaattestautomation.apppages.collectionofpages.Pages;
import com.azmqalabs.edaattestautomation.common.DBUtil;
import com.azmqalabs.edaattestautomation.common.ExtentManager;
import com.azmqalabs.edaattestautomation.common.InitializeDriver;
import com.azmqalabs.edaattestautomation.common.Log;
import com.azmqalabs.edaattestautomation.common.ReadData;
import com.azmqalabs.edaattestautomation.common.webDriverEventListener;
import com.azmqalabs.edaattestautomation.objectrepository.EdaatOR;
import com.codoid.products.fillo.Recordset;

// TEST LISTENER
@Listeners(com.azmqalabs.edaattestautomation.common.TestListener.class)
public class AdminSubBillersCorporateSubBillerBasedOnProductErrorMsg {

	// DECLARATION SECTION
	static String TestDataTab="AdminSubBillerBasedOnProduct";  

	private WebDriver driver;
	private InitializeDriver initializeDriver;
	private EventFiringWebDriver driverEvent;
	private webDriverEventListener eventListener;

	Map<Object, Object> testdatamap;
	Map<Object, Object> testresultsmap;
	private String TestScriptID="";
	static Recordset recTestData;
	static ArrayList<String> arrListTestDataColumnNames;
	String sBrowserTestData="";
	String browserFromXML="";
	ExtentReports extent;
	ExtentTest test;
	Pages Pages;
	Log Log;
	DBUtil DBUtil;

	// FACTORY - DATA PROVIDER
	@Factory (dataProvider="TestDataProvider")
	public AdminSubBillersCorporateSubBillerBasedOnProductErrorMsg(Map<Object, Object> testdatamap){
		this.testdatamap=testdatamap;
		this.TestScriptID=testdatamap.get("TestScriptID").toString();
		this.sBrowserTestData=testdatamap.get("Browser").toString();
	}
	@Override
	public String toString(){
		return String.format("%S", TestScriptID);
	}


	// DATA PROVIDER - FOR TEST DATA
	@DataProvider
	public static Object[][] TestDataProvider() throws Exception {
		Map<String, String> TestDataColNames;
		ReadData.retrieveLoginEnvDetails();
		arrListTestDataColumnNames=ReadData.readDataTableColumns(TestDataTab);
		TestDataColNames=ReadData.mapTestDataTableColumns(arrListTestDataColumnNames);
		recTestData=ReadData.readTestData(TestDataTab);
		int lastRowOfTestData=recTestData.getCount();
		Object[][] testdataobj = new Object[lastRowOfTestData][1];
		testdataobj=ReadData.mapTestData(TestDataColNames,recTestData);
		return testdataobj;
	}

	// TEST METHOD
	//	    @Parameters({ "username", "password" })
	@Test
	public void myTest() throws InterruptedException, Exception{
		try{
			testresultsmap=testdatamap;
			testresultsmap.put("BrowserName", browserFromXML);
			testresultsmap.put("TestScriptID", TestScriptID);
			testresultsmap.put("TestDataName", TestDataTab);
			System.out.println(testdatamap.get(TestScriptID));
			

			Log.ReportEvent("INFO", "Step1 : Verify Biller Application Launched Suceessfully");
			Pages.InvokeApplicationPage.launchApplication();	        
			Pages.InvokeApplicationPage.Chooseoptions(Log);	

			Log.ReportEvent("INFO", "Step2 : Verify Biller Login is Suceessful");
			Pages.AdminLoginPage.LoginToApplication(testdatamap,Log);

			Log.ReportEvent("INFO", "Step3 : Verify Error Messages is successfull");
			Pages.AdminSubbillerPage.AddproductError(testdatamap);

			Log.ReportEvent("INFO", "Step4 : Logout  Suceessful");
			Pages.AdminLoginPage.Logout(EdaatOR.Logout,Log);

			Log.PostTestStatus(TestScriptID);
			DBUtil.UpdateTestResultInDB(testresultsmap);
			driver.quit();
		}
		catch (Exception e)
		{
			Log.takeScreenShot();
			Log.PostTestStatus(TestScriptID);
			Log.ReportEvent("INFO", "TEST EXECUTION INCOMPLETE"+e);
			DBUtil.UpdateTestResultExceptionInDB(testresultsmap);
			Log.ReportEvent("FATAL", "<< !!!!!!!!!!!!!!!!!!!!! TEST INCOMPLETE !!!!!!!!!!!!!!!!!!!!! >>"+e);
			System.out.println("<< FATAL - !!!!!!!!!!!!!!!!!!!!! TEST INCOMPLETE !!!!!!!!!!!!!!!!!!!!! >>"+e);
			driver.quit();
			throw new NullPointerException("********FATAL EXCEPTION TRIGGERED********");
		}
	}

	// BEFORE CLASS METHOD - BROWSER INITIALIZATION
	@BeforeClass
	public void beforeClass() throws Exception {
		browserFromXML=sBrowserTestData;		        
		// EXTENT REPORT
		extent=ExtentManager.CreateExtentReportExtent();
		String className=this.getClass().getSimpleName();
        test=ExtentManager.CreateExtentReportTest(extent,className,testdatamap.get("TestDescription").toString(), browserFromXML,TestScriptID);
		// INITIALIZE DRIVER
		initializeDriver=new InitializeDriver();
		driver=initializeDriver.initDriver(browserFromXML);
		driverEvent = new EventFiringWebDriver(driver);
		eventListener = new webDriverEventListener(test);
		driverEvent.register(eventListener);
		this.sBrowserTestData=browserFromXML;
		this.driver=driverEvent;
		// INITIALIZE PAGE FACTORY OBJECT
		Pages=new Pages(driver,test);
		Log=new Log(driver,test);
		DBUtil=new DBUtil(driver,test);
		// LOG TEST MACHINE/USER DETAILS
		Log.QAMachineInfo();
	}
	// AFTER CLASS
	@AfterClass
	public void afterClass() {
		extent.flush();
	}

	// AFTER TEST - NEED TO USE FOR LOGIN/LOGOUT HANDLING PURPOSE
	@AfterTest
	public void afterTest() {
		System.out.println("After test");
	}



}
