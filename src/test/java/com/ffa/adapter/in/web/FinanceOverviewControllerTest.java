package com.ffa.adapter.in.web;

import java.time.LocalDate;
import java.time.Month;
import java.time.Year;
import java.util.List;
import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ffa.application.port.in.GetFinanceOverviewUseCase;
import com.ffa.domain.FinanceOverview;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = FinanceOverviewController.class)
public class FinanceOverviewControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private GetFinanceOverviewUseCase getFinanceOverviewUseCase;

    @Test
    void testGetFinanceOverview_ReturnStatus200() throws Exception {
        //given
        Year year = Year.of(LocalDate.now().getYear());
        Month month = Month.JANUARY;
        List<UUID> owners = List.of(UUID.randomUUID(), UUID.randomUUID(), UUID.randomUUID());
        FinanceOverview financeOverview = FinanceOverview.builder().build();
        when(getFinanceOverviewUseCase.getFinanceOverviewForGivenDateAndOwners(year, month, owners)).thenReturn(financeOverview);

        // when
        mockMvc.perform(get("/overview")
                          .param("year", year.toString())
                          .param("month", month.toString())
                          .param("ids", UUID.randomUUID().toString())
                          .contentType("application/json"))
               .andExpect(status().isOk());
    }
}
