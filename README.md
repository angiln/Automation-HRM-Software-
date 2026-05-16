# ⚡ OrangeHRM · Test Automation Suite

> `status: active` &nbsp;|&nbsp; `last updated: May 16, 2026` &nbsp;|&nbsp; `commits: daily`

---

## 📊 Latest Allure Report — May 16, 2026

| Metric | Result |
|--------|--------|
| Total Test Cases | 27 |
| Pass Rate | 92.59% |
| Duration | 17m 56s |
| Test Suites | 2 |

<img width="1902" alt="Allure Overview" src="https://github.com/user-attachments/assets/8966f9a8-9dcb-47cc-892c-72884c1c4593" />
<img width="1907" alt="Allure Suites" src="https://github.com/user-attachments/assets/28bf9b41-bcc3-4c70-836e-0042af84ff6c" />
<img width="1911" alt="Allure Timeline" src="https://github.com/user-attachments/assets/512fbd39-4cfb-4edf-86fd-a8e2b7ebc9aa" />

---

## 🛠️ Tech Stack

![Java](https://img.shields.io/badge/Java-17-ED8B00?style=flat&logo=openjdk&logoColor=white)
![Selenium](https://img.shields.io/badge/Selenium-4.43.0-43B02A?style=flat&logo=selenium&logoColor=white)
![JUnit5](https://img.shields.io/badge/JUnit-5-25A162?style=flat&logo=junit5&logoColor=white)
![Maven](https://img.shields.io/badge/Maven-C71A36?style=flat&logo=apachemaven&logoColor=white)
![Allure](https://img.shields.io/badge/Allure-2.30.0-orange?style=flat)
![GitHub](https://img.shields.io/badge/GitHub-181717?style=flat&logo=github)

| Category | Tools |
|----------|-------|
| Language | Java 17 |
| Automation | Selenium WebDriver 4.43.0 |
| Test Framework | JUnit 5 |
| Design Pattern | Page Object Model (POM) |
| Reporting | Allure Reports 2.30.0 |
| Build Tool | Maven |
| Version Control | Git & GitHub |
| Testing Types | UI Testing, Frontend Testing, Functional Testing, Regression Testing |
| IDE | IntelliJ IDEA |

---

## 📁 Project Structure
src/
└── test/
└── java/
├── driverSetter/        # WebDriver setup & ChromeOptions config
├── PageObjectModel/     # POM classes for each module
└── testData/            # JUnit 5 test classes

---

## 🗓️ Development Timeline
May 16, 2026  ──●  Allure reporting integrated | 27 test cases | 92.59% pass rate
──●  orangeLogin.java — 12 login test cases completed
──●  orangeDahboard.java — 15 dashboard test cases
──●  Search bar automation with dynamic XPath
──●  Quick launch menu navigation tests
──●  Multi-tab handling (Upgrade, Help, Footer links)
──●  Sidebar collapse/expand tests
──●  Buzz newsfeed scroll & redirect tests
──●  Page Object Model structure established
──●  ChromeOptions configured (language, locale)
──●  Project initialized — HRM login automation

---

## ✅ Test Coverage

### `testData.orangeLogin` — 12 Test Cases
- Correct username & password
- Wrong username / wrong password combinations
- Blank username & password (Required field validation)
- Case sensitivity tests (ADMIN, admin, Admin)
- Forgot password redirect

### `testData.orangeDahboard` — 15 Test Cases
- Timer icon → Attendance page redirect
- My Action icons → Performance & Recruitment redirect
- Quick Launch menu — all 6 items
- Buzz newsfeed scroll & user redirect
- Employees on Leave settings popup
- Upgrade button → new tab verification
- User icon dropdown toggle
- Help button → new tab verification
- Footer OrangeHRM link → new tab
- Sidebar collapse arrow
- OrangeHRM logo click
- Search bar — all 12 menu items verified
- Menu item navigation

---

## 🚀 How to Run

```bash
# Clone the repo
git clone https://github.com/angiln/Automation-HRM-Software-.git

# Run all tests
mvn test

# View Allure report
allure serve target/allure-results
```

---

## 👤 Author

<h3>Angil</h3>

[![GitHub](https://img.shields.io/badge/GitHub-angiln-181717?style=flat&logo=github)](https://github.com/angiln)
![Commits](https://img.shields.io/badge/Commits-Daily-brightgreen?style=flat)
![Status](https://img.shields.io/badge/Project-Active-blue?style=flat)
