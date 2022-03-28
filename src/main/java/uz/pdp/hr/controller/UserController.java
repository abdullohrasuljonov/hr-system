package uz.pdp.hr.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import uz.pdp.hr.payload.ApiResponse;
import uz.pdp.hr.payload.ChangeSalaryDto;
import uz.pdp.hr.payload.EmployeeDto;
import uz.pdp.hr.payload.EmployeeLoginDto;
import uz.pdp.hr.service.EmployeeService;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/employee")
public class UserController {

    @Autowired
    EmployeeService employeeService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@Valid @RequestBody EmployeeLoginDto dto) {
        ApiResponse apiResponse = employeeService.login(dto);
        return ResponseEntity.status(apiResponse.isSuccess() ? 200 : 401).body(apiResponse);
    }

    @PreAuthorize("hasAnyRole('ADMIN', 'DIRECTOR')")
    @PutMapping("/edit/{id}")
    public ResponseEntity<?> edit(@Valid @RequestBody EmployeeDto email, @PathVariable String id) {
        ApiResponse apiResponse = employeeService.edit(email, id);
        return ResponseEntity.status(apiResponse.isSuccess() ? 200 : 401).body(apiResponse);
    }

    @PreAuthorize("hasAnyRole('ADMIN', 'DIRECTOR')")
    @PutMapping("/edit")
    public ResponseEntity<?> editSalary(@Valid @RequestBody ChangeSalaryDto dto) {
        ApiResponse apiResponse = employeeService.editSalary(dto);
        return ResponseEntity.status(apiResponse.isSuccess() ? 200 : 401).body(apiResponse);
    }

    @PreAuthorize("hasAnyRole('DIRECTOR','HR_MANAGER')")
    @GetMapping
    public ResponseEntity<?> get() {
        ApiResponse apiResponse = employeeService.get();
        return ResponseEntity.status(apiResponse.isSuccess() ? 200 : 401).body(apiResponse);
    }

    @PreAuthorize("hasAnyRole('DIRECTOR','HR_MANAGER')")
    @GetMapping("/{email}")
    public ResponseEntity<?> info(@PathVariable String email, @RequestParam String from, @RequestParam String to) {
        ApiResponse apiResponse = employeeService.info(email, from, to);
        return ResponseEntity.status(apiResponse.isSuccess() ? 200 : 401).body(apiResponse);
    }

    @PreAuthorize("hasAnyRole('DIRECTOR','HR_MANAGER')")
    @GetMapping("/salary/{email}")
    public ResponseEntity<?> infoSalary(@PathVariable String email, @RequestParam String from, @RequestParam String to) {
        ApiResponse apiResponse = employeeService.infoSalary(email, from, to);
        return ResponseEntity.status(apiResponse.isSuccess() ? 200 : 401).body(apiResponse);
    }

    @PreAuthorize("hasAnyRole('DIRECTOR','HR_MANAGER')")
    @GetMapping("/task/{email}")
    public ResponseEntity<?> infoTask(@PathVariable String email, @RequestParam String from, @RequestParam String to) {
        ApiResponse apiResponse = employeeService.infoTask(email, from, to);
        return ResponseEntity.status(apiResponse.isSuccess() ? 200 : 401).body(apiResponse);
    }

    @PreAuthorize("hasRole('DIRECTOR')")
    @DeleteMapping("/{email}")
    public ResponseEntity<?> delete(@PathVariable String email) {
        ApiResponse apiResponse = employeeService.delete(email);
        return ResponseEntity.status(apiResponse.isSuccess() ? 200 : 401).body(apiResponse);
    }
}