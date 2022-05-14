package test;

import java.io.FileInputStream;


public class zad1 {

    public static void main(String args[]) {

        try {
            FileInputStream input = new FileInputStream("C:\\Users\\Patryk\\IdeaProjects\\java-backend\\src\\test\\test_file.txt");
            int index = input.read();
            while (index != -1) {
                System.out.print((char) index);
                index = input.read();
            }
            input.close();
        } catch (Exception e) {
            e.getStackTrace();
        }
    }
}
