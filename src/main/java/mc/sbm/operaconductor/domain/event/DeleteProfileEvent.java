package mc.sbm.operaconductor.domain.event;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "oc_delete_profile_events")
@Data
@EqualsAndHashCode(callSuper = true)
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class DeleteProfileEvent extends BaseHotelEvent {

    // NAME table
    private String nameId;
    private String nameType;
    private String name;
    private String first;
    private String middle;
    private String title;
    private String nationality;
    private String gender;
    private String birthDate;
    private String birthCountry;
    private String blMsg;
    private String cashBlInd;
    private String emailYn;
    private String active;
    private String inactiveDate;
    private String language;
    private String mailYn;
    private String vipStatus;
    private String profession;
    private String insertDate;

    // MEMBERSHIPS table
    private String membershipInactiveDate;
    private String membershipCardNo;
    private String membershipType;
    private String membershipNameOnCard;
}
