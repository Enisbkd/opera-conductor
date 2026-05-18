package mc.sbm.operaconductor.service.mapper;

import lombok.RequiredArgsConstructor;
import mc.sbm.operaconductor.GenericEvent;
import mc.sbm.operaconductor.domain.FinancialTransactionDto;
import mc.sbm.operaconductor.repository.event.CashieringPostingEventRepository;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
public class CashieringDeletePostingMapper implements SinkMapper<FinancialTransactionDto> {

    private final CashieringPostingEventRepository repository;

    @Override
    public String eventKey() {
        return "CASHIERING_DELETE_POSTING";
    }

    @Override
    public FinancialTransactionDto map(GenericEvent event) {
        return FinancialTransactionMapper.fromEvent(event);
    }

    @Override
    public Class<FinancialTransactionDto> targetClass() {
        return FinancialTransactionDto.class;
    }

    @Override
    @Transactional
    public void sink(FinancialTransactionDto dto) {
        repository.save(FinancialTransactionMapper.toEntity(dto, "DELETE POSTING"));
    }
}
