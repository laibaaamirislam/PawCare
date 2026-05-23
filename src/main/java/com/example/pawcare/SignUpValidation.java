package com.example.pawcare;

import java.io.*;
import java.util.ArrayList;

public class SignUpValidation {
    public boolean validateEmail(String email) throws ClassNotFoundException, IOException {
        ArrayList<Customer> existingCustomers = readFromFile(new File("CustomerSignUp.ser"));
        if (existingCustomers != null) {
            for (Customer c : existingCustomers) {
                if (email.equals(c.getEmail())) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean validateEmailFormat(String email) {
        return email.matches("^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,7}$");
    }

    public boolean validateUsername(String username) throws ClassNotFoundException, IOException {
        ArrayList<Customer> existingCustomers = readFromFile(new File("CustomerSignUp.ser"));
        if (existingCustomers != null) {
            for (Customer c : existingCustomers) {
                if (username.equals(c.getUsername())) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isValidPassword(String password) {
        return password != null && password.length() >= 5 && password.length() <= 8;
    }

//    public void createAccount(String email, String username, String password) throws IOException {
//        Customer customer = new Customer(username, email, password,null,null);
//        writeToFile(new File("C:\\Users\\Lenovo\\IdeaProjects\\demo\\Customer.ser"), customer);
//    }

//    public void writeToFile(File file, ArrayList<Customer> customer) throws IOException {
//        // boolean append = file.exists() && file.length() > 0;
//        try{
//        FileOutputStream fileOutputStream = new FileOutputStream(file);
//        MyObjectOutputStream myObjectOutputStream = new MyObjectOutputStream(fileOutputStream);
//        myObjectOutputStream.writeObject(customer);
//        myObjectOutputStream.close();
//        fileOutputStream.close();
//    } catch (IOException e) {
//        e.getMessage();
//    }
//
//    }
//
//
//    public ArrayList<Customer> readFromFile(File file) throws IOException, ClassNotFoundException {
//        ArrayList<Customer> customers = new ArrayList<>();
//        if (!file.exists() || file.length() == 0) {
//            return customers;
//        }
//        FileInputStream fileInputStream = new FileInputStream(file);
//             ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
//            customers = (ArrayList<Customer>) objectInputStream.readObject();
//            objectInputStream.close();
//            fileInputStream.close();
//        return customers;


    public static ArrayList<Customer> readFromFile(File file) {
        ArrayList<Customer> list = new ArrayList<>();
        if (file != null && file.exists()) {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
                list = (ArrayList<Customer>) ois.readObject();
            } catch (FileNotFoundException e) {
                System.out.println("File not found: " + e.getMessage());
            } catch (IOException e) {
                System.out.println("Error reading file: " + e.getMessage());
            } catch (ClassNotFoundException e) {
                System.out.println("Class not found: " + e.getMessage());
            }
        }
        return list;
    }

    public  void writeToFile(File file,ArrayList<Customer> list) throws IOException {
        if (list != null && file != null) {
            try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))) {
                oos.writeObject(list);
            } catch (IOException e) {
                System.out.println("Error writing to file: " + e.getMessage());
            }
        }
    }

    public boolean validateLogin(String username, String password) throws IOException, ClassNotFoundException {
        ArrayList<Customer> loggedIn = new ArrayList<>();

        loggedIn=((ArrayList<Customer>)readFromFile(new File("CustomerSignUp.ser")));
        if (loggedIn != null) {
            for (Customer c : loggedIn) {
                if ((username.equals(c.getUsername())) && password.equals(c.getPassword())) {
                    return true;
                }
            }
        }
        return false;
    }
}
