package api_task_service;


import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class Get_AllPosts {

    public static void validateStatusCode200() {

        given().get("https://jsonplaceholder.typicode.com/posts").then().statusCode(200);
    }

    public static void validateResponseInJSON() {
        given().get("https://jsonplaceholder.typicode.com/posts").then().statusCode(200).contentType("application/json");
    }

    public static void validateUserIDinTheResponse() {
        given().get("https://jsonplaceholder.typicode.com/posts").then().assertThat().body("[0].'userId'", equalTo(1));
    }

    public static void validateIDinTheResponse() {
        given().get("https://jsonplaceholder.typicode.com/posts").then().assertThat().body("[0].'id'", equalTo(1));
    }

    public static void validateTitleInTheResponse() {
        given().get("https://jsonplaceholder.typicode.com/posts").then().assertThat().body("[0].'title'", equalTo("sunt aut facere repellat provident occaecati excepturi optio reprehenderit"));
    }

    public static void validateBodyInTheResponse() {
        given().get("https://jsonplaceholder.typicode.com/posts").then().assertThat().body("[0].'body'", equalTo("quia et suscipit\nsuscipit recusandae consequuntur expedita et cum\nreprehenderit molestiae ut ut quas totam\nnostrum rerum est autem sunt rem eveniet architecto"));
    }


}
