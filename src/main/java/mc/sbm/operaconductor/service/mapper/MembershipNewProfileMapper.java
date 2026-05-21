package mc.sbm.operaconductor.service.mapper;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeParseException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mc.sbm.operaconductor.GenericEvent;
import mc.sbm.operaconductor.domain.MembershipDto;
import mc.sbm.operaconductor.domain.event.Membership;
import mc.sbm.operaconductor.domain.event.MembershipId;
import mc.sbm.operaconductor.repository.event.MembershipRepository;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
@Slf4j
public class MembershipNewProfileMapper implements SinkMapper<MembershipDto> {

    private final MembershipRepository membershipRepository;

    @Override
    public String eventKey() {
        return "PROFILE_NEW_PROFILE";
    }

    @Override
    public MembershipDto map(GenericEvent event) {
        return MembershipMapper.fromEvent(event);
    }

    @Override
    public Class<MembershipDto> targetClass() {
        return MembershipDto.class;
    }

    @Override
    @Transactional
    public void sink(MembershipDto dto) {
        MembershipId membershipId = MembershipId.builder()
            .membershipCardNo(dto.getMembershipCardNo())
            .membershipType(dto.getMembershipType())
            .nameId(Long.valueOf(dto.getNameId()))
            .build();

        LocalDate inactiveDate = null;
        if (dto.getInactiveDate() != null && !dto.getInactiveDate().isBlank()) {
            try {
                inactiveDate = LocalDate.parse(dto.getInactiveDate());
            } catch (DateTimeParseException e) {
                log.warn(
                    "Could not parse inactiveDate '{}' for membershipCardNo={}: {}",
                    dto.getInactiveDate(),
                    dto.getMembershipCardNo(),
                    e.getMessage()
                );
            }
        }

        Membership entity = Membership.builder()
            .hotelId(dto.getHotelId())
            .moduleName("Profile")
            .eventName("NEW PROFILE")
            .eventTimestamp(dto.getTimestamp())
            .id(membershipId)
            .nameOnCard(dto.getNameOnCard())
            .inactiveDate(inactiveDate)
            .processedAt(LocalDateTime.now())
            .build();
        membershipRepository.save(entity);
    }
}
