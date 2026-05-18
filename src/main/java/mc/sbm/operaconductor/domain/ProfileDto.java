package mc.sbm.operaconductor.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProfileDto {

    private String timestamp;
    private String primaryKey;
    private String hotelId;

    // NAME table elements
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

    // MEMBERSHIPS table elements
    private String membershipInactiveDate;
    private String membershipCardNo;
    private String membershipType;
    private String membershipNameOnCard;
}
