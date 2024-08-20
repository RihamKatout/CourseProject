package com.exalt.training.dao;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AccountDAOImpl implements AccountDAO{
    @Override
    public void addAccount() {
        System.out.println("Adding an account ...");
    }

    @Override
    public List<String> findAccounts() {
        return List.of("Riham", "Muneer", "Siwar");
    }
}
