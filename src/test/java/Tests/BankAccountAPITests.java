package Tests;

import API.BankAccountAPI;
import Utils.LoginAPI;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;


public class BankAccountAPITests {
    @Test
    @Tag("create")
    @DisplayName("Can create new Bank Account")
    public void canCreateNewBankAccount(){

        String token = LoginAPI.obtainToken();
        BankAccountAPI bankAccountAPI = new BankAccountAPI(token);
        Response createResp = bankAccountAPI.createBankAccount();
        Assertions.assertEquals(201, createResp.statusCode());
    }

    @Test
    @Tag("update")
    @DisplayName("Can update existing Bank Account")
    public void UpdateExistingBankAccount(){
        String token = LoginAPI.obtainToken();
        BankAccountAPI bankAccountAPI = new BankAccountAPI(token);
        Response createResp = bankAccountAPI.updateBankAccount(15);
        Assertions.assertEquals(204, createResp.statusCode());
    }

}
