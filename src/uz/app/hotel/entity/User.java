package uz.app.hotel.entity;

import uz.app.hotel.database.DB;

import java.util.UUID;

import static java.util.UUID.randomUUID;

public class User {
    private final String  id= randomUUID().toString();
    private String username;
    private String password;
    private Double balance;
    private Role role;

    public User(String username, String password,Double balance, Role role) {
        this.username = username;
        this.password = password;
        this.balance = balance;
        this.role = role;
    }

    public String getId() {
        return id;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", id='" + id + '\'' +
                ", password='" + password + '\'' +
                ", balance=" + balance +
                ", role=" + role +
                '}';
    }
}
