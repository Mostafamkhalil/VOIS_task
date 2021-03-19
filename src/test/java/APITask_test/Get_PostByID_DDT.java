package APITask_test;

import org.testng.annotations.DataProvider;

import java.lang.reflect.Method;

public class Get_PostByID_DDT {

    @DataProvider(name = "PostByID_Title_DDT")
    public Object[][] titleData(){

        Object[][] dataSet = null;

            dataSet = new Object[][] {
                    {100, "at nam consequatur ea labore ea harum"}
            };



        return dataSet;
    }

    @DataProvider(name = "PostByID_Body_DDT")
    public Object[][] bodyData(){

        Object[][] dataSet = null;
        dataSet = new Object[][] {
                {1, "quia et suscipit\nsuscipit recusandae consequuntur expedita et cum\nreprehenderit " +
                        "molestiae ut ut quas totam\nnostrum rerum est autem sunt rem eveniet architecto"}
        };
        return dataSet;
    }

}
