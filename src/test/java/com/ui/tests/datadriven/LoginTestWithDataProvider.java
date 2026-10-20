package com.ui.tests.datadriven;

import static org.testng.Assert.assertEquals;

import org.apache.logging.log4j.Logger;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.ui.dataProvider.DataProviderUtil;
import com.ui.pages.HomePage;
import com.ui.pojo.User;
import com.ui.test.TestBase;
import com.utility.LoggerUtility;

import dataprovider.ui.bean.UserBean;

@Listeners(com.ui.listeners.TestListener.class)
public final class LoginTestWithDataProvider extends TestBase {

	Logger logger= LoggerUtility.getLogger(this.getClass());

    @Test(
        description = "Verifies if valid user is able to login",
        groups = {"e2e", "sanity"},
        dataProviderClass = DataProviderUtil.class,
        dataProvider = "LoginCredentialsDataProviderUsingExcel"
    )
    public void loginTest(User user) {

    	logger.info("Using Excel Data Provider to Run Login Test");
        assertEquals(
            homePage.goToLoginPage()
                .doLoginWith(user.getEmail(), user.getPassword())
                .getUserName(),
            "Neeraj Joshi"
        );
    }
    
    @Test(
            description = "Verifies if valid user is able to login",
            groups = {"e2e", "sanity"},
            dataProviderClass = DataProviderUtil.class,
            dataProvider = "LoginCredentialsDataProviderUsingCSV"
        )
        public void loginTestWithCSV(UserBean userBean) {
       	logger.info("Using CSV Data Provider to Run Login Test");
            assertEquals(
                homePage.goToLoginPage()
                    .doLoginWith(userBean.getEmail(), userBean.getPassword())
                    .getUserName(),
                "Neeraj Joshi"
            );
        }
    
    @Test(
            description = "Verifies if valid user is able to login",
            groups = {"e2e", "sanity"},
            dataProviderClass = DataProviderUtil.class,
            dataProvider = "LoginCredentialsDataProviderUsingJson"
        )
        public void loginTestWithJSON(User user) {
       	logger.info("Using JSON Data Provider to Run Login Test");
            assertEquals(
                homePage.goToLoginPage()
                    .doLoginWith(user.getEmail(), user.getPassword())
                    .getUserName(),
                "Neeraj Joshi"
            );
        }
    
    
}