package APITask_test;

import api_task_service.Get_PostsByID;
import org.testng.Assert;
import org.testng.annotations.Test;

public class tst_getPostsByID {

    @Test
    public void tst_statusCodeIs200() {
        Get_PostsByID.validateStatusCode200(100);
    }

    @Test
    public void tst_responseIsInJSON() {
        Get_PostsByID.validateResponseInJSON(2);
    }

    @Test(dataProvider = "PostByID_Title_DDT", dataProviderClass = Get_PostByID_DDT.class)
    public void tst_titleInResponseBody(int postID, String titleValue) {
        String titleReturnValue = Get_PostsByID.validateTitleDataInResponse(postID);
        Assert.assertEquals(titleReturnValue, titleValue, "Different values in the title.");
    }

    @Test(dataProvider = "PostByID_Body_DDT", dataProviderClass = Get_PostByID_DDT.class)
    public void tst_bodyInResponseBody(int postID, String bodyValue) {
        String bodyReturnValue = Get_PostsByID.validateBodyDataInResponse(postID);
        Assert.assertEquals(bodyReturnValue, bodyValue, "Different values in the body.");
    }



}
