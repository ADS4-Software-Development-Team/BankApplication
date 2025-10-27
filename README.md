# 🏦 BankAPP

[![Java](https://img.shields.io/badge/Java-17+-red?style=for-the-badge&logo=java)]()
[![Firebase](https://img.shields.io/badge/Firebase-Realtime_DB-orange?style=for-the-badge&logo=firebase)]()
[![Spring Boot](https://img.shields.io/badge/Spring_Boot-Backend-green?style=for-the-badge&logo=springboot)]()
[![Render](https://img.shields.io/badge/Hosted_on-Render-blue?style=for-the-badge&logo=render)]()
[![License: MIT](https://img.shields.io/badge/License-MIT-yellow?style=for-the-badge)]()

---

### 🌐 **Live Demo**
👉 **[bankapp-7iks.onrender.com/#](https://bankapp-7iks.onrender.com/#)**  

---

## 📘 Project Overview
**BankAPP** is a secure, full-stack **online banking application** built using **Java**, **Spring Boot**, and **Firebase Realtime Database**.  
It allows users to **open accounts**, **manage balances**, and **perform transactions** seamlessly — all through a clean, modern web interface.  

This project demonstrates real-world integration between **Firebase cloud services** and a **Java backend**, showcasing skills in **REST APIs**, **cloud data management**, and **responsive UI design**.

---

## ✨ Key Features
- 💰 **Savings Account** – Earn interest on your balance  
- 🏢 **Business Account** – Manage business finances efficiently  
- 💳 **Credit Account** – Access instant credit facilities  
- 💵 **Debit Account** – Everyday banking made simple  
- 🔄 **Real-time Transactions** – Deposit, withdraw, and transfer instantly  
- 📊 **View Transaction History** – Complete visibility of your account activity  
- 🔐 **Firebase Authentication (optional)** – Secure access control  
- ☁️ **Cloud Synced Data** – Stored safely in Firebase Realtime Database  
- 📱 **Responsive Design** – Works beautifully on mobile and desktop  

---

## 🧱 Project Structure
com.dekagoaytech.bankapp/
├── config/
│ └── FirebaseConfig.java
├── controller/
│ ├── AccountController.java
│ └── WebAccountController.java
├── model/
│ ├── Account.java
│ ├── BusinessAccount.java
│ ├── CreditAccount.java
│ ├── DebitAccount.java
│ ├── SavingsAccount.java
│ ├── Money.java
│ └── Transaction.java
├── service/
│ └── AccountService.java
└── main/
└── Application.java + more 


---

## 🧰 Tech Stack
| Layer | Technology |
|-------|-------------|
| **Frontend** | HTML, CSS, JavaScript |
| **Backend** | Java 17+, Spring Boot |
| **Database** | Firebase Realtime Database |
| **Hosting** | Render |
| **Build Tool** | Maven |
| **Version Control** | Git + GitHub |

---

## ⚙️ Setup Instructions

### 🪜 Step 1: Clone the Repository
```bash

git clone https://github.com/your-username/BankAPP.git
cd BankAPP

🪜 Step 2: Connect to Firebase

Go to Firebase Console
.

Create or select a project.

Navigate to Build → Realtime Database.

Click ⋮ (three dots) → Export JSON.

Save the file as serviceAccountKey.json inside your project.

Example configuration:

private static final String DATABASE_URL = "https://your-database-name.firebaseio.com/";
private static final String SERVICE_ACCOUNT_KEY = "path/to/serviceAccountKey.json";

🪜 Step 3: Run the App
./mvnw spring-boot:run
or run Application.java directly in your IDE.

🪜 Step 4: Open in Browser

Local: http://localhost:8080

Live: bankapp-7iks.onrender.com/#

🧩 Example Firebase Structure
{
  "accounts": {
    "user001": {
      "name": "Defence Ndzhobela",
      "accountType": "Savings",
      "balance": 2000.00,
      "transactions": {
        "txn001": {
          "type": "deposit",
          "amount": 500.00,
          "date": "2025-10-27"
        }
      }
    }
  }
}


🧠 Learning Highlights

Integrated Firebase Realtime Database with Spring Boot using RESTful APIs

Implemented account models and inheritance (OOP) in Java

Designed clean, responsive UI with HTML & CSS

Deployed full-stack app using Render hosting

Practiced cloud-based data management and configuration

👨‍💻 Author's

👤 Tebelelo Lekoana
👤 Khaynisile Khosi Msimang 
👤 Goitseone Rakgomo
👤 Ayanda Mthethwa 
👤 Defence Ndzhobela
💼 Software Developer – CAPACITI
📍 Braamfontein, South Africa

🤝 Contributing

Contributions are welcome!

Fork the repository

Create your feature branch (feature/new-feature)

Commit your changes

Push to the branch

Open a Pull Request

📜 License

This project is licensed under the MIT License.
Feel free to use, modify, and distribute it with proper attribution.

🌟 Support the Project

If you find this project helpful, don’t forget to ⭐ star this repo on GitHub!
Every star helps others discover this work. 🌍

BankAPP – A clean, cloud-powered banking experience built with Firebase and Java.


---

Would you like me to add **GitHub social preview image** (like a banner at the top showing “BankAPP – Firebase + Java Banking System”)?  
It will make your repository stand out beautifully when shared.



