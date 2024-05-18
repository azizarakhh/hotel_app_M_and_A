package uz.app.hotel.classServices;

import uz.app.hotel.entity.Hotel;
import uz.app.hotel.entity.Location;
import uz.app.hotel.entity.Role;
import uz.app.hotel.entity.User;
import uz.app.hotel.service.AdminService;

import static uz.app.hotel.util.Utils.*;

public class AdminClass implements AdminService {
    User currentUser = null;
    HotelClass hotelClass = HotelClass.getInstance();

    public int menu(){
        System.out.println("""
                0 -> exit
                1 -> add hotel
                2 -> show hotel
                3 -> show hotels
                4 -> edit hotel
                5 -> delete hotel
                6 -> show users
                7 -> show reservation history
                8 -> cancel reservation
                9 -> reserve for user
                """);
        return nextInteger();
    }

    public void current(User currentUser){
        this.currentUser = currentUser;
        service();
    }

    @Override
    public void service() {
        while (true){
            switch (menu()){
                case 0 -> {
                    System.out.printf("See you soon, %s", currentUser);
                    currentUser = null;
                    return;
                }
                case 1 -> addHotel();
                case 2 -> showHotel();
                case 3 -> showHotels();
                case 4 -> editHotel();
                case 5 -> deleteHotel();
                case 6 -> showUsers();
                case 7 -> showReservationHistory();
                case 8 -> calcelReservation();
                case 9 -> reserveForUser();
            }
        }
    }

    @Override
    public void addHotel() {
        System.out.println("Enter Hotel name:");
        String name = strScanner.nextLine();
        System.out.println("Enter Hotel location:");
        Location location = Location.valueOf(strScanner.nextLine());
        System.out.println("Enter Hotel floor:");
        Integer floor = scanner.nextInt();
        System.out.println("Enter Hotel roomsCount:");
        Integer roomsCount = scanner.nextInt();
        Hotel hotel = new Hotel(name, location, floor, roomsCount);
        if (hotelClass.add(hotel)) {
            System.out.println("Added successfully!");
        } else {
            System.out.println("This hotel already exists!");
        }
    }

    @Override
    public void showHotel() {
        showHotels();
        System.out.println("Enter Hotel ID:");
        String id = strScanner.nextLine();
        System.out.println(hotelClass.show(id));
        Hotel hotel = hotelClass.show(id);
        if (hotel != null){
            System.out.println(hotel);
        }else{
            System.out.println("Something went wrong!");
        }
    }

    @Override
    public void showHotels() {
        if (db.hotels.isEmpty()){
            System.out.println("There is no hotel yet");
        } else {
            for (Hotel hotel : db.hotels) {
                if (hotel != null){
                    System.out.println(hotel);
                }
            }
        }
    }

    @Override
    public void editHotel() {
        showHotels();
        System.out.println("Enter Hotel ID:");
        String id = strScanner.nextLine();
        Hotel hotel = hotelClass.show(id);
        if (hotel != null){
            System.out.println(hotel);
        }else{
            System.out.println("Something went wrong!");
        }
        hotelClass.edit(id, hotel);
    }

    @Override
    public void deleteHotel() {
        showHotels();
        System.out.println("Enter hotel ID:");
        String id = strScanner.nextLine();
        if (hotelClass.delete(id)) {
            System.out.println("Deleted successfully!");
        } else {
            System.out.println("Something went wrong!");
        }
    }

    @Override
    public void showUsers() {
        if (db.users.isEmpty()){
            System.out.println("There is no user yet");
        } else {
            for (User user : db.users) {
                if (user != null){
                    System.out.println(user);
                }
            }
        }
    }

    @Override
    public void showReservationHistory() {
        showUsers();
        System.out.println("Enter username to see Reservation History:");
        String username = strScanner.nextLine();
        // show
    }

    @Override
    public void calcelReservation() {

    }

    @Override
    public void reserveForUser() {
        System.out.println("Enter username:");
        String username = strScanner.nextLine();
        System.out.println("Enter password:");
        String password = strScanner.nextLine();
        System.out.println("Enter balance:");
        Double balance = nextDouble();
        User user = new User(username, password, balance, Role.USER);

        System.out.println("Enter Hotel name:");
        String hotelName = strScanner.nextLine();
        System.out.println("Enter floor:");
        Integer floor = nextInteger();
        System.out.println("Enter room:");
        Integer room = nextInteger();
        System.out.println("Enter startDate:");
        //
        System.out.println("Enter endDate:");
        //
    }

    private static AdminClass adminClass;
    public static AdminClass getInstance(){
        if (adminClass == null){
            adminClass = new AdminClass();
        }
        return adminClass;
    }
}
