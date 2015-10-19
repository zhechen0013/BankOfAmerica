package com.abc;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Account {

    public static final int CHECKING = 0;
    public static final int SAVINGS = 1;
    public static final int MAXI_SAVINGS = 2;

    private final int accountType;
    public List<Transaction> transactions;

    private int previousdate;

    
    public Account(int accountType) {
        this.accountType = accountType;
        this.transactions = new ArrayList<Transaction>();
    }
   
    public void deposit(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("amount must be greater than zero");
        } else {
            transactions.add(new Transaction(amount));
        }
    }

public void withdraw(double amount) {
    if (amount <= 0) {
        throw new IllegalArgumentException("amount must be greater than zero");
    } else {
        transactions.add(new Transaction(-amount));
        if(accountType==2)
        previousdate=Calendar.DATE;
}
}
    public double interestEarned() {
        double amount = sumTransactions();
        switch(accountType){
            case SAVINGS:
                if (amount <= 1000)
                    return amount * 0.001;
                else
                    return 1 + (amount-1000) * 0.002;
//            case SUPER_SAVINGS:
//                if (amount <= 4000)
//                    return 20;
            case MAXI_SAVINGS:
            	int day =Calendar.DATE;
            	int period=day-previousdate;
            	if(period>10){
            		return amount*0.5;
            	}
            	return amount*0.001;
            	
            		
//                if (amount <= 1000)
//                    return amount * 0.02;
//                if (amount <= 2000)
//                    return 20 + (amount-1000) * 0.05;
//                return 70 + (amount-2000) * 0.1;
            default:
                return amount * 0.001;
        }
        
        
    }

    public double sumTransactions() {
       return checkIfTransactionsExist(true);
    }

    private double checkIfTransactionsExist(boolean checkAll) {
        double amount = 0.0;
        for (Transaction t: transactions)
            amount += t.amount;
        return amount;
    }

    public int getAccountType() {
        return accountType;
    }


    public void addinterest(){
    	
    }

    public void accountTransfer(int beginAccountType,int endAccountType,double amount){
    
    	Account ac1=new Account(beginAccountType);
       Account ac2=new Account(endAccountType);
       double beginamount=ac1.sumTransactions();
       double endamount=ac2.sumTransactions();
      
         if(beginAccountType==endAccountType){
          System.err.println("error");
        }
       else{
          if(amount<beginamount){
              ac1.transactions.add(new Transaction(-amount));
              ac2.transactions.add(new Transaction(amount));
              }
          else{
              System.out.println("error");
              }
        }
    }

}
