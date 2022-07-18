package logging_service.repo;

import logging_service.domain.BankAdminLogs;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.time.OffsetTime;
import java.util.List;

public interface BankAdminLogsRepo extends JpaRepository<BankAdminLogs, Long> {
    List<BankAdminLogs> findByDateCreatedBetween(LocalDate startDate, LocalDate endDate, Pageable pageable);
    List<BankAdminLogs> findByUserIdAndDateCreatedBetween(Long userId, LocalDate startDate, LocalDate endDate, Pageable pageable);
    List<BankAdminLogs> findAllByUserId(Long userId, Pageable pageable);

}
