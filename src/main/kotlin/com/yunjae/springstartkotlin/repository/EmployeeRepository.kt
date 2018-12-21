package com.yunjae.springstartkotlin.repository

import com.yunjae.springstartkotlin.model.Employee
import org.springframework.data.cassandra.repository.ReactiveCassandraRepository

interface EmployeeRepository: ReactiveCassandraRepository<Employee, String>