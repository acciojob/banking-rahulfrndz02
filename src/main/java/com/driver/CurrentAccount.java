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
        this.tradeLicenseId = tradeLicenseId;
        this.tradeLicenseId.toUpperCase();
    }

    public String getTradeLicenseId() {
        return tradeLicenseId;
    }

    public void setTradeLicenseId(String tradeLicenseId) {
        this.tradeLicenseId = tradeLicenseId;
    }

    public boolean isValid(String str, int len) {
        for (int i = 1; i < len; i++)
        {
            if (str.charAt(i) == str.charAt(i - 1))
                return false;
        }
        // If the string is alternating
        return true;
    }

    public void validateLicenseId() throws Exception {
        // A trade license Id is said to be valid if no two consecutive characters are same
        // If the license Id is valid, do nothing
        // If the characters of the license Id can be rearranged to create any valid license Id
        // If it is not possible, throw "Valid License can not be generated" Exception
        String s = this.tradeLicenseId;
        int max=0,n=s.length();
        boolean isValid = true;
        for(int i=1; i<n; i++){
            if(s.charAt(i) == s.charAt(i-1))
                isValid = false;
        }
        String ans = " ";
        if(isValid == false){
            int[] charMap = new int[26];
            char mostUsedChar = s.charAt(0);
            for(char c : s.toCharArray()){
                charMap[c-'a']++;
                if(charMap[c-'a'] > charMap[mostUsedChar-'a']){
                    mostUsedChar = c;
                }
            }
            char[] ansArray = new char[n];
            int ansArrayIndex =0;
            for(int i=-1; i<charMap.length; i++){
                char currCh;
                if(i == -1){
                    currCh = mostUsedChar;
                }else{
                    currCh = (char)(i+ 'a');
                }
                while(charMap[currCh-'a'] > 0){
                    if((ansArrayIndex>0 && ansArray[ansArrayIndex-1] == currCh) || (ansArrayIndex<ansArray.length-1 && ansArray[ansArrayIndex+1] == currCh)){
                        isValid = false;
                        throw  new Exception("Valid Licence can not be generated");
                    }
                    ansArray[ansArrayIndex] = currCh;

                    if(ansArrayIndex +2 < ansArray.length){
                        ansArrayIndex += 2;
                    }else{
                        ansArrayIndex += 1;
                    }
                    charMap[currCh-'a']--;
                }
            }
            ans =new String(ansArray);
        }
        this.tradeLicenseId = ans;

    }
}