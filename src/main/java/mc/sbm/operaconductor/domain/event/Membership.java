package mc.sbm.operaconductor.domain.event;

import jakarta.persistence.*;
import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

/**
 * Entity mapping for OPERA.MEMBERSHIPS table.
 * Transaction table storing loyalty/membership programme data per guest profile.
 */
@Entity
@Table(
    name = "MEMBERSHIPS",
    schema = "SYSTEM",
    uniqueConstraints = { @UniqueConstraint(name = "MEMBERSHIPS_UK", columnNames = { "NAME_ID", "MEMBERSHIP_TYPE", "MEMBERSHIP_CARD_NO" }) }
)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class Membership extends BaseMembershipEvent {

    @EmbeddedId
    private MembershipId id;

    /**
     * Name as it appears on the Membership Card.
     */
    @Column(name = "NAME_ON_CARD", nullable = false, length = 80)
    private String nameOnCard;

    /**
     * The date the record was marked as inactive.
     */
    @Column(name = "INACTIVE_DATE")
    private LocalDate inactiveDate;

    /**
     * Satisfies AbstractAuditingEntitySBM contract.
     * Returns a human-readable composite key string.
     */
    @Override
    public String getId() {
        if (id == null) return null;
        return id.getNameId() + "-" + id.getMembershipType() + "-" + id.getMembershipCardNo();
    }
}
