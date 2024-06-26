package com.azmqalabs.edaattestautomation.apppages.collectionofpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import com.aventstack.extentreports.ExtentTest;
import com.azmqalabs.edaattestautomation.apppages.biller.pages.*;
import com.azmqalabs.edaattestautomation.common.DBConnect;
import com.azmqalabs.edaattestautomation.common.uielement.fieldDecorator;
import com.azmqalabs.edaattestautomation.testscripts.biller.BillerSettingsPricingListSearch;
import com.azmqalabs.edaattestautomation.apppages.Client.pages.*;
import com.azmqalabs.edaattestautomation.apppages.admin.pages.*;

public class Pages{

	
	private WebDriver driver;
	private ExtentTest test;
	public BillerLoginPage BillerLoginPage;
	public DBConnect DBConnect;
	public InvokeApplicationPage InvokeApplicationPage;
	public BillerIndividualClientPage BillerIndividualClientPage;
	public BillerSubbillerPage BillerSubbillerPage;
	public BillerSettingsPage BillerSettingsPage;
	public BillerSignUpPage BillerSignUpPage;
	public BillerCorporatePage BillerCorporatePage;
	public BillerReceivablesExportedbillsPage BillerReceivablesExportedbillsPage;
	public BillerSettingsDiscountPage BillerSettingsDiscountPage;
	public BillerUserMngUserListPage BillerUserMngUserListPage;
	public BillerSystemMangementPage BillerSystemMangementPage;
	public BillerAPIdocumentPage BillerAPIdocumentPage;
	public AdminCorporatePage AdminCorporatePage;
	public AdminIndividualClientPage AdminIndividualClientPage;
	public AdminInvokeApplicationPage AdminInvokeApplicationPage;
	public AdminLoginPage AdminLoginPage;
	public AdminReceivablesExportedbillsPage AdminReceivablesExportedbillsPage;
	public AdminAPIDocumentPage AdminAPIDocumentPage;
	public AdminSettingsDiscountPage AdminSettingsDiscountPage;
	public AdminReportsReceivablesReportsPage AdminReportsReceivablesReportsPage;
	public AdminSystemManagementWathiqIntegrationPage AdminSystemManagementWathiqIntegrationPage;
	public AdminSettingsContentManagementPage AdminSettingsContentManagementPage;
	public AdminSettingsPage AdminSettingsPage;
	public AdminSubbillerPage AdminSubbillerPage;
	public AdminSystemManagementSamaIntegrationPage AdminSystemManagementSamaIntegrationPage;
	public AdminSystemMangement AdminSystemMangement;
	public AdminUserMngUserListPage AdminUserMngUserListPage;
	public AdminSignUpPage AdminSignUpPage;
	public AdminNotApprovedBillerManagement AdminNotApprovedBillerManagement;
	public AdminApprovedBillerManagement AdminApprovedBillerManagement;
	public AdminTrackerBillerManagementPage AdminTrackerBillerManagementPage;
	public AdminSystemMangementContactsPage AdminSystemMangementContactsPage;
	public AdminSystemMngCorporateclientMngpage AdminSystemMngCorporateclientMngpage;
	public AdminSystemMgmIndividualClientPage AdminSystemMgmIndividualClientPage;
	public AdminSystemMngDistributionPage AdminSystemMngDistributionPage;
	public AdminSystemMgmBillersCategoriesMngpage AdminSystemMgmBillersCategoriesMngpage;
	public AdminSystemMgmSubBillersPage AdminSystemMgmSubBillersPage;
	public AdminSettingsPricingListPage AdminSettingsPricingListPage;
	public AdminUserMngGrpsMngPage AdminUserMngGrpsMngPage;
	public AdminReportsAdminReportsPage  AdminReportsAdminReportsPage;
	public AdminReceivablesBalancePage  AdminReceivablesBalancePage;
	public AdminClientsImportClientDataPage AdminClientsImportClientDataPage ;
	public AdminReceivablesPaidOutsideEdaatPage AdminReceivablesPaidOutsideEdaatPage;
	public AdminSettingTermsManagementPage AdminSettingTermsManagementPage;
	public AdminMyAccountPage AdminMyAccountPage;
	public AdminPayablesIncomingBillsPage AdminPayablesIncomingBillsPage;
	
	
	public MyBillsPage MyBillsPage;
	public BillerUserGroupManagementPage BillerUserGroupManagementPage;
	public BillerDashboardPages BillerDashboardPages;
	public BillerPayablesPage BillerPayablesPage;
	public BillerImportClientdataPage BillerImportClientdataPage;
	public BillerSettingPricelistPage BillerSettingPricelistPage;
	public BillerMyAccountNotificationSettingPage BillerMyAccountNotificationSettingPage;
	public BillerSettingProductsManagementPage BillerSettingProductsManagementPage;
	public BillerReportsReceivablesReportPage BillerReportsReceivablesReportPage;
	public BillerSettingTermsManagementPage billerSettingTermsManagementPage;
	public BillerSettingTermsManagementPage BillerSettingTermsManagementPage;
	public BillerSettingsInvoicesTemplatesPage BillerSettingsInvoicesTemplatesPage;
	public BillerSettingsPaidOutsideEDAATBillsPage BillerSettingsPaidOutsideEDAATBillsPage;
	public BillerReceivablesBalancePage BillerReceivablesBalancePage;
	public BillerReceivablesPaidOutsideEdaatPage BillerReceivablesPaidOutsideEdaatPage;
	public BillerReportReceivableReportforSuperBillerPage BillerReportReceivableReportforSuperBillerPage;
	public ClientSignUpPage ClientSignUpPage;
	public ClientLoginPage ClientLoginPage;
	public ClientReportsClientAccountStatementPage ClientReportsClientAccountStatementPage;
	public ClientPayablesIncomingBillsPage ClientPayablesIncomingBillsPage;
	public ClientMyAccountPage ClientMyAccountPage;
	public ClientPayablesInstallmentsBillsPage ClientPayablesInstallmentsBillsPage;
	public BillerReportsCustomReconciliationReportPage BillerReportsCustomReconciliationReportPage;
	public BillerReportsDailyReconciliationReportSadadPage BillerReportsDailyReconciliationReportSadadPage;
	public Pages(WebDriver driver,ExtentTest test){
		this.driver=driver;
		this.test=test;
		PageFactory.initElements(new fieldDecorator(driver,test), this);
		DBConnect= new DBConnect(driver,test);
		InvokeApplicationPage = new InvokeApplicationPage(driver,test);
		BillerLoginPage = new  BillerLoginPage(driver,test);
		BillerIndividualClientPage = new  BillerIndividualClientPage(driver,test);
		BillerSettingsPage =new  BillerSettingsPage(driver,test);
		BillerSubbillerPage=new  BillerSubbillerPage(driver,test);
		BillerSignUpPage=new  BillerSignUpPage(driver,test);
		BillerCorporatePage= new BillerCorporatePage(driver,test);
		BillerReceivablesExportedbillsPage= new BillerReceivablesExportedbillsPage(driver,test);
		BillerSettingsDiscountPage= new BillerSettingsDiscountPage(driver,test);
		BillerUserMngUserListPage= new BillerUserMngUserListPage(driver,test);
		BillerSystemMangementPage=new BillerSystemMangementPage(driver, test);
		AdminCorporatePage=new AdminCorporatePage(driver, test);
		AdminIndividualClientPage =new  AdminIndividualClientPage(driver,test);
		AdminAPIDocumentPage =new  AdminAPIDocumentPage(driver,test);
		AdminInvokeApplicationPage=new  AdminInvokeApplicationPage(driver,test);
		AdminLoginPage=new  AdminLoginPage(driver,test);
		AdminReceivablesExportedbillsPage= new AdminReceivablesExportedbillsPage(driver,test);
		AdminSettingsDiscountPage= new AdminSettingsDiscountPage(driver,test);
		AdminSettingsPage= new AdminSettingsPage(driver,test);
		AdminSubbillerPage= new AdminSubbillerPage(driver,test);
		AdminSystemMangement=new AdminSystemMangement(driver, test);
		AdminUserMngUserListPage=new AdminUserMngUserListPage(driver, test);
		AdminSignUpPage=new AdminSignUpPage(driver, test);
		AdminNotApprovedBillerManagement=new AdminNotApprovedBillerManagement(driver, test);
		AdminApprovedBillerManagement=new AdminApprovedBillerManagement(driver, test);
		AdminTrackerBillerManagementPage=new AdminTrackerBillerManagementPage(driver, test);
		AdminSystemMangementContactsPage=new AdminSystemMangementContactsPage(driver,test);
		AdminSystemMngCorporateclientMngpage=new AdminSystemMngCorporateclientMngpage(driver,test);
		AdminSystemMgmIndividualClientPage=new AdminSystemMgmIndividualClientPage(driver,test);
		AdminSystemMgmBillersCategoriesMngpage=new AdminSystemMgmBillersCategoriesMngpage(driver,test);
		AdminSystemMngDistributionPage=new AdminSystemMngDistributionPage(driver,test);
		AdminSystemMgmSubBillersPage=new AdminSystemMgmSubBillersPage(driver,test);
		AdminSettingsPricingListPage=new AdminSettingsPricingListPage(driver,test);
		AdminUserMngGrpsMngPage= new AdminUserMngGrpsMngPage(driver,test);
		AdminSettingTermsManagementPage= new AdminSettingTermsManagementPage(driver,test);
		AdminPayablesIncomingBillsPage= new AdminPayablesIncomingBillsPage(driver,test);
		AdminReportsAdminReportsPage=new AdminReportsAdminReportsPage(driver,test);
		AdminReportsReceivablesReportsPage=new AdminReportsReceivablesReportsPage(driver,test);
		AdminMyAccountPage=new AdminMyAccountPage(driver,test);
		AdminSystemManagementWathiqIntegrationPage=new AdminSystemManagementWathiqIntegrationPage(driver,test);
		AdminClientsImportClientDataPage= new AdminClientsImportClientDataPage(driver, test);
		AdminSystemManagementSamaIntegrationPage= new AdminSystemManagementSamaIntegrationPage(driver, test);
		MyBillsPage=new MyBillsPage(driver, test);
		BillerUserGroupManagementPage=new BillerUserGroupManagementPage(driver, test);
		BillerDashboardPages=new BillerDashboardPages(driver, test);
		BillerPayablesPage=new BillerPayablesPage(driver, test);
		BillerImportClientdataPage=new BillerImportClientdataPage(driver, test);
		BillerSettingPricelistPage= new BillerSettingPricelistPage(driver, test);
	    BillerMyAccountNotificationSettingPage=new BillerMyAccountNotificationSettingPage(driver, test);
	    BillerSettingProductsManagementPage=new BillerSettingProductsManagementPage(driver, test);
		BillerReportsReceivablesReportPage=new BillerReportsReceivablesReportPage(driver, test);
		BillerSettingTermsManagementPage=new BillerSettingTermsManagementPage(driver, test);
		BillerSettingsInvoicesTemplatesPage=new BillerSettingsInvoicesTemplatesPage(driver, test);
		BillerSettingsPaidOutsideEDAATBillsPage=new BillerSettingsPaidOutsideEDAATBillsPage(driver, test);
		BillerReceivablesBalancePage=new BillerReceivablesBalancePage(driver, test);
		BillerReportReceivableReportforSuperBillerPage=new BillerReportReceivableReportforSuperBillerPage(driver, test);
		BillerAPIdocumentPage=new BillerAPIdocumentPage(driver, test);
		BillerReceivablesPaidOutsideEdaatPage=new BillerReceivablesPaidOutsideEdaatPage(driver, test);
		ClientSignUpPage= new ClientSignUpPage(driver, test);
		ClientLoginPage= new ClientLoginPage(driver, test);
		ClientReportsClientAccountStatementPage= new ClientReportsClientAccountStatementPage(driver, test);
		AdminReceivablesBalancePage= new AdminReceivablesBalancePage(driver, test);
		AdminSettingsContentManagementPage= new AdminSettingsContentManagementPage(driver, test);
		AdminReceivablesPaidOutsideEdaatPage= new AdminReceivablesPaidOutsideEdaatPage(driver, test);
		ClientMyAccountPage= new ClientMyAccountPage(driver, test);
		ClientPayablesInstallmentsBillsPage= new ClientPayablesInstallmentsBillsPage(driver, test);
		ClientPayablesIncomingBillsPage= new ClientPayablesIncomingBillsPage(driver, test);
		BillerReportsCustomReconciliationReportPage = new BillerReportsCustomReconciliationReportPage(driver,test);
		BillerReportsDailyReconciliationReportSadadPage=new BillerReportsDailyReconciliationReportSadadPage(driver,test);
	}
}
