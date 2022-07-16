package logging_service.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.OffsetDateTime;



@Getter
@Setter
@MappedSuperclass
public class AuditLogs {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotNull
    private Long userId;
    @NotNull
    private String username;
    @NotNull
    private String message;
    @NotNull
    private Long corporateId;


    @CreatedDate
    @Column(nullable = false, updatable = false)
    private OffsetDateTime dateCreated;

}
