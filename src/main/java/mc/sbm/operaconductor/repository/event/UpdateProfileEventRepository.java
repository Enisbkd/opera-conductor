package mc.sbm.operaconductor.repository.event;

import mc.sbm.operaconductor.domain.event.UpdateProfileEvent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UpdateProfileEventRepository extends JpaRepository<UpdateProfileEvent, Long> {}
