package mc.sbm.operaconductor.service.mapper;

import java.time.LocalDateTime;
import lombok.RequiredArgsConstructor;
import mc.sbm.operaconductor.GenericEvent;
import mc.sbm.operaconductor.domain.NameDto;
import mc.sbm.operaconductor.domain.event.Name;
import mc.sbm.operaconductor.repository.event.NameRepository;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
public class NameNewProfileMapper implements SinkMapper<NameDto> {

    private final NameRepository nameRepository;

    @Override
    public String eventKey() {
        return "PROFILE_NEW_PROFILE";
    }

    @Override
    public NameDto map(GenericEvent event) {
        return NameMapper.fromEvent(event);
    }

    @Override
    public Class<NameDto> targetClass() {
        return NameDto.class;
    }

    @Override
    @Transactional
    public void sink(NameDto dto) {
        Name entity = Name.builder()
            .primaryKey(dto.getPrimaryKey())
            .hotelId(dto.getHotelId())
            .moduleName("Profile")
            .eventName("NEW PROFILE")
            .eventTimestamp(dto.getTimestamp())
            .nameId(dto.getNameId())
            .nameType(dto.getNameType())
            .sName(dto.getSName())
            .last(dto.getLast())
            .first(dto.getFirst())
            .sFirst(dto.getSFirst())
            .middle(dto.getMiddle())
            .title(dto.getTitle())
            .gender(dto.getGender())
            .nationality(dto.getNationality())
            .birthDate(dto.getBirthDate())
            .birthDateStr(dto.getBirthDateStr())
            .birthCountry(dto.getBirthCountry())
            .language(dto.getLanguage())
            .profession(dto.getProfession())
            .activeYn(dto.getActiveYn())
            .inactiveDate(dto.getInactiveDate())
            .blMsg(dto.getBlMsg())
            .cashBlInd(dto.getCashBlInd())
            .emailYn(dto.getEmailYn())
            .mailYn(dto.getMailYn())
            .vipStatus(dto.getVipStatus())
            .insertDate(dto.getInsertDate())
            .processedAt(LocalDateTime.now())
            .build();
        nameRepository.save(entity);
    }
}
