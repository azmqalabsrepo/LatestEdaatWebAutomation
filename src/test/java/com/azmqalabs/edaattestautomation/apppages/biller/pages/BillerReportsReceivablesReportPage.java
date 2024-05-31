package com.azmqalabs.edaattestautomation.apppages.biller.pages;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.server.handler.SwitchToFrame;
import org.openqa.selenium.remote.server.handler.SwitchToParentFrame;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.azmqalabs.edaattestautomation.apppages.GlobalConstant;
import com.azmqalabs.edaattestautomation.apppages.masterpages.BasePage;
import com.azmqalabs.edaattestautomation.common.uielement.fieldDecorator;
import com.azmqalabs.edaattestautomation.objectrepository.EdaatOR;
import com.azmqalabs.edaattestautomation.common.Log;


public class BillerReportsReceivablesReportPage extends BasePage
{

	public BillerReportsReceivablesReportPage(WebDriver driver,ExtentTest test)
	{
		 this.driver=driver;
		 this.test=test;
		 
		 PageFactory.initElements(new fieldDecorator(driver,test), this);
	}  
	

	@FindBy(xpath = EdaatOR.Biller_Client)
	public WebElement Client;
		
	    
	    public boolean Exists(){
	    	return super.Exists(Client); 
		}
	    
	 public void VerifyIndividualClientsReport(Map<Object, Object> testdatamap,Log Log) throws Exception {
		 try{
			 WebClick(EdaatOR.Biller_ReportsMenu);
			 Thread.sleep(1000);
			 WebClick(EdaatOR.Biller_Recevible_ReportMenu);
			 Thread.sleep(1000);
			 WebClickUsingJS(EdaatOR.Biller_individual_Report);
			 Thread.sleep(2000);
			 driver.navigate().back();
			 //Thread.sleep(2000);
	       
			 test.log(Status.PASS,"#FUNC-Delete User from userlist and IsDelete User check box" + driver.getTitle() +" * User Management PASS * " );	
		    	Log.ReportEvent("PASS", " Verify IndividualClientReport");
     }catch(Exception e){
      test.log(Status.FATAL, "#FUNC-Toggle Click" + driver.getTitle() + " * Toggle Click FAIL * ");
 		this.takeScreenShot();
     }
				 
	 }
	  //Function Summary  : Method to Navigate to Client account statement.  
			//Parameter Summary : N/A
			public void navigatetoclientAccountStatement() {
				try{
					WebClickUsingJS(EdaatOR.Biller_ReportMenu); 
					Thread.sleep(1000);
					WebClickUsingJS(EdaatOR.Biller_ReceivablesReportsbtn); 
					Thread.sleep(1000);
					WebClickUsingJS(EdaatOR.Biller_ReportClientaccountbtn); 
					Thread.sleep(1000);
					
		    		test.log(Status.PASS,"#FUNC-ClientAccountPage " + driver.getTitle() +" * ClientAccountReportPage PASS * " );
		    		this.takeScreenShot();
					}
				catch(Exception e){
			test.log(Status.FAIL,"#FUNC-ClientAccountPage" + driver.getTitle() +" * ClientAccountReportPage FAIL * " );
			this.takeScreenShot();
			}

			}
		
