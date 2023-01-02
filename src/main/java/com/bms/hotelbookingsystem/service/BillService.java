package com.bms.hotelbookingsystem.service;

import com.bms.hotelbookingsystem.dto.BillDto;
import com.bms.hotelbookingsystem.dto.converter.BillDtoConverter;
import com.bms.hotelbookingsystem.dto.request.CreateBillRequest;
import com.bms.hotelbookingsystem.dto.request.UpdateBillRequest;
import com.bms.hotelbookingsystem.exception.BillNotFoundException;
import com.bms.hotelbookingsystem.helper.DateHelper;
import com.bms.hotelbookingsystem.helper.message.BusinessLogMessage;
import com.bms.hotelbookingsystem.helper.message.BusinessMessage;
import com.bms.hotelbookingsystem.model.Bill;
import com.bms.hotelbookingsystem.repository.BillRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class BillService {
    private final BillRepository billRepository;
    private final RentService rentService;
    private final BillDtoConverter converter;

    public BillService(BillRepository billRepository,
                       RentService rentService,
                       BillDtoConverter converter) {
        this.billRepository = billRepository;
        this.rentService = rentService;
        this.converter = converter;
    }

    public void createBill(CreateBillRequest request) {
        Bill bill = new Bill();

        bill.setPrice(request.getPrice());
        bill.setRent(rentService.findRentByRentId(request.getRentId()));
        bill.setCreatedAt(DateHelper.getCurrentDate());
        bill.setUpdatedAt(DateHelper.getCurrentDate());

        billRepository.save(bill);
        log.info(BusinessLogMessage.Bill.BILL_CREATED);
    }

    public void updateBill(final String id, UpdateBillRequest request) {
        Bill bill = findBillByBillId(id);

        bill.setPrice(request.getPrice());
        bill.setUpdatedAt(DateHelper.getCurrentDate());

        billRepository.save(bill);
        log.info(BusinessLogMessage.Bill.BILL_UPDATED + id);
    }

    public void deleteBill(final String id) {
        Bill bill = findBillByBillId(id);

        billRepository.delete(bill);
        log.info(BusinessLogMessage.Bill.BILL_DELETED + id);
    }

    public BillDto findBillById(final String id) {
        Bill bill = findBillByBillId(id);

        log.info(BusinessLogMessage.Bill.BILL_FOUND + id);
        return converter.convert(bill);
    }

    public List<BillDto> findAllBills() {
        List<Bill> billList = billRepository.findAll();

        if (billList.isEmpty()) {
            log.info(BusinessLogMessage.Bill.BILL_LIST_EMPTY);
            throw new BillNotFoundException(BusinessMessage.Bill.BILL_LIST_EMPTY);
        }

        log.info(BusinessLogMessage.Bill.BILL_LISTED);
        return converter.convert(billList);
    }

    protected Bill findBillByBillId(final String id) {
        return billRepository.findById(id).orElseThrow(() -> {
            log.error(BusinessLogMessage.Bill.BILL_NOT_FOUND + id);
            throw new BillNotFoundException(BusinessMessage.Bill.BILL_NOT_FOUND);
        });
    }
}
