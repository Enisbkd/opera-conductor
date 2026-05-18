package mc.sbm.operaconductor.repository.event;

import mc.sbm.operaconductor.domain.event.DeleteReservationEvent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeleteReservationEventRepository extends JpaRepository<DeleteReservationEvent, Long> {}