				//Function Summary  : Method to Generate Client account Statement Report.  
			//Parameter Summary : Invoice Contract,FromYear,FromMonth,ToYear,ToMonth,ToDate.
			public void ClientAccountReports(Map<Object, Object> testdatamap,Log Log)
			{
				try{
					navigatetoclientAccountStatement();
					ClientType(testdatamap);
					Thread.sleep(1000);
					SelectClient(testdatamap.get("ClientName").toString());	
					//WebClick(EdaatOR.Biller_SelectSubbillertype);
					Thread.sleep(1000);	
					WebSelect(EdaatOR.Biller_SubbillerTypeindvidutial, testdatamap.get("SubBiller").toString());    
				    Thread.sleep(2000);
				    WebClick(EdaatOR.Biller_SelectSubbillerName);
				    Thread.sleep(2000);
				    WebClickUsingJS("//li[text()='"+(testdatamap.get("SubbillerName").toString())+"']");					
				//	WebEdit(EdaatOR.Biller_Invoicecontract,testdatamap.get("Invoice Contract").toString());
					WebClick(EdaatOR.Biller_ReportFromdate);
					Thread.sleep(1000);
			        selectDropdownValue_PartialText(EdaatOR.Biller_reportFromYear,testdatamap.get("FromYear").toString());
			    	Thread.sleep(1000);
			        selectDropdownValue_PartialText(EdaatOR.Biller_reportFromMonth,testdatamap.get("FromMonth").toString());
			    	Thread.sleep(1000);
			        WebClick("//a[text()='"+testdatamap.get("FromDate").toString()+"']");
			    	Thread.sleep(1000);
			        WebClick(EdaatOR.Biller_ReportTodate);
			    	Thread.sleep(1000);
			        selectDropdownValue_PartialText(EdaatOR.Biller_reportToyear,testdatamap.get("ToYear").toString());
			    	Thread.sleep(1000);
			        selectDropdownValue_PartialText(EdaatOR.Biller_reportToMonth,testdatamap.get("ToMonth").toString());
			    	Thread.sleep(1000);
			        WebClick("//a[text()='"+testdatamap.get("ToDate").toString()+"']");	
			    	Thread.sleep(1000);
			        WebClick(EdaatOR.Biller_reportsearchbutton);
			        waitForPageToLoad();
			        //Thread.sleep(5000);			    
			        //this.takeScreenShot();			       
			      
			        switchToWindow();			      
			        swithchToFrame(EdaatOR.Biller_reportframe);
			        verifyElementIsPresent(EdaatOR.Biller_report);
			        Thread.sleep(1000);
			        switchBacktoParentwindow();
			    	Thread.sleep(1000);
			    	Log.ReportEvent("PASS", " Verify Generate Client account statement is Successful");
			        }
				catch(Exception e){
			test.log(Status.FAIL,"#FUNC-Generate Report and export" + driver.getTitle() +" * Generate Report and export FAIL * " );
			this.takeScreenShot();
			}			
			}	
						
		    //Function Summary  : Method to Select Client type. 
			//Parameter Summary : ClientType,Individual.
			public void ClientType(Map<Object, Object> testdatamap) { 
				
				try{
					WebClick(EdaatOR.Biller_ClientType);
					String ele=testdatamap.get("ClientType").toString();
					if(ele.equalsIgnoreCase("Individual")) {
					selectDropdownValue_PartialText(EdaatOR.Biller_ClientTypeindvidutial, ele);
					}
					else {
						selectDropdownValue_PartialText(EdaatOR.Biller_ClientTypeCorporate, ele);
					}			
					
				}
				catch(Exception e){
			test.log(Status.FAIL,"#FUNC-Generate Report and export" + driver.getTitle() +" * Generate Report and export FAIL * " );
			this.takeScreenShot();
			}			
			}
			  //Function Summary  : Method to Select Client type. 
			 //Parameter Summary : ClientName.
			public void SelectClient(String client) throws InterruptedException {
				
				WebClick(EdaatOR.Biller_ClientName);
				Thread.sleep(1000);
				WebClickUsingActions(EdaatOR.Biller_SelectClientName+"["+client+"]");
				//WebClick(EdaatOR.Biller_SelectClientName);
			}
			 //Function Summary  : Method to Select SubBiller type. 
			 //Parameter Summary : SubBiller,Individual.	
		public void SubbillerType(Map<Object, Object> testdatamap) { 
			
			try{
				WebClick(EdaatOR.Biller_SelectSubbillertype);
				String ele=testdatamap.get("SubBiller").toString();
				if(ele.equalsIgnoreCase("Individual")) {
				selectDropdownValue_PartialText(EdaatOR.Biller_SubbillerTypeindvidutial, ele);
				}
				else {
					selectDropdownValue_PartialText(EdaatOR.Biller_SubbillerTypeCorporate, ele);
				}			
				
			}
			catch(Exception e){
		test.log(Status.FAIL,"#FUNC-Generate Report and export" + driver.getTitle() +" * Generate Report and export FAIL * " );
		this.takeScreenShot();
		}			
		}
		//Function Summary  : Method to Select SubBiller Name. 
		 //Parameter Summary : N/A.
		public void SelectSubbillername(String sub) throws InterruptedException {
			//WebSelect1(EdaatOR.Biller_Invoice_SBilIdList,SubBiller);
			WebClick(EdaatOR.Biller_SelectSubbillerName);
			Thread.sleep(1000);
			WebClick(EdaatOR.Biller_SelectSubbillerName1+"["+sub+"]");
		//	WebClick(EdaatOR.Biller_SelectClientName);
		}

