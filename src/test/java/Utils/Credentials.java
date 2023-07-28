package Utils;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
public class Credentials {
    public String email;
    public String password;
    public String domain;

    public Credentials(String email, String password, String domain){
        this.email = email;
        this.password = password;
        this.domain = domain;
    }


    public static void main(String[] args) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        Credentials myCredentials = new Credentials("cmotanmc@gmail.com", "1234565432", "nitom");
        //Convert java object to json
        String credentialsJson = gson.toJson(myCredentials);
    }

}