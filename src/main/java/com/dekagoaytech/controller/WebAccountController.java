package com.dekagoaytech.controller;
import com.google.firebase.auth.*;
import com.google.firebase.database.*;
import com.dekagoaytech.model.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.google.firebase.auth.UserRecord;
import com.google.firebase.auth.UserRecord.CreateRequest;

import java.util.HashMap;
import java.util.Map;
@Controller
public class WebAccountController {

    // Home page
    @GetMapping("/")
    public String showHome() {
        return "index"; // templates/index.html
    }

    // Login page
    @GetMapping("/login")
    public String showLogin() {
        return "login"; // templates/login.html
    }

    // Open Account page
    @GetMapping("/openAccount")
    public String openAccount() {
        return "openAccount"; // templates/openAccount.html
    }

    // Dashboard page
    @GetMapping("/dashboard")
    public String showDashboard() {
        return "dashboard"; // templates/dashboard.html
    }
    @GetMapping("/manageAccounts")
    public String showAddAccountPage() {
        return "manageAccounts"; // templates/manageAccounts.html
    }
 @GetMapping("/transact")
    public String showTransactPage() {
        return "transact"; // templates/transact.html
    }
    @GetMapping("/business")
    public String showBusinessPage() {
        return "business"; // templates/Business.html
    }
    @GetMapping("/transact")
    public String showInsurencePage() {
        return "Insurence"; // templates/Insurence.html
    }
    @GetMapping("/credit")
    public String showCreditPage() {
        return "credit"; // templates/credit.html
    }
    // Account creation form submission
    @PostMapping("/create-account")
    public String createAccount(
            @RequestParam String accountType,
            @RequestParam String firstName,
            @RequestParam String lastName,
            @RequestParam String email,
            @RequestParam String phone,
            @RequestParam String dob,
            @RequestParam String ssn,
            @RequestParam String address,
            @RequestParam String city,
            @RequestParam(required = false) String state,
            @RequestParam String zip,
            @RequestParam long initialDeposit,
            @RequestParam String password,
            Model model) {

        try {
            // 🔐 Create Firebase Authentication user
            CreateRequest request = new CreateRequest()
                    .setEmail(email)
                    .setPassword(password);
            UserRecord userRecord = FirebaseAuth.getInstance().createUser(request);
            String uid = userRecord.getUid();

            // 🧾 Save additional info in Firebase Realtime DB
            DatabaseReference dbRef = FirebaseDatabase.getInstance().getReference("accounts").child(uid);

            Map<String, Object> accountData = new HashMap<>();
            accountData.put("accountType", accountType);
            accountData.put("firstName", firstName);
            accountData.put("lastName", lastName);
            accountData.put("email", email);
            accountData.put("phone", phone);
            accountData.put("dob", dob);
            accountData.put("ssn", ssn);
            accountData.put("address", address);
            accountData.put("city", city);
            accountData.put("zip", zip);
            accountData.put("initialDeposit", initialDeposit);
            accountData.put("timestamp", System.currentTimeMillis());

            dbRef.setValueAsync(accountData);

            model.addAttribute("message", "✅ Account created successfully!");
            model.addAttribute("balance", initialDeposit);
            return "success";

        } catch (FirebaseAuthException e) {
            model.addAttribute("message", "❌ Error creating account: " + e.getMessage());
            return "openAccount";
        }
    }

    // ======================
    // LOGIN HANDLER
    // ======================
    @PostMapping("/loginUser")
    public String loginUser(
            @RequestParam String email,
            @RequestParam String password,
            Model model) {

        try {
            // Firebase Admin SDK can't check passwords directly.
            // Use Firebase REST API to verify credentials:
            String apiKey = "AIzaSyAljsKmPE-ydqESzPgXFBN2u5otm0WJCCQ";
            String loginUrl = "https://identitytoolkit.googleapis.com/v1/accounts:signInWithPassword?key=" + apiKey;

            String payload = "{\"email\":\"" + email + "\",\"password\":\"" + password + "\",\"returnSecureToken\":true}";

            java.net.URL url = new java.net.URL(loginUrl);
            java.net.HttpURLConnection conn = (java.net.HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setDoOutput(true);

            try (java.io.OutputStream os = conn.getOutputStream()) {
                os.write(payload.getBytes());
                os.flush();
            }

            int responseCode = conn.getResponseCode();
            if (responseCode == 200) {
                model.addAttribute("message", "✅ Login successful!");
                return "dashboard"; // create dashboard.html
            } else {
                model.addAttribute("message", "❌ Invalid email or password.");
                return "login";
            }
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("message", "⚠️ Login failed: " + e.getMessage());
            return "login";
        }
    }
}

