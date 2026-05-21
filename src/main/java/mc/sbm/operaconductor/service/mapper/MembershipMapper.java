package mc.sbm.operaconductor.service.mapper;

import java.util.Map;
import java.util.stream.Collectors;
import mc.sbm.operaconductor.GenericEvent;
import mc.sbm.operaconductor.domain.MembershipDto;

public class MembershipMapper {

    private MembershipMapper() {}

    static MembershipDto fromEvent(GenericEvent event) {
        Map<String, String> d = event
            .getDetail()
            .stream()
            .collect(
                Collectors.toMap(
                    GenericEvent.EventDetail::getElementName,
                    detail -> detail.getNewValue() != null ? detail.getNewValue() : "",
                    (a, b) -> a
                )
            );

        return MembershipDto.builder()
            .timestamp(event.getTimestamp())
            .primaryKey(event.getPrimaryKey())
            .hotelId("HPDEV")
            .nameId(d.get("NAME ID"))
            .membershipType(d.get("MEMBERSHIP TYPE"))
            .membershipCardNo(d.get("MEMBERSHIP NUMBER"))
            .nameOnCard(d.get("MEMBERSHIP NAME ON CARD"))
            .inactiveDate(d.get("MEMBERSHIP INACTIVE DATE"))
            .build();
    }
}
