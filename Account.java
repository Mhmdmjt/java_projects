
class Account {
    private int id;
    private String holderName;
    private long phoneNumber;
    private char accountType;
    private double balance;

    public Account(int id, String holderName, long phoneNumber, char accountType, double balance) {
        this.id = id;
        this.holderName = holderName;
        this.phoneNumber = phoneNumber;
        this.accountType = accountType;
        this.balance = balance;
    }

    public int getId() {
        return id;
    }

    public String getHolderName() {
        return holderName;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public char getAccountType() {
        return accountType;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setAccountType(char accountType) {
        this.accountType = accountType;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Holder Name: " + holderName + ", Phone Number: " + phoneNumber +
                ", Account Type: " + accountType + ", Balance: " + balance;
    }

    public void setId(int newId) {
        this.id=newId;
    }

    public void setHolderName(String newHolderName) {
        this.holderName=newHolderName;
    }
}
