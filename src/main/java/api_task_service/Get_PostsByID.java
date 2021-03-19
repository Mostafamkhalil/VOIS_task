package api_task_service;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class Get_PostsByID {


    public static void validateStatusCode200(int postID) {
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
        given().get("/posts/" + postID).then().statusCode(200);
    }

    public static void validateResponseInJSON(int postID){
        given().get("https://jsonplaceholder.typicode.com/posts/" + postID).then().contentType("application/json");
    }


    public static String validateTitleDataInResponse(int postID){
        Response response = given().get("https://jsonplaceholder.typicode.com/posts/" + postID).then().statusCode(200).contentType("application/json").extract().response();
        return response.jsonPath().getString("title");
    }

    public static String validateBodyDataInResponse(int postID){
        Response response = given().get("https://jsonplaceholder.typicode.com/posts/" + postID).then().statusCode(200).contentType("application/json").extract().response();
        return response.jsonPath().getString("body");
    }




}
