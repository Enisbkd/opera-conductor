package mc.sbm.operaconductor.service.mapper;

import lombok.RequiredArgsConstructor;
import mc.sbm.operaconductor.GenericEvent;
import mc.sbm.operaconductor.domain.ReservationDto;
import mc.sbm.operaconductor.repository.event.NewReservationEventRepository;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
public class ReservationDeleteReservationMapper extends ReservationBaseMapper {

    private final NewReservationEventRepository repository;

    @Override
    public String eventKey() {
        return "RESERVATION_DELETE_RESERVATION";
    }

    @Override
    public ReservationDto map(GenericEvent event) {
        return fromEvent(event);
    }

    @Override
    @Transactional
    public void sink(ReservationDto dto) {
        System.out.println("toktokt c'est moi");
        repository.deleteReservationNameByPrimaryKey(Long.valueOf(dto.getPrimaryKey()));
    }
}
