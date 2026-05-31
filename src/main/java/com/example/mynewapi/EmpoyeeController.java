package com.example.mynewapi;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class EmpoyeeController {

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
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("003561", "谢晨", "電算室"));
        employees.add(new Employee("003562", "田中太郎", "営業部"));
        employees.add(new Employee("003563", "李明", "技術部"));
        return employees;
    }

    @GetMapping("/employees/{employeeId}")
    public Employee getEmployeeByEmployeeId(@PathVariable String employeeId) {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("003561", "谢晨", "電算室"));
        employees.add(new Employee("003562", "田中太郎", "営業部"));
        employees.add(new Employee("003563", "李明", "技術部"));
        for (Employee employee : employees) {
            if (employee.getEmployeeId().equals(employeeId)) {
                return employee;
            }
        }
        return null;
    }

    @GetMapping("/employees/search")
    public Employee searchEmployee(@RequestParam String name) {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("003561", "谢晨", "電算室"));
        employees.add(new Employee("003562", "田中太郎", "営業部"));
        employees.add(new Employee("003563", "李明", "技術部"));
        for (Employee employee : employees) {
            if (employee.getName().equals(name)) {
                return employee;
            }
        }
        return null;
    }

    @PostMapping("/employees")
    public List<Employee> addEmployees(@RequestBody List<Employee> employees) {
        return employees;
    }
}
