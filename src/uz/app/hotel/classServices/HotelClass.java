package uz.app.hotel.classServices;

import uz.app.hotel.database.DB;
import uz.app.hotel.entity.Hotel;
import uz.app.hotel.service.HotelService;

import java.util.List;
import java.util.Objects;

public class HotelClass implements HotelService {
    DB db = DB.getInstance();

    @Override
    public boolean add(Hotel hotel) {
        if (hotel != null) {
            for (Hotel h : db.hotels) {
                if (Objects.equals(hotel, h)) {
                    return false;
                }
            }
        }
        return true;
        /// add
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
        return false;
    }

    @Override
    public boolean delete(String id) {
        if (id.isEmpty()) {
            return false;
        } else {
            for (Hotel h : db.hotels) {
                if (h.getId().equals(id)) {
                    // delete
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
