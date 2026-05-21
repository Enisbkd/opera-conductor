package mc.sbm.operaconductor.repository.event;

import mc.sbm.operaconductor.domain.event.Name;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NameRepository extends JpaRepository<Name, Long> {}
