package mc.sbm.operaconductor.repository.event;

import mc.sbm.operaconductor.domain.event.UpdateReservationEvent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UpdateReservationEventRepository extends JpaRepository<UpdateReservationEvent, Long> {}
