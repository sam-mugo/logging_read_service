package logging_service.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;

@Getter
@Setter
@Entity
public class BankAdminLogs extends AuditLogs {

}
