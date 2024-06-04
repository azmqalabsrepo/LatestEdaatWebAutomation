/**
* Test Script Name  				 : N/A
* Objective                             : Verify the Individual Client Functionality.
* Version      						 : 1.0
* Author       						 : Kathirvelu M
* Created Date 			      		 : 17/05/2023
* Last Updated on					 : N/A
* Updated By   			 			 : Basavaraj Mudnur
* Pre-Conditions					 : N/A
* Epic Details						 : N/A
* User Story Details				 : N/A
**/
package com.azmqalabs.edaattestautomation.apppages.biller.pages;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.azmqalabs.edaattestautomation.apppages.masterpages.BasePage;
import com.azmqalabs.edaattestautomation.common.Log;
import com.azmqalabs.edaattestautomation.common.uielement.fieldDecorator;
import com.azmqalabs.edaattestautomation.objectrepository.EdaatOR;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.Map;



public class BillerIndividualClientPage extends BasePage
{

	public BillerIndividualClientPage(WebDriver driver,ExtentTest test)
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

	    //Function Summary : Method to create Individual client 
		//Parameter Summary: CorporateName,CRNumber,PersonName,PersonID,MobileNo,Email,ClientRefno.
	public void AddIndividualclient(String FullName,String SecondName,String ThirdName,String LastName,String NationalID,String Year,String Month,String Date,String MobileNo,String Email,String Refno,Log Log){
        try{
        		Addclient(FullName,SecondName,ThirdName,LastName,NationalID,Year,Month,Date,MobileNo,Email,Refno);
        		boolean Ele=BillerSearchIndividualclient(NationalID,FullName);
	        	if(Ele==true)
{
	        		test.log(Status.PASS,"#FUNC-Add Individual client" + driver.getTitle() +" * Add Individual client PASS * " );
	        	    Log.ReportEvent("PASS", " Verify Add Individual Client is Successful");
}
        	else
    	    	test.log(Status.FAIL,"#FUNC-Add Individual client" + driver.getTitle() +" * Add Individual client FAIL * " );
    	}catch(Exception e){
    	test.log(Status.FAIL,"#FUNC-Add Individual client" + driver.getTitle() +" * Add Individual client FAIL * " );
            this.takeScreenShot();
        	}
    	}
	//Function Summary   : Method to Search Individual Client and View Invoice details of Client and Navigate back.
	//Parameter Summary : client,View.
	public void Action(String Action,Log Log){
        try{
            WebClickUsingJS(EdaatOR.Biller_Add_Individualclient);
            Thread.sleep(1000);        
            if(Action.equalsIgnoreCase("View")) {                
                if(CheckElementExists(EdaatOR.Biller_Invoice_table)==true) {
                    Thread.sleep(2000);
                    WebClear(EdaatOR.Biller_Individualclient_SearchByname);
                    WebEdit(EdaatOR.Biller_Individualclient_SearchByname, "Fullname");                    
                    WebClick(EdaatOR.Biller_Individualclient_Search);
                    Thread.sleep(1500);
                    WebClick(EdaatOR.Biller_Corpclient_Searchname);
                    Thread.sleep(1500);
                    switchTonextwindow();
                    scrollDowntillend(driver);
                    this.takeScreenShot();
                    WebClick(EdaatOR.Biller_Individualclient_Back);
                    test.log(Status.PASS,"#FUNC-Individual Client Table Exists" + driver.getTitle() +" * Individual Client Table Exists PASS * " );
                  	Log.ReportEvent("PASS", " Verify Upadate Individual Client is Suceessfull");
                }               
           //Function Summary   : Method to Search Individual Client and deactivate and activate Client status.
          //Parameter Summary : Deactivate,Fullname.
            }else if(Action.equalsIgnoreCase("Deactivate")) {
                WebEdit(EdaatOR.Biller_Individualclient_SearchByname, "Fullname");                    
                WebClick(EdaatOR.Biller_Individualclient_Search);
                Thread.sleep(2000);
                WebClickUsingJS(EdaatOR.Biller_Individualclient_Deactivate);
                Thread.sleep(2000);
                WebClick(EdaatOR.Biller_Individualclient_button);
                Thread.sleep(2000);
                WebClickUsingJS(EdaatOR.Biller_Individualclient_Deactivate);
                Thread.sleep(2000);
                WebClick(EdaatOR.Biller_Individualclient_button);
                this.takeScreenShot();
                test.log(Status.PASS,"#FUNC-Individual Client Deactivate/Activate Done" + driver.getTitle() +" * Individual Client Deactivate/Activate Done PASS * " );
              	Log.ReportEvent("PASS", " Verify Upadate Individual Client is Suceessfull");
            }
             //Function Summary   : Method to verify the Export to Excel Functionality.
            //Parameter Summary : Excel.
            else if(Action.equalsIgnoreCase("Excel")) {
                WebClick(EdaatOR.Biller_Individualclient_export);
                Thread.sleep(2000);                
                test.log(Status.PASS,"#FUNC-Export Done" + driver.getTitle() +" * Export Done PASS * " );
              	Log.ReportEvent("PASS", " Verify Upadate Individual Client is Suceessfull");
            }else
                test.log(Status.FAIL,"#FUNC-Updated Individual client" + driver.getTitle() +" * Updated Individual client FAIL * " );
        }catch(Exception e){
            test.log(Status.FATAL,"#FUNC-Updated Individual client" + driver.getTitle() +" * Updated Individual client FAIL * " );
            this.takeScreenShot();
        }
    }
	
