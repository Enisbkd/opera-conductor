package mc.sbm.operaconductor.service.mapper;

import java.time.LocalDateTime;
import lombok.RequiredArgsConstructor;
import mc.sbm.operaconductor.GenericEvent;
import mc.sbm.operaconductor.domain.ReservationDto;
import mc.sbm.operaconductor.domain.event.ReservationName;
import mc.sbm.operaconductor.repository.event.NewReservationEventRepository;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
public class ReservationUpdateReservationMapper extends ReservationBaseMapper {

    private final NewReservationEventRepository repository;

    @Override
    public String eventKey() {
        return "<RESERVATION_UPDATE_RESERVATION>";
    }

    @Override
    public ReservationDto map(GenericEvent event) {
        return fromEvent(event);
    }

    @Override
    @Transactional
    public void sink(ReservationDto dto) {
        ReservationName entity = ReservationName.builder()
            .primaryKey(dto.getPrimaryKey())
            .hotelId(dto.getHotelId())
            .moduleName("Reservation")
            .eventName("UPDATE RESERVATION")
            .eventTimestamp(dto.getTimestamp())
            .resvNameId(dto.getResvNameId())
            .resort(dto.getResort())
            .beginDate(dto.getBeginDate())
            .endDate(dto.getEndDate())
            .reservationStatus(dto.getReservationStatus())
            .confirmationNo(dto.getConfirmationNo())
            .nameId(dto.getNameId())
            .guestFirstName(dto.getGuestFirstName())
            .guestName(dto.getGuestName())
            .externalReference(dto.getExternalReference())
            .partyCode(dto.getPartyCode())
            .udfc16(dto.getUdfc16())
            .udfc22(dto.getUdfc22())
            .resInsertSource(dto.getResInsertSource())
            .insertDate(dto.getInsertDate())
            .adults(dto.getAdults())
            .children(dto.getChildren())
            .rateCode(dto.getRateCode())
            .stayDate(dto.getStayDate())
            .applySeq(dto.getApplySeq())
            .travelAgentId(dto.getTravelAgentId())
            .companyId(dto.getCompanyId())
            .origin(dto.getOrigin())
            .actionDate(dto.getActionDate())
            .room(dto.getRoom())
            .processedAt(LocalDateTime.now())
            .membershipId(dto.getMembershipId())
            .build();
        repository.deleteReservationNameByPrimaryKey(Long.valueOf(dto.getPrimaryKey()));
        repository.save(entity);
    }
}
