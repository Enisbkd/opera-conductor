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

    /** Opera V5: NAME_ID — primary key of the NAME record */
    @Column(name = "name_id", length = 50)
    private String nameId;

    /** Opera V5: NAME_TYPE — type of profile (e.g. GUEST, COMPANY, TRAVEL AGENT). NOT NULL in V5. */
    @Column(name = "name_type", length = 20)
    private String nameType;

    /** Opera V5: SNAME VARCHAR2(80) — uppercase value of last or company name. NOT NULL in V5. */
    @Column(name = "s_name", length = 80)
    private String sName;

    /** Opera V5: LAST VARCHAR2(40) — last name of the individual, or search name for other types */
    @Column(name = "last", length = 40)
    private String last;

    /** Opera V5: FIRST VARCHAR2(40) — first name of the individual */
    @Column(name = "first", length = 40)
    private String first;

    /** Opera V5: SFIRST VARCHAR2(40) — uppercased version of FIRST */
    @Column(name = "s_first", length = 40)
    private String sFirst;

    /** Opera V5: MIDDLE VARCHAR2(40) — middle name of the individual */
    @Column(name = "middle", length = 40)
    private String middle;

    /** Opera V5: TITLE VARCHAR2(40) — title of the individual (e.g. Mr, Mrs) */
    @Column(name = "title", length = 40)
    private String title;

    /** Opera V5: GENDER VARCHAR2(1) — M (Male) or F (Female) */
    @Column(name = "gender", length = 1)
    private String gender;

    /** Opera V5: NATIONALITY VARCHAR2(20) — nationality of the individual */
    @Column(name = "nationality", length = 20)
    private String nationality;

    /** Opera V5: BIRTH_DATE — date of birth stored as string from event payload */
    @Column(name = "birth_date", length = 30)
    private String birthDate;

    /** Opera V5: BIRTH_DATE_STR VARCHAR2(2000) — encrypted/masked birth date (e.g. ~:377F0FF...) */
    @Column(name = "birth_date_str", length = 2000)
    private String birthDateStr;

    /** Opera V5: BIRTH_COUNTRY VARCHAR2(20) — country of birth */
    @Column(name = "birth_country", length = 20)
    private String birthCountry;

    /** Opera V5: LANGUAGE VARCHAR2(20) — primary language of the profile */
    @Column(name = "language", length = 20)
    private String language;

    /** Opera V5: PROFESSION VARCHAR2(80) — profession of the individual */
    @Column(name = "profession", length = 80)
    private String profession;

    /** Opera V5: ACTIVE_YN VARCHAR2(1) — whether the profile is active (Y/N) */
    @Column(name = "active_yn", length = 1)
    private String activeYn;

    /** Opera V5: INACTIVE_DATE — date the record was marked as inactive */
    @Column(name = "inactive_date", length = 30)
    private String inactiveDate;

    /** Opera V5: BL_MSG VARCHAR2(2000) — blacklist message for restricted profiles */
    @Column(name = "bl_msg", length = 2000)
    private String blMsg;

    /** Opera V5: CASH_BL_IND VARCHAR2(1) — billing restriction: C (Cash), R (Restricted), N (Normal) */
    @Column(name = "cash_bl_ind", length = 1)
    private String cashBlInd;

    /** Opera V5: EMAIL_YN VARCHAR2(1) — email consent flag (Y/N) */
    @Column(name = "email_yn", length = 1)
    private String emailYn;

    /** Opera V5: MAIL_YN VARCHAR2(1) — mail consent flag (Y/N) */
    @Column(name = "mail_yn", length = 1)
    private String mailYn;

    /** Opera V5: VIP_STATUS VARCHAR2(20) — VIP status of the individual */
    @Column(name = "vip_status", length = 20)
    private String vipStatus;

    /** Opera V5: INSERT_DATE — event timestamp on first appearance of this primaryKey */
    @Column(name = "insert_date", length = 30)
    private String insertDate;
}
