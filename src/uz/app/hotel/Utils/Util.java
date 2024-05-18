package uz.app.hotel.Utils;


import java.util.InputMismatchException;
import java.util.Scanner;


public class Util {

    public static String[]args;
    public static Scanner scanner = new Scanner(System.in);
    public static Scanner srtScanner = new Scanner(System.in);
    public static void printStr(String str, String color){
        System.out.println(color + str + Color.RESET);
    }
    public static String getLine(String text){
        System.out.println(text);
        return srtScanner.nextLine();
    }
    public static String getLine(String text,String color){
        System.out.println(color + text + Color.RESET);
        return srtScanner.nextLine();
    }
    public static int getInt(String text,String color){
        while (true){
            try {
                System.out.println(color + text + Color.RESET);
                return scanner.nextInt();
            }catch (InputMismatchException i){
                printStr("Its not an Integer!",Color.RED);
                scanner.nextInt();
            }
        }
    }
    public static int getInt(String text){
        while (true){
            try {
                System.out.println(text);
                return scanner.nextInt();
            }catch (InputMismatchException i){
                printStr("Its not an Integer!",Color.RED);
                scanner.nextInt();
            }
        }
    }public static double getDouble(String text){
        while (true){
            try {
                System.out.println(text);
                return scanner.nextDouble();
            }catch (InputMismatchException i){
                printStr("Its not an Integer!",Color.RED);
                scanner.nextDouble();
            }
        }
    }public static double getDouble(String text,String color){
        while (true){
            try {
                System.out.println(color + text + Color.RESET);
                return scanner.nextDouble();
            }catch (InputMismatchException i){
                printStr("Its not an Integer!",Color.RED);
                scanner.nextDouble();
            }
        }
    }
}

