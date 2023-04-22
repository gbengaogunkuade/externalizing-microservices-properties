package com.ogunkuade.employee.controller;

import com.ogunkuade.employee.dto.EmployeeRequest;
import com.ogunkuade.employee.dto.EmployeeResponse;
import com.ogunkuade.employee.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/employee")
public class EmployeeController {


    private EmployeeService employeeService;


    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping("/create")
    public EmployeeResponse savingEmployee(@RequestBody EmployeeRequest employeeRequest){
        return employeeService.saveEmployee(employeeRequest);
    }

    @GetMapping("/{id}")
    public EmployeeResponse gettingEmployeeById(@PathVariable Long id){
        System.out.println("Getting Employee By Id");
        return employeeService.getEmployeeById(id);
    }

    @GetMapping("/all")
    public List<EmployeeResponse> getttingAllEmployees(){
        System.out.println("Getting All Employees");
        return employeeService.getAllEmployees();
    }



}
