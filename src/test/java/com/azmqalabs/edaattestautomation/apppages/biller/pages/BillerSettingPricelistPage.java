/**
*
* Test Script Name                   : N/A.
* Objective                          : Verify price list Functionality.
* Version                            : 1.0
* Author                             : Arun Kumar MS.
* Created Date                       : 11/08/2023
* Last Updated on                    : N/A
* Updated By                         : Arun Kumar MS
* Pre-Conditions                     :
* Manual Testcase Name               : N/A.
* Epic Details                       : N/A
* User Story Details                 : N/A
* Defects affecting this test script : None
* Work Arounds/Known Issues          : None
**/
package com.azmqalabs.edaattestautomation.apppages.biller.pages;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;


import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.azmqalabs.edaattestautomation.apppages.GlobalConstant;
import com.azmqalabs.edaattestautomation.apppages.masterpages.BasePage;
import com.azmqalabs.edaattestautomation.common.Log;
import com.azmqalabs.edaattestautomation.common.uielement.fieldDecorator;
import com.azmqalabs.edaattestautomation.objectrepository.EdaatOR;

public class BillerSettingPricelistPage extends BasePage {
	public BillerSettingPricelistPage(WebDriver driver,ExtentTest test)
	{
		this.driver=driver;
		this.test=test;

		PageFactory.initElements(new fieldDecorator(driver,test), this);
	}  


	@FindBy(xpath = EdaatOR.Biller_PriceListpagetxt)
	public WebElement PriceList;


	public boolean Exists(){
		return super.Exists(PriceList); 
	}
	
	//Function Summary : Navigate to pricelist page 
	//Parameter Summary: N/A
	public void navigatetoPriceListPage() throws Exception {
		try {
		WebClickUsingJS(EdaatOR.Biller_Settings);
		Thread.sleep(2000);
		WebClickUsingJS(EdaatOR.Biller_PriceList);
		waitForPageToLoad();
		this.takeScreenShot();
		test.log(Status.PASS,"#FUNC-Verify Navigate to Pricelist page " + driver.getTitle() +" * Navigate to Pricelist page is Pass * " );
		}
		catch (Exception e) {
			e.printStackTrace();
			this.takeScreenShot();
			test.log(Status.FATAL,"#FUNC-View Navigate to Pricelist page " + driver.getTitle() +" * Navigate to Pricelist page is Fail * " );
		}
		
	}
	
