package com.example.econrich.service;

import com.example.econrich.domain.employee.Employee;
import com.example.econrich.domain.employee.EmployeeRepository;
import com.example.econrich.domain.employee.EmployeeRepositoryCustom;
import com.example.econrich.dto.employee.EmployeeReqDto;
import com.example.econrich.dto.employee.EmployeeResDto;
import com.example.econrich.handler.exception.CustomApiException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeService {


    private final EmployeeRepositoryCustom employeeRepositoryCustom;

    public EmployeeResDto.ProfileResDto findProfile(Long id){
        return employeeRepositoryCustom.findProfile(id).orElseThrow(() -> new CustomApiException("해당 id에 대한 조회 결과가 없습니다."));
    }

    public List<EmployeeResDto.JobHistoryResDto> findHistory(Long id){
        return employeeRepositoryCustom.findHistory(id);
    }

    public void increaseSalary(EmployeeReqDto.IncreaseSalaryDto dto){
        employeeRepositoryCustom.updateSalary(dto);
    }
}
