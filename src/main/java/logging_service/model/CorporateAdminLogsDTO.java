package logging_service.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class CorporateAdminLogsDTO {
    private Long id;
    @NotBlank(message = "Invalid userId: Empty userId")
    @NotNull(message = "Invalid userId: userId is Null")
    private Long userId;
    @NotBlank(message = "Invalid username: Empty username")
    @NotNull(message = "Invalid username: username is null")
    private String username;
    @NotBlank(message = "Invalid log message: Empty message")
    @NotNull(message = "Invalid log message: message is null")
    private String message;
    @NotBlank(message = "Invalid corporateId: Empty corporateID")
    @NotNull(message = "Invalid corporateId: corporateId is Null")
    private Long corporateId;
}
