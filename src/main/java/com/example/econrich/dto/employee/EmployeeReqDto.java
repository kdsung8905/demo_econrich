package com.example.econrich.dto.employee;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

public class EmployeeReqDto {

    @Getter
    @Setter
    public static class IncreaseSalaryDto{

        @Schema(description = "jobId(pk)", example = "AD_VP")
        private String jobId;
        @Schema(description = "인상 비율(%)", example = "15")
        private BigDecimal payIncreaseRate;

    }
}
