package com.driver;

public class SavingsAccount extends BankAccount{
    double rate;
    double maxWithdrawalLimit;

    public SavingsAccount(String name, double balance, double maxWithdrawalLimit, double rate) {
        // minimum balance is 0 by default
        super(balance);
        this.setBalance(0);
        this.rate = rate;
        this.maxWithdrawalLimit = maxWithdrawalLimit;


    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public double getMaxWithdrawalLimit() {
        return maxWithdrawalLimit;
    }

    public void setMaxWithdrawalLimit(double maxWithdrawalLimit) {
        this.maxWithdrawalLimit = maxWithdrawalLimit;
    }

    public void withdraw(double amount) throws Exception {
        // Might throw the following errors:
        // 1. "Maximum Withdraw Limit Exceed" : If the amount exceeds maximum withdrawal limit
        try{
            if(amount < maxWithdrawalLimit){
                //
            }
        }
        catch (Exception e){
            System.out.println("Maximum Withdraw Limit Exceed");
        }
        // 2. "Insufficient Balance" : If the amount exceeds balance
        try{
            if(amount < getBalance()){

                //
            }
        }
        catch (Exception e){
            System.out.println("Insufficient Balance");
        }

    }

    public double getSimpleInterest(int years){
        // Return the final amount considering that bank gives simple interest on current amount
        double interest = balance*year*rate/100;
        return interest;
    }

    public double getCompoundInterest(int times, int years){
        // Return the final amount considering that bank gives compound interest on current amount given times per year
        double compound_interest = balance * (Math.pow((1 + rate / 100), times)) - balance;
        return  compound_interest;
    }

}
