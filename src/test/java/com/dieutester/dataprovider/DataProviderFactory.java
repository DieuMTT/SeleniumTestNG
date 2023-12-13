package com.dieutester.dataprovider;

import com.dieutester.helpers.ExcelHelper;
import org.testng.annotations.DataProvider;

public class DataProviderFactory {
    @DataProvider(name = "DataLoginSuccess", parallel = true)
    public Object[][] dataLoginSuccess() {
//        return new Object[][]{
//                                 {"admin@example.com", "123456"},
//                                {"admin@example.com", "123456"}
//        };
        ExcelHelper excelHelper = new ExcelHelper();
        Object[][] data = excelHelper.getExcelData("src/test/resources/testdata/DataTest.xlsx", "LoginDataSuccess");
        return data;
    }

    @DataProvider(name = "DataLoginEmailInvalid", parallel = true)
    public Object[][] dataLoginFail() {
//        return new Object[][]{
//                {"admin123@example.com", "123456"},
//                {"customer123@example.com", "123456"}

        ExcelHelper excelHelper = new ExcelHelper();
        Object[][] data = excelHelper.getExcelData("src/test/resources/testdata/DataTest.xlsx", "LoginDataFail");
        return data;
    }


    @DataProvider(name = "data_provider_login_excel_hashtable", parallel = true)
    public Object[][] dataLoginFromExcelHashtable() {
        ExcelHelper excelHelper = new ExcelHelper();
        Object[][] data = excelHelper.getDataHashTable("src/test/resources/testdata/DataTest.xlsx", "LoginDataFail", 2, 2);
        System.out.println("Login Data from Excel: " + data);
        return data;
    }
}
