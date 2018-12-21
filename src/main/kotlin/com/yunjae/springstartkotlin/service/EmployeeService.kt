package com.yunjae.springstartkotlin.service

import com.yunjae.springstartkotlin.model.Employee
import com.yunjae.springstartkotlin.model.EmployeeDto
import com.yunjae.springstartkotlin.model.EmployeeUpdateReq
import com.yunjae.springstartkotlin.repository.EmployeeRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.ui.Model
import reactor.core.publisher.Mono
import reactor.core.publisher.toMono

@Service
class EmployeeService {

    @Autowired
    lateinit var employeeRepo: EmployeeRepository


    fun createEmployee(employee: EmployeeDto) = employeeRepo.save(EmployeeDto.fromDto(employee))

    fun getEmployee(id: String): Mono<Employee> = employeeRepo.findById(id)

    fun getAllEmployees(minAage: Int? = null, minSalary: Double? = null) =
            employeeRepo.findAll()
                    .filter { it.age >= minAage ?: Int.MIN_VALUE }
                    .filter { it.salary > minSalary ?: Double.MIN_VALUE }

    fun updateEmployee(id: String, updateEmployee: EmployeeUpdateReq): Mono<Employee> {
        return employeeRepo.findById(id)
                .flatMap {
                    it.department = updateEmployee.department ?: it.department
                    it.salary = updateEmployee.salary ?: it.salary
                    println(updateEmployee.toString())
                    employeeRepo.save(it)
                }
    }

    fun deleteEmployee(id: String) = employeeRepo.deleteById(id)


    val employeeMap = hashMapOf(1 to "Alberto", 2 to "Peter", 3 to "John")

    fun findEmployee(id: Int) = employeeMap[id] ?: "Not_Found"
}