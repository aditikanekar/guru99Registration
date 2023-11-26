package com.tests;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.google.common.collect.Table.Cell;


public class Xls_Reader {
	public  String path;
	public  FileInputStream fis = null;
	public  FileOutputStream fileOut =null;
	private XSSFWorkbook workbook = null;
	private XSSFSheet sheet = null;
	private XSSFRow row   =null;
	private XSSFCell cell = null;
	
	
public Xls_Reader(String path) throws Exception {
		
	FileInputStream file = new FileInputStream(new File(path));

	//Create Workbook instance holding reference to .xlsx file
	XSSFWorkbook workbook = new XSSFWorkbook(file);

	//Get first/desired sheet from the workbook
	XSSFSheet sheet = workbook.getSheetAt(0);

	//Iterate through each rows one by one
	Iterator<Row> rowIterator = sheet.iterator();
	while (rowIterator.hasNext()) {

	  Row row = rowIterator.next();

	  //For each row, iterate through all the columns
	  Iterator<org.apache.poi.ss.usermodel.Cell> cellIterator = row.cellIterator();
	   
	  while (cellIterator.hasNext()) {

	    org.apache.poi.ss.usermodel.Cell cell = cellIterator.next();

	    
	    }
	  }
	  System.out.println("");
	  file.close();
	}
	



}