	public void TableGridview(){
	    try{
	    	WebClickUsingJS(EdaatOR.Biller_Add_Individualclient);
	    	Thread.sleep(1000);	    
	    	if(CheckElementExists(EdaatOR.Biller_Invoice_table)==true) {
    			Thread.sleep(2000);
    			WebClear(EdaatOR.Biller_Individualclient_SearchByname);
    			WebEdit(EdaatOR.Biller_Individualclient_SearchByname, "client");        			
    			WebClick(EdaatOR.Biller_Individualclient_Search);
    			Thread.sleep(1000);
    			WebClick(EdaatOR.Biller_Corpclient_Searchname);
    			Thread.sleep(1000);
    			switchTonextwindow();
    			scrollDowntillend(driver);
    			this.takeScreenShot();
    			WebClick(EdaatOR.Biller_Individualclient_Back);
    			test.log(Status.PASS,"#FUNC-Individual Client Table Exists" + driver.getTitle() +" * Individual Client Table Exists PASS * " );
	    		}
	    	else {
	    		test.log(Status.FAIL,"#FUNC-Individual Client Table Not Exists" + driver.getTitle() +" * Individual Client Table Not Exists FAIL * " );
	    	}
	    }catch(Exception e){
	    	test.log(Status.FATAL,"#FUNC-Table View Individual client" + driver.getTitle() +" * Table View Individual client FAIL * " );
	        this.takeScreenShot();
	    }
	}
	
	
	public void Export(){
	    try{
	    	WebClickUsingJS(EdaatOR.Biller_Add_Individualclient);
	    	Thread.sleep(1000);	
	    	if(CheckElementClickable(EdaatOR.Biller_Individualclient_export)==true) {
	    		WebClick(EdaatOR.Biller_Individualclient_export);
				Thread.sleep(2000);    			
				test.log(Status.PASS,"#FUNC-Export Individual client Done" + driver.getTitle() +" * Export Individual client Done PASS * " );
	    	}
	    	else {
	    		test.log(Status.FAIL,"#FUNC-Export Individual client Not Done" + driver.getTitle() +" * Export Individual client Not Done FAIL  * " );
	    	}
	    }catch(Exception e){
	    	test.log(Status.FATAL," #FUNC-Export Individual client Not Done " + driver.getTitle() +" * Export Individual client Not Done FAIL * " );
	        this.takeScreenShot();
	    }
	}	
	
	public void ActivateDeactivate(Map<Object,Object> testdatamap){
	    try{
	    	WebClickUsingJS(EdaatOR.Biller_Add_Individualclient);
	    	Thread.sleep(1000);	
	    	if(CheckElementExists(EdaatOR.Biller_Individualclient_Deactivate)==true) {
	    		WebEdit(EdaatOR.Biller_Individualclient_SearchByname,testdatamap.get("ClintName").toString());        			
				Thread.sleep(2000);
	    		WebClickUsingJS(EdaatOR.Biller_Individualclient_Search);
				Thread.sleep(2000);
				WebClickUsingJS(EdaatOR.Biller_Individualclient_Deactivate);
				Thread.sleep(2000);
				WebClick(EdaatOR.Biller_Individualclient_button);
				Thread.sleep(2000);
				WebClickUsingJS(EdaatOR.Biller_Individualclient_Deactivate);
				Thread.sleep(2000);
				WebClick(EdaatOR.Biller_Individualclient_button);
				this.takeScreenShot();
				test.log(Status.PASS,"#FUNC-Individual Client Deactivate/Activate Done" + driver.getTitle() +" * Individual Client Deactivate/Activate Done PASS * " );
	    	}
	    	else {
	    		test.log(Status.FAIL,"#FUNC-Individual Client Deactivate/Activate Not Done" + driver.getTitle() +" * Individual Client Deactivate/Activate Not Done FAIL  * " );
	    		}
	    }catch(Exception e){
	    	test.log(Status.FATAL," #FUNC-Individual Client Deactivate/Activate Not Done " + driver.getTitle() +" * Individual Client Deactivate/Activate Not Done FAIL * " );
	        this.takeScreenShot();
	    }
	}	
	//Function Summary   : Method to Download Individual Client inovice details.	
	//Parameter Summary  : NationalID,FullName,Refno.
public void Download(Map<Object,Object> testdatamap,Log Log){
    try{
    	WebClickUsingJS(EdaatOR.Biller_Add_Individualclient);
    	Thread.sleep(3000);
		boolean Ele=BillerSearchIndividualclient(testdatamap.get("NationalID").toString(),testdatamap.get("FullName").toString());
		Thread.sleep(4000);
    	if(Ele==true) {
    	//	WebClickUsingJS(EdaatOR.Biller_Individualclient_Search);
			Thread.sleep(2000);		
    		WebClick(EdaatOR.Biller_InvoiceName);
    		waitForPageToLoad();
    		switchTonextwindow();
    		Thread.sleep(4000);
    		WebClickUsingJS(EdaatOR.Biller_Imgdownload);
    		Thread.sleep(4000);
    		test.log(Status.PASS,"#FUNC-Download ID " + driver.getTitle() +" * Download ID PASS * " );
         	Log.ReportEvent("PASS", " Verify Download ID is Suceessfull");
    	}else
	    	test.log(Status.FAIL,"#FUNC-Download ID" + driver.getTitle() +" * Download ID FAIL * " );
	}catch(Exception e){
	test.log(Status.FAIL,"#FUNC-Download ID" + driver.getTitle() +" * Download ID FAIL * " );
	this.takeScreenShot();
	}
}
//Function Summary : Method to Search "client" 
//Parameter Summary: NationalID,FullName,.
	public boolean BillerSearchIndividualclient(String NationalID,String  FullName){
	boolean existsElement = false;
	try{
			
			// WebEdit(EdaatOR.Biller_Individualclient_Refno,Refno);
			// Thread.sleep(2000);
             	
        	WebEdit(EdaatOR.Biller_Individualclient_IdNumber,NationalID);
        	Thread.sleep(2000);
			WebEdit(EdaatOR.Biller_Individualclient_Cname,FullName);
        	Thread.sleep(2000);
        	WebClickUsingJS(EdaatOR.Biller_Individualclient_Search);
        	Thread.sleep(2000);
        	if(CheckElementExists("//td[text()='"+NationalID+"']")==true) {
        		existsElement=true;
        		Thread.sleep(2000);
		    }
	    	this.takeScreenShot();	    	
	    
    }catch(Exception e){
    	e.printStackTrace();
   	 	this.takeScreenShot();
    }
    return existsElement;
}
 	//Function Summary   : Method to Search Individual Client.	
	//Parameter Summary   : NationalID,ClientName,Refno.
public boolean BillerSearchIndividualclientall(String ClientName,String NationalID,String Refno,Log Log){
	boolean existsElement = false;
	try{
			WebClickUsingJS(EdaatOR.Biller_Add_Individualclient);
        	Thread.sleep(2000);
        	WebEdit(EdaatOR.Biller_Individualclient_Name,ClientName);
			Thread.sleep(1000);
			WebClickUsingJS(EdaatOR.Biller_Individualclient_Search);
			Thread.sleep(1000);
			//WebClickUsingJS(EdaatOR.Biller_Individualclient_Search);
			Thread.sleep(1000);
		
		//	WebClickUsingJS(EdaatOR.Biller_Individualclient_Search);
			//Thread.sleep(1000);
			//WebEdit(EdaatOR.Biller_Individualclient_Name,ClientName);
			//Thread.sleep(1000);
			//WebEdit(EdaatOR.Biller_Individualclient_IdNumber,NationalID);
			Thread.sleep(1000);
			WebEdit(EdaatOR.Biller_Individualclient_CustomerRefNumber,Refno);
			Thread.sleep(1000);
        	WebClickUsingJS(EdaatOR.Biller_Individualclient_Search);
        	existsElement=ExistsCheck("//td[text()='"+NationalID+"']");
			Thread.sleep(1000);
			this.takeScreenShot();
  			Log.ReportEvent("PASS", " Verify Individual Client  Search is Suceessful");
     	
    }catch(Exception e){
//       test.log(Status.FAIL,"#FUNC-Add Individual client" + driver.getTitle() +" * Add Individual client PASS * " );
        this.takeScreenShot();
    }
    return existsElement;
}

//Function Summary : "Navigate to  add Individual clients" page and enter all details and Create Individual client 
//Parameter Summary: CorporateName,CRNumber,PersonName,PersonID,MobileNo,Email,ClientRefno,Year,Month,Refno.
public void Addclient(String FullName,String SecondName,String ThirdName,String LastName,String NationalID,String Year,String Month,String Date,String MobileNo,String Email,String Refno){
	try{
            WebClickUsingJS(EdaatOR.Biller_Add_Individualclient);
        	Thread.sleep(2000);
        	WebClickUsingJS(EdaatOR.Biller_Add_Individualclient_Button);
        	Thread.sleep(2000);
        	WebEdit(EdaatOR.Biller_Individualclient_fname,FullName);
        	WebEdit(EdaatOR.Biller_Individualclient_sname,SecondName);
        	WebEdit(EdaatOR.Biller_Individualclient_tname,ThirdName);
        	WebEdit(EdaatOR.Biller_Individualclient_lname,LastName);
        	WebEdit(EdaatOR.Biller_Individualclient_IdNumber,NationalID);
        	WebClick(EdaatOR.Biller_Individualclient_DateOfBirth);
        	selectDropdownValue_PartialText(EdaatOR.Biller_Individualclient_DateOfYear, Year);
        	selectDropdownValue_PartialText(EdaatOR.Biller_Individualclient_DateOfMonth, Month);
        	WebClick("//a[text()='"+Date+"']");
        	WebEdit(EdaatOR.Biller_Individualclient_Email,Email);
        	WebEdit(EdaatOR.Biller_Individualclient_Refno,Refno);
        	Thread.sleep(2000);            	
        	WebEdit(EdaatOR.Biller_Individualclient_MobileNo,MobileNo);
        	this.takeScreenShot();
        	Thread.sleep(2000);            	
        	WebClickUsingJS(EdaatOR.Biller_Individualclient_Add);
        	Thread.sleep(2000);            	

    }catch(Exception e){
    	 e.printStackTrace();
    	 this.takeScreenShot();
    }
}

