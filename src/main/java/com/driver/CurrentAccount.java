package com.driver;

public class CurrentAccount extends BankAccount{
    String tradeLicenseId; //consists of Uppercase English characters only

    public CurrentAccount(String name, double balance, String tradeLicenseId) throws Exception {
        // minimum balance is 5000 by default. If balance is less than 5000, throw "Insufficient Balance" exception
        super(name,balance,0);

            if(balance < 5000) {
                throw new Exception("Insufficient Balance");
            }
            this.tradeLicenseId = tradeLicenseId;

        this.tradeLicenseId.toUpperCase();
    }

    public String getTradeLicenseId() {
        return tradeLicenseId;
    }

    public void setTradeLicenseId(String tradeLicenseId) {
        this.tradeLicenseId = tradeLicenseId;
    }

    public void validateLicenseId() throws Exception {
        // A trade license Id is said to be valid if no two consecutive characters are same
        // If the license Id is valid, do nothing
        // If the characters of the license Id can be rearranged to create any valid license Id
        // If it is not possible, throw "Valid License can not be generated" Exception
        int n = tradeLicenseId.length();
        char[] ch = tradeLicenseId.toCharArray();
        try {
            for (int i = 0; i < n; i++) {
                if (ch[i] == ch[i + 1]) {
                    char c = ch[i + 1];
                    ch[i + 1] = ch[i];
                    ch[i] = c;
                }
            }
        }
        catch (Exception e){
            System.out.println("Valid License can not be generated");
        }
    }

}
