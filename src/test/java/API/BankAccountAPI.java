package API;

import Utils.BankAccount;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class BankAccountAPI {
        private String token;
        private static final String ENDPOINT = "/bank/accounts";
        private static final Gson gson = new GsonBuilder().setPrettyPrinting().create();
        private static final String BASE_URL = "https://api.inv.bg";

        public BankAccountAPI (String token){
            this.token = token;
        }

        public Response createBankAccount(){
                String body = gson.toJson(BankAccount.getCreateNewBankAccount());
                return RestAssured.given()
                        .log().all()
                        .auth().oauth2(token)
                        .baseUri(BASE_URL) //Sets the base uri for the request
                        .basePath("v3") //Sets the base path for the request
                        .header("User-Agent", "Good try")
                        .accept(ContentType.JSON) //Sets Accept header
                        .contentType(ContentType.JSON) //Sets Content-Type header
                        .body(body) //Sets the request body
                        .when().post(ENDPOINT)// Sets verb to POST and provide resource url
                        .prettyPeek(); //Prints response in a nice way
        }

        public Response updateBankAccount(int bankAccountId){
                String body = gson.toJson(BankAccount.getUpdateBankAccount());
                return RestAssured.given()
                        .log().all()
                        .auth().oauth2(token)
                        .baseUri(BASE_URL) //Sets the base uri for the request
                        .basePath("v3") //Sets the base path for the request
                        .header("User-Agent", "Good try")
                        .accept(ContentType.JSON) //Sets Accept header
                        .contentType(ContentType.JSON)
                        .body(body)//Sets Content-Type header
                        .when().patch(ENDPOINT + "/" + bankAccountId)// Sets verb to POST and provide resource url
                        .prettyPeek(); //Prints response in a nice way
        }

}
