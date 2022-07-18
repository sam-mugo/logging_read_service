package logging_service.service;


import logging_service.domain.EmployeeLogs;
import logging_service.repo.EmployeeLogsRepo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.OffsetTime;


@Service
public class EmployeeLogsService {
    private final EmployeeLogsRepo employeeLogsRepo;

    public EmployeeLogsService(EmployeeLogsRepo employeeLogsRepo) {
        this.employeeLogsRepo = employeeLogsRepo;
    }

    /*
    * Saves logs to db Table
    * */
    public EmployeeLogs saveLog(EmployeeLogs employeeLogs) {
        return employeeLogsRepo.save(employeeLogs);
    }



    /*
     * Retrieves all EmployeeLogs
     * with a page size limit
     * */
    public Page<EmployeeLogs> findAllLogs(Integer pageNo, Integer pageSize) {
        Pageable paging = PageRequest.of(pageNo, pageSize);

        return employeeLogsRepo.findAll(paging);
    }


    /*
     * Retrieves all EmployeeLogs
     * paged between two dates
     * */
    public Page<EmployeeLogs> findAllLogsBetweenDates(Integer pageNo, Integer pageSize, OffsetTime startDate, OffsetTime endDate) {
        Pageable paging  = PageRequest.of(pageNo, pageSize);
        return (Page<EmployeeLogs>) employeeLogsRepo.findByDateCreatedBetween(startDate, endDate, paging);
    }

    /*
     * Retrieves paged results of all logs by userId
     * */
    public Page<EmployeeLogs> findLogsByUserId(final Long userId, Integer pageNo, Integer pageSize) {
        Pageable paging  = PageRequest.of(pageNo, pageSize);
        return (Page<EmployeeLogs>) employeeLogsRepo.findAllByUserId(userId, paging);
    }


    /*
     * Retrieves paged results of all logs by userId between a range of dates
     * */
    public Page<EmployeeLogs> findLogsByUSerIdBetweenDates(final Long userId,
                                                                 OffsetTime startDate,
                                                                 OffsetTime endDate,
                                                                 Integer pageNo, Integer pageSize) {
        Pageable paging = PageRequest.of(pageNo, pageSize);
        return (Page<EmployeeLogs>) employeeLogsRepo.findByUserIdAndDateCreatedBetween(userId, startDate,endDate, paging);

    }
}
