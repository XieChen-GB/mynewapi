package com.example.mynewapi;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }

    @GetMapping("/1")
    public Employee getEmployee() {
        return new Employee("003561", "谢晨", "電算室");
    }

    @GetMapping("/employees")
    public List<Employee> getEmployees() {
        return employeeService.getAllEmployees();
    }

    @GetMapping("/employees/{employeeId}")
    public Employee getEmployeeByEmployeeId(@PathVariable String employeeId) {
        return employeeService.getEmployeeById(employeeId).orElse(null);
    }

    @GetMapping("/employees/search")
    public Employee searchEmployee(@RequestParam String name) {
        return employeeService.searchByName(name).orElse(null);
    }

    @PostMapping("/employees")
    public List<Employee> addEmployees(@RequestBody List<Employee> employees) {
        return employeeService.addEmployees(employees);
    }
}
