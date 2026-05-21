package mc.sbm.operaconductor.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class NameDto {

    private String timestamp;
    private String primaryKey;
    private String hotelId;

    // NAME table fields
    private String nameId; // NAME_ID  → "NAME ID"
    private String nameType; // NAME_TYPE → "NAME TYPE"
    private String sName; // SNAME     → "NAME" (company name / legal name)
    private String last; // LAST      → "NAME" (can be empty for companies)
    private String first; // FIRST     → "FIRST"
    private String sFirst; // SFIRST    → "FIRST" (uppercase)
    private String middle; // MIDDLE    → "MIDDLE"
    private String title; // TITLE     → "TITLE"
    private String gender; // GENDER    → "GENDER"
    private String nationality; // NATIONALITY → "NATIONALITY"
    private String birthDate; // BIRTH_DATE → "BIRTH DATE"
    private String birthDateStr; // BIRTH_DATE_STR → TBD (encrypted form)
    private String birthCountry; // BIRTH_COUNTRY → "BIRTH COUNTRY"
    private String language; // LANGUAGE  → "LANGUAGE"
    private String profession; // PROFESSION → "PROFESSION"
    private String activeYn; // ACTIVE_YN → "ACTIVE"
    private String inactiveDate; // INACTIVE_DATE → "INACTIVE DATE"
    private String blMsg; // BL_MSG    → "BL MSG"
    private String cashBlInd; // CASH_BL_IND → "CASH BL IND"
    private String emailYn; // EMAIL_YN  → "EMAIL YN"
    private String mailYn; // MAIL_YN   → "MAIL YN"
    private String vipStatus; // VIP_STATUS → "VIP STATUS"
    private String insertDate; // INSERT_DATE → event timestamp on first appearance
}
