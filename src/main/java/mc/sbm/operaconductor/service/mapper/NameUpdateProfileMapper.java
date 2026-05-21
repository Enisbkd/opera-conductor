package mc.sbm.operaconductor.service.mapper;

import lombok.RequiredArgsConstructor;
import mc.sbm.operaconductor.GenericEvent;
import mc.sbm.operaconductor.domain.NameDto;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
public class NameUpdateProfileMapper implements SinkMapper<NameDto> {

    @Override
    public String eventKey() {
        return "PROFILE_UPDATE_PROFILE";
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
        // TODO: persist to the appropriate Name event entity/repository
    }
}
