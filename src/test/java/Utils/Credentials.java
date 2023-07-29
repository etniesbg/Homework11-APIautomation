package Utils;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
public class Credentials {

    private final String email;
    private final String password;
    private final String domain;

    public Credentials(String email, String password, String domain){
        this.email = email;
        this.password = password;
        this.domain = domain;
    }
    private static final Credentials MY_CREDENTIALS = new Credentials("cmotanmc@gmail.com", "1234565432", "nitom");

    public static Credentials getMyCredentials() {
        return MY_CREDENTIALS;
    }

}