package registrationtests;

import org.testng.annotations.DataProvider;

import java.util.Random;

import static basetest.BaseTest.configSheet;

public class RegistrationDDT {
    @DataProvider(name = "registrationData")
    public Object[][] registrationData(){

        int noOfData = configSheet.getNumberOfDataUnderTitle("Registration email");
        Object[][] data = new Object[noOfData][11];
        Random rand = new Random();
        int random = rand.nextInt(1000000);

        for(int i=0 ; i<noOfData ; i++) {
            data[i][0] = configSheet.getStringUnderTitle("Registration email",i) + random;   //email
            data[i][1] = configSheet.getStringUnderTitle("Registration First name",i);     //first name
            data[i][2] = configSheet.getStringUnderTitle("Registration Last Name",i);      //last name
            data[i][3] = configSheet.getStringUnderTitle("Gender",i);                      //gender
            data[i][4] = configSheet.getStringUnderTitle("Password",i);                    //password
            data[i][5] = configSheet.getStringUnderTitle("Address",i);                     //Address
            data[i][6] = configSheet.getStringUnderTitle("City",i);                        //City
            data[i][7] = configSheet.getStringUnderTitle("State",i);                       //State
            data[i][8] = configSheet.getStringUnderTitle("Postal Code",i);                 //Postal Code
            data[i][9] = configSheet.getStringUnderTitle("Country",i);                     //Country
            data[i][10] = configSheet.getStringUnderTitle("Mobile Phone",i);               //Mobile Phone
        }
        return data;
    }
}
