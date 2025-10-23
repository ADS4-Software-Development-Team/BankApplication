package com.dekagoaytech.service;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;

import java.io.FileInputStream;
import java.io.IOException;

public class FirebaseInitializer {

    public static void initialize() throws IOException {
        FileInputStream serviceAccount =
                new FileInputStream("src/main/resources/firebase-service-account.json");

        FirebaseOptions options = FirebaseOptions.builder()
                .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                .setDatabaseUrl("https://java-app-8ebd6-default-rtdb.firebaseio.com")
                .build();

        if(FirebaseApp.getApps().isEmpty()) { // Prevent multiple initializations
            FirebaseApp.initializeApp(options);
            System.out.println("✅ Firebase successfully initialized!");
        }
    }
}