		 //Function Summary  : Navigate to Verify ClientInvoiceReport Generate Functionality  
		//Parameter Summary : N/A
		public void navigatetoclientinvoicereport(Log Log) {
			try{
				WebClickUsingJS(EdaatOR.Biller_ReportMenu); 
				Thread.sleep(1000);
				WebClickUsingJS(EdaatOR.Biller_ReceivablesReportsbtn); 
				Thread.sleep(1000);
				WebClickUsingJS(EdaatOR.Biller_ClientsInvoicesReport); 
				Thread.sleep(1000);
	    		test.log(Status.PASS,"#FUNC-ClientInvoiceReportPage " + driver.getTitle() +" * ClientInvoiceReportPage PASS * " );
	    		Log.ReportEvent("PASS", " Verify Navigate to Verify ClientInvoiceReport Generate is Suceessful");
	    		this.takeScreenShot();
				}
			catch(Exception e){
		test.log(Status.FAIL,"#FUNC-ClientInvoiceReportPage" + driver.getTitle() +" * ClientInvoiceReportPage FAIL * " );
		this.takeScreenShot();
		}

		}
		
		//Function Summary  : Method to Enter FromDate 
		//Parameter Summary : FromYear,FromMonth,FromDate
		private void EnterFromdate(Map<Object, Object> testdatamap) throws InterruptedException {
			WebClick(EdaatOR.Biller_Clientreport_FromDate);
			selectDropdownValue_PartialText(EdaatOR.Biller_Clientreport_Fromyear,testdatamap.get("FromYear").toString());
			selectDropdownValue_PartialText(EdaatOR.Biller_Clientreport_FromMonth,testdatamap.get("FromMonth").toString());
            WebClick("//a[text()='"+testdatamap.get("FromDate").toString()+"']");
			Thread.sleep(1000);
		}
		
		//Function Summary  : Method to Enter Todate 
		//Parameter Summary : ToYear,ToMonth,ToDate
		private void EnterTodate(Map<Object, Object> testdatamap) throws InterruptedException {
			WebClick(EdaatOR.Biller_Clientreport_TODate);
			selectDropdownValue_PartialText(EdaatOR.Biller_Clientreport_Toyear,testdatamap.get("ToYear").toString());
			selectDropdownValue_PartialText(EdaatOR.Biller_Clientreport_ToMonth,testdatamap.get("ToMonth").toString());
            WebClick("//a[text()='"+testdatamap.get("ToDate").toString()+"']");
			Thread.sleep(1000);

		}
		
