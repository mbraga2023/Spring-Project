Java Spring Web Project

Originally developed by Danilo Aparecido (https://github.com/didox)

Administrative Web Application
This project is an administrative web application developed using Java Spring framework, with the Thymeleaf templating engine. It utilizes a MariaDB SQL database to manage data and perform various operations. The main focus of this application is to provide a user-friendly interface for managing data, performing CRUD operations, and ensuring secure access through a login system.

Features
Login Page: The application features a secure login page that uses cookies to control access to the administrative pages. Users need to authenticate themselves before accessing the main functionalities.

CRUD Operations: The application allows users to perform CRUD (Create, Read, Update, Delete) operations on data stored in the MariaDB SQL database. Users can add new entries, update existing ones, view details, and delete entries.

Thymeleaf Templating: Thymeleaf is used to create dynamic and interactive web pages. It enables the seamless integration of server-side code with HTML templates, making the application responsive and user-friendly.

Database Integration: The application integrates with the MariaDB SQL database, allowing efficient storage, retrieval, and manipulation of data. This enables users to manage information effectively and ensure data integrity.

User Interface Styling: The user interface of the application is designed with a clean and modern look. It uses the Bootstrap framework, CSS, and JavaScript to provide a visually appealing and responsive experience.

Setup Instructions
Clone the Repository: Start by cloning this repository to your local machine using the following command:

sh
Copy code
git clone https://github.com/mbraga2023/Spring-Project
Database Configuration: Set up your MariaDB database and configure the connection details in the application's configuration files.

Build and Run: Use Maven to build the application and run it using a local server. Navigate to the project directory and execute the following commands:

sh
Copy code
cd admin-web-app
mvn clean install
mvn spring-boot:run
Access the Application: Open your web browser and go to http://localhost:8080 to access the administrative web application. You will be directed to the login page where you can authenticate and start using the application.

Dependencies
Java Spring Framework
Thymeleaf Templating Engine
MariaDB SQL Database
Bootstrap CSS Framework
Maven Build Tool

Contribution
Contributions are welcome! If you have suggestions, improvements, or bug fixes, please feel free to create a pull request or open an issue.

License
This project is licensed under the MIT License. Feel free to use and modify it for your own purposes.

Thank you for your interest in our Administrative Web Application. If you have any questions or need further assistance, please don't hesitate to contact us.
