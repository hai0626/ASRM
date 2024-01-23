package com.example.spring.Service;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class AccountLockService {
    private static final int MAX_ATTEMPTS = 3;
    private static int ATTEMPTS = 1;

    private Map<String, Integer> lockedAccounts = new HashMap<>();

    public boolean isAccountLocked(String username) {
        return lockedAccounts.getOrDefault(username, 0) >= MAX_ATTEMPTS;
    }

    public void lockAccount(String username) {
        lockedAccounts.put(username, ATTEMPTS + 1);
        System.out.println(lockedAccounts);
    }

    public void unlockAccount(String username) {
        lockedAccounts.remove(username);
    }
}