	    //Function Summary  : Method to Verify ClientInvoiceReport Generate Functionality  
		//Parameter Summary : ClientType,ClientName,BillStatus,IdorCR,exportmsg
		public void GenerateReport(Map<Object, Object> testdatamap,Log Log) { 
			try{
				EnterFromdate(testdatamap);
				EnterTodate(testdatamap);
				selectDropdownValue_PartialText(EdaatOR.Biller_ClientType,testdatamap.get("ClientType").toString());
				Thread.sleep(500);
				WebClick(EdaatOR.Biller_ClientNamearro);
				WebEdit(EdaatOR.Biller_ClientNametextbox, testdatamap.get("ClientName").toString());
				Thread.sleep(1000);
				WebClick(EdaatOR.Biller_ClientNameoption);
				Thread.sleep(1000);
				selectDropdownValue_PartialText(EdaatOR.Biller_BillStatus,testdatamap.get("BillStatus").toString());
				Thread.sleep(500);
				WebEdit(EdaatOR.Biller_IdorCR,testdatamap.get("IdorCR").toString());
				Thread.sleep(2000);
//				selectDropdownValue_PartialText(EdaatOR.Biller_SubBillerType,testdatamap.get("SubBillerType").toString());
//				WebClickUsingJS(EdaatOR.Biller_SubBillerType);
//				WebClick("//option[text()='"+testdatamap.get("SubBillerType").toString()+"'])[2]");
//				Thread.sleep(500);
//				WebClick(EdaatOR.Biller_SubBillerNamearro);
//				Thread.sleep(1000);
//				WebEdit(EdaatOR.Biller_SubBillerNametxtbox, testdatamap.get("subbiller").toString());
//				Thread.sleep(2000);
//				WebClickUsingJS(EdaatOR.Biller_SubbillerNameoption);
//				Thread.sleep(1000);
				WebClick(EdaatOR.Biller_Generatebtn);
				Thread.sleep(2000);
				switchTonextwindow();
				waitForPageToLoad();
	    		this.takeScreenShot();
				switchBacktoParentwindow();
				Thread.sleep(2000);
				WebClick(EdaatOR.Biller_Exporttoexcelbtn);
				scrollDowntillend(driver);
				VerifyValue1(WebGetText(EdaatOR.Biller_exportedmsg), testdatamap.get("exportmsg").toString());
				waitForPageToLoad();
				Thread.sleep(1000);
	    		test.log(Status.PASS,"#FUNC-Generate Report and export " + driver.getTitle() +" * Generate Report and export PASS * " );
	    		Log.ReportEvent("PASS", " Verify Clients Invoices Report Generate Report is Suceessful");
	    		this.takeScreenShot();
				}
			catch(Exception e){
		test.log(Status.FAIL,"#FUNC-Generate Report and export" + driver.getTitle() +" * Generate Report and export FAIL * " );
		this.takeScreenShot();
		}
			
		}
		 //Function Summary  : Method to navigate to Receivevable report
		 //Parameter Summary : N/A	
		public void navigatetoReceivableReports() throws InterruptedException {
			
			WebClickUsingJS(EdaatOR.Biller_ReportMenu); 
			Thread.sleep(1000);
			WebClickUsingJS(EdaatOR.Biller_ReceivablesReportsbtn); 
			Thread.sleep(1000);	
		}
		 //Function Summary  : Method to verify corporate client report 
		 //Parameter Summary : N/A	
	public void CorporateClientReport(Log Log) { 
		
		try{
			navigatetoReceivableReports();
			WebClickUsingJS(EdaatOR.Biller_CorporateClientReport); 
			Thread.sleep(3000);
			swithchToFrame(EdaatOR.Biller_CorporateReport);
			Thread.sleep(3000);
			verifyElementIsPresent(EdaatOR.Biller_CorporateReportBillerName);
			this.takeScreenShot();
			driver.navigate().back();
		    test.log(Status.PASS,"#FUNC-Corporate client report " + driver.getTitle() +" * Corporate client report FAIL * " );
	        Log.ReportEvent("PASS", " Verify Generate Client account statement is Successful");
			}
		
		catch(Exception e){
	test.log(Status.FATAL,"#FUNC-Corporate client report " + driver.getTitle() +" * Corporate client report  FAIL * " );
	this.takeScreenShot();
	}			
	}
	
