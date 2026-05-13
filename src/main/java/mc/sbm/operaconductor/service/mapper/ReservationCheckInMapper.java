package mc.sbm.operaconductor.service.mapper;

import mc.sbm.operaconductor.GenericEvent;
import mc.sbm.operaconductor.domain.ReservationDto;
import org.springframework.stereotype.Component;

@Component
public class ReservationCheckInMapper extends ReservationBaseMapper {

    @Override
    public String eventKey() {
        return "RESERVATION_CHECK_IN";
    }

    @Override
    public ReservationDto map(GenericEvent event) {
        return fromEvent(event);
    }
}
