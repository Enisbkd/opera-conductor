package mc.sbm.operaconductor.repository.event;

import mc.sbm.operaconductor.domain.event.ReservationName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NewReservationEventRepository extends JpaRepository<ReservationName, Long> {
    ReservationName deleteReservationNameByPrimaryKey(Long id);
}
