# 🌐 Enuygun.com Web Test Automation Project

This project is created to test **Enuygun.com**'s web application with end-to-end automation flows. The tests are written using **Java (JDK 24.0.1)**, **Selenium**, and **TestNG**, and results are reported using **Allure**.  
The aim is to validate core booking functionalities on the platform, including hotel, flight, and car rental flows.

---

## 🚀 Technologies and Tools Used

| Technology / Tool    | Description                                        |
|---------------------|----------------------------------------------------|
| Java (JDK 24.0.1)   | Programming language for the test code             |
| Selenium WebDriver  | Web UI automation library                          |
| TestNG              | Testing framework for managing and executing tests |
| Allure Reports      | Test reporting and visual result dashboard         |
| Maven               | Project and dependency management tool             |
| IntelliJ IDEA       | Recommended IDE for development                    |

---

## 🧪 Test Environment

- **Platform:** Enuygun.com (Web Application)  
- **Browser:** Chrome (Latest Stable)  
- **Automation Type:** End-to-End UI Test Automation  
- **Test Runner:** TestNG  
- **Reporting Tool:** Allure  

---

## 📁 Project Structure

```
enuygun-web-automation/
├── src/
│   └── test/
│       └── java/
│           ├── Pages/            # Page Object Model classes
│           │   ├── GuestInfoPage
│           │   ├── HomePage
│           │   ├── HomePageCar
│           │   ├── HotelSearchPage
│           │   └── PaymentPage
│           ├── Tests/            # Test Scenarios
│           │   ├── BaseTest
│           │   ├── carRentalTest
│           │   ├── FlightTicket
│           │   └── HotelReservationTest
│           ├── Utils/            # Utilities and reusable methods
│           │   ├── DriverFactory
│           │   ├── LogHelper
│           │   └── RMethods
│           └── Data/
│               └── logback.xml
├── pom.xml
├── .gitignore
```

---

## 📊 Test Report

The following reports are generated after execution:

- **Framework:** Allure  
- **Total Tests:** 3  
- **Test Suites:** HotelReservationTest, FlightTicket, carRentalTest  
- **Result:** ✅ All test cases passed successfully  
- **How to View:**  
  ```bash
  allure serve allure-results
  ```

---

## 🧭 Test Scope (User Stories)

- ✅ **US_01:** ✈️ Flight Ticket Search and Filtering  
  Users can search for flights, and filter by date, airline, and price.

- ✅ **US_02:** 🏨 Hotel Listing, Filtering & Reservation  
  Users can filter hotels by date, price, and rating, and proceed to the reservation screen.

- ✅ **US_03:** 🚗 Car Rental Search and Filtering  
  Users can search for cars by city and date, and filter by gearbox, fuel type, and price range.

---

## 📬 Contact

| Test Scenario             | QA Engineer               | LinkedIn                                              |
|--------------------------|---------------------------|--------------------------------------------------------|
| Hotel Reservation Test   | Oğuzhan Melih Güçlü       | [linkedin.com/in/oguzhanmelihguclu](https://www.linkedin.com/in/oguzhanmelihguclu/) |
| Car Rental Test          | Sezgin Mert               | [linkedin.com/in/sezginmert](https://www.linkedin.com/in/sezginmert/)               |
| Flight Ticket Test       | Mert Güler                | [linkedin.com/in/mertglerr](https://www.linkedin.com/in/mertglerr/)                 |

- **Email:** [oguzhanmguclu@gmail.com](mailto:oguzhanmguclu@gmail.com)
