import controllers.DepartmentAPI
import controllers.EmployeeAPI
import models.Department
import models.Employee

// Main function for handling operations
fun main() {

    val departmentAPI = DepartmentAPI()
    val employeeAPI = EmployeeAPI(departmentAPI)

    // Adding sample departments
    departmentAPI.addDepartment(Department(1, "HR"))
    departmentAPI.addDepartment(Department(2, "Engineering"))

    // Adding sample employees
    employeeAPI.addEmployee(Employee(1, "Alice", 1))
    employeeAPI.addEmployee(Employee(2, "Bob", 2))

    // Adding employees to a department
    employeeAPI.addEmployeeToDepartment(1, 2)
    employeeAPI.addEmployeeToDepartment(2, 1)

    // Displaying all employees
    println("All Employees:")
    employeeAPI.getAllEmployees().forEach { println(it) }

    // Displaying all departments
    println("All Departments:")
    departmentAPI.getAllDepartments().forEach { println(it) }

    // Displaying employees by department
    println("\nEmployees in models.Department 1:")
    employeeAPI.getEmployeesByDepartment(1).forEach { println(it) }

    // Displaying employees by department
    println("\nEmployees in models.Department 2:")
    employeeAPI.getEmployeesByDepartment(2).forEach { println(it) }

}
