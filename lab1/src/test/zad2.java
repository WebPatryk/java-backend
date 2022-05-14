package test;

import java.io.FileOutputStream;
import java.util.Scanner;


public class zad2 {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        String data = in.nextLine();

        try {
            FileOutputStream output = new FileOutputStream("C:\\Users\\Patryk\\IdeaProjects\\java-backend\\src\\test\\to_save.txt");
            byte[] array = data.getBytes();
            output.write(array);
            output.close();
        } catch (Exception e) {
            e.getStackTrace();
        }
    }
}