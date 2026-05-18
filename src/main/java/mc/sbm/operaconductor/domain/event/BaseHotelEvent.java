package mc.sbm.operaconductor.domain.event;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@MappedSuperclass
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Data
public abstract class BaseHotelEvent {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator", sequenceName = "sequence_generator", allocationSize = 50)
    private Long id;

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
}
