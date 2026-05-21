package mc.sbm.operaconductor.repository.event;

import mc.sbm.operaconductor.domain.event.Membership;
import mc.sbm.operaconductor.domain.event.MembershipId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MembershipRepository extends JpaRepository<Membership, MembershipId> {}
