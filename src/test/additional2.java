package test;

import java.util.*;
import java.util.HashMap;

public class additional2 {
    public static void main(String[] args) {
        // HashSet declaration
        HashSet<String> hset =
                new HashSet<String>();

        hset.add("Apple");
        hset.add("Mango");
        hset.add("Grapes");
        hset.add("Orange");
        hset.add("Fig");
        hset.add("Apple");
        hset.add("Mango");
        hset.add(null);
        hset.add(null);

        System.out.println(hset);
    }
}


