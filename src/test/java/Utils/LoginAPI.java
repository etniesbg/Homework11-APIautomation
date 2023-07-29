package Utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class LoginAPI {
    private static final String BASE_URL = "https://api.inv.bg";
    private static final String ENDPOINT = "/login/token";
    private static final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    public static String obtainToken() {
        String body = gson.toJson(Credentials.getMyCredentials());
        return RestAssured.given()
                .log().all()
                .baseUri(BASE_URL) //Sets the base uri for the request
                .basePath("v3") //Sets the base path for the request
                .header("User-Agent", "Good try")
                .accept(ContentType.JSON) //Sets Accept header
                .contentType(ContentType.JSON) //Sets Content-Type header
                .body(body) //Sets the request body
                .when().post(ENDPOINT)// Sets verb to POST and provide resource url
                .prettyPeek() //Prints response in a nice way
                .then().extract().body().jsonPath().getString("token"); //Extract the token from the response body
    }

}
