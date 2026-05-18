package mc.sbm.operaconductor.service.mapper;

import mc.sbm.operaconductor.GenericEvent;

/**
 * Contract for every sink mapper.
 * Each implementation handles one specific moduleName+eventName combination.
 */
public interface SinkMapper<T> {
    /**
     * The key this mapper handles, in the form "MODULENAME_EVENTNAME"
     * (uppercased, spaces replaced by underscores).
     * Example: "CASHIERING_NEW_POSTING"
     */
    String eventKey();

    /** Maps the given generic event payload to the target domain object. */
    T map(GenericEvent event);

    /** Returns the target class that this mapper produces. */
    Class<T> targetClass();

    /** Persist the mapped value to the database. Default is a no-op; override to save. */
    default void sink(T mapped) {}
}