	//Function Summary : Method to search pricelist page 
	//Parameter Summary: N/A
	private void PriceListSearch(Map<Object,Object>testdatamap) {
		try {
		WebEdit(EdaatOR.Biller_PriceListsfield,testdatamap.get("PriceListName").toString());
		Thread.sleep(1000);
		WebClick(EdaatOR.Biller_PriceListSeacrchbtn);
		Thread.sleep(2000);
		this.takeScreenShot();
		test.log(Status.PASS,"#FUNC-Verify Search Pricelist" + driver.getTitle() +" * Search Pricelist is Pass * " );
				}
		catch (Exception e) {
			e.printStackTrace();
			this.takeScreenShot();
			test.log(Status.FATAL,"#FUNC-Verify Search Pricelist" + driver.getTitle() +" * Search Pricelist is Fail* " );
		}
		}
	//Function Summary : Method to Select radio button of Impact on the base price.
	//Parameter Summary: Impact On The Basic Price,Increase Price.
	public void ImpactOnTheBasicPrice(Map<Object, Object> testdatamap)
	{
	String ele=testdatamap.get("Impact On The Basic Price").toString();
	if(ele.equalsIgnoreCase("Increase Price"))
	{
		WebClick(EdaatOR.Biller_Pricelistincradiobtn);
	}
	else
	{
		WebClick(EdaatOR.Biller_Pricelistdscradiobtn);
	}
	}
	public void Rounding(Map<Object, Object> testdatamap)
	{
		String ele=testdatamap.get("Rounding").toString();
		if(ele.equalsIgnoreCase("Rounding Up"))
		{
			WebClick(EdaatOR.Biller_Roundinguprdn);
		}
		else if(ele.equalsIgnoreCase("Rounding Down"))
		{
			WebClick(EdaatOR.Biller_Roundingdownrdn);
		}
		else
		{
			WebClick(EdaatOR.Biller_RoundingNordn);
		}
	}
	//Function Summary : Method to add price list.
	//Parameter Summary: Price List Name in Arabic,Price List Name in English,Increase or Decrease Ratio,FromYear,FromMonth,FromDate,ToYear,ToMonth,ToDate,Description.	
	public void AddPriselist(Map<Object, Object> testdatamap)
	{
		WebClick(EdaatOR.Biller_AddPricelistbtn);
		WebEdit(EdaatOR.Biller_Pricelistnameinarabic,testdatamap.get("Price List Name in Arabic").toString());
		WebEdit(EdaatOR.Biller_PricelistnameinEnglish,testdatamap.get("Price List Name in English").toString());
		ImpactOnTheBasicPrice(testdatamap);
		WebEdit(EdaatOR.Biller_Pricelistbtn,testdatamap.get("Increase or Decrease Ratio").toString());
		WebClick(EdaatOR.Biller_AddPriceFromdate);
		selectDropdownValue_PartialText(EdaatOR.Biller_AddPriceFromYear,testdatamap.get("FromYear").toString());
    	selectDropdownValue_PartialText(EdaatOR.Biller_AddPriceFromMonth,testdatamap.get("FromMonth").toString());
    	WebClick("//a[text()='"+testdatamap.get("FromDate").toString()+"']");
    	WebClick(EdaatOR.Biller_AddPriceTodate);
    	selectDropdownValue_PartialText(EdaatOR.Biller_AddPriceToyear,testdatamap.get("ToYear").toString());
    	selectDropdownValue_PartialText(EdaatOR.Biller_AddPriceToMonth,testdatamap.get("ToMonth").toString());
    	WebClick("//a[text()='"+testdatamap.get("ToDate").toString()+"']");
    	Rounding(testdatamap);
    	WebEdit(EdaatOR.Biller_Pricelistdescriptionbtn,testdatamap.get("Description").toString());
    	WebClick(EdaatOR.Biller_ActiveCheckbox);
    	WebClick(EdaatOR.Biller_AddPricelistbtn2);
    	
	}
	//Function Summary : Method to Search price list.
	//Parameter Summary: N/A.	
	public void verifySearchFunctionality(Map<Object,Object>testdatamap,Log Log) throws Exception {
		try {
			navigatetoPriceListPage();
			PriceListSearch(testdatamap);
			this.takeScreenShot();
			test.log(Status.PASS,"#FUNC-Verify Navigate to pricelist page  and search pricelist page " + driver.getTitle() +" * Navigate to pricelist page  and search pricelist page Pass * " );
        	Log.ReportEvent("PASS", " Verify Search pricelist is Suceessfull");

			
		}
			catch (Exception e) {
				e.printStackTrace();
				this.takeScreenShot();
				test.log(Status.FATAL,"#FUNC-Verify Navigate to pricelist page  and search pricelist page" + driver.getTitle() +" * Navigate to pricelist page  and search pricelist page Fail* " );
			}
		}
	
