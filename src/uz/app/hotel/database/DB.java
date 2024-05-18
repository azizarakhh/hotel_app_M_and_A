package uz.app.hotel.database;


import uz.app.hotel.entity.Hotel;
import uz.app.hotel.entity.Location;
import uz.app.hotel.entity.Role;
import uz.app.hotel.entity.User;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DB {

    public HashSet<String> ids = new HashSet<>();
    public Set<User> users=new HashSet<>();
    public Set<Hotel> hotels=new HashSet<>();
    public HashMap<Hotel, List<User>> hotelUsers = new HashMap<>();
    public HashMap<User, List<Hotel>> userOrders = new HashMap<>();

    private static DB db;
    public static DB getInstance(){
        if (db==null) {
            db = new DB();
            db.users.add(new User("admin","admin",0.0, Role.ADMIN));
            db.users.add(new User("u1","u1",100_000.0, Role.USER));
            db.users.add(new User("u2","u2",100_000.0, Role.USER));
            db.users.add(new User("u3","u3",100_000.0, Role.USER));

            db.hotels.add(new Hotel("Tashkent Hotel", Location.TASHKENT, 10, 10));
            db.hotels.add(new Hotel("Namangan Hotel", Location.NAMANGAN, 5, 5));
        }
        return db;
    }
}
