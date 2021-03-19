package logintests;

import org.testng.annotations.DataProvider;

import static basetest.BaseTest.configSheet;

public class LoginDDT {
    @DataProvider(name = "Login Credentials")
    public Object[][] credentials(){
        int noOfData = configSheet.getNumberOfDataUnderTitle("Login email");
        Object[][] data = new Object[noOfData][4];

        for(int i=0 ; i<noOfData ; i++) {
            data[i][0] = configSheet.getStringUnderTitle("Login email",i);
            data[i][1] = configSheet.getStringUnderTitle("Login password",i);
            data[i][2] = configSheet.getStringUnderTitle("Login First name",i);
            data[i][3] = configSheet.getStringUnderTitle("Login Last name",i);
        }
        return data;
    }
}
