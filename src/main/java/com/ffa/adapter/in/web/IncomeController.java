package com.ffa.adapter.in.web;

import static org.springframework.http.ResponseEntity.ok;

import com.ffa.adapter.in.web.resource.IncomeResource;
import com.ffa.application.port.in.CreateIncomeUseCase;
import com.ffa.domain.Income;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("income")
@RequiredArgsConstructor
public class IncomeController {
  private final CreateIncomeUseCase createIncomeUseCase;

  @PostMapping("/create-income")
  public ResponseEntity createIncome(@Validated @RequestBody IncomeResource incomeResource){
    Income income = Income.builder()
                          .yearIncome(incomeResource.getYearIncome())
                          .monthIncome(incomeResource.getMonthIncome())
                          .amount(incomeResource.getAmount())
                          .ownerId(incomeResource.getOwnerId())
                          .build();

    Income savedIncome = createIncomeUseCase.createIncome(income);

    IncomeResource response = IncomeResource.builder()
                                            .id(savedIncome.getId())
                                            .yearIncome(savedIncome.getYearIncome())
                                            .monthIncome(savedIncome.getMonthIncome())
                                            .amount(savedIncome.getAmount())
                                            .ownerId(savedIncome.getOwnerId())
                                            .build();

    return ok(response);
  }

}
