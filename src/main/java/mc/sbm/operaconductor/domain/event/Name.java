package mc.sbm.operaconductor.domain.event;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "oc_name")
@Data
@EqualsAndHashCode(callSuper = true)
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class Name extends BaseHotelEvent {

    // NAME_ID
    private String nameId;

    // NAME_TYPE
    private String nameType;

    // SNAME — company/legal name, or last name
    private String sName;

    // LAST — last name (can be empty for companies)
    private String last;

    // FIRST
    private String first;

    // SFIRST — uppercased version of FIRST
    private String sFirst;

    // MIDDLE
    private String middle;

    // TITLE
    private String title;

    // GENDER
    private String gender;

    // NATIONALITY
    private String nationality;

    // BIRTH_DATE
    private String birthDate;

    // BIRTH_DATE_STR — encrypted form (e.g. ~:377F0FF...)
    @Column(length = 500)
    private String birthDateStr;

    // BIRTH_COUNTRY
    private String birthCountry;

    // LANGUAGE
    private String language;

    // PROFESSION
    private String profession;

    // ACTIVE_YN
    private String activeYn;

    // INACTIVE_DATE
    private String inactiveDate;

    // BL_MSG
    private String blMsg;

    // CASH_BL_IND
    private String cashBlInd;

    // EMAIL_YN
    private String emailYn;

    // MAIL_YN
    private String mailYn;

    // VIP_STATUS
    private String vipStatus;

    // INSERT_DATE — event timestamp on first appearance of primaryKey
    private String insertDate;
}
