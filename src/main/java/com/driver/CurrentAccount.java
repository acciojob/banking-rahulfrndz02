package com.driver;

public class CurrentAccount extends BankAccount {
    String tradeLicenseId; //consists of Uppercase English characters only

    public CurrentAccount(String name, double balance, String tradeLicenseId) throws Exception {
        // minimum balance is 5000 by default. If balance is less than 5000, throw "Insufficient Balance" exception
        super(name, balance, 0);
        try {
            if (balance > 5000)
                this.setMinBalance(5000.00);
        } catch (Exception e) {
            System.out.println("Insufficient Balance");
        }
        this.tradeLicenseId.toUpperCase();
    }

    public String getTradeLicenseId() {
        return tradeLicenseId;
    }

    public void setTradeLicenseId(String tradeLicenseId) {
        this.tradeLicenseId = tradeLicenseId;
    }

    private String valid(String S){
        int[] hash = new int[26];
        for (int i = 0; i < S.length(); i++) {
            hash[S.charAt(i) - 'a']++;
        }
        int max = 0, letter = 0;
        for (int i = 0; i < hash.length; i++) {
            if (hash[i] > max) {
                max = hash[i];
                letter = i;
            }
        }
        if (max > (S.length() + 1) / 2) {
            return "";
        }
        char[] res = new char[S.length()];
        int idx = 0;
        while (hash[letter] > 0) {
            res[idx] = (char) (letter + 'a');
            idx += 2;
            hash[letter]--;
        }
        for (int i = 0; i < hash.length; i++) {
            while (hash[i] > 0) {
                if (idx >= res.length) {
                    idx = 1;
                }
                res[idx] = (char) (i + 'a');
                idx += 2;
                hash[i]--;
            }
        }
        return String.valueOf(res);
    }

    public void validateLicenseId() throws Exception {
        // A trade license Id is said to be valid if no two consecutive characters are same
        // If the license Id is valid, do nothing
        // If the characters of the license Id can be rearranged to create any valid license Id
        // If it is not possible, throw "Valid License can not be generated" Exception
//        int n = tradeLicenseId.length();
//        char[] ch = tradeLicenseId.toCharArray();
//        try {
//            for (int i = 0; i < n; i++) {
//                if (ch[i] == ch[i + 1]) {
//                    char c = ch[i + 1];
//                    ch[i + 1] = ch[i];
//                    ch[i] = c;
//                }
//            }
//        } catch (Exception e) {
//            System.out.println("Valid License can not be generated");
//        }
        for(int i=0;i<tradeLicenseId.length()-1;i++){
            if(tradeLicenseId.charAt(i)==tradeLicenseId.charAt(i+1)){
                String s = valid(tradeLicenseId);
                if(s.equals("")){
                    throw new Exception("Valid License can not be generated");
                }
                else {
                    tradeLicenseId=s;
                }
                break;
            }
        }
    }
}