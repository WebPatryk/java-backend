package test;

import java.time.*;



public class zad5 {

    public static void main(String[] args) {
        LocalDate ld = LocalDate.now();
        LocalTime lt = LocalTime.now();
        System.out.println("LOCAL: " +ld+" "+lt);

        Instant now = Instant.now();
        System.out.println("GLOBAL: " + now);
    }

}