package mc.sbm.operaconductor.domain.event;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "close_guest_folio_events")
@Data
@EqualsAndHashCode(callSuper = true)
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class CloseGuestFolioEvent extends BaseHotelEvent {

    // RESERVATION_NAME table
    private String resvNameId;
    private String folioCloseDate;
}
