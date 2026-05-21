package mc.sbm.operaconductor.domain.event;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class MembershipId implements Serializable {

    @Column(name = "NAME_ID", nullable = false)
    private Long nameId;

    @Column(name = "MEMBERSHIP_TYPE", nullable = false, length = 20)
    private String membershipType;

    @Column(name = "MEMBERSHIP_CARD_NO", nullable = false, length = 50)
    private String membershipCardNo;
}
