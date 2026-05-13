package mc.sbm.operaconductor;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GenericEvent {

    private String moduleName;
    private String eventName;
    private String primaryKey;
    private String timestamp;
    private String publisherId;
    private String actionInstanceId;
    private String hotelId;
    private List<EventDetail> detail;
    private Metadata metadata;

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class EventDetail {

        private String elementName;
        private String newValue;
        private String oldValue;
        private String scopeFrom;
        private String scopeTo;
        private String elementSequence;
        private String elementType;
        private String elementRole;
    }

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Metadata {

        private String offset;
        private String uniqueEventId;
    }
}
