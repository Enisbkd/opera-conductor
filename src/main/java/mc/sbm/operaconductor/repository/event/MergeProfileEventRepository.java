package mc.sbm.operaconductor.repository.event;

import mc.sbm.operaconductor.domain.event.MergeProfileEvent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MergeProfileEventRepository extends JpaRepository<MergeProfileEvent, Long> {}
