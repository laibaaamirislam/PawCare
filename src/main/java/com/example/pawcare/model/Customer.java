package com.example.pawcare.model;

import java.io.Serializable;
import java.util.Objects;

public class Customer implements Serializable {
private static final long serialVersionUID = 3L;

private final String username;
private final String email;
private final String password;
private final String phoneNumber;
private final String address;
private final String gender;

public Customer(String username, String email, String password, String gender, String phoneNumber, String address) {
    this.username = Objects.requireNonNull(username, "username");
    this.email = Objects.requireNonNull(email, "email");
    this.password = Objects.requireNonNull(password, "password");
    this.gender = gender == null ? "" : gender;
    this.phoneNumber = phoneNumber == null ? "" : phoneNumber;
    this.address = address == null ? "" : address;
}

public String getGender() {
    return gender;
}

public String getUsername() {
    return username;
}

public String getEmail() {
    return email;
}

public String getPassword() {
    return password;
}

public String getPhoneNumber() {
    return phoneNumber;
}

public String getAddress() {
    return address;
}

public Customer withPassword(String newPassword) {
    return new Customer(username, email, newPassword, gender, phoneNumber, address);
}

@Override
public String toString() {
    return "Customer{" +
            "username='" + username + '\'' +
            ", email='" + email + '\'' +
            ", phoneNumber='" + phoneNumber + '\'' +
            ", address='" + address + '\'' +
            '}';
}
}
