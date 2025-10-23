package com.dekagoaytech.model;

public class CreditAccount extends  Account{
    public  Money availableBalance = new Money(0);
    private final Money overDraftlimit = new Money(10000);
    private String accountName;
    private String email;
    private String phone;
    private String dob;
    private String ssn;
    private String address;
    private String city;
    private String zip;

    public CreditAccount(){
        this.accountName = "Credit Account";
    }

    public CreditAccount(String accountName){
        this.accountName = accountName;
    }

    @Override
    public Money getAvailableBalance() {
        return availableBalance;
    }

    @Override
    public String accountName() {
        return accountName;
    }

    @Override
    public void renameAccount(String accountName) {
        this.accountName = accountName;
    }

    @Override
    public void deposit(Money amount) {
        getAvailableBalance().add(amount);
    }

    @Override
    public void withdraw(Money amount) {
        if(sufficientAmount(amount)){
            getAvailableBalance().subtract(amount);
        }else{
            System.out.println("Cannot exceed overdraft limit, try again");
        }
    }

    private boolean sufficientAmount(Money amount){
        return getAvailableBalance().getAmount() - amount.getAmount() < -overDraftlimit.getAmount();
    }

    @Override
    public String getEmail() {
        return email;
    }

    @Override
    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String getPhone() {
        return phone;
    }

    @Override
    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String getDob() {
        return dob;
    }

    @Override
    public void setDob(String dob) {
        this.dob = dob;
    }

    @Override
    public String getSsn() {
        return ssn;
    }

    @Override
    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    @Override
    public String getAddress() {
        return address;
    }

    @Override
    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String getCity() {
        return city;
    }

    @Override
    public void setCity(String city) {
        this.city = city;
    }
    @Override
    public String getZip() {
        return zip;
    }

    @Override
    public void setZip(String zip) {
        this.zip = zip;
    }
}