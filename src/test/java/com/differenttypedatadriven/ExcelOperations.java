package com.differenttypedatadriven;

import com.excel.utility.Xls_Reader;

public class ExcelOperations {
    public static void main(String[] args) {

        Xls_Reader reader = new Xls_Reader("C:/Workspace/DataDrivenTesting/src/test/java/com/TestData/ExcelFacebookReg/FacebookReg.xlsx");
        System.out.println( reader.addColumn("HomePage","newdata"));
        System.out.println( reader.setCellData("HomePage","newdata",3,"hello"));

        if(!reader.isSheetExist("satyam")){
            reader.addSheet("satyam");
        }
        System.out.println( reader.addColumn("satyam","newdata"));
        System.out.println( reader.setCellData("satyam","newdata",3,"hello"));

    }
}
