package mc.sbm.operaconductor.domain.event;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import mc.sbm.operaconductor.domain.AbstractAuditingEntitySBM;

@MappedSuperclass
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Data
@EqualsAndHashCode(callSuper = true)
public abstract class BaseHotelEvent extends AbstractAuditingEntitySBM<Long> {

    @Id
    @Column(name = "primary_key_val", nullable = false, length = 100)
    private String primaryKey;

    @Column(nullable = false, length = 20)
    private String hotelId;

    @Column(nullable = false, length = 100)
    private String moduleName;

    @Column(nullable = false, length = 100)
    private String eventName;

    @Column(length = 100)
    private String eventTimestamp;

    @Column(length = 100)
    private String uniqueEventId;

    @Column(nullable = false)
    private LocalDateTime processedAt;

    @Override
    public String getId() {
        return primaryKey;
    }
}