	//Function Summary  : Method to verify Sub Biller report 
	//Parameter Summary : SubBillerType,NationalID,CRNumber
	public void SubBillerReport(Map<Object, Object> testdatamap,Log Log) { 
		
		try{
			String SubBillerType=testdatamap.get("SubBillerType").toString();
			navigatetoReceivableReports();
			WebClickUsingJS(EdaatOR.Biller_SubBillerReportLink); 
			Thread.sleep(800);
			switchToWindow();
			//WebClickUsingJS(EdaatOR.Biller_SubBillerCorporate); 
			WebClickUsingJS("//label[text()='"+SubBillerType+"']");
			if(SubBillerType.equals("Individual"))
			{ 
				WebEdit(EdaatOR.Biller_SubBillerNationalID, testdatamap.get("NationalID").toString());
			    Thread.sleep(800);
			}
			else {
				WebEdit(EdaatOR.Biller_SubBillerCRNumber, testdatamap.get("CRNumber").toString());
			    Thread.sleep(800);	
			}
			WebClickUsingJS(EdaatOR.Biller_SubBillerGenerateReport);
			Thread.sleep(800);
			switchToWindow();
			swithchToFrame(EdaatOR.Admin_Corporate_Report);
			verifyElementIsPresent("//div[contains(text(),'"+SubBillerType+"')]");
			this.takeScreenShot();
			switchBacktoParentwindow();
		    test.log(Status.PASS,"#FUNC-Sub biller report " + driver.getTitle() +" * Sub biller report FAIL * " );
		     Log.ReportEvent("PASS", " Verify Sub Biller Report is Successful");
		}
		
		catch(Exception e){
	    test.log(Status.FATAL,"#FUNC-Sub biller report " + driver.getTitle() +" * Sub biller report  FAIL * " );
	    this.takeScreenShot();
	}			
	}
	public void NavigatetoOverdueBillsReport(Log Log)throws InterruptedException
	{
		WebClickUsingJS(EdaatOR.Biller_ReportMenu); 
		Thread.sleep(1000);
		WebClickUsingJS(EdaatOR.Biller_ReceivablesReportsbtn); 
		Thread.sleep(1000);
		WebClickUsingJS(EdaatOR.Biller_OverDueBillsReport); 
		Thread.sleep(1000);
		this.takeScreenShot();
		Log.ReportEvent("PASS", " Verify Navigate to Overdue Bills Report is Suceessful");
	}
	public void VerifyOverdueBillsReport(Map<Object, Object> testdatamap,Log Log)
	{
		try{
			
			WebClick(EdaatOR.Biller_OverDueBillsReportClientType); 
			WebSelect(EdaatOR.Biller_OverDueBillsReportClientType, testdatamap.get("ClientType").toString());
			Thread.sleep(2000);
			WebClick(EdaatOR.Biller_OverDueBillsReportClientName);
			Thread.sleep(2000);
		    WebEdit(EdaatOR.Biller_OverDueBillsReportclientNameTxtField, testdatamap.get("ClientName").toString());
			Thread.sleep(2000);
			WebSelect(EdaatOR.Biller_OverDueBillsReportSubBillerType, testdatamap.get("SuperBillerType").toString());
			///Thread.sleep(1000);
			//WebSelect(EdaatOR.Biller_OverDueBillsReportSubBillerName, testdatamap.get("SuperBillerName").toString());
			Thread.sleep(3000);
			WebClickUsingJS(EdaatOR.Biller_OverDueBillsGenerateReportBTN); 
			waitForPageToLoad();
			switchToWindow();
			this.takeScreenShot();
			swithchToFrame(EdaatOR.Biller_OverDueBillsReportFrame);
			Thread.sleep(1000);
			VerifyValue1(getText("//div[text()='"+testdatamap.get("ClientName").toString()+"']"), testdatamap.get("ClientName").toString());
			Thread.sleep(2000);
	        switchBacktoParentwindow();
    		test.log(Status.PASS,"#FUNC-Verify Overdue Bills Report " + driver.getTitle() +" * Verify Overdue Bills Report is PASS * " );
    		Log.ReportEvent("PASS", " Verify Overdue Bills Report is Suceessful is Suceessful");
    		this.takeScreenShot();
			}
		catch(Exception e){
	test.log(Status.FAIL,"#FUNC-Verify Overdue Bills Report " + driver.getTitle() +" * Verify Overdue Bills Report is FAIL * " );
	this.takeScreenShot();
	}
	}
	
