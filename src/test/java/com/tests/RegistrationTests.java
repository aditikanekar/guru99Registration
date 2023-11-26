package com.tests;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.bouncycastle.asn1.dvcs.Data;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.pages.RegistrationPage;


import io.github.bonigarcia.wdm.WebDriverManager;

public class RegistrationTests {
	WebDriver driver;
	private String sTestCaseName;

	private int iTestCaseRow;
	
	RegistrationPage registrationPage=new RegistrationPage();
	
	@BeforeTest
	    public void testBrowser() {
	       WebDriverManager.chromedriver().setup();
	        driver = new ChromeDriver();   
	        driver.manage().window().maximize();
	        driver.get("https://demo.guru99.com/test/newtours/register.php");
	       
	    }

	@Test(dataProvider = "data")
	 public void tescase(Map<String, String> map) throws Exception {
	//password and confirm password mismatch validation
		registrationPage.verifyPassword(driver);
		 
		 //enter Details
		 registrationPage.enterDetails(driver,map.get("firstname"), map.get("lastname"), map.get("phone"), map.get("Address"), map.get("City"), map.get("State"), map.get("postalCode"), map.get("Username"), map.get("Password"));
		 
 }
	
	 
	 @AfterTest
	 public void closeTest() {
		 driver.quit();  
	 }
	

	  @DataProvider(name = "data")
	  public Object[][] dataSupplier() throws IOException {
	    File file = new File("details.xlsx");
	    FileInputStream fis = new FileInputStream(file);
	    XSSFWorkbook wb = new XSSFWorkbook(fis);
	    XSSFSheet sheet = wb.getSheetAt(0);
	    wb.close();
	    int lastRowNum = sheet.getLastRowNum() ;
	    int lastCellNum = sheet.getRow(0).getLastCellNum();
	    Object[][] obj = new Object[lastRowNum][1];
	    for (int i = 0; i < lastRowNum; i++) {
	      Map<Object, Object> datamap = new HashMap<>();
	      for (int j = 0; j < lastCellNum; j++) {
	        datamap.put(sheet.getRow(0).getCell(j).toString(), sheet.getRow(i+1).getCell(j).toString());
	      }
	      obj[i][0] = datamap;
	    }
	    return  obj;
	  }
}
