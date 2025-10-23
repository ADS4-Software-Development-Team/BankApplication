package com.dekagoaytech.model;

public class DebitAccount extends Account {
    private String accountId;
    private String accountName;
    private Money availableBalance;
    private final Money MINBALANCE = new Money(0);

    private String email;
    private String phone;
    private String dob;
    private String ssn;
    private String address;
    private String city;
    private String zip;

    // 🔹 Required for Firebase
    public DebitAccount() {
        this.accountName = "Debit Account";
        this.availableBalance = new Money(0);
    }

    public DebitAccount(String accountName) {
        this.accountName = accountName;
        this.availableBalance = new Money(0);
    }

    // 🔹 Getters & Setters
    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    @Override
    public Money getAvailableBalance() {
        return availableBalance;
    }

    public void setAvailableBalance(Money availableBalance) {
        this.availableBalance = availableBalance;
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
        this.availableBalance.add(amount);
    }

    @Override
    public void withdraw(Money amount) {
        if (sufficientAmount(amount)) {
            this.availableBalance.subtract(amount);
        } else {
            System.out.println("Insufficient amount");
        }
    }

    private boolean sufficientAmount(Money amount) {
        return availableBalance.getAmount() - amount.getAmount() >= MINBALANCE.getAmount();
    }

    @Override
    public String getEmail() { return email; }

    @Override
    public void setEmail(String email) { this.email = email; }

    @Override
    public String getPhone() { return phone; }

    @Override
    public void setPhone(String phone) { this.phone = phone; }

    @Override
    public String getDob() { return dob; }

    @Override
    public void setDob(String dob) { this.dob = dob; }

    @Override
    public String getSsn() { return ssn; }

    @Override
    public void setSsn(String ssn) { this.ssn = ssn; }

    @Override
    public String getAddress() { return address; }

    @Override
    public void setAddress(String address) { this.address = address; }

    @Override
    public String getCity() { return city; }

    @Override
    public void setCity(String city) { this.city = city; }

    @Override
    public String getZip() { return zip; }

    @Override
    public void setZip(String zip) { this.zip = zip; }
}
