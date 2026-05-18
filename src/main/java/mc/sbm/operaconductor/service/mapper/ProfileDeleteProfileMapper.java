package mc.sbm.operaconductor.service.mapper;

import java.time.LocalDateTime;
import lombok.RequiredArgsConstructor;
import mc.sbm.operaconductor.GenericEvent;
import mc.sbm.operaconductor.domain.ProfileDto;
import mc.sbm.operaconductor.domain.event.DeleteProfileEvent;
import mc.sbm.operaconductor.repository.event.DeleteProfileEventRepository;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
public class ProfileDeleteProfileMapper implements SinkMapper<ProfileDto> {

    private final DeleteProfileEventRepository repository;

    @Override
    public String eventKey() {
        return "PROFILE_DELETE_PROFILE";
    }

    @Override
    public ProfileDto map(GenericEvent event) {
        return ProfileMapper.fromEvent(event);
    }

    @Override
    public Class<ProfileDto> targetClass() {
        return ProfileDto.class;
    }

    @Override
    @Transactional
    public void sink(ProfileDto dto) {
        DeleteProfileEvent entity = DeleteProfileEvent.builder()
            .primaryKey(dto.getPrimaryKey())
            .hotelId(dto.getHotelId())
            .moduleName("Profile")
            .eventName("DELETE PROFILE")
            .eventTimestamp(dto.getTimestamp())
            .nameId(dto.getNameId())
            .nameType(dto.getNameType())
            .name(dto.getName())
            .first(dto.getFirst())
            .middle(dto.getMiddle())
            .title(dto.getTitle())
            .nationality(dto.getNationality())
            .gender(dto.getGender())
            .birthDate(dto.getBirthDate())
            .birthCountry(dto.getBirthCountry())
            .blMsg(dto.getBlMsg())
            .cashBlInd(dto.getCashBlInd())
            .emailYn(dto.getEmailYn())
            .active(dto.getActive())
            .inactiveDate(dto.getInactiveDate())
            .language(dto.getLanguage())
            .mailYn(dto.getMailYn())
            .vipStatus(dto.getVipStatus())
            .profession(dto.getProfession())
            .insertDate(dto.getInsertDate())
            .membershipInactiveDate(dto.getMembershipInactiveDate())
            .membershipCardNo(dto.getMembershipCardNo())
            .membershipType(dto.getMembershipType())
            .membershipNameOnCard(dto.getMembershipNameOnCard())
            .processedAt(LocalDateTime.now())
            .build();
        repository.save(entity);
    }
}
