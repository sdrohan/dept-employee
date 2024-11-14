package controllers

import models.Department

class DepartmentAPI {
    private val departments = mutableListOf<Department>()

    fun addDepartment(department: Department) {
        //add code for adding a dept with a unique id
        departments.add(department)
    }

    fun getAllDepartments(): List<Department> = departments

    fun departmentExists(departmentId: Int): Department? {
        return departments.find { it -> it.id == departmentId }
    }
}