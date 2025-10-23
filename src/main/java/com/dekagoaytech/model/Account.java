package com.dekagoaytech.model;

public abstract class Account {
    public abstract Money getAvailableBalance();
    public abstract String accountName();
    public abstract void renameAccount(String accountName);
    public abstract void deposit(Money amount);
    public abstract void withdraw(Money amount);

    // Added fields for user details
    public abstract String getEmail();
    public abstract void setEmail(String email);
    public abstract String getPhone();
    public abstract void setPhone(String phone);
    public abstract String getDob();
    public abstract void setDob(String dob);
    public abstract String getSsn();
    public abstract void setSsn(String ssn);
    public abstract String getAddress();
    public abstract void setAddress(String address);
    public abstract String getCity();
    public abstract void setCity(String city);

    public abstract String getZip();
    public abstract void setZip(String zip);
}