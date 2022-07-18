package logging_service.service;

import logging_service.domain.BankAdminLogs;
import logging_service.repo.BankAdminLogsRepo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import java.time.LocalDate;
import java.time.OffsetTime;
import java.util.List;


@Service
public class BankAdminLogsService {
    private final BankAdminLogsRepo bankAdminLogsRepo;

    public BankAdminLogsService(BankAdminLogsRepo bankAdminLogsRepo) {
        this.bankAdminLogsRepo = bankAdminLogsRepo;
    }

    /*
    * Saves a log to the BankAdminLogs Table
    * */
    public BankAdminLogs saveLog(BankAdminLogs bankAdminLogs) {
        return bankAdminLogsRepo.save(bankAdminLogs);
    }


    /*
     * Retrieves all BankAdminLogs
     * with a page size limit
     * */
    public Page<BankAdminLogs> findAllLogs(Integer pageNo, Integer pageSize) {
        Pageable paging = PageRequest.of(pageNo, pageSize);

        return bankAdminLogsRepo.findAll(paging);
    }

    /*
     * Retrieves all BankAdminLogs
     * paged between two dates
     * */
    public Page<BankAdminLogs> findAllLogsBetweenDates(Integer pageNo,
                                                       Integer pageSize,
                                                       LocalDate startDate,
                                                       LocalDate endDate) {
        Pageable paging  = PageRequest.of(pageNo, pageSize);
        return (Page<BankAdminLogs>) bankAdminLogsRepo.findByDateCreatedBetween(startDate, endDate, paging);
    }

    /*
     * Retrieves paged results of all logs by userId
     * */
    public Page<BankAdminLogs> findLogsByUserId(final Long userId, Integer pageNo, Integer pageSize) {
        Pageable paging  = PageRequest.of(pageNo, pageSize);
        return (Page<BankAdminLogs>) bankAdminLogsRepo.findAllByUserId(userId, paging);
    }


    /*
     * Retrieves paged results of all logs by userId between a range of dates
     * */
    public Page<BankAdminLogs> findLogsByUSerIdBetweenDates(final Long userId,
                                                            LocalDate startDate,
                                                            LocalDate endDate,
                                                            Integer pageNo, Integer pageSize) {
        Pageable paging = PageRequest.of(pageNo, pageSize);
        return (Page<BankAdminLogs>) bankAdminLogsRepo.findByUserIdAndDateCreatedBetween(userId, startDate,endDate, paging);

    }
}