	//Function Summary : Method to Search/add/delete price list.
	//Parameter Summary: N/A.
	public void PriceListDelete(Map<Object, Object> testdatamap,Log Log) {
		// TODO Auto-generated method stub
		try {
			verifySearchFunctionality(testdatamap,Log);
			Thread.sleep(2000);
			if(CheckElementExists(EdaatOR.Biller_Searchpresent)==false)
			{
			WebClick(EdaatOR.Biller_PriceListDeletebtn);
			this.takeScreenShot();
			WebClick(EdaatOR.Biller_PriceListDeleteConformbtn);
			Thread.sleep(2000);
			PriceListSearch(testdatamap);
			Thread.sleep(2000);
			verifyElementIsPresent(EdaatOR.Biller_PriceListNodata);
        	Log.ReportEvent("PASS", " Verify Search and delete pricelist is Suceessfull");

		}
		else 
		{
			AddPriselist(testdatamap);
			PriceListSearch(testdatamap);
			WebClick(EdaatOR.Biller_PriceListDeletebtn);
			this.takeScreenShot();
			WebClick(EdaatOR.Biller_PriceListDeleteConformbtn);
			Thread.sleep(2000);
			PriceListSearch(testdatamap);
			Thread.sleep(2000);
			verifyElementIsPresent(EdaatOR.Biller_PriceListNodata);	
		}
			
		}
	
			catch (Exception e) {
				e.printStackTrace();
				this.takeScreenShot();
			}
	}
	//Function Summary   : Method to ClickonBillersettings
	//Parameter Summary  : N/A
	public void ClickonBillersettings() {
	WebClickUsingJS(EdaatOR.Biller_Settings);
	waitForPageToLoad();
	}
	//Function Summary   : Method to ClickonPricingList
	//Parameter Summary  : N/A
	private void ClickonPricingList() {
	WebClickUsingJS(EdaatOR.Biller_settings_Price);
	waitForPageToLoad();
	}
	//Function Summary   : Method to navigatePricingList
	//Parameter Summary  : N/A
	public void navigatePricingList(Log Log)
	{
		ClickonBillersettings();
		ClickonPricingList();
    	Log.ReportEvent("PASS", " Verify Pricing List Page dispayed Suceessfull");

	}
	//Function Summary   : Method to EnterSearchitem
	//Parameter Summary  : N/A
	public void EnterSearchitem(String PriceListName) throws InterruptedException {
		
		WebEdit(EdaatOR.Biller_settings_efield,PriceListName);
		Thread.sleep(1000);
		WebClick(EdaatOR.Biller_settings_sbtn);
		}
	//Function Summary   : Method to VerifyViewPriceButton
	//Parameter Summary  : PriceListName
	public void VerifyViewPriceButton(Map<Object, Object> testdatamap,Log Log)
	{
		try {
			EnterSearchitem(testdatamap.get("PriceListName").toString());
			Thread.sleep(1000);
			WebClick(EdaatOR.Biller_settings_Pricebtn );
			this.takeScreenShot();
			Thread.sleep(1000);
			verifyElementIsPresent(EdaatOR.Biller_settings_Priceverify);
			Thread.sleep(1000);
			VerifyValue1(getText(EdaatOR.Biller_settings_Pricenameverify),"Price List Name in Arabic");
			this.takeScreenShot();
			test.log(Status.PASS,"#FUNC-View Price details" + driver.getTitle() +" * Pricing List view Price details PASS * " );	
        	Log.ReportEvent("PASS", " Verify  View Price details button functionality is Suceessfull");

		}
		catch (Exception e) {
			test.log(Status.PASS,"#FUNC-View Price details" + driver.getTitle() +" * Pricing List view Price details FAIL * " );	
		}
	}
	//Function Summary   : Method to Navigate pricing list in settings module.
	//Parameter Summary : N/A.
	public void navigatePriceList(Log Log) throws Exception {
		WebClickUsingJS(EdaatOR.Biller_Settings);
		Thread.sleep(200);
		WebClickUsingJS(EdaatOR.Biller_PricingList);
		Thread.sleep(1000);
    	Log.ReportEvent("PASS", " Verify Pricing list Is Displayed Successfully");

	}
	
