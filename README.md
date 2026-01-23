🧪 RescueWay Automation Testing Project
----------------------------------------------

This repository contains an automation testing framework built using Selenium WebDriver, Java, TestNG, and Page Object Model (POM) to test the RescueWay web application.

The project focuses on functional UI testing, clean code structure, and industry best practices suitable for a QA fresher learning real-world automation.


🔧 Tech Stack
----------------

Programming Language: Java

Automation Tool: Selenium WebDriver

Test Framework: TestNG

Design Pattern: Page Object Model (POM)

Build Tool: Maven (if applicable)

Browser: Google Chrome

IDE: Eclipse / IntelliJ



📁 Project Structure
------------------------

src/test/java
│
├── base
│   └── BaseClass.java
│
├── pages
│   ├── HomePage.java
│   ├── ContactPage.java
│   ├── SignupPage.java
│
└── tests
    └── NavigationTests.java



📌 Explanation
------------------

BaseClass
Handles WebDriver setup, browser configuration, and teardown.

Pages
Contains page-level locators and actions (POM concept).

Tests
Contains TestNG test cases that validate application behavior using page methods.


✅ Features Covered
------------------------

Home page navigation validation

Mouse hover actions

Page redirection checks (About, Service, Signup)

Contact form submission

Signup functionality (valid and negative scenarios)

URL and behavior-based assertions

Screenshot utility for important actions


🧠 Framework Highlights
------------------------

✔ Page Object Model for maintainability

✔ Explicit waits using WebDriverWait

✔ Reusable utility methods

✔ No Thread.sleep() usage

✔ Clear assertions for every test

✔ Clean and readable test code


▶️ How to Run the Tests
------------------------

Clone the repository:

git clone https://github.com/your-username/rescueway-automation.git


Open the project in Eclipse / IntelliJ

Ensure:

Chrome browser is installed

ChromeDriver is compatible with browser version

Selenium and TestNG dependencies are added

Run tests:

Right-click on test class → Run as TestNG Test

Or run using testng.xml (if added)

📸 Screenshots

Screenshots are captured automatically and saved in the screenshots/ folder for important test flows like form submission.

🚀 Future Enhancements
------------------------

Login & Dashboard automation

Report Disaster and Campaign flows

TestNG DataProvider for data-driven testing

Extent Reports integration

CI/CD integration (GitHub Actions / Jenkins)

👤 Author
------------------------

Girish Kumar
QA Automation Tester (Fresher)
Learning Selenium, TestNG, and modern testing practices step by step.

🙌 Acknowledgements
------------------------

Selenium Documentation

TestNG Documentation

Open-source QA community
------------------------

⭐ If you like this project

Feel free to ⭐ star the repository and share feedback.