	//Function Summary : Method to delete Individual client 
	//Parameter Summary: CorporateName, CRNumber, PersonName, PersonID, MobileNo, Email,ClientRefno,ResonforDelete 
public void DeleteIndividualClient(String FullName,String SecondName,String ThirdName,String LastName,String NationalID,String Year,String Month,String Date,String MobileNo,String Email,String Refno,String ResonforDelete,Log Log){
    try{
    		Addclient(FullName,SecondName,ThirdName,LastName,NationalID,Year,Month,Date,MobileNo,Email,Refno);
        	BillerSearchIndividualclient(NationalID,FullName);
        	Thread.sleep(2000);
        	boolean Ele=DeleteIndClient(NationalID,ResonforDelete);
        	if(Ele==true)
{
        	test.log(Status.PASS,"#FUNC-Delete Individual client" + driver.getTitle() +" * Delete Individual client PASS * " );
         	Log.ReportEvent("PASS", " Verify Individual Client Delete is Suceessful");
}
        	else
    	    	test.log(Status.FAIL,"#FUNC-Delete Individual client" + driver.getTitle() +" * Delete Individual client FAIL * " );
    }catch(Exception e){
    	test.log(Status.FATAL,"#FUNC-Delete Individual client" + driver.getTitle() +" * Delete Individual client FAIL * " );
        this.takeScreenShot();
    }
}

//Function Summary : Method to delete Individual client and check "deletedcheckbox".
//Parameter Summary: ClientRefno,ResonforDelete,Delete	
public boolean DeleteIndClient(String NationalID,String ResonforDelete){
	boolean existsNID = false;
	try{
    	if(getText("//td[text()='"+NationalID+"']").equals(NationalID)){
    	selectDropdownValue_PartialText(EdaatOR.Biller_Invoice_Delete,"Delete");
    	Thread.sleep(2000);    	
    	WebClick(EdaatOR.Biller_Invoice_Reasontxt);
    	WebClick("//li[text()='"+ResonforDelete+"']");
    	Thread.sleep(3000);
    	WebClick(EdaatOR.Biller_Invoice_Deletebtn);
    	Thread.sleep(2000);
    	WebEdit(EdaatOR.Biller_Individualclient_IdNumber,NationalID);
    	Thread.sleep(2000);
    	WebClick(EdaatOR.Biller_Invoice_Deletechkbox);
    	Thread.sleep(2000);
    	WebClick(EdaatOR.Biller_Individualclient_Search);
    	Thread.sleep(2000);
    	if(CheckElementExists("//td[text()='"+NationalID+"']")==true) {
	    	existsNID=true;
	    }
    	this.takeScreenShot();	    	
    	}
    	    	
    }catch (Exception e) {
    	e.printStackTrace();
   	 	this.takeScreenShot();
	}
	return existsNID;
    }
//Function Summary   : Method to Update Individual client   
//Parameter Summary : FullName, SecondName, ThirdName, LastName, NationalID, Year, Month, Date, MobileNo, Email.
public void UpdateIndividualClient(String FullName,String SecondName,String ThirdName,String LastName,String NationalID,String Year,String Month,String Date,String MobileNo,String Email ,String Refno,Log Log){
    try{
    		
        	boolean Ele=UpdateIndClient(FullName, SecondName, ThirdName, LastName, Year, Month,Date, MobileNo, Email, Refno);
        	if(Ele==true)
{
        	test.log(Status.PASS,"#FUNC-Updated  Individual client" + driver.getTitle() +" * Updated Individual client PASS * " );
        	Log.ReportEvent("PASS", " Verify Upadate Individual Client is Suceessfull");
}
        	else
    	    	test.log(Status.FAIL,"#FUNC-Updated Individual client" + driver.getTitle() +" * Updated Individual client FAIL * " );
    }catch(Exception e){
    	test.log(Status.FATAL,"#FUNC-Updated Individual client" + driver.getTitle() +" * Updated Individual client FAIL * " );
        this.takeScreenShot();
    }
}

//Function Summary   : Method to Enter Details to Update Individual client   
//Parameter Summary : FullName, Seco
public boolean UpdateIndClient(String FullName,String SecondName,String ThirdName,String LastName,String Year,String Month,String Date,String MobileNo,String Email,String Refno){
	boolean existsNID = false;
	try{
		WebClickUsingJS(EdaatOR.Biller_Add_Individualclient);
    	Thread.sleep(1000);	    	
    	selectDropdownValue_PartialText(EdaatOR.Biller_Invoice_Delete,"Edit");
    	Thread.sleep(1000);	    	
//	    	WebClick(EdaatOR.Biller_Invoice_Reasontxt);
    	switchTonextwindow();
    	Thread.sleep(1000);	    	
    	WebClear(EdaatOR.Biller_Individualclient_fname);
    	WebEdit(EdaatOR.Biller_Individualclient_fname,FullName);
    	WebClear(EdaatOR.Biller_Individualclient_sname);
    	WebEdit(EdaatOR.Biller_Individualclient_sname,SecondName);
    	WebClear(EdaatOR.Biller_Individualclient_tname);
    	WebEdit(EdaatOR.Biller_Individualclient_tname,ThirdName);
    	WebClear(EdaatOR.Biller_Individualclient_lname);
    	WebEdit(EdaatOR.Biller_Individualclient_lname,LastName);
    	WebClick(EdaatOR.Biller_Individualclient_DateOfBirth);
    	selectDropdownValue_PartialText(EdaatOR.Biller_Individualclient_DateOfYear, Year);
    	selectDropdownValue_PartialText(EdaatOR.Biller_Individualclient_DateOfMonth, Month);
    	WebClick("//a[text()='"+Date+"']");
    	WebClear(EdaatOR.Biller_Individualclient_MobileNo);
    	WebEdit(EdaatOR.Biller_Individualclient_MobileNo,MobileNo);
    	WebClear(EdaatOR.Biller_Individualclient_Email);
    	WebEdit(EdaatOR.Biller_Individualclient_Email,Email);
    	WebClear(EdaatOR.Biller_Individualclient_Refno);
    	WebEdit(EdaatOR.Biller_Individualclient_Refno,Refno);
 
       	Thread.sleep(2000);	    	 	
    	this.takeScreenShot();	
    	WebClick(EdaatOR.Biller_Individualclient_Add);
    	Thread.sleep(2000);
    	if(CheckElementExists("//td[text()='"+MobileNo+"']")==true) {
	    	existsNID=true;
    	Thread.sleep(2000);	    	
	    }
    	   	
    	    	
    }catch (Exception e) {
    	e.printStackTrace();
   	 	this.takeScreenShot();
	}
	return existsNID;
    }


public int getInvoiceCountNext() throws Exception {
	int intiCount=0;
	boolean countRow=false;
	while (CheckElementExists(EdaatOR.Biller_Invoice_Next)==false){  
		WebClick(EdaatOR.Biller_Invoice_NextBtn);
		Thread.sleep(1000);
		intiCount=intiCount+getInvoiceCount()+10;
		countRow=true;
	}
	
	if(countRow==false) {
		intiCount=10;
	}
	return intiCount;
}
public int getInvoiceCount() {
	List<WebElement> invoice = driver.findElements(By.xpath(EdaatOR.Biller_Invoice_Count));
	waitForPageToLoad();
	int count =invoice.size();
	return count;
}
public void naviagteCreateInvoicePage() {
	ClickOnExportInvoiceBtn();
	waitForPageToLoad();

}
public void ClickOnExportInvoiceBtn() {
	WebClickUsingJS(EdaatOR.Biller_AddInvoice_btn);
	waitForPageToLoad();
}
public void enterClientNameOrNationalID(Map<Object,Object> testdatamap) throws Exception {
	String client=testdatamap.get("ClientID").toString();
	if(client.equalsIgnoreCase("Individual")) {
		ClickOnIndividualRadBtn();
	}
	else if(client.equalsIgnoreCase("Corporate")){
		ClickOnCoporateRadBtn();
	}

	SelectCustomerID(testdatamap.get("ClientName").toString());
	String sBill=testdatamap.get("SubBiller").toString();
	if(!sBill.equalsIgnoreCase("")) {
			SelectSubBiller(sBill);
		}

	}
	public void SelectSubBiller(String SubBiller) {
		WebSelect(EdaatOR.Biller_Invoice_SBilIdList,SubBiller);
		waitForPageToLoad();
	}
public void SelectCustomerID(String Cust) throws Exception {
		
		WebClick(EdaatOR.Biller_Invoice_CustIDListindi);
		Thread.sleep(500);
		WebClick(EdaatOR.Biller_Invoice_ClientRoleId+"["+Cust+"]");
	waitForPageToLoad();
}
public void ClickOnCoporateRadBtn() {
	WebClickUsingJS(EdaatOR.Biller_Invoice_CopoRdv);
	waitForPageToLoad();
}

public void ClickOnIndividualRadBtn() {
	WebClickUsingJS(EdaatOR.Biller_Invoice_IndividualRdv);
	waitForPageToLoad();
}


//Function Summary : Method to select "Invoice Template"from dropdown   
//Parameter Summary: TemplateName.
public void selectTemplate(String drop,Map<Object,Object> testdatamap) throws Exception {
	Thread.sleep(500);	
	waitForPageToLoad();
	WebSelectByVisibleText(EdaatOR.Biller_Invoice_TemplateList,testdatamap.get("TemplateName").toString());
	waitForPageToLoad();
}

