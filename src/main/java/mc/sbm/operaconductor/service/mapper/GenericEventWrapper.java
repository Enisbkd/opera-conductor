package mc.sbm.operaconductor.service.mapper;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import mc.sbm.operaconductor.GenericEvent;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GenericEventWrapper {

    private String id;
    private String type;
    private Payload payload;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Payload {

        private Data data;

        @lombok.Data
        @NoArgsConstructor
        @AllArgsConstructor
        public static class Data {

            private GenericEvent newEvent;
        }
    }
}
