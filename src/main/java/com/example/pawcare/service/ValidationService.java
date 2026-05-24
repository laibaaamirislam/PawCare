package com.example.pawcare.service;

import com.example.pawcare.model.Customer;

import java.util.Optional;

public class ValidationService {
    private static final String EMAIL_PATTERN =
            "^[A-Za-z0-9]+([._%+-][A-Za-z0-9]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*\\.[A-Za-z]{2,}$";
    private static final String PHONE_PATTERN = "^[0-9]{7,15}$";

    private final CustomerStorageService storageService;

    public ValidationService(CustomerStorageService storageService) {
        this.storageService = storageService;
    }

    public static ValidationService defaultService() {
        return new ValidationService(CustomerStorageService.defaultStorage());
    }

    public boolean isBlank(String value) {
        return value == null || value.trim().isEmpty();
    }

    public String normalize(String value) {
        return value == null ? "" : value.trim();
    }

    public boolean isValidEmailFormat(String email) {
        return email != null && email.matches(EMAIL_PATTERN);
    }

    public boolean isValidPassword(String password) {
        return password != null && password.length() >= 5 && password.length() <= 8;
    }

    public boolean isValidPhoneNumber(String phoneNumber) {
        return phoneNumber != null && phoneNumber.matches(PHONE_PATTERN);
    }

    public boolean isEmailAvailable(String email) {
        return email != null && !storageService.emailExists(email);
    }

    public boolean isUsernameAvailable(String username) {
        return username != null && !storageService.usernameExists(username);
    }

    public Optional<Customer> authenticate(String username, String password) {
        return storageService.authenticate(username, password);
    }

    public Optional<Customer> findByEmail(String email) {
        return storageService.findByEmail(email);
    }
}
