package uz.app.hotel.classServices;

import uz.app.hotel.entity.User;
import uz.app.hotel.service.UserService;

public class UserClass implements UserService {
    @Override
    public void service() {

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

    }

    private static UserClass userClass;
    public static UserClass getInstance(){
        if (userClass == null){
            userClass = new UserClass();
        }
        return userClass;
    }
}
