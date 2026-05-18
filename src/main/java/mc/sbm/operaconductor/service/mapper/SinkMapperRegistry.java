package mc.sbm.operaconductor.service.mapper;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;

/**
 * Holds all SinkMapper beans indexed by their eventKey().
 * New mappers are auto-registered just by adding @Component.
 */
@Component
public class SinkMapperRegistry {

    private final Map<String, SinkMapper<?>> mappers;

    /** Creates a new SinkMapperRegistry and indexes all provided mappers by their event key. */
    public SinkMapperRegistry(List<SinkMapper<?>> allMappers) {
        this.mappers = allMappers.stream().collect(Collectors.toMap(SinkMapper::eventKey, Function.identity()));
    }

    /**
     * Computes the event key from a GenericEvent (moduleName + "_" + eventName, normalized).
     */
    public static String toEventKey(String moduleName, String eventName) {
        return (moduleName + "_" + eventName).toUpperCase().replace(" ", "_");
    }

    /** Returns the SinkMapper registered for the given event key, or null if none is found. */
    public SinkMapper<?> getMapper(String eventKey) {
        return mappers.get(eventKey);
    }

    /** Returns true if a mapper is registered for the given event key. */
    public boolean hasMapper(String eventKey) {
        return mappers.containsKey(eventKey);
    }
}
