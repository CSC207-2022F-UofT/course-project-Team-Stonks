package db;

public class PortfolioDSRequest {
    public String name;
    public double balance;
    public String username;
    
    public PortfolioDSRequest(String name, double balance, String username){
        this.name = name;
        this.balance = balance;
        this.username = username;
    }

    public String getName() {
        return this.name;
    }

    public double getBalance() {
        return this.balance;
    }

    public String getUsername() {
        return this.username;
    }
}