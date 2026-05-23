package com.example.pawcare;

import java.io.Serializable;

    public class Customer implements Serializable {
        private static final long serialVersionUID = 3L;

        private String username;
        private String email;
        private String password;
        private String phoneNumber;
        private String address;
        private String gender;

        public Customer(String username, String email, String password,String gender, String phoneNumber, String address) {
            this.username = username;
            this.email = email;
            this.password = password;
            this.gender=gender;
            this.phoneNumber = phoneNumber;
            this.address = address;
        }

        public String getGender() {
            return gender;
        }

        public void setGender(String gender) {
            this.gender = gender;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public String getPhoneNumber() {
            return phoneNumber;
        }

        public void setPhoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String toString() {
            return "Customer{" +
                    "username='" + getUsername() + '\'' +
                    ", email='" + getEmail() + '\'' +
                    ", password='" + getPassword() + '\'' +
                    ", phoneNumber='" + phoneNumber + '\'' +
                    ", address='" + address + '\'' +
                    '}';
        }
}