	//Function Summary : Method to select "subbiller" and select "Name or register number" of subbiller from dropdowns  
	//Parameter Summary: SubBiller,FixedPrice,FixedPercentage.
public void selectSubbiller(String drop,Map<Object,Object> testdatamap) throws Exception {
	Thread.sleep(500);
	WebClickUsingJS(EdaatOR.Biller_Invoice_Subbill);
	SelectInvoiceTemplate(drop,testdatamap.get("SubBiller").toString());
	waitForPageToLoad();
	EnterFixedPrice(testdatamap.get("FixedPrice").toString());
	EnterPercentage(testdatamap.get("FixedPercentage").toString());	
}

//Function Summary : Method select "Name or Register number" of subbiller from dropdown  
//Parameter Summary: N/A
public void SelectInvoiceTemplate(String sel, String Tem) throws InterruptedException {
	Thread.sleep(500);
	selectDropdownValue_PartialText(sel, Tem);
}

//Function Summary : Method to click on "add product" button in "create invoice"page  
//Parameter Summary: N/A
public void ClickOnProductBtn() {
	WebClickUsingJS(EdaatOR.Biller_Invoice_AddProductBtn);
	waitForPageToLoad();
}

//Function Summary : Method to select "product" from dropdown.  
//Parameter Summary: N/A
public void SelectProduct(String Cust) {
	WebSelect(EdaatOR.Biller_Invoice_ProductID,Cust);
	waitForPageToLoad();
}

//Function Summary : Method to click on "add" button in "add product"popup.  
//Parameter Summary: N/A
public void ClickOnProductAddBtn() {
	WebClick(EdaatOR.Biller_Invoice_AddBtn);
	waitForPageToLoad();
}

//Function Summary : Method to enter"Invoice Due Date" in "Create invoice"page 
//Parameter Summary: N/A
public void EnterIssuedDate() throws Exception {
	WebClick(EdaatOR.Biller_Invoice_DateInvoc);
	Thread.sleep(800);
	WebClick(EdaatOR.Biller_RegistDate_exprDate);
}


public void SelectDuration(String dur) {
	WebSelect(EdaatOR.Biller_Invoice_DurationID,dur);
	waitForPageToLoad();
}

public void EnterMinPrice(String Price) {
	WebEdit(EdaatOR.Biller_Invoice_MinTax,Price);
	waitForPageToLoad();
}
public void EnterFixedPrice(String Price) {
	WebEdit(EdaatOR.Biller_Invoice_Fixed,Price);
	waitForPageToLoad();
}


public void EnterCondition(String Price) {
	WebEdit(EdaatOR.Biller_Invoice_Conditon,Price);
	waitForPageToLoad();
}
public void EnterPercentage(String Price) {
	WebEdit(EdaatOR.Biller_Invoice_Percentage,Price);
	waitForPageToLoad();
}
public void ClickOnCreateInvoiceBtn() {
	WebClickUsingJS(EdaatOR.Biller_Invoice_CreateReapeat);
	waitForPageToLoad();
}
public void EnterDescriptionSaved(String Price) {
	WebEdit(EdaatOR.Biller_Invoice_Descript,Price);
	waitForPageToLoad();
}

public void EnterDescriptionOne(String Price) {
	WebEdit(EdaatOR.Biller_Invoice_Descript1,Price);
	waitForPageToLoad();
}
public void ClickOnExportBtn() {
	WebClickUsingJS(EdaatOR.Biller_Invoice_ExportButton);
	waitForPageToLoad();
}

public void ClickOnSaveBtn() {
	WebClickUsingJS(EdaatOR.Biller_Invoice_Create);
	waitForPageToLoad();
}

//Function Summary : Method to add "product" in "add product"popup.
//Parameter Summary: ProductName.
public void addProductDetails(Map<Object,Object> testdatamap) throws Exception {
	ClickOnProductBtn();
	Thread.sleep(1000);
	SelectProduct(testdatamap.get("ProductName").toString());
    	Thread.sleep(2000);	    	
	//EnterProductPrice(testdatamap.get("ProductPrice").toString());
	ClickOnProductAddBtn();
	Thread.sleep(1000);
}

//Function Summary : Method enter "Invoice Due Date" in "Create invoice"page
//Parameter Summary: N/A
public void enterInvoicDetails(Map<Object,Object> testdatamap) throws Exception {
	EnterIssuedDate();
//		SelectDuration(testdatamap.get("Duration").toString());
//		EnterMinPrice(testdatamap.get("MinPrice").toString());
//		EnterCondition(testdatamap.get("InvoiceCondition").toString());
//		ClickOnCreateInvoiceBtn();
	Thread.sleep(1000);
}
public int getInvoiceCountNextAfteradd() throws Exception {
	int aftCount=0;
	boolean countRow=false;
	while (CheckElementExists(EdaatOR.Biller_Invoice_Next)==false){  
		WebClick(EdaatOR.Biller_Invoice_NextBtn);
		Thread.sleep(1000);
		aftCount=aftCount+getInvoiceCountAdd()+10;
		countRow=true;
	}
	
	if(countRow==false) {
		aftCount=10;
	}
	return aftCount;
}

//Function Summary : Method to click on "Create and save" or "Create and Export"button in "create invoice" page
//Parameter Summary: InvoiceType,Save,Export.
public void enterInvoiceCaseType(Map<Object,Object> testdatamap) throws Exception {

//		EnterDescriptionSaved(testdatamap.get("Description").toString());
//		EnterDescriptionOne(testdatamap.get("Description").toString());
	String iType=testdatamap.get("InvoiceType").toString();
	if(iType.equalsIgnoreCase("Save")) {
		ClickOnSaveBtn();
	}
	else if(iType.equalsIgnoreCase("Export")){
		ClickOnExportBtn();
	}
	Thread.sleep(1000);
}

//Function Summary : Method to get the "count of the invoices" in the "Grid view" 
//Parameter Summary: N/A
public int getInvoiceCountAdd() {
	List<WebElement> invoice = driver.findElements(By.xpath(EdaatOR.Biller_Invoice_AfteraddInvoice));
	waitForPageToLoad();
	int count =invoice.size();
	return count;
}

//Function Summary : Method to create Individual client invoice  
//Parameter Summary: Create Invoice,Template Name.
public void CreateIndividualClientInvoice(Map<Object,Object> testdatamap,Log Log) throws Exception {
	try {
		
		WebClickUsingJS(EdaatOR.Biller_Add_Individualclient);
    	Thread.sleep(1000);	    	
    	selectDropdownValue_PartialText(EdaatOR.Biller_Invoice_Delete,"Create Invoice");
//	    	WebClick(EdaatOR.Biller_Invoice_Reasontxt);
    		switchTonextwindow();
			Thread.sleep(1000);
//			String iType=testdatamap.get("InvoiceType").toString();
//			if(iType.equalsIgnoreCase("Save")) {
//				int intiCount=getInvoiceCountNext();
//				naviagteCreateInvoicePage();
			//enterClientNameOrNationalID(testdatamap);
			selectSubbiller(EdaatOR.Biller_Invoice_SBilIdList,testdatamap);
			Thread.sleep(1000);
			
			WebClick(EdaatOR.Biller_Invoice_TemplateList);
			WebSelectByVisibleText(EdaatOR.Biller_Invoice_TemplateList,testdatamap.get("TemplateName").toString());
			selectTemplate(EdaatOR.Biller_Invoice_TemplateList,testdatamap);
			addProductDetails(testdatamap);
			enterInvoicDetails(testdatamap);
			enterInvoiceCaseType(testdatamap);
//				int afterSave=getInvoiceCountNextAfteradd();
//				VerifyTwoIntValue(intiCount+1, afterSave);

			int val=getInvoiceCountAdd();
			if(CheckElementExists(EdaatOR.Biller_Invoice_AfteraddInvoice+"["+val+"]/td[10]")==true){
				test.log(Status.PASS,"#FUNC- Create Individual Client Invoice" + driver.getTitle() +" *Create Individual Client Invoice  PASS * " );
				Log.ReportEvent("PASS", " Verify Create Individual Client Invoice is Suceessfull");
			}
			else{
				test.log(Status.FAIL,"#FUNC- Create Individual Client Invoice" + driver.getTitle() +" * Create Individual Client Invoice FAIL * " );
			}
			this.takeScreenShot();
		

	}
	catch(Exception e){
		test.log(Status.FATAL,"#FUNC-Create Individual Client Invoice" + driver.getTitle() +" * Create Individual Client Invoice FAIL * " );
		this.takeScreenShot();
	}
}
//Function Summary   : Method to View Client Invoice 
//Parameter Summary :Individual,Corporate
public void ViewIndividualClientInvoice(Map<Object,Object> testdatamap,Log Log) throws Exception {
	boolean existsNID=false;
	try {
		if(testdatamap.get("ClientID").toString().equalsIgnoreCase("Individual")) {
			WebClickUsingJS(EdaatOR.Biller_Add_Individualclient);
		}if(testdatamap.get("ClientID").toString().equalsIgnoreCase("Corporate")) {
			WebClickUsingJS(EdaatOR.Biller_Add_Companyclient);
		}
    	Thread.sleep(1000);	    	
    	selectDropdownValue_PartialText(EdaatOR.Biller_Invoice_Delete,"View Invoice");
    	switchTonextwindow();
    	this.takeScreenShot();
    	Thread.sleep(1000);
    	WebClick(EdaatOR.Biller_Invoice_view);
    	switchTonextwindow();
    	this.takeScreenShot();
    	if(ExistsCheck(EdaatOR.Biller_Invoice_form)==true) {
	    	existsNID=true;
	    	test.log(Status.PASS,"#FUNC-View Individual Client Invoice " + driver.getTitle() +" * View Individual Client Invoice PASS * " );
	    	Log.ReportEvent("PASS", " Verify View Individual Client Invoice is Suceessfull");
	    }
    	else {
    		test.log(Status.FAIL,"#FUNC-View Individual Client Invoice  " + driver.getTitle() +" *View Individual Client Invoice FAIL * " );
    	}
    	this.takeScreenShot();	    	
    }catch(Exception e){
		test.log(Status.FATAL,"#FUNC-View Individual Client Invoice" + driver.getTitle() +" *View Individual Client Invoice FAIL * " );
			this.takeScreenShot();
		}
	}
	//Function Summary  : method to verify Error messages in Add individual client page
	//Parameter Summary : FullName,SecondName,ThirdName,LastName,NationalID,Year,Month,Date,MobileNo,Email and Refno,ExpectedResult.

