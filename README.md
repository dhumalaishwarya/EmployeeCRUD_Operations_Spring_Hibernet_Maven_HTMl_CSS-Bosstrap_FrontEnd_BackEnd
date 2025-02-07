# EmployeeCRUD_Operations_Spring_Hibernet_Maven_HTMl_CSS-Bosstrap_FrontEnd_BackEnd
Employee_CRUD_Operations
 this is url 
 Open http://localhost:8080/employees.


 Mysql connection 
 CREATE DATABASE employee_db;
USE employee_db;

CREATE TABLE employees (
    id INT AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL
);
