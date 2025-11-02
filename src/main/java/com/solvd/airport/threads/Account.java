package com.solvd.airport.threads;

public class Account {
    private int id;
    private String name;
    private double balance;
    
    public Account(int id, String name, double balance) {
        this.id = id;
        this.name = name;
        this.balance = balance;
    }
    
    public int getId() { return id; }
    public String getName() { return name; }
    
    @Override
    public String toString() {
        return "Id: " + id + ", Name: " + name + ", Balance: " + balance;
    }
}
