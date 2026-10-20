package com.utility;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.ui.pojo.User;

public class ExcelReaderUtility {

	public static <T> Iterator<User> readExcel(String path, String sheetName, Class<T> clazz) {

		InputStream stream = Thread.currentThread().getContextClassLoader().getResourceAsStream(path);

		List<User> userList = new ArrayList<User>();

		User user;

		XSSFWorkbook xssfWorkbook = null;
		try {
			xssfWorkbook = new XSSFWorkbook(stream);
			XSSFSheet xssfSheet = xssfWorkbook.getSheet(sheetName);
			Iterator<Row> rowIterator = xssfSheet.iterator();
			rowIterator.next();
			Row row;
			while (rowIterator.hasNext()) {

				row = rowIterator.next();

				Cell email = row.getCell(0);
				Cell password = row.getCell(1);

				user = new User(email.toString(), password.toString());

				userList.add(user);
			}

			xssfWorkbook.close();
		} catch (

		IOException e) {

			e.printStackTrace();
		}
		
		return userList.iterator();

	}

}
