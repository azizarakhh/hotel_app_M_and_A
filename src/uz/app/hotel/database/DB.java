package uz.app.hotel.database;


public class DB {
    private static DB db ;
    public static DB getInstance(){
        if (db == null)
            db=new DB();
        return db;
    }


}