	//Function Summary  : Method to NavigatetoSadadPaymentsTransactionsReport
	//Parameter Summary : N/A
	public void NavigatetoSadadPaymentsTransactionsReport(Log Log) throws InterruptedException {
			
		WebClickUsingJS(EdaatOR.Biller_ReportMenu); 
		Thread.sleep(1000);
		WebClickUsingJS(EdaatOR.Biller_ReceivablesReportsbtn); 
		Thread.sleep(1000);
		WebClickUsingJS(EdaatOR.Biller_Receivables_Sadadpaybtn);
		Thread.sleep(1000);
		Log.ReportEvent("PASS", " Navigate to Sadad Payments Transactions Report");
		}
	//Function Summary  : Method to VerifySadadPaymentTransactionReport
	//Parameter Summary : InvoiceNumber,InvoiceType,ClientType,ClientName,FromYear,ToYear,FromMonth,ToMonth,ToDate,FromDate,Products
	public void VerifySadadPaymentTransactionReport(Map<Object, Object> testdatamap,Log Log) {

		try
		{
			selectDropdownValue_PartialText(EdaatOR.Biller_Receivables_SadadpayInvoicetype,testdatamap.get("InvoiceType").toString());
			Thread.sleep(1000);
			WebEdit(EdaatOR.Biller_Receivables_SadadpayInvoiceno,testdatamap.get("InvoiceNumber").toString());
			Thread.sleep(1000);
			selectDropdownValue_PartialText(EdaatOR.Biller_Receivables_SadadpayClienttype,testdatamap.get("ClientType").toString());
			Thread.sleep(1000);
			WebClick(EdaatOR.Biller_Receivables_SadadpayClientname);
			Thread.sleep(1000);
			WebClickUsingActions("//li[text()='"+testdatamap.get("ClientName").toString()+"']");
			WebClick(EdaatOR.Biller_Receivables_Sadadpay_FromCalender);
			selectDropdownValue_PartialText(EdaatOR.Biller_Receivables_Sadadpay_FromYear, testdatamap.get("FromYear").toString());
			selectDropdownValue_PartialText(EdaatOR.Biller_Receivables_Sadadpay_FromMonth, testdatamap.get("FromMonth").toString());
			WebClick("//a[text()='"+testdatamap.get("FromDate").toString()+"']");
			Thread.sleep(800);
			WebClick(EdaatOR.Biller_Receivables_Sadadpay_ToCalender);
			selectDropdownValue_PartialText(EdaatOR.Biller_Receivables_Sadadpay_ToYear, testdatamap.get("ToYear").toString());
			selectDropdownValue_PartialText(EdaatOR.Biller_Receivables_Sadadpay_ToMonth, testdatamap.get("ToMonth").toString());
			WebClick("//a[text()='"+testdatamap.get("ToDate").toString()+"']");
			Thread.sleep(1000);
			WebClick(EdaatOR.Biller_Receivables_Sadadpay_product);
			Thread.sleep(1000);
			WebClickUsingActions("//li[text()='"+testdatamap.get("Products").toString()+"']");
			Thread.sleep(1000);
			this.takeScreenShot();
			WebClick(EdaatOR.Biller_Receivables_Sadadpay_generatebtn);
			switchToWindow();
			Thread.sleep(1000);
			swithchToFrame(EdaatOR.Biller_Receivables_Sadadpay_frame);
			Thread.sleep(1000);
			this.takeScreenShot();
			verifyElementIsPresent(EdaatOR.Biller_Receivables_Sadadpay_Verify);
			Thread.sleep(1000);
			switchBacktoParentwindow();
    		test.log(Status.PASS,"#FUNC-Verify Sadad Payments Transactions Report " + driver.getTitle() +" * Sadad Payments Transactions Report PASS * " );
    		Log.ReportEvent("PASS", "Verify Sadad Payments Transaction Generate Report is Suceessful");
		}
		catch (Exception e) {
			test.log(Status.FAIL,"#FUNC-Verify Sadad Payments Transactions Report" + driver.getTitle() +" * Sadad Payments Transactions Report FAIL * " );
			this.takeScreenShot();
		}
	}
	//Function Summary  : Method to Generate Client account Statement Report.  
	//Parameter Summary : Invoice Contract,FromYear,FromMonth,ToYear,ToMonth,ToDate.
	public void ClientAccountStatementReportUI(Map<Object, Object> testdatamap)
	{
		try{
			navigatetoclientAccountStatement();
			String ClientType=testdatamap.get("Client").toString();
			if(ClientType.equals("Valid")) {
			ClientType(testdatamap);
			Thread.sleep(1000);
			SelectClient(testdatamap.get("ClientName").toString());
			}
			WebClick(EdaatOR.Biller_SelectSubbillertype);
			Thread.sleep(1000);	
			WebSelect(EdaatOR.Biller_SubbillerTypeindvidutial, testdatamap.get("SubBiller").toString());    
		    Thread.sleep(2000);
		    WebClickUsingActions(EdaatOR.Biller_SelectSubbillerName);
		    Thread.sleep(2000);
	       WebClick("//li[text()='"+(testdatamap.get("SubbillerName").toString())+"']");
		//	WebEdit(EdaatOR.Biller_Invoicecontract,testdatamap.get("Invoice Contract").toString());
	       String Date = testdatamap.get("ValidDate").toString();
	       if(Date.equalsIgnoreCase("Valid")){
			WebClick(EdaatOR.Biller_ReportFromdate);
			Thread.sleep(1000);
	        selectDropdownValue_PartialText(EdaatOR.Biller_reportFromYear,testdatamap.get("FromYear").toString());
	    	Thread.sleep(1000);
	        selectDropdownValue_PartialText(EdaatOR.Biller_reportFromMonth,testdatamap.get("FromMonth").toString());
	    	Thread.sleep(1000);
	        WebClick("//a[text()='"+testdatamap.get("FromDate").toString()+"']");
	    	Thread.sleep(1000);
	        WebClick(EdaatOR.Biller_ReportTodate);
	    	Thread.sleep(1000);
	        selectDropdownValue_PartialText(EdaatOR.Biller_reportToyear,testdatamap.get("ToYear").toString());
	    	Thread.sleep(1000);
	        selectDropdownValue_PartialText(EdaatOR.Biller_reportToMonth,testdatamap.get("ToMonth").toString());
	    	Thread.sleep(1000);
	        WebClick("//a[text()='"+testdatamap.get("ToDate").toString()+"']");	
	    	Thread.sleep(1000);
	       }
	        WebClickUsingJS(EdaatOR.Biller_reportsearchbutton);
	        Thread.sleep(2000);
	       
	        }
		catch(Exception e){
	test.log(Status.FAIL,"#FUNC-Generate Report and export" + driver.getTitle() +" * Generate Report and export FAIL * " );
	this.takeScreenShot();
		}
	}
	
