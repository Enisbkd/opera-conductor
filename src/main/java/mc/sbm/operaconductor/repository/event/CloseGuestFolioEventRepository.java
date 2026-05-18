package mc.sbm.operaconductor.repository.event;

import mc.sbm.operaconductor.domain.event.CloseGuestFolioEvent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CloseGuestFolioEventRepository extends JpaRepository<CloseGuestFolioEvent, Long> {}
