package APITask_test;

import api_task_service.Get_AllPosts;
import org.testng.annotations.Test;

public class tst_getAllPosts {

    @Test
    public void tst_statusCodeEquals200() {
        Get_AllPosts.validateStatusCode200();
    }

    @Test
    public void tst_responseIsInJSON() {
        Get_AllPosts.validateResponseInJSON();
    }

    @Test
    public void tst_userIDinTheResponseBody() {
        Get_AllPosts.validateUserIDinTheResponse();
    }

    @Test
    public void tst_IDInTheResponseBody() {
        Get_AllPosts.validateIDinTheResponse();
    }

    @Test
    public void tst_titleInTheResponseBody() {
        Get_AllPosts.validateTitleInTheResponse();
    }

    @Test
    public void tst_BodyInTheResponseBody() {
        Get_AllPosts.validateBodyInTheResponse();
    }


}