	     //Function Summary   : Method to Verify Client Account Statement Report ErrorMsg
	   	 //Parameter Summary  : Expected.
		public void ClientAccountStatementErrorMsgValidation(Map<Object, Object> testdatamap) {
			try
			{
				ClientAccountStatementReportUI(testdatamap);
				String Expected=testdatamap.get("ExpectedResult").toString();
				if(ExistsCheck(EdaatOR.Biller_Reports_Receiv_ClientAccStm_ClientTypeError))
				{
					VerifyValue1(getText(EdaatOR.Biller_Reports_Receiv_ClientAccStm_ClientTypeError), testdatamap.get("ExpectedResult").toString());
					test.log(Status.PASS, "#FUNC-This Field Is Required ErrorMessage Exists" + driver.getTitle() + " * This Field Is Required ErrorMessage Exists * ");
				}
				else if (ExistsCheck(EdaatOR.Biller_Reports_Receiv_ClientAccStm_ClientError)) {
				    VerifyValue1(getText(EdaatOR.Biller_Reports_Receiv_ClientAccStm_ClientError), testdatamap.get("ExpectedResult").toString());
					test.log(Status.PASS, "#FUNC-This Field Is Required ErrorMessage Exists" + driver.getTitle() + " *This Field Is Required ErrorMessage Exists * ");
				}
				else if (ExistsCheck(EdaatOR.Biller_Reports_Receiv_ClientAccStm_FromDateError)) {
				    VerifyValue1(getText(EdaatOR.Biller_Reports_Receiv_ClientAccStm_FromDateError), testdatamap.get("ExpectedResult").toString());
					test.log(Status.PASS, "#FUNC-This Field Is Required ErrorMessage Exists" + driver.getTitle() + " *This Field Is Required ErrorMessage Exists * ");
				}
	            else {
	            	test.log(Status.FAIL, "#FUNC-Element Not Exists" + driver.getTitle() + " * Element Not Exists * ");
	            }
			}
			catch (Exception e) {
				test.log(Status.FATAL,"#FUNC-Receivable Reports Client Account Stataement Fail" + driver.getTitle() +" * Receivable Reports Client Account Stataement FAIL * " );
				this.takeScreenShot();
			}
	 }
		//Function Summary  : Method to Navigate Custom reconciliation Report page.  
				//Parameter Summary : NA
				public void navigateToCustomReconciliationReportPage(Log Log)throws InterruptedException
				{
					try{
					WebClickUsingJS(EdaatOR.Biller_ReportMenu);
					Thread.sleep(1000);
					WebClickUsingJS(EdaatOR.Biller_ReceivablesReportsbtn);
					Thread.sleep(1000);
					WebClickUsingJS(EdaatOR.Biller_CustomReconciliationReport);
					Thread.sleep(1000);
					this.takeScreenShot();
					Log.ReportEvent("PASS", " Verify Custom Reconciliation Report is Suceessful");
					}
					catch (Exception e) {
						test.log(Status.FATAL,"Navigate to Custom Reconciliation Report Page is FAIL" );
						this.takeScreenShot();
					}
				}
                 //Function Summary  : Method to Navigate Daily Reconciliation Report SADAD page.  
				//Parameter Summary : NA
				public void navigateDailyReconciliationReportSADAD(Log Log)throws InterruptedException
				{
					try{
					WebClickUsingJS(EdaatOR.Biller_ReportMenu);
					Thread.sleep(1000);
					WebClickUsingJS(EdaatOR.Biller_ReceivablesReportsbtn);
					Thread.sleep(1000);
					WebClickUsingJS(EdaatOR.Biller_CustomReconciliationReportSadad);
					Thread.sleep(1000);
					this.takeScreenShot();
					Log.ReportEvent("PASS", " Verify Custom Reconciliation Report(Sadad) is Suceessful");
					}
					catch (Exception e) {
						test.log(Status.FATAL,"Navigate to Custom Reconciliation Report Page is FAIL" );
						this.takeScreenShot();
					}
				}
			
	 }
	 

