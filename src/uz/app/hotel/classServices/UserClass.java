package uz.app.hotel.classServices;

import uz.app.hotel.entity.Hotel;
import uz.app.hotel.entity.Reservation;
import uz.app.hotel.entity.User;
import uz.app.hotel.service.UserService;

import static uz.app.hotel.database.DB.currentUser;
import static uz.app.hotel.util.Utils.nextInteger;

public class UserClass implements UserService {
    AdminClass adminClass = AdminClass.getInstance();
    ReservationClass reservationClass = ReservationClass.getInstance();

    public int menu(){
        System.out.println("""
                0 -> exit
                1 -> show Hotels
                2 -> show Reservations
                3 -> reserve
                4 -> cancel Reservation
                5 -> reschedule Reservation
                6 -> showHistory
                """);
        return nextInteger();
    }


    @Override
    public void service() {
        while (true){
            switch (menu()){
                case 0 -> {
                    System.out.println("See you soon, " + currentUser);
                    return;
                }
                case 1 -> showHotels();
                case 2 -> showReservations();
                case 3 -> reserve();
                case 4 -> cancelReservation();
                case 5 -> rescheduleReservation();
                case 6 -> showHistory();
                default -> {
                    System.out.println("error");
                    menu();
                }
            }
        }
    }

    @Override
    public void showHotels() {
        adminClass.showHotels();
    }

    @Override
    public void showReservations() {
        reservationClass.showReservation(currentUser.getId());
    }

    @Override
    public void reserve() {
        Reservation reservation = new Reservation();

    }

    @Override
    public void cancelReservation() {
        reservationClass.cancelReservation(currentUser.getId());
    }

    @Override
    public void rescheduleReservation() {
    }

    @Override
    public void showHistory() {
        if (currentUser.getHistory().isEmpty()){
            System.out.println("your historry is empty");
            return;
        }
        for (Hotel hotel : currentUser.getHistory()) {
            System.out.println(hotel);
        }

    }

    private static UserClass userClass;
    public static UserClass getInstance(){
        if (userClass == null){
            userClass = new UserClass();
        }
        return userClass;
    }
}