	//Function Summary   : Method to add pricing list
	//Parameter Summary : PriceNameEnglish,PriceNameArabic,FromYear,FromMonth,FromDate,ToYear,ToMonth,ToDate,ImpactOnPrice
	public void addPriceList(Map<Object,Object>testdatamap,Log Log) {
		try {
			String PriceNameEnglish=testdatamap.get("PriceNameEnglish").toString();
			WebClickUsingJS(EdaatOR.Biller_AddBtn);
			waitForPageToLoad();
			WebEdit(EdaatOR.Biller_PriceNameAr, testdatamap.get("PriceNameArabic").toString());
			Thread.sleep(200);
			WebEdit(EdaatOR.Biller_PriceNameEn, PriceNameEnglish);
			Thread.sleep(200);
			WebClick("//label[text()='"+testdatamap.get("ImpactOnPrice").toString()+"']");
			Thread.sleep(200);
			WebEdit(EdaatOR.Biller_Ratio, testdatamap.get("Ratio").toString());
			Thread.sleep(200);
			WebClick(EdaatOR.Biller_FromCalendar);
			Thread.sleep(200);
			selectDropdownValue_PartialText(EdaatOR.Biller_FromYear,testdatamap.get("FromYear").toString());
	        selectDropdownValue_PartialText(EdaatOR.Biller_FromMonth,testdatamap.get("FromMonth").toString());
	        WebClick(" //div[@class='calendars-popup']//a[text()='"+testdatamap.get("FromDate").toString()+"']");
	        WebClick(EdaatOR.Biller_ToCalendar);
	        Thread.sleep(200);
	        selectDropdownValue_PartialText(EdaatOR.Biller_FromYear,testdatamap.get("ToYear").toString());
	        selectDropdownValue_PartialText(EdaatOR.Biller_FromMonth,testdatamap.get("ToMonth").toString());
	        WebClick(" //div[@class='calendars-popup']//a[text()='"+testdatamap.get("ToDate").toString()+"']");
	        Thread.sleep(200);
	        WebClick("//label[text()='"+testdatamap.get("ImpactOnPrice").toString()+"']");
	        WebClickUsingJS(EdaatOR.Biller_RadioBtn);
	    	
	        WebClickUsingJS(EdaatOR.Biller_AddPriceBtn);
	    	WebEdit(EdaatOR.Biller_SearchName,PriceNameEnglish);
	    	WebClick(EdaatOR.Biller_SearchButton);
	    	verifyElementIsPresent("//td[text()='"+PriceNameEnglish+"']");
	    	test.log(Status.PASS,"#FUNC-Add price list" + driver.getTitle() +" *Add price list PASS * " );
        	Log.ReportEvent("PASS", " Verify Add pricing list is Suceessfull");

		}
		catch(Exception e){
			test.log(Status.FATAL,"#FUNC-Add price list" + driver.getTitle() +" * Add price list FAIL * " );
			this.takeScreenShot();
		}
}
	//Function Summary : Method to Search price list.
		//Parameter Summary: N/A.	
		public void verifyPricelistgridview(Log Log) throws Exception {
			try {
				//navigatetoPriceListPage();
				verifyElementIsPresent(EdaatOR.Biller_Pricelistsym);
				verifyElementIsPresent(EdaatOR.Biller_Pricelistgrid);				
				this.takeScreenShot();
				test.log(Status.PASS,"#FUNC-Verify Navigate to pricelist page  and view records of Grid " + driver.getTitle() +" * Navigate to pricelist page  and view records of Grid is Pass * " );
	        	Log.ReportEvent("PASS", " Verify  View Price details button functionality is Suceessfull");

				
			}
				catch (Exception e) {
					e.printStackTrace();
					this.takeScreenShot();
					test.log(Status.FATAL,"#FUNC-Verify Navigate to pricelist page  and view records of Grid" + driver.getTitle() +" * Navigate to pricelist page  and view records of Grid is Fail* " );
				}
			}
	
