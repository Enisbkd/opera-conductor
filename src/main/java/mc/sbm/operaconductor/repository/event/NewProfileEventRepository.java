package mc.sbm.operaconductor.repository.event;

import mc.sbm.operaconductor.domain.event.NewProfileEvent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NewProfileEventRepository extends JpaRepository<NewProfileEvent, Long> {}
