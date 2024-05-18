package uz.app.hotel.entity;

import java.util.List;

import static java.util.UUID.randomUUID;

public class User {
    private final String  id= randomUUID().toString();
    private String name;
    private String username;
    private String password;
    private List<Hotel> hotels;

    public User() {
    }

    public User(String name, String username, String password) {
        this.name = name;
        this.username = username;
        this.password = password;


    }

    public List<Hotel> getHistory() {
        return hotels;
    }
    public void setHistory(List<Hotel> hotels) {
        hotels.add((Hotel) hotels);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