		//Function Summary   : Method to Verify AddPricelistErrorMsg
		//Parameter Summary  : Expected
		public void AddPriceListErrorMessageValidation(Map<Object,Object>testdatamap) {
			AddPriselistUI(testdatamap);
			String Expected=testdatamap.get("ExpectedResult").toString();
			try {
				if(ExistsCheck(EdaatOR.Biller_Settings_PricelistArabicNameError)) {
					VerifyValue(Expected,EdaatOR.Biller_Settings_PricelistArabicNameError);
					test.log(Status.PASS, "#FUNC-Pricelist ArabicName Error Message Exists" + driver.getTitle() + " * Pricelist ArabicName Error Message Exists * ");	    	
			     }
				else if(ExistsCheck(EdaatOR.Biller_Settings_PricelistEngNameError)){
					VerifyValue(Expected,EdaatOR.Biller_Settings_PricelistEngNameError);
					test.log(Status.PASS, "#FUNC-Pricelist EnglishName Error Message Exists" + driver.getTitle() + " * Pricelist EnglishName Error Message Exists * ");
				}
				else if(ExistsCheck(EdaatOR.Biller_Settings_PricelistRatioError)){
					VerifyValue(Expected,EdaatOR.Biller_Settings_PricelistRatioError);
					test.log(Status.PASS, "#FUNC-Pricelist Increase or Decrease Ratio Error Message Exists" + driver.getTitle() + " * Pricelist Increase or Decrease Ratio Error Message Exists * ");
				}
				else if(ExistsCheck(EdaatOR.Biller_Settings_PricelistFromDateError)){
					VerifyValue(Expected,EdaatOR.Biller_Settings_PricelistFromDateError);
					test.log(Status.PASS, "#FUNC-Pricelist FromDate Error Message Exists" + driver.getTitle() + " * Pricelist FromDate Error Message Exists * ");
				}
				else if(ExistsCheck(EdaatOR.Biller_Settings_PricelistToDateError)){
					VerifyValue(Expected,EdaatOR.Biller_Settings_PricelistToDateError);
					test.log(Status.PASS, "#FUNC-Pricelist ToDate Error Message Exists" + driver.getTitle() + " * Pricelist ToDate Error Message Exists * ");
				}
				else if(ExistsCheck(EdaatOR.Biller_Settings_PricelistRoundingRadioBTNError)){
					VerifyValue(Expected,EdaatOR.Biller_Settings_PricelistRoundingRadioBTNError);
					test.log(Status.PASS, "#FUNC-Pricelist Rounding Radio Button Error Message Exists" + driver.getTitle() + " * Pricelist Rounding Radio Button Error Message Exists * ");
				}
				
				else {

					test.log(Status.FAIL, "#FUNC-Element Not Exists" + driver.getTitle() + " * Element Not Exists * ");
				  }
				
			}
			catch(Exception e){
				test.log(Status.FATAL,"#FUNC-Add price list" + driver.getTitle() +" * Add price list FAIL * " );
				this.takeScreenShot();
			}
	}
		//Function Summary   : Method to  AddPricelist
		//Parameter Summary  : Price List Name in Arabic,Price List Name in English,Increase or Decrease Ratio,ValidFromDate
		//                     Valid,FromYear,FromMonth,FromDate,ValidToDate,ToYear,ToMonth,ToDate,RadioButton,Description
		public void AddPriselistUI(Map<Object, Object> testdatamap)
		{
			WebClick(EdaatOR.Biller_AddPricelistbtn);
			WebEdit(EdaatOR.Biller_Pricelistnameinarabic,testdatamap.get("Price List Name in Arabic").toString());
			WebEdit(EdaatOR.Biller_PricelistnameinEnglish,testdatamap.get("Price List Name in English").toString());
			ImpactOnTheBasicPrice(testdatamap);
			WebEdit(EdaatOR.Biller_Pricelistbtn,testdatamap.get("Increase or Decrease Ratio").toString());
			String FromDate = testdatamap.get("ValidFromDate").toString();
			if(FromDate.equalsIgnoreCase("Valid")) {
			WebClick(EdaatOR.Biller_AddPriceFromdate);
			selectDropdownValue_PartialText(EdaatOR.Biller_AddPriceFromYear,testdatamap.get("FromYear").toString());
	    	selectDropdownValue_PartialText(EdaatOR.Biller_AddPriceFromMonth,testdatamap.get("FromMonth").toString());
	    	WebClick("//a[text()='"+testdatamap.get("FromDate").toString()+"']");
			}
			String ToDate = testdatamap.get("ValidToDate").toString();
			if(ToDate.equalsIgnoreCase("Valid")) {
	    	WebClick(EdaatOR.Biller_AddPriceTodate);
	    	selectDropdownValue_PartialText(EdaatOR.Biller_AddPriceToyear,testdatamap.get("ToYear").toString());
	    	selectDropdownValue_PartialText(EdaatOR.Biller_AddPriceToMonth,testdatamap.get("ToMonth").toString());
	    	WebClick("//a[text()='"+testdatamap.get("ToDate").toString()+"']");
			}
			String Radio= testdatamap.get("RadioButton").toString();
			if(Radio.equalsIgnoreCase("Valid")) {
	    	Rounding(testdatamap);
			}
	    	WebEdit(EdaatOR.Biller_Pricelistdescriptionbtn,testdatamap.get("Description").toString());
	    	WebClick(EdaatOR.Biller_ActiveCheckbox);
	    	WebClick(EdaatOR.Biller_AddPricelistbtn2);
	    	this.takeScreenShot();
	    	
		}

	
}
