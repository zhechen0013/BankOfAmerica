package com.abc;

import java.util.Calendar;
import java.util.Date;

public class Transaction {
    public double amount;

    private Date transactionDate;

    public Transaction(double amount) {
        this.amount = amount;
        this.transactionDate = DateProvider.getInstance().now();
    }
    

    public void  add(double amo){
          amount += amo;
    }
   

}
