package test;

import java.util.ArrayList;
import java.util.LinkedList;


public class additional1 {
    public static void main(String[] args) {
        ArrayList<String> cars = new ArrayList<String>();
        cars.add("Volvo");
        cars.add("BMW");
        cars.add("Ford");
        cars.add("Mazda");
        cars.add("Peugeot");
        cars.add("Volkswagen");


        for (int i = 0; i < cars.size(); i += 1) {
            cars.remove(i);
        }


        System.out.println(cars);


        LinkedList<String> animals = new LinkedList<String>();
        animals.add("Dog");
        animals.add("Cat");
        animals.add("Parrot");
        animals.add("Hamster");
        animals.add("Snake");


        for (int i = 0; i < animals.size(); i+=1) {
                animals.remove(i);
        }
        System.out.println(animals);

    }

}


