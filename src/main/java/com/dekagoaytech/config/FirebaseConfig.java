package com.dekagoaytech.config;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import org.springframework.stereotype.Component;
import jakarta.annotation.PostConstruct;

import java.io.ByteArrayInputStream;
import java.nio.charset.StandardCharsets;

@Component
public class FirebaseConfig {

    private static boolean initialized = false;

    @PostConstruct
    public void init() {
        if (initialized) return;

        try {
            // Read JSON credentials from environment variable
            String firebaseCredentials = System.getenv("FIREBASE_CREDENTIALS_JSON");

            if (firebaseCredentials == null || firebaseCredentials.isEmpty()) {
                System.err.println("⚠️ Firebase credentials not found in environment variables!");
                return;
            }

            ByteArrayInputStream serviceAccount =
                    new ByteArrayInputStream(firebaseCredentials.getBytes(StandardCharsets.UTF_8));

            FirebaseOptions options = FirebaseOptions.builder()
                    .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                    .setDatabaseUrl("https://java-app-8ebd6-default-rtdb.firebaseio.com")
                    .build();

            FirebaseApp.initializeApp(options);
            initialized = true;

            System.out.println("✅ Firebase initialized successfully from environment variable!");
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("❌ Failed to initialize Firebase", e);
        }
    }
}
