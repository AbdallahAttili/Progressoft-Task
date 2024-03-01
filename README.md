
# Progressoft Task: Deals Management System

The Deals Management System is designed to streamline the process of adding and managing deal transactions within the Progressoft platform. This system facilitates the efficient handling of deal data, ensuring accuracy and reliability in financial transactions.

## Features

- **Add Deals**: Users can add deal transactions with detailed attributes including deal ID, currency pairs, deal timestamp, and transaction amounts.
- **View Deal By ID**: Provides functionality to view deal by id.
- **View all Deals**: Provides functionality to view all deals in the system.
- **Deal Validation**: Ensures all deals meet specific criteria before being added to the system.

## Getting Started

### Prerequisites

- Java JDK 17 or later
- Maven 3.6 or later (for building the project)
- MySQL 5.7 or later

### Installation

1. **Clone the repository**

   ```
   git clone https://github.com/AbdallahAttili/Progressoft-Task.git
   ```

2. **Navigate to the project directory**

   ```
   cd Progressoft-Task
   ```

3. **Build the project with Maven**

   ```
   mvn clean install
   ```

4. **Configure the database**

    - Ensure your MySQL service is running.
    - Create a database named `fx_deals`.
    - Update `src/main/resources/application.properties` with your database credentials.

5. **Run the application**

   ```
     sudo docker-compose up --build
   ```
   or
   ```
   java -jar target/progresSoftApplication-0.0.1-SNAPSHOT.jar
   ```

   Alternatively, you can run the application directly through Maven:

   ```
   mvn spring-boot:run
   ```

### Usage

- **Add a Deal**: Send a POST request to `/deals/add-deals` with the deal information in JSON format.

  ```json
  {
    "dealId": "12345",
    "fromCurrencyIsoCode": "USD",
    "toCurrencyIsoCode": "EUR",
    "dealTimestamp": "2023-03-15T14:30:00",
    "dealOrderingAmount": 1000
  }
  ```

- **View Deal by Id**: Access `/deals/{dealId}` to view all deals in the system.
- **View Deals**: Access `/deals/list` to view all deals in the system.

## Contributing

We welcome contributions to the Deals Management System. Please follow these steps to contribute:

1. Fork the repository.
2. Create a new branch (`git checkout -b feature/AmazingFeature`).
3. Commit your changes (`git commit -m 'Add some AmazingFeature'`).
4. Push to the branch (`git push origin feature/AmazingFeature`).
5. Open a Pull Request.

## License

Distributed under the MIT License. See `LICENSE` for more information.

## Contact
Project Link: [https://github.com/AbdallahAttili/Progressoft-Task](https://github.com/AbdallahAttili/Progressoft-Task)
