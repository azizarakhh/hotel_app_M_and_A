package uz.app.hotel.classServices;

import uz.app.hotel.entity.Reservation;
import uz.app.hotel.service.ReservationService;

import java.time.LocalDate;
import java.util.List;

public class ReservationClass implements ReservationService {
    @Override
    public boolean addReservation(Reservation reservation) {
        return false;
    }

    @Override
    public Reservation showReservation(String id) {
        return null;
    }

    @Override
    public List<Reservation> showReservationByUser(String id) {
        return List.of();
    }

    @Override
    public List<Reservation> showReservationByHotel(String id) {
        return List.of();
    }

    @Override
    public boolean cancelReservation(String id) {
        return false;
    }

    @Override
    public boolean finishReservation(String id, LocalDate date) {
        return false;
    }

    @Override
    public boolean rescheduleReservation(String id, LocalDate from, LocalDate to) {
        return false;
    }

    private static ReservationClass reservationClass;


    public static ReservationClass getInstance(){
        if (reservationClass == null){
            reservationClass = new ReservationClass();
        }
        return reservationClass;
    }
}
