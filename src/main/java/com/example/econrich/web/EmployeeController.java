package com.example.econrich.web;

import com.example.econrich.config.CustomApiResponse;
import com.example.econrich.dto.ResponseDto;
import com.example.econrich.dto.employee.EmployeeReqDto;
import com.example.econrich.dto.employee.EmployeeResDto;
import com.example.econrich.service.EmployeeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name = "employee", description = "employee 컨트롤러")
@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;

    @Operation(summary = "employee 현재 정보", description = "특정 사원의 현재 정보 조회")
    @ApiResponse(responseCode = "200", description = "successful operation",
            content = @Content(
                    mediaType = "application/json",
                    schema = @Schema(implementation = EmployeeResDto.ProfileResDto.class),
                    examples = @ExampleObject(value = "{\"code\": 1, \"msg\" : \"직원 정보 조회 성공\", \"data\" : \"ProfileResDto\"}")))
    @CustomApiResponse
    @GetMapping("/employee/{id}")
    public ResponseEntity findProfile(
            @Parameter(name = "id", description = "직원id(pk)", example = "101")
            @PathVariable(value = "id") Long id){

        return ResponseEntity.ok().body(new ResponseDto<>(1, "직원 정보 조회 성공", employeeService.findProfile(id)));
    }

    @Operation(summary = "employee 이력 정보", description = "특정 사원의 이력 정보 조회")
    @ApiResponse(responseCode = "200", description = "successful operation",
            content = @Content(
                    mediaType = "application/json",
                    schema = @Schema(implementation = EmployeeResDto.JobHistoryResDto.class),
                    examples = @ExampleObject(value = "{\"code\": 1, \"msg\" : \"직원 이력 조회 성공\", \"data\" : \"JobHistoryResDto\"}")))
    @CustomApiResponse
    @GetMapping("/employee/history/{id}")
    public ResponseEntity findHistory(
            HttpServletRequest request,
            @Parameter(name = "id", description = "employee(id)", example = "101")
            @PathVariable(value = "id") Long id){

        return ResponseEntity.ok().body(new ResponseDto<>(1, "직원 이력 조회 성공", employeeService.findHistory(id)));
    }

    @Operation(summary = "특정 부서의 급여 인상", description = "특정 부서의 급여 인상")
    @ApiResponse(responseCode = "200", description = "successful operation",
            content = @Content(
                    mediaType = "application/json",
                    examples = @ExampleObject(value = "{\"code\": 1, \"msg\" : \"해당 부서의 급여인상 성공\", \"data\" : \"\"}")))
    @CustomApiResponse
    @PutMapping ("/employee/increase-salary")
    public ResponseEntity increaseSalary(
            @RequestBody EmployeeReqDto.IncreaseSalaryDto dto){

        employeeService.increaseSalary(dto);

        return ResponseEntity.ok().body(new ResponseDto<>(1, "해당 부서의 급여인상 성공", null));
    }





}