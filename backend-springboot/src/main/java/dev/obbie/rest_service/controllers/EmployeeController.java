package dev.obbie.rest_service.controllers;

import dev.obbie.rest_service.domain.Employee;
import dev.obbie.rest_service.exception.ResourceNotFoundException;
import dev.obbie.rest_service.repository.EmployeeRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class EmployeeController {
    private final EmployeeRepository employeeRepository;
    public EmployeeController(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }
    //read
   @GetMapping("/employees")
   public List<Employee> all(){
        return employeeRepository.findAll();
    }
    //create
    @PostMapping("/employees")
    public Employee createEmployee(@RequestBody Employee employee){
       return employeeRepository.save(employee);
    }
    @GetMapping("/employees/{id}")
    public ResponseEntity<Employee> getById(@PathVariable Long id){
        Employee employee= employeeRepository.findById(id)
                .orElseThrow(()->new ResourceNotFoundException(
                        "Employee with "+id+" does not exist "));
        return ResponseEntity.ok(employee);
    }
    //update
    @PutMapping("/employees/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable Long id, @RequestBody
             Employee employee){
        Employee emp = employeeRepository.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("Employee with "+id+" does not exist "));
        emp.setName(employee.getName());
        emp.setLastName(employee.getLastName());
        emp.setEmailId(employee.getEmailId());
        Employee updated = employeeRepository.save(emp);
        return ResponseEntity.ok(updated);
    }
    //delete
    @DeleteMapping("/employees/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteEmployee(@PathVariable Long id){
        Employee employee =employeeRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Employee with "+id+" does not exist "));
        employeeRepository.delete(employee);
        Map<String,Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }
}
