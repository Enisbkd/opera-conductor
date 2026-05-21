package mc.sbm.operaconductor.domain;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MembershipDto {

    private String timestamp;
    private String primaryKey;
    private String hotelId;

    private String nameId;
    private String membershipType;
    private String membershipCardNo;
    private String nameOnCard;
    private String inactiveDate;
}
