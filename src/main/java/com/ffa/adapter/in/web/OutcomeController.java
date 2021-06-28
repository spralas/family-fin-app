package com.ffa.adapter.in.web;

import java.time.Month;
import java.time.Year;
import java.util.List;
import java.util.UUID;

import static org.springframework.http.ResponseEntity.ok;

import com.ffa.adapter.in.web.resource.IncomeResource;
import com.ffa.adapter.in.web.resource.OutcomeResource;
import com.ffa.application.port.in.CreateOutcomeUseCase;
import com.ffa.domain.Income;
import com.ffa.domain.Outcome;

import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("outcome")
@RequiredArgsConstructor
public class OutcomeController {
    private final CreateOutcomeUseCase createOutcomeUseCase;

    @PostMapping("/create-outcome")
    public ResponseEntity createOutcome(@Validated @RequestBody OutcomeResource outcomeResource) {
        Outcome outcome = Outcome.builder()
                                 .yearOutcome(outcomeResource.getYearOutcome())
                                 .monthOutcome(outcomeResource.getMonthOutcome())
                                 .amount(outcomeResource.getAmount())
                                 .ownerId(outcomeResource.getOwnerId())
                                 .build();

        Outcome savedOutcome = createOutcomeUseCase.createOutcome(outcome);

        OutcomeResource response = OutcomeResource.builder()
                                                  .id(savedOutcome.getId())
                                                  .yearOutcome(savedOutcome.getYearOutcome())
                                                  .monthOutcome(savedOutcome.getMonthOutcome())
                                                  .amount(savedOutcome.getAmount())
                                                  .ownerId(savedOutcome.getOwnerId())
                                                  .build();
        return ok(response);
    }

    @GetMapping("/get-outcome")
    public void getOutcome(@RequestParam("year") Year year, @RequestParam("month") Month month, @RequestParam("ids") List<UUID> ownerIds) {

    }
}