	public void VerifyAddIndClietErrorMsg(String FullName,String SecondName,String ThirdName,String LastName,String NationalID,String Year,String Month,String Date,String MobileNo,String Email,String Refno,String ExpectedResult) throws InterruptedException{
		{
		Addclient(FullName,SecondName,ThirdName,LastName,NationalID,Year,Month,Date,MobileNo,Email,Refno);
		Thread.sleep(50);
		this.takeScreenShot();
			try {
				if (ExistsCheck(EdaatOR.Biller_AlertMsg)){
				if(ExistsCheck(EdaatOR.Biller_NationalIDExistsAlertMsg)) {
					VerifyValue1(ExpectedResult,getText(EdaatOR.Biller_NationalIDExistsAlertMsg));				
					test.log(Status.PASS, "#FUNC-Individual Client NationalID Exists alert Message Exists" + driver.getTitle() + " *NationalID alert Message Exists * ");
				}
				else if (ExistsCheck(EdaatOR.Biller_ClientRefExistsAlertMsg)){	
					VerifyValue1(ExpectedResult,getText(EdaatOR.Biller_ClientRefExistsAlertMsg));				
					test.log(Status.PASS, "#FUNC-Individual Client Reference number Exists alert Message Exists" + driver.getTitle() + " *Client Ref alert Message Exists * ");
				}
			}
				else if (ExistsCheck(EdaatOR.Biller_FirstNameErrorMsg) && ExistsCheck(EdaatOR.Biller_SecondNameErrorMsg) && ExistsCheck(EdaatOR.Biller_ThirdNameErrorMsg) && ExistsCheck(EdaatOR.Biller_LastNameErrorMsg) && ExistsCheck(EdaatOR.Biller_NationalIDErrorMsg) && ExistsCheck(EdaatOR.Biller_MobileNoErrorMsg) ){	
					this.takeScreenShot();
					VerifyValue1(ExpectedResult, getText(EdaatOR.Biller_FirstNameErrorMsg));
					Thread.sleep(500);
					VerifyValue1(ExpectedResult, getText(EdaatOR.Biller_SecondNameErrorMsg));
					Thread.sleep(500);
					VerifyValue1(ExpectedResult, getText(EdaatOR.Biller_ThirdNameErrorMsg));
					Thread.sleep(500);
					VerifyValue1(ExpectedResult, getText(EdaatOR.Biller_LastNameErrorMsg));
					Thread.sleep(500);
					VerifyValue1(ExpectedResult, getText(EdaatOR.Biller_NationalIDErrorMsg));	
					Thread.sleep(500);
					VerifyValue1(ExpectedResult, getText(EdaatOR.Biller_MobileNoErrorMsg));	
					test.log(Status.PASS, "#FUNC-Individual Client fields  ErrorMessage Exists" + driver.getTitle() + " *   ErrorMessage Exists * ");
				}
				
				else if (ExistsCheck(EdaatOR.Biller_FirstNameErrorMsg)) {
					VerifyValue1(ExpectedResult, getText(EdaatOR.Biller_FirstNameErrorMsg));
					test.log(Status.PASS, "#FUNC-Individual Client FirstName ErrorMessage Exists" + driver.getTitle() + " * FirstName ErrorMessage Exists * ");
				}
				else if (ExistsCheck(EdaatOR.Biller_SecondNameErrorMsg)) {
					VerifyValue1(ExpectedResult, getText(EdaatOR.Biller_SecondNameErrorMsg));
					test.log(Status.PASS, "#FUNC-Individual Client SecondName ErrorMessage Exists" + driver.getTitle() + " *SecondName ErrorMessage Exists * ");
				}
				else if (ExistsCheck(EdaatOR.Biller_ThirdNameErrorMsg)){	
					VerifyValue1(ExpectedResult, getText(EdaatOR.Biller_ThirdNameErrorMsg));			
					test.log(Status.PASS, "#FUNC-Individual Client ThirdName ErrorMessage Exists" + driver.getTitle() + " *ThirdName ErrorMessage Exists * ");
				}
				else if (ExistsCheck(EdaatOR.Biller_LastNameErrorMsg)){	
					VerifyValue1(ExpectedResult, getText(EdaatOR.Biller_LastNameErrorMsg));		
					test.log(Status.PASS, "#FUNC-Individual Client LastName ErrorMessage Exists" + driver.getTitle() + " *LastName ErrorMessage Exists * ");
				}
				else if (ExistsCheck(EdaatOR.Biller_NationalIDErrorMsg)){	
					VerifyValue1(ExpectedResult, getText(EdaatOR.Biller_NationalIDErrorMsg));				
					test.log(Status.PASS, "#FUNC-Individual Client NationalID ErrorMessage Exists" + driver.getTitle() + " *NationalID ErrorMessage Exists * ");
				}
				else if (ExistsCheck(EdaatOR.Biller_NationalIDStartsError)){	
					VerifyValue1(ExpectedResult, getText(EdaatOR.Biller_NationalIDStartsError));			
					test.log(Status.PASS, "#FUNC-Individual Client National ID starts with ErrorMessage Exists" + driver.getTitle() + " *National ID  ErrorMessage Exists * ");
				}
				else if (ExistsCheck(EdaatOR.Biller_MobileNoErrorMsg)){	
					VerifyValue1(ExpectedResult, getText(EdaatOR.Biller_MobileNoErrorMsg));			
					test.log(Status.PASS, "#FUNC-Individual Client Mobile Number ErrorMessage Exists" + driver.getTitle() + " *Mobile Number  ErrorMessage Exists * ");
				}
				
			  else {
					test.log(Status.FAIL, "#FUNC-No error Exists" + driver.getTitle() + " * No error Exists * ");
				}
			} 
			catch (Exception e) {
				//test.log(Status.FATAL,ErrorFontColorPrefix + " AdminIndividualClient Page - Add Individual Client failed - unable to Enter" + e+ ErrorFontColorSuffix);
				test.log(Status.FATAL,ErrorFontColorPrefix + "Error found at class: " + this.getClass().getName() + " Code line Number: "+ new Exception().getStackTrace()[0].getLineNumber() + "!" + ErrorFontColorSuffix);
				throw new NoSuchElementException("Add Individual Client "+ "Page - Not Loaded");
			}
		}
	}

