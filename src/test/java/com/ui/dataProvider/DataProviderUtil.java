package com.ui.dataProvider;

import java.util.Iterator;

import org.testng.annotations.DataProvider;

import com.ui.pojo.LoginData;
import com.ui.pojo.User;
import com.utility.CSVReaderUtility;
import com.utility.ExcelReaderUtility;
import com.utility.JsonUtility;

import dataprovider.ui.bean.UserBean;

public class DataProviderUtil {

	@DataProvider(name = "LoginCredentialsDataProviderUsingJson")
	public static Iterator<User> loginTestDataProvider() {

		LoginData loginData = JsonUtility.readJson("testData/loginData.json", LoginData.class);

		return loginData.getData().iterator();
	}

	@DataProvider(name = "LoginCredentialsDataProviderUsingCSV")
	public static Iterator<UserBean> loginTestCSVDataProvider() {

		return CSVReaderUtility.readCSV("testData/loginData.csv", UserBean.class);
	}

	@DataProvider(name = "LoginCredentialsDataProviderUsingExcel")
	public static Iterator<User> loginTestExcelDataProvider() {

		return ExcelReaderUtility.readExcel("testData/LoginData.xlsx", "LoginData", User.class);
	}

}