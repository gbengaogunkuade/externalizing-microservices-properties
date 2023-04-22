package com.ogunkuade.employee.service;

import com.ogunkuade.employee.dto.EmployeeRequest;
import com.ogunkuade.employee.dto.EmployeeResponse;
import com.ogunkuade.employee.entity.Employee;
import com.ogunkuade.employee.repository.EmployeeRepository;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;


@Service
public class EmployeeService {

    private EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository){
        this.employeeRepository = employeeRepository;
    }


    public EmployeeResponse saveEmployee(EmployeeRequest employeeRequest){
        Employee employeeNew = new Employee(
                employeeRequest.getName(),
                employeeRequest.getEmail(),
                employeeRequest.getBloodGroup()
        );

        Employee employee = employeeRepository.save(employeeNew);
        EmployeeResponse employeeResponse = new EmployeeResponse(
                employee.getId(),
                employee.getName(),
                employee.getEmail(),
                employee.getBloodGroup()
        );
        return employeeResponse;
    }



    public EmployeeResponse getEmployeeById(Long id) {
        try{
            Employee employeeFound = employeeRepository.findEmployeesById(id);
            EmployeeResponse employeeResponse = new EmployeeResponse(
                    employeeFound.getId(),
                    employeeFound.getName(),
                    employeeFound.getEmail(),
                    employeeFound.getBloodGroup()
            );
            return employeeResponse;
        }
        catch(Exception e){
            System.out.println(String.format("No employee with the id %d in our database", id));
            return new EmployeeResponse();
        }
    }



    public List<EmployeeResponse> getAllEmployees(){
        List<Employee> employees = employeeRepository.findAll();
        List<EmployeeResponse> employeesFound = new ArrayList<>();
        for(Employee employee : employees){
            employeesFound.add(new EmployeeResponse(
                    employee.getId(),
                    employee.getName(),
                    employee.getEmail(),
                    employee.getBloodGroup()
                    ));
        }
        return employeesFound;
    }



}
