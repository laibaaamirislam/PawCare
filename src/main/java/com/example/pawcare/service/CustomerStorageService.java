package com.example.pawcare.service;

import com.example.pawcare.model.Customer;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CustomerStorageService {
    private static final String DATA_FILE_NAME = "CustomerSignUp.ser";
    private final Path dataFile;

    public CustomerStorageService(Path dataFile) {
        this.dataFile = dataFile;
    }

    public static CustomerStorageService defaultStorage() {
        return new CustomerStorageService(Path.of(DATA_FILE_NAME));
    }

    public synchronized List<Customer> loadCustomers() {
        if (!Files.exists(dataFile) || isEmpty(dataFile)) {
            return new ArrayList<>();
        }

        try (ObjectInputStream ois = new ObjectInputStream(Files.newInputStream(dataFile))) {
            Object result = ois.readObject();
            if (result instanceof List) {
                return new ArrayList<>((List<Customer>) result);
            }
        } catch (IOException | ClassNotFoundException ex) {
            backupCorruptFile();
        }
        return new ArrayList<>();
    }

    public synchronized boolean saveCustomers(List<Customer> customers) {
        if (customers == null) {
            return false;
        }

        try {
            Path parent = dataFile.getParent() == null ? Path.of(".") : dataFile.getParent();
            Files.createDirectories(parent);
            Path tempFile = Files.createTempFile(parent, "customers", ".tmp");
            try (ObjectOutputStream oos = new ObjectOutputStream(Files.newOutputStream(tempFile))) {
                oos.writeObject(new ArrayList<>(customers));
            }
            moveFile(tempFile, dataFile);
            return true;
        } catch (IOException ex) {
            return false;
        }
    }

    public synchronized boolean addCustomer(Customer customer) {
        if (customer == null) {
            return false;
        }
        List<Customer> customers = loadCustomers();
        customers.add(customer);
        return saveCustomers(customers);
    }

    public boolean emailExists(String email) {
        if (email == null) {
            return false;
        }
        return loadCustomers().stream().anyMatch(c -> email.equalsIgnoreCase(c.getEmail()));
    }

    public boolean usernameExists(String username) {
        if (username == null) {
            return false;
        }
        return loadCustomers().stream().anyMatch(c -> username.equalsIgnoreCase(c.getUsername()));
    }

    public Optional<Customer> findByEmail(String email) {
        if (email == null) {
            return Optional.empty();
        }
        return loadCustomers().stream()
                .filter(customer -> email.equalsIgnoreCase(customer.getEmail()))
                .findFirst();
    }

    public Optional<Customer> authenticate(String username, String password) {
        if (username == null || password == null) {
            return Optional.empty();
        }
        return loadCustomers().stream()
                .filter(customer -> username.equals(customer.getUsername())
                        && password.equals(customer.getPassword()))
                .findFirst();
    }

    public boolean updatePassword(String email, String newPassword) {
        if (email == null || newPassword == null) {
            return false;
        }
        List<Customer> customers = loadCustomers();
        boolean updated = false;
        List<Customer> updatedCustomers = new ArrayList<>();
        for (Customer customer : customers) {
            if (email.equalsIgnoreCase(customer.getEmail())) {
                updatedCustomers.add(customer.withPassword(newPassword));
                updated = true;
            } else {
                updatedCustomers.add(customer);
            }
        }
        return updated && saveCustomers(updatedCustomers);
    }

    private boolean isEmpty(Path file) {
        try {
            return Files.size(file) == 0;
        } catch (IOException ex) {
            return true;
        }
    }

    private void backupCorruptFile() {
        if (!Files.exists(dataFile)) {
            return;
        }
        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));
        Path backupPath = Path.of(dataFile + ".corrupt-" + timestamp);
        try {
            moveFile(dataFile, backupPath);
        } catch (Exception ignored) {
        }
    }

    private void moveFile(Path source, Path destination) throws IOException {
        try {
            Files.move(source, destination, StandardCopyOption.REPLACE_EXISTING, StandardCopyOption.ATOMIC_MOVE);
        } catch (IOException ex) {
            Files.move(source, destination, StandardCopyOption.REPLACE_EXISTING);
        }
    }
}
