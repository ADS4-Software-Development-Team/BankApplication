package com.dekagoaytech.service;

import com.dekagoaytech.model.*;
import org.springframework.stereotype.Service;

@Service
public class AccountService {

    private final Account account;

    // Change the account type here (or inject/configure per user/session)
    public AccountService() {
        this.account = new SavingsAccount(); // or BusinessAccount(), etc.
    }



    public void deposit(long amountInCents) {
        account.deposit(new Money(amountInCents));
    }

    public void withdraw(long amountInCents) {
        account.withdraw(new Money(amountInCents));
    }

    public String getBalance() {
        return account.getAvailableBalance().toDisplayInRands();
    }

    public String getAccountName() {
        return account.accountName();
    }
}
