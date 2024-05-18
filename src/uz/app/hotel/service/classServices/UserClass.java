package uz.app.hotel.service.classServices;

import uz.app.hotel.Utils.Util;
import uz.app.hotel.entity.Hotel;
import uz.app.hotel.service.UserService;

import java.awt.*;

import static uz.app.hotel.database.DB.currentUser;

public class UserClass implements UserService {
    @Override
    public void service() {
        System.out.println("welcome");
        while (true) {
            switch (Util.getInt("""
                    0 -> exit
                    1 -> Show hotels
                    2 -> show Reservations
                    3 -> reserve
                    4 -> cancel Reservation
                    5 -> reschedule Reservation
                    6 -> Show history
                    """, String.valueOf(Color.YELLOW))) {
                case 0 -> {
                    System.out.println("See you leter");
                    return;
                }
                case 1 -> showHotels();
                case 2 -> showReservations();
                case 3 -> reserve();
                case 4 -> cancelReservation();
                case 5 -> rescheduleReservation();
                case 6 -> showHistory();
                default -> {
                    System.out.println("Error");
                    service();
                }
            }
        }


    }


    @Override
    public void showHotels() {

    }

    @Override
    public void showReservations() {

    }

    @Override
    public void reserve() {

    }

    @Override
    public void cancelReservation() {

    }

    @Override
    public void rescheduleReservation() {

    }

    @Override
    public void showHistory() {
        if (currentUser.getHistory().isEmpty()) {
            System.out.println("your history is empty");
            return;
        }
        for (Hotel hotel : currentUser.getHistory()) {
            System.out.println(hotel);
        }
    }

}
