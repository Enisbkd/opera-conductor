package mc.sbm.operaconductor.repository.event;

import mc.sbm.operaconductor.domain.event.CashieringPostingEvent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CashieringPostingEventRepository extends JpaRepository<CashieringPostingEvent, Long> {}
