package uz.app.hotel.classServices;

import uz.app.hotel.database.DB;
import uz.app.hotel.entity.Hotel;
import uz.app.hotel.entity.Location;
import uz.app.hotel.service.HotelService;

import java.util.List;
import java.util.Objects;

import static uz.app.hotel.util.Utils.*;

public class HotelClass implements HotelService {
    DB db = DB.getInstance();

    @Override
    public boolean add(Hotel hotel) {
        if (hotel != null) {
            for (Hotel h : db.hotels) {
                if (Objects.equals(hotel, h)) {
                    db.hotels.add(hotel);
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public Hotel show(String id) {
        if (id.isEmpty()) {
            return null;
        }else {
            for (Hotel hotel : db.hotels) {
                if (hotel.getId().equals(id)) {
                    return hotel;
                }
            }
        }
        return null;
    }

    @Override
    public List<Hotel> showAll() {
        return List.of();
    }

    @Override
    public boolean edit(String id, Hotel hotel) {
        switch (editMenu()){
            case 0 -> {
                return false;
            }
            case 1 -> {
                System.out.println("Enter hotel name:");
                String name = strScanner.nextLine();
                hotel.setName(name);
            }
            case 2 -> {
                System.out.println("Enter hotel location:");
                Location location = Location.valueOf(strScanner.nextLine());
                hotel.setLocation(location);
            }
            case 3 -> {
                System.out.println("Enter hotel floor:");
                Integer floor = nextInteger();
                hotel.setFloors(floor);
            }
            case 4 -> {
                System.out.println("Enter hotel room:");
                Integer room = nextInteger();
                hotel.setRoomsCount(room);
            }
        }
        return false;
    }

    private int editMenu(){
        System.out.println("""
                0 -> exit
                1 -> change hotel name
                2 -> change hotel location
                3 -> change hotel floor
                4 -> change hotel room
                """);
        return nextInteger();
    }

    @Override
    public boolean delete(String id) {
        if (id.isEmpty()) {
            return false;
        } else {
            for (Hotel h : db.hotels) {
                if (h.getId().equals(id)) {
                    db.hotels.remove(h);
                    return true;
                }
            }
        }
        return false;
    }

    private static HotelClass hotelClass;
    public static HotelClass getInstance(){
        if (hotelClass == null){
            hotelClass = new HotelClass();
        }
        return hotelClass;
    }
}
