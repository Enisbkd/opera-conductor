package mc.sbm.operaconductor.service.mapper;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import mc.sbm.operaconductor.GenericEvent;
import mc.sbm.operaconductor.domain.event.CloseGuestFolioEvent;
import mc.sbm.operaconductor.repository.event.CloseGuestFolioEventRepository;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
public class ReservationCloseGuestFolioMapper implements SinkMapper<CloseGuestFolioEvent> {

    private final CloseGuestFolioEventRepository repository;

    @Override
    public String eventKey() {
        return "RESERVATION_CLOSE_GUEST_FOLIO";
    }

    @Override
    public CloseGuestFolioEvent map(GenericEvent event) {
        Map<String, String> d = event
            .getDetail()
            .stream()
            .collect(
                Collectors.toMap(GenericEvent.EventDetail::getElementName, e -> e.getNewValue() != null ? e.getNewValue() : "", (a, b) -> a)
            );
        return CloseGuestFolioEvent.builder()
            .primaryKey(event.getPrimaryKey())
            .hotelId(event.getHotelId())
            .moduleName("Reservation")
            .eventName("CLOSE GUEST FOLIO")
            .eventTimestamp(event.getTimestamp())
            .resvNameId(d.get("RESV NAME ID"))
            .folioCloseDate(d.get("FOLIO CLOSE DATE"))
            .processedAt(LocalDateTime.now())
            .build();
    }

    @Override
    public Class<CloseGuestFolioEvent> targetClass() {
        return CloseGuestFolioEvent.class;
    }

    @Override
    @Transactional
    public void sink(CloseGuestFolioEvent entity) {
        repository.save(entity);
    }
}
