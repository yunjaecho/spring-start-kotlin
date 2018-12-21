package com.yunjae.springstartkotlin.controller

import com.yunjae.springstartkotlin.model.Employee
import com.yunjae.springstartkotlin.model.EmployeeDto
import com.yunjae.springstartkotlin.model.EmployeeUpdateReq
import com.yunjae.springstartkotlin.service.DepartmentService
import com.yunjae.springstartkotlin.service.EmployeeService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import reactor.core.publisher.Mono
import javax.validation.Valid

@RestController
class EmployeeController {
    @Autowired
    lateinit var employeeService: EmployeeService

    @Autowired
    lateinit var departmentService: DepartmentService

    @PostMapping("/employee")
    fun createEmployee(@Valid @RequestBody employee: EmployeeDto) =
            employeeService.createEmployee(employee).map { newEmployee -> ResponseEntity.status(HttpStatus.CREATED).body(newEmployee) }

    @GetMapping("/employee/{id}")
    fun getEmployee(@PathVariable("id") id: String) = employeeService.getEmployee(id).map { EmployeeDto.toDto(it) }

    @GetMapping("/employee")
    fun getEmployee(@RequestParam("minAge", required = false) minAge: Int?,
                    @RequestParam("minSalary", required = false) minSalary: Double?) =
            employeeService.getAllEmployees(minAge, minSalary)

    @GetMapping("/departments")
    fun getAllDepartments() = departmentService.getAllDepartments()

    @PutMapping("/employee/{id}")
    fun updateEmployee(@PathVariable("id") id: String, @Valid @RequestBody updateEmployee: EmployeeUpdateReq): Mono<Employee> {
        return employeeService.updateEmployee(id, updateEmployee)
    }

    @RequestMapping("/employee/{id}", method = arrayOf(RequestMethod.DELETE))
    fun deleteEmployee(@PathVariable("id") id: String) = employeeService.deleteEmployee(id)


}