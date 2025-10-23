package com.dekagoaytech.service;

import com.dekagoaytech.model.DebitAccount;
import com.google.api.core.ApiFuture;
import com.google.firebase.database.*;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
public class FirebaseAccountService {

    private final DatabaseReference dbRef;

    public FirebaseAccountService() throws Exception {
        FirebaseInitializer.initialize();
        this.dbRef = FirebaseDatabase.getInstance().getReference("accounts");
    }

    // 🔹 Save account to Firebase
    public CompletableFuture<Void> saveAccount(DebitAccount account) {
        CompletableFuture<Void> future = new CompletableFuture<>();

        try {
            // If no accountId, generate one
            if (account.getAccountId() == null || account.getAccountId().isEmpty()) {
                String generatedId = dbRef.push().getKey();
                account.setAccountId(generatedId);
            }

            ApiFuture<Void> firebaseFuture = dbRef.child(account.getAccountId()).setValueAsync(account);

            firebaseFuture.addListener(() -> {
                try {
                    firebaseFuture.get();
                    future.complete(null);
                } catch (Exception e) {
                    future.completeExceptionally(e);
                }
            }, Runnable::run);

        } catch (Exception e) {
            future.completeExceptionally(e);
        }

        return future;
    }

    // 🔹 Read account from Firebase
    public CompletableFuture<DebitAccount> getAccount(String accountId) {
        CompletableFuture<DebitAccount> future = new CompletableFuture<>();

        dbRef.child(accountId).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {
                DebitAccount account = snapshot.getValue(DebitAccount.class);
                future.complete(account);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                future.completeExceptionally(error.toException());
            }
        });

        return future;
    }
}
