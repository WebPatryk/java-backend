package test;

import org.codehaus.jackson.map.ObjectMapper;

import java.io.IOException;

public class zad8 {
    public static class User {

        private String name;
        private int age;

        public User(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return this.name;
        }

        public int getAge() {
            return this.age;
        }
    }

    public static void main(String[] args) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();

        User userObject = new User("John",21);
        String userJson = objectMapper.writeValueAsString(userObject);

        System.out.println(userJson); // {"name":"John","age":21}
    }
}