package com.solvd.airport.threads;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class Connection {
    
    private static final Logger logger = LogManager.getLogger(Connection.class);
    private final String name;
    private final Map<Integer, Account> accounts;
    private int accountIdCounter = 1;
    
    public Connection(String name) {
        this.name = name;
        this.accounts = new HashMap<>();
    }
    
    public String getName() {
        return name;
    }
    
    public Account create(String name, double balance) {
        Account account = new Account(accountIdCounter++, name, balance);
        accounts.put(account.getId(), account);
        logger.info("Created: " + account);
        return account;
    }
    
    public Account get(int id) {
        return accounts.get(id);
    }
    
    public void update(int id, String newName, double newBalance) {
        Account account = accounts.get(id);
        if (account != null) {
            accounts.put(id, new Account(id, newName, newBalance));
            logger.info("Account is updated: " + accounts.get(id));
        }
    }
    
    public void delete(int id) {
        accounts.remove(id);
        logger.info("Removed account: "+ id);
    }
}
