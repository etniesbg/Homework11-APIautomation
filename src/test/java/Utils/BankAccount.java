package Utils;

import org.apache.commons.lang3.RandomStringUtils;

public class BankAccount {
    private String iban;
    private String bic;
    private String bank;
    private String bank_en;
    public static String ibanGenerator = RandomStringUtils.randomAlphanumeric(15);
    public static String bicGenerator = RandomStringUtils.randomAlphanumeric(6);
    public static String nameGenerator = RandomStringUtils.randomAlphabetic(5,15);
    public static String nameEnGenerator = RandomStringUtils.randomAlphabetic(5,15);

    public BankAccount(String iban, String bic, String bankName, String bankNameEn){
        this.iban = iban;
        this.bic = bic;
        this.bank = bankName;
        this.bank_en = bankNameEn;
    }

    private static BankAccount createNewBankAccount = new BankAccount(ibanGenerator, bicGenerator, nameGenerator, nameEnGenerator);
    private static BankAccount updateBankAccount = new BankAccount(ibanGenerator, bicGenerator, nameGenerator, nameEnGenerator);

    public static BankAccount getCreateNewBankAccount() {
        return createNewBankAccount;
    }

    public static BankAccount getUpdateBankAccount() {
        return updateBankAccount;
    }
}
