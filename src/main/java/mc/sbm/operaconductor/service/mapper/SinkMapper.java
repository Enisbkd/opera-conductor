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

    T map(GenericEvent event);

    Class<T> targetClass();
}
