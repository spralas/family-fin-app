package com.ffa.adapter.in.web;

import java.time.LocalDate;
import java.time.Month;
import java.time.Year;
import java.util.List;
import java.util.UUID;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ffa.application.port.in.GetFinanceOverviewUseCase;
import com.ffa.domain.FinanceOverview;

import lombok.RequiredArgsConstructor;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping("overview")
@RequiredArgsConstructor
public class FinanceOverviewController {
    private final GetFinanceOverviewUseCase getFinanceOverviewUseCase;

    @GetMapping
    public ResponseEntity getFinanceOverview(@RequestParam("year") Year year, @RequestParam("month") Month month, @RequestParam("ids") List<UUID> ownerIds){
        FinanceOverview financeOverview = getFinanceOverviewUseCase.getFinanceOverviewForGivenDateAndOwners(year, month, ownerIds);
        return ok(financeOverview);
    }
}
