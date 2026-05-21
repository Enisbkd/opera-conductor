package mc.sbm.operaconductor.service.mapper;

import java.util.Map;
import java.util.stream.Collectors;
import mc.sbm.operaconductor.GenericEvent;
import mc.sbm.operaconductor.domain.NameDto;

public class NameMapper {

    private NameMapper() {}

    static NameDto fromEvent(GenericEvent event) {
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
        return NameDto.builder()
            .timestamp(event.getTimestamp())
            .primaryKey(event.getPrimaryKey())
            .hotelId("HPDEV")
            .nameId(d.get("NAME ID"))
            .nameType(d.get("NAME TYPE"))
            .sName(d.get("NAME"))
            .last(d.get("NAME"))
            .first(d.get("FIRST"))
            .sFirst(d.get("FIRST") != null ? d.get("FIRST").toUpperCase() : null)
            .middle(d.get("MIDDLE"))
            .title(d.get("TITLE"))
            .gender(d.get("GENDER"))
            .nationality(d.get("NATIONALITY"))
            .birthDate(d.get("BIRTH DATE"))
            .birthDateStr(d.get("BIRTH DATE STR"))
            .birthCountry(d.get("BIRTH COUNTRY"))
            .language(d.get("LANGUAGE"))
            .profession(d.get("PROFESSION"))
            .activeYn(d.get("ACTIVE"))
            .inactiveDate(d.get("INACTIVE DATE"))
            .blMsg(d.get("BL MSG"))
            .cashBlInd(d.get("CASH BL IND"))
            .emailYn(d.get("EMAIL YN"))
            .mailYn(d.get("MAIL YN"))
            .vipStatus(d.get("VIP STATUS"))
            .insertDate(event.getTimestamp())
            .build();
    }
}
