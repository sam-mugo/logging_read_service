package logging_service.service;


import logging_service.domain.BankAdminLogs;
import logging_service.domain.CorporateAdminLogs;
import logging_service.repo.CorporateAdminLogsRepo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.OffsetTime;
import java.util.List;


@Service
public class CorporateAdminLogsService {
    private final CorporateAdminLogsRepo corporateAdminLogsRepo;

    public CorporateAdminLogsService(CorporateAdminLogsRepo corporateAdminLogsRepo) {
        this.corporateAdminLogsRepo = corporateAdminLogsRepo;
    }


    /*
    * Saves a log to the db Table
    * */
    public CorporateAdminLogs saveLog(CorporateAdminLogs corporateAdminLogs) {
        return corporateAdminLogsRepo.save(corporateAdminLogs);
    }

    /*
     * Retrieves all CorporateAdminLogs
     * with a page size limit
     * */
    public Page<CorporateAdminLogs> findAllLogs(Integer pageNo, Integer pageSize) {
        Pageable paging = PageRequest.of(pageNo, pageSize);

        return corporateAdminLogsRepo.findAll(paging);
    }

    /*
     * Retrieves all CorporateAdminLogs
     * paged between two dates
     * */
    public Page<CorporateAdminLogs> findAllLogsBetweenDates(Integer pageNo,
                                                            Integer pageSize,
                                                            LocalDate startDate,
                                                            LocalDate endDate) {
        Pageable paging  = PageRequest.of(pageNo, pageSize);
        return (Page<CorporateAdminLogs>) corporateAdminLogsRepo.findByDateCreatedBetween(startDate, endDate, paging);
    }

    /*
     * Retrieves paged results of all logs by userId
     * */
    public Page<CorporateAdminLogs> findLogsByUserId(final Long userId, Integer pageNo, Integer pageSize) {
        Pageable paging  = PageRequest.of(pageNo, pageSize);
        return (Page<CorporateAdminLogs>) corporateAdminLogsRepo.findAllByUserId(userId, paging);
    }


    /*
     * Retrieves paged results of all logs by userId between a range of dates
     * */
    public Page<CorporateAdminLogs> findLogsByUSerIdBetweenDates(final Long userId,
                                                                 LocalDate startDate,
                                                                 LocalDate endDate,
                                                            Integer pageNo, Integer pageSize) {
        Pageable paging = PageRequest.of(pageNo, pageSize);
        return (Page<CorporateAdminLogs>) corporateAdminLogsRepo.findByUserIdAndDateCreatedBetween(userId, startDate,endDate, paging);
    }

}
