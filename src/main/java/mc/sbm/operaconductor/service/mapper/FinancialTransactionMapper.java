package mc.sbm.operaconductor.service.mapper;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import mc.sbm.operaconductor.GenericEvent;
import mc.sbm.operaconductor.domain.FinancialTransactionDto;
import mc.sbm.operaconductor.domain.event.CashieringPostingEvent;
import mc.sbm.operaconductor.repository.event.CashieringPostingEventRepository;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
public class FinancialTransactionMapper implements SinkMapper<FinancialTransactionDto> {

    private final CashieringPostingEventRepository repository;

    @Override
    public String eventKey() {
        return "CASHIERING_NEW_POSTING";
    }

    @Override
    public FinancialTransactionDto map(GenericEvent event) {
        return fromEvent(event);
    }

    @Override
    public Class<FinancialTransactionDto> targetClass() {
        return FinancialTransactionDto.class;
    }

    @Override
    @Transactional
    public void sink(FinancialTransactionDto dto) {
        repository.save(toEntity(dto, "NEW POSTING"));
    }

    static FinancialTransactionDto fromEvent(GenericEvent event) {
        Map<String, String> d = event
            .getDetail()
            .stream()
            .collect(
                Collectors.toMap(GenericEvent.EventDetail::getElementName, e -> e.getNewValue() != null ? e.getNewValue() : "", (a, b) -> a)
            );
        return FinancialTransactionDto.builder()
            .timestamp(event.getTimestamp())
            .businessDate(d.get("BUSINESS DATE"))
            .fromResvId(d.get("FROM RESV ID"))
            .grossAmount(d.get("GROSS AMOUNT"))
            .guestAccountCredit(d.get("GUEST ACCOUNT CREDIT"))
            .guestAccountDebit(d.get("GUEST ACCOUNT DEBIT"))
            .marketCode(d.get("MARKET CODE"))
            .nameId(d.get("NAME ID"))
            .rateCode(d.get("RATE CODE"))
            .resvNameId(d.get("RESV NAME ID"))
            .room(d.get("ROOM"))
            .trxAmount(d.get("TRX AMOUNT"))
            .transactionCode(d.get("TRANSACTION CODE"))
            .trxDate(d.get("TRX DATE"))
            .folioType(d.get("FOLIO_TYPE"))
            .postingDate(d.get("TRANSACTION DATE"))
            .remark(d.get("TRANSACTION DESC"))
            .build();
    }

    static CashieringPostingEvent toEntity(FinancialTransactionDto dto, String eventName) {
        return CashieringPostingEvent.builder()
            .primaryKey(dto.getResvNameId() != null ? dto.getResvNameId() : "")
            .hotelId("")
            .moduleName("Cashiering")
            .eventName(eventName)
            .eventTimestamp(dto.getTimestamp())
            .businessDate(dto.getBusinessDate())
            .fromResvId(dto.getFromResvId())
            .grossAmount(dto.getGrossAmount())
            .guestAccountCredit(dto.getGuestAccountCredit())
            .guestAccountDebit(dto.getGuestAccountDebit())
            .marketCode(dto.getMarketCode())
            .nameId(dto.getNameId())
            .rateCode(dto.getRateCode())
            .resvNameId(dto.getResvNameId())
            .room(dto.getRoom())
            .trxAmount(dto.getTrxAmount())
            .transactionCode(dto.getTransactionCode())
            .trxDate(dto.getTrxDate())
            .folioType(dto.getFolioType())
            .postingDate(dto.getPostingDate())
            .remark(dto.getRemark())
            .processedAt(LocalDateTime.now())
            .build();
    }
}
