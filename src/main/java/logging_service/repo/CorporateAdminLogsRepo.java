package logging_service.repo;

import logging_service.domain.BankAdminLogs;
import logging_service.domain.CorporateAdminLogs;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.OffsetTime;
import java.util.List;
//import org.springframework.data.repository.PagingAndSortingRepository;

public interface CorporateAdminLogsRepo extends JpaRepository<CorporateAdminLogs, Long> {
    List<CorporateAdminLogs> findByDateCreatedBetween(OffsetTime startDate, OffsetTime endDate, Pageable pageable);
    List<CorporateAdminLogs> findByUserIdAndDateCreatedBetween(Long userId, OffsetTime startDate, OffsetTime endDate, Pageable pageable);
    List<CorporateAdminLogs> findAllByUserId(Long userId, Pageable pageable);
}
