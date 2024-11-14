package controllers

import models.Employee

class EmployeeAPI(private val departmentAPI: DepartmentAPI) {
    private val employees = mutableListOf<Employee>()

    fun addEmployee(employee: Employee){
        // add code to validate that employeeId and deptId exist
        // add code for adding a employee with a unique id
        employees.add(employee)
    }

    fun getAllEmployees(): List<Employee> = employees

    fun getEmployeesByDepartment(departmentId: Int): List<Employee> =
        employees.filter { it.departmentId == departmentId }

    fun addEmployeeToDepartment(employeeId: Int, departmentId: Int) : String {
        val employee = employees.find { it.id == employeeId }
        if (employee == null) {
            return "models.Employee with ID \${employeeId} does not exist"
        } else if (departmentAPI.departmentExists(departmentId) != null) {
            return "models.Department with ID \${departmentId} does not exist."
        } else {
            employees[employees.indexOf(employee)] = employee.copy(departmentId = departmentId)
            return "models.Employee \${employee.name} moved to department ID \${departmentId}."
        }
    }
}