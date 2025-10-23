package com.dekagoaytech.config;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;
import java.io.InputStream;

@Component
public class FirebaseConfig {

    private static boolean initialized = false;

    @PostConstruct
    public void init() {
        if (initialized) return;
        try {
            InputStream serviceAccount =
                    getClass().getClassLoader().getResourceAsStream("firebase-service-account.json");

            FirebaseOptions options = FirebaseOptions.builder()
                    .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                    .setDatabaseUrl("https://java-app-8ebd6-default-rtdb.firebaseio.com")
                    .build();

            FirebaseApp.initializeApp(options);
            initialized = true;
            System.out.println("✅ Firebase initialized successfully");
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("❌ Failed to initialize Firebase", e);
        }
    }
}
