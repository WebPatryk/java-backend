package com.example.demo;

import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class UserService {
    @Service
    public class UsersService {

        // ...

        @PostConstruct
        private void onCreate() {
            // wczytywanie uzytkowników
        }

        @PreDestroy
        private void onDestroy() {
            // zapisywanie uzytkowników
        }

        // ...
    }
}
