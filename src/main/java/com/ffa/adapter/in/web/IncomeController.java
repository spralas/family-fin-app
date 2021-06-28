package com.ffa.adapter.in.web;

import java.time.Month;
import java.time.Year;
import java.util.List;
import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ffa.adapter.in.web.resource.IncomeResource;
import com.ffa.application.port.in.CreateIncomeUseCase;
import com.ffa.application.port.in.GetIncomeUseCase;
import com.ffa.domain.Income;

import lombok.RequiredArgsConstructor;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping("income")
@RequiredArgsConstructor
public class IncomeController {
  private final CreateIncomeUseCase createIncomeUseCase;
  private final GetIncomeUseCase getIncomeUseCase;

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

  @GetMapping("/get-income")
  public ResponseEntity getIncome(@RequestParam("year") Year year, @RequestParam("month") Month month, @RequestParam("ids") List<UUID> ownerIds){
    List<Income> incomes = getIncomeUseCase.getIncomeForGivenPeriodAndOwners(year, month, ownerIds);
    return ok(incomes);
  }
}
