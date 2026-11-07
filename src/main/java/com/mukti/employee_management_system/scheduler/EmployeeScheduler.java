package com.mukti.employee_management_system.scheduler;

import com.mukti.employee_management_system.repository.EmployeeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class EmployeeScheduler {
    private final EmployeeRepository employeeRepository;
    public EmployeeScheduler(EmployeeRepository employeeRepository){
        this.employeeRepository=employeeRepository;
    }
    @Scheduled(fixedRate = 30000)
    public void employeeCountTask(){
        long employeeCount=employeeRepository.count();
        log.info("Current total employee in database: {}",employeeCount);
    }
    @Scheduled(fixedRate = 10000)
    public void taskScheduler(){
        log.info("Scheduler is working");
    }
    @Scheduled(cron = "0 0 9 * * *",zone = "Asia/Kolkata")
    public void dailyReporter(){
        log.info("Daily employees report generated ");
    }
}
