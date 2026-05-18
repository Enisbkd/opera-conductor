package mc.sbm.operaconductor.repository.event;

import mc.sbm.operaconductor.domain.event.DeleteProfileEvent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeleteProfileEventRepository extends JpaRepository<DeleteProfileEvent, Long> {}
