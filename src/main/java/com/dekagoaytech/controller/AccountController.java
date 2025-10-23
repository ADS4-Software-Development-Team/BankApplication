package com.dekagoaytech.controller;

import com.dekagoaytech.model.DebitAccount; // ✅ Import your model
import com.dekagoaytech.service.FirebaseAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {

    private final FirebaseAccountService firebaseAccountService;

    @Autowired
    public AccountController(FirebaseAccountService firebaseAccountService) {
        this.firebaseAccountService = firebaseAccountService;
    }

    // ✅ Create a new account and save to Firebase
    @PostMapping("/create")
    public ResponseEntity<String> createAccount(@RequestBody DebitAccount account) {
        try {
            firebaseAccountService.saveAccount(account).get();
            return ResponseEntity.ok("✅ Account created successfully in Firebase!");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError()
                    .body("❌ Error saving account: " + e.getMessage());
        }
    }

    // ✅ Retrieve account by ID (Firebase key)
    @GetMapping("/{key}")
    public ResponseEntity<?> getAccount(@PathVariable String key) {
        try {
            DebitAccount account = firebaseAccountService.getAccount(key).get();
            if (account != null) {
                return ResponseEntity.ok(account);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError()
                    .body("❌ Error fetching account: " + e.getMessage());
        }
    }

}
