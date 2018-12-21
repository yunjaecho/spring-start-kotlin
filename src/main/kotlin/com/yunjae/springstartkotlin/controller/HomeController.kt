package com.yunjae.springstartkotlin.controller

import com.yunjae.springstartkotlin.service.EmployeeService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class HomeController @Autowired constructor(val employeeService: EmployeeService) {

    /*@Autowired
    lateinit var employeeService: EmployeeService*/

    @GetMapping("/{id}")
    fun getName(@PathVariable("id") id: Int): String {
        return "Name: ${employeeService.findEmployee(id)}"
    }
}