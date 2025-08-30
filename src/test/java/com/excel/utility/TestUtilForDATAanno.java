package com.excel.utility;

import java.util.ArrayList;
import java.util.Objects;

public class TestUtilForDATAanno {
     // added static here so on copy allow
        static Xls_Reader reader;

        public static ArrayList<Object[]> getDataFromExcel(){

            // used arraylist using object
            ArrayList<Object[]> myData = new ArrayList<Object[]>();
            try {
                reader = new Xls_Reader("C:/Workspace/DataDrivenTesting/src/test/java/com/TestData/ExcelFacebookReg/FacebookReg.xlsx");
            }catch (Exception e){
                e.printStackTrace();
            }
            // get row count for loop
            int rowCount = reader.getRowCount("RegTestData");
            System.out.println(rowCount);

            // for loop for travaels data to read it
            for (int rowNum =2;rowNum<=rowCount;rowNum++){
                String firstname= reader.getCellData("RegTestData","firstname",rowNum);
                System.out.println(firstname);
                String surname= reader.getCellData("RegTestData","surname",rowNum);
                System.out.println(surname);
                String mobileNumber= reader.getCellData("RegTestData","mobile",rowNum);
                System.out.println(mobileNumber);
                String password= reader.getCellData("RegTestData","password",rowNum);
                System.out.println(password);

                System.out.println("*************************************************");

                    Object[] ab ={"firstname","surname","mobileNumber","password"} ;
                    myData.add(ab);
                //  myData.add(new Object[]{firstname,surname,mobileNumber,password});
            }
                     return myData;

        }


}
