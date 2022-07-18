package logging_service.repo;

import logging_service.domain.BankAdminLogs;
import logging_service.domain.CorporateAdminLogs;
import logging_service.domain.EmployeeLogs;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.time.OffsetTime;
import java.util.List;
//import org.springframework.data.repository.PagingAndSortingRepository;

public interface EmployeeLogsRepo extends JpaRepository<EmployeeLogs, Long> {
    List<EmployeeLogs> findByDateCreatedBetween(LocalDate startDate, LocalDate endDate, Pageable pageable);
    List<EmployeeLogs> findByUserIdAndDateCreatedBetween(Long userId, LocalDate startDate, LocalDate endDate, Pageable pageable);
    List<EmployeeLogs> findAllByUserId(Long userId, Pageable pageable);

}
