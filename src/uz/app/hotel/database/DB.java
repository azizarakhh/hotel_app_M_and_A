package uz.app.hotel.database;


import uz.app.hotel.entity.User;

public class DB {
    private static DB db ;
    public static User currentUser = new User();
    public static DB getInstance(){
        if (db == null)
            db=new DB();
        return db;
    }


}
