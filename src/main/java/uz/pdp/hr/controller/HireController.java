package uz.pdp.hr.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import uz.pdp.hr.payload.ApiResponse;
import uz.pdp.hr.payload.EmployeeHireDto;
import uz.pdp.hr.service.HireService;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@RestController
@RequestMapping(path = "/api/hire")
@RequiredArgsConstructor
public class HireController {

    @Autowired
    HireService hireService;

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/director")
    public ResponseEntity<?> addDirector(@Valid @RequestBody EmployeeHireDto dto){
        ApiResponse apiResponse = hireService.addDirector(dto);
        return ResponseEntity.status(apiResponse.isSuccess() ? 201 : 409).body(apiResponse);
    }

    @PreAuthorize("hasAnyRole('ADMIN', 'DIRECTOR')")
    @PostMapping("/manager")
    public ResponseEntity<?> addManager(@Valid @RequestBody EmployeeHireDto dto) {
        ApiResponse apiResponse = hireService.addManager(dto);
        return ResponseEntity.status(apiResponse.isSuccess() ? 201 : 409).body(apiResponse);
    }

    @PreAuthorize("hasAnyRole('ADMIN', 'DIRECTOR', 'HR_MANAGER')")
    @PostMapping("/worker")
    public ResponseEntity<?> addWorker(@Valid @RequestBody EmployeeHireDto dto) {
        ApiResponse apiResponse = hireService.addWorker(dto);
        return ResponseEntity.status(apiResponse.isSuccess() ? 201 : 409).body(apiResponse);
    }

    @PostMapping("/verify")
    public ResponseEntity<?> verifyPassword(@RequestParam String emailCode, @RequestParam String email, HttpServletRequest request) {
        ApiResponse apiResponse = hireService.verify(emailCode, email, request);
        return ResponseEntity.status(apiResponse.isSuccess() ? 200 : 409).body(apiResponse);
    }

}