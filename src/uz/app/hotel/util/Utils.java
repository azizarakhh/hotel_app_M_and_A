package uz.app.hotel.util;

import uz.app.hotel.database.DB;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public interface Utils {
        String RED = "\u001B[31m";
        String RESET = "\u001B[0m";
        Scanner scanner = new Scanner(System.in);
        Scanner strScanner = new Scanner(System.in);
        DB db = DB.getInstance();

        static int nextInteger() {
            while (true) {
                try {
                    int n = scanner.nextInt();
                    return n;
                } catch (InputMismatchException e) {
                    System.out.println(RED + "It is not an integer!" + RESET);
                    System.out.println("Please re-enter: ");
                    scanner.next();
                }
            }
        }

        static double nextDouble() {
            while (true) {
                try {
                    return scanner.nextDouble();
                } catch (InputMismatchException e) {
                    System.out.println(RED + "It is not an double!" + RESET);
                    System.out.println("Please re-enter: ");
                    scanner.next();
                }
            }
        }

        static String generateId() {
            while (true) {
                Random random = new Random();
                String id = Integer.toString(random.nextInt(1000, 9999));
                if (db.ids.add(id)) return id;
            }
        }
}
