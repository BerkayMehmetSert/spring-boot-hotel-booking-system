package com.bms.hotelbookingsystem.service;

import com.bms.hotelbookingsystem.dto.PaymentTypeDto;
import com.bms.hotelbookingsystem.dto.converter.PaymentTypeDtoConverter;
import com.bms.hotelbookingsystem.dto.request.CreatePaymentTypeRequest;
import com.bms.hotelbookingsystem.dto.request.UpdatePaymentTypeRequest;
import com.bms.hotelbookingsystem.exception.PaymentTypeNotFoundException;
import com.bms.hotelbookingsystem.helper.DateHelper;
import com.bms.hotelbookingsystem.helper.message.BusinessLogMessage;
import com.bms.hotelbookingsystem.helper.message.BusinessMessage;
import com.bms.hotelbookingsystem.model.PaymentType;
import com.bms.hotelbookingsystem.repository.PaymentTypeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class PaymentTypeService {
    private final PaymentTypeRepository paymentTypeRepository;
    private final PaymentTypeDtoConverter converter;

    public PaymentTypeService(PaymentTypeRepository paymentTypeRepository, PaymentTypeDtoConverter converter) {
        this.paymentTypeRepository = paymentTypeRepository;
        this.converter = converter;
    }

    public void createPaymentType(CreatePaymentTypeRequest request) {
        PaymentType paymentType = new PaymentType();

        paymentType.setName(request.getName());
        paymentType.setCreatedAt(DateHelper.getCurrentDate());
        paymentType.setUpdatedAt(DateHelper.getCurrentDate());

        paymentTypeRepository.save(paymentType);
        log.info(BusinessLogMessage.PaymentType.PAYMENT_TYPE_CREATED);
    }

    public void updatePaymentType(final String id, UpdatePaymentTypeRequest request) {
        PaymentType paymentType = findPaymentTypeByPaymentTypeId(id);

        paymentType.setName(request.getName());
        paymentType.setUpdatedAt(DateHelper.getCurrentDate());

        paymentTypeRepository.save(paymentType);
        log.info(BusinessLogMessage.PaymentType.PAYMENT_TYPE_UPDATED + id);
    }

    public void deletePaymentType(final String id) {
        PaymentType paymentType = findPaymentTypeByPaymentTypeId(id);

        paymentTypeRepository.delete(paymentType);
        log.info(BusinessLogMessage.PaymentType.PAYMENT_TYPE_DELETED + id);
    }

    public PaymentTypeDto findPaymentTypeById(final String id) {
        PaymentType paymentType = findPaymentTypeByPaymentTypeId(id);

        log.info(BusinessLogMessage.PaymentType.PAYMENT_TYPE_FOUND + id);
        return converter.convert(paymentType);
    }

    public List<PaymentTypeDto> findAllPaymentTypes() {
        List<PaymentType> paymentTypeList = paymentTypeRepository.findAll();

        if (paymentTypeList.isEmpty()) {
            log.error(BusinessLogMessage.PaymentType.PAYMENT_TYPE_LIST_EMPTY);
            throw new PaymentTypeNotFoundException(BusinessMessage.PaymentType.PAYMENT_TYPE_LIST_EMPTY);
        }

        log.info(BusinessLogMessage.PaymentType.PAYMENT_TYPE_LISTED);
        return converter.convert(paymentTypeList);
    }

    protected PaymentType findPaymentTypeByPaymentTypeId(final String id) {
        return paymentTypeRepository.findById(id).orElseThrow(() -> {
            log.error(BusinessLogMessage.PaymentType.PAYMENT_TYPE_NOT_FOUND + id);
            throw new PaymentTypeNotFoundException(BusinessMessage.PaymentType.PAYMENT_TYPE_NOT_FOUND);
        });
    }
}
