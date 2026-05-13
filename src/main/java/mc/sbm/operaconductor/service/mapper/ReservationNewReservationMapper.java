package mc.sbm.operaconductor.service.mapper;

import mc.sbm.operaconductor.GenericEvent;
import mc.sbm.operaconductor.domain.ReservationDto;
import org.springframework.stereotype.Component;

@Component
public class ReservationNewReservationMapper extends ReservationBaseMapper {

    @Override
    public String eventKey() {
        return "RESERVATION_NEW_RESERVATION";
    }

    @Override
    public ReservationDto map(GenericEvent event) {
        return fromEvent(event);
    }
}