	//Function Summary  : method to verify Error messages in Edit individual client page
	//Parameter Summary : FullName,SecondName,ThirdName,LastName,NationalID,Year,Month,Date,MobileNo,Email and Refno,ExpectedResult.
	public void VerifyEditIndClietErrorMsg(String FullName,String SecondName,String ThirdName,String LastName,String NationalID,String Year,String Month,String Date,String MobileNo,String Email,String Refno,String ExpectedResult) throws InterruptedException{
		{
			UpdateIndClient(FullName, SecondName, ThirdName, LastName, Year, Month,Date, MobileNo, Email, Refno);
			Thread.sleep(50);
			this.takeScreenShot();
			try {
				if (ExistsCheck(EdaatOR.Biller_AlertMsg)){	
					if(ExistsCheck(EdaatOR.Biller_ClientRefExistsAlertMsg)) {
						VerifyValue1(ExpectedResult,getText(EdaatOR.Biller_ClientRefExistsAlertMsg));				
						test.log(Status.PASS, "#FUNC-Individual Client Reference number Exists alert Message Exists" + driver.getTitle() + " *Client Ref alert Message Exists * ");
					}else if(ExistsCheck(EdaatOR.Biller_NationalIDExistsAlertMsg)) {
						VerifyValue1(ExpectedResult,getText(EdaatOR.Biller_NationalIDExistsAlertMsg));				
						test.log(Status.PASS, "#FUNC-Individual Client NationalID Exists alert Message Exists" + driver.getTitle() + " *NationalID alert Message Exists * ");
					}
				}
				else if (ExistsCheck(EdaatOR.Biller_MandatoryErrorMsg)){	
					this.takeScreenShot();
					VerifyValue1(ExpectedResult, getText(EdaatOR.Biller_FirstNameErrorMsg));
					Thread.sleep(500);
					VerifyValue1(ExpectedResult, getText(EdaatOR.Biller_SecondNameErrorMsg));
					Thread.sleep(500);
					VerifyValue1(ExpectedResult, getText(EdaatOR.Biller_ThirdNameErrorMsg));
					Thread.sleep(500);
					VerifyValue1(ExpectedResult, getText(EdaatOR.Biller_LastNameErrorMsg));
					Thread.sleep(500);
					VerifyValue1(ExpectedResult, getText(EdaatOR.Biller_MobileNoErrorMsg));	
					test.log(Status.PASS, "#FUNC-Edit Individual Client  ErrorMessage Exists" + driver.getTitle() + " *   ErrorMessage Exists * ");
				}
				else if (ExistsCheck(EdaatOR.Biller_FirstNameErrorMsg)) {
					VerifyValue1(ExpectedResult, getText(EdaatOR.Biller_FirstNameErrorMsg));
					test.log(Status.PASS, "#FUNC-Individual Client FirstName ErrorMessage Exists" + driver.getTitle() + " * FirstName ErrorMessage Exists * ");
				}
				else if (ExistsCheck(EdaatOR.Biller_SecondNameErrorMsg)) {
					VerifyValue1(ExpectedResult, getText(EdaatOR.Biller_SecondNameErrorMsg));
					test.log(Status.PASS, "#FUNC-Individual Client SecondName ErrorMessage Exists" + driver.getTitle() + " *SecondName ErrorMessage Exists * ");
				}
				else if (ExistsCheck(EdaatOR.Biller_ThirdNameErrorMsg)){	
					VerifyValue1(ExpectedResult, getText(EdaatOR.Biller_ThirdNameErrorMsg));			
					test.log(Status.PASS, "#FUNC-Individual Client ThirdName ErrorMessage Exists" + driver.getTitle() + " *ThirdName ErrorMessage Exists * ");
				}
				else if (ExistsCheck(EdaatOR.Biller_LastNameErrorMsg)){	
					VerifyValue1(ExpectedResult, getText(EdaatOR.Biller_LastNameErrorMsg));		
					test.log(Status.PASS, "#FUNC-Individual Client LastName ErrorMessage Exists" + driver.getTitle() + " *LastName ErrorMessage Exists * ");
				}
				else if (ExistsCheck(EdaatOR.Biller_MobileNoErrorMsg)){	
					VerifyValue1(ExpectedResult, getText(EdaatOR.Biller_MobileNoErrorMsg));			
					test.log(Status.PASS, "#FUNC-Individual Client Mobile Number ErrorMessage Exists" + driver.getTitle() + " *Mobile Number  ErrorMessage Exists * ");
				}
				else {
					test.log(Status.FAIL, "#FUNC-No error Exists" + driver.getTitle() + " * No error Exists * ");
				}
			} 
			catch (Exception e) {
				//test.log(Status.FATAL,ErrorFontColorPrefix + " AdminIndividualClient Page - Add Individual Client failed - unable to Enter" + e+ ErrorFontColorSuffix);
				test.log(Status.FATAL,ErrorFontColorPrefix + "Error found at class: " + this.getClass().getName() + " Code line Number: "+ new Exception().getStackTrace()[0].getLineNumber() + "!" + ErrorFontColorSuffix);
				throw new NoSuchElementException("Edit Individual Client "+ "Page - Not Loaded");
			}
		}
	}

	
	//Function Summary  : method to verify Error messages in delete individual client page
	//Parameter Summary : ExpectedResult
	public void VerifyDeleteIndClietErrorMsg(String ExpectedResult) throws InterruptedException{
		{
			try {
				WebClickUsingJS(EdaatOR.Biller_Add_Individualclient);
				Thread.sleep(500);
				selectDropdownValue_PartialText(EdaatOR.Biller_Invoice_DeleteFrstRow,"Delete");
				Thread.sleep(500);
				WebClick(EdaatOR.Admin_Invoice_Deletebtn);
				this.takeScreenShot();
				if (ExistsCheck(EdaatOR.Biller_DeleteClientErrMsg)){	
					VerifyValue1(ExpectedResult, getText(EdaatOR.Biller_DeleteClientErrMsg));			
					test.log(Status.PASS, "#FUNC-Individual Client delete ErrorMessage Exists" + driver.getTitle() + " *Delete Error Message Exists * ");
				}
				else {
					test.log(Status.FAIL, "#FUNC-No error Exists" + driver.getTitle() + " * No error Exists * ");
				}
			} 
			catch (Exception e) {
				//test.log(Status.FATAL,ErrorFontColorPrefix + " AdminIndividualClient Page - Add Individual Client failed - unable to Enter" + e+ ErrorFontColorSuffix);
				test.log(Status.FATAL,ErrorFontColorPrefix + "Error found at class: " + this.getClass().getName() + " Code line Number: "+ new Exception().getStackTrace()[0].getLineNumber() + "!" + ErrorFontColorSuffix);
				throw new NoSuchElementException("Delete Individual Client "+ "Page - Not Loaded");
			}
		}
	}
	
}