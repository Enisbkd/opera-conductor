package mc.sbm.operaconductor.service.mapper;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;

/**
 * Holds all SinkMapper beans indexed by their eventKey().
 * New mappers are auto-registered just by adding @Component.
 * Multiple mappers can share the same eventKey.
 */
@Component
public class SinkMapperRegistry {

    private final Map<String, List<SinkMapper<?>>> mappers;

    /** Creates a new SinkMapperRegistry and indexes all provided mappers by their event key. */
    public SinkMapperRegistry(List<SinkMapper<?>> allMappers) {
        this.mappers = allMappers.stream().collect(Collectors.groupingBy(SinkMapper::eventKey));
    }

    /**
     * Computes the event key from a GenericEvent (moduleName + "_" + eventName, normalized).
     */
    public static String toEventKey(String moduleName, String eventName) {
        return (moduleName + "_" + eventName).toUpperCase().replace(" ", "_");
    }

    /** Returns all SinkMappers registered for the given event key, or an empty list if none is found. */
    public List<SinkMapper<?>> getMappers(String eventKey) {
        return mappers.getOrDefault(eventKey, Collections.emptyList());
    }

    /** Returns true if at least one mapper is registered for the given event key. */
    public boolean hasMapper(String eventKey) {
        return mappers.containsKey(eventKey);
    }
}
