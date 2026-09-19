# Quantum Book Store

A Java-based book store application that manages different types of books and their purchasing workflows.

The project demonstrates object-oriented design, inventory management, purchase validation, and delivery handling for different book types.

## 🚀 Technologies

* Java
* Object-Oriented Programming
* Collections
* Service-based design

## 📁 Project Structure

```text
quantum-book-store/
├── fawrii2/
├── ss1.jpg
├── ss2.jpg
├── ss3.jpg
└── README.md
```

## ⚙️ Installation

Clone the repository:

```bash
git clone https://github.com/Zeyadtharwat66/quantum-book-store.git
```

Navigate to the project:

```bash
cd quantum-book-store
```

Open the Java project in your preferred Java development environment and run the application from its main class.

## 📌 Purchasing Logic

The application:

* Looks up books by ISBN
* Validates requested quantities for physical books
* Sends physical books to the shipping service
* Sends e-books to the mail service
* Reduces inventory stock
* Returns the total purchase price

Errors are handled when:

* A book does not exist
* A book is not purchasable
* There is not enough stock

## 🛠️ Main Features

* Add books to inventory
* Buy books using ISBN
* Support different book types
* Remove outdated books
* Handle shipping for physical books
* Handle email delivery for e-books
* Extend the system with additional product types

## 🔮 Future Improvements

* Add automated tests
* Add a REST API
* Add persistent database storage
* Add centralized exception handling
* Add a web interface

## 👨‍💻 Author

**Zeyad Tharwat**

## 📄 License

This project is for learning and development purposes.
