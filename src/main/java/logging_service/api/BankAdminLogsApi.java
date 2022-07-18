package logging_service.api;


import io.swagger.v3.oas.annotations.responses.ApiResponse;
import logging_service.domain.BankAdminLogs;
import logging_service.service.BankAdminLogsService;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.OffsetTime;
import java.util.List;

@RestController
@RequestMapping("/api")
public class BankAdminLogsApi {

    private final BankAdminLogsService bankAdminLogsService;

    public BankAdminLogsApi(BankAdminLogsService bankAdminLogsService) {
        this.bankAdminLogsService = bankAdminLogsService;
    }


    /*
    * Api for saving logs to the database
    * */
    @PostMapping
    @ApiResponse(responseCode = "201")
    public ResponseEntity<BankAdminLogs> addBankAdminLog(@RequestBody @Valid final BankAdminLogs bankAdminLogs) {
        return new ResponseEntity<>(bankAdminLogsService.saveLog(bankAdminLogs), HttpStatus.CREATED);
    }


    /*
    * Api for retrieving paginated logs by user type
    * */
    @RequestMapping(value = "/{pageNo}/{pageSize}", method = RequestMethod.GET)
    public Page<BankAdminLogs> bankAdminLogsPage(@PathVariable Integer pageNo, @PathVariable Integer pageSize){
        return bankAdminLogsService.findAllLogs(pageNo, pageSize);
    }


    /*
    * Retrieve all paginated logs by a userId
    * */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Page<BankAdminLogs> bankAdminLogsPageByUserId(@PathVariable Long userId, Integer pageNo, Integer pageSize){
        return bankAdminLogsService.findLogsByUserId(userId, pageNo, pageSize);
    }


    /*
    * Retrieve all paginated logs by a userId between a range of dates
    * */
    @RequestMapping(value = "/{userId}/{startDate}/{endDate}/{pageNo}/{pageSize}", method = RequestMethod.GET)
    public Page<BankAdminLogs> bankAdminLogsByUserIdInRangeOfDates(@PathVariable Long userId,
                                                                   OffsetTime startDate,
                                                                   OffsetTime endDate, Integer pageNo,
                                                                   Integer pageSize){
        return bankAdminLogsService.findLogsByUSerIdBetweenDates(userId, startDate, endDate, pageNo, pageSize);
    }
}
