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

    // Event-level fields
    private String timestamp;
    private String primaryKey;
    private String hotelId;

    // Name / identity
    private String nameId;
    private String nameType;
    private String name;
    private String name2;
    private String name3;
    private String firstName;
    private String middle;
    private String title;
    private String xName;
    private String xFirstName;
    private String xSalutation;
    private String xTitle;
    private String incognitoName;
    private String incognitoFirst;
    private String businessTitle;
    private String language;
    private String nationality;
    private String gender;
    private String birthDate;
    private String birthPlace;
    private String birthCountry;
    private String vipStatus;
    private String status;

    // Address
    private String address1;
    private String address2;
    private String address3;
    private String address4;
    private String city;
    private String state;
    private String postalCode;
    private String country;
    private String addressType;
    private String addressPrimaryYn;
    private String addressLanguage;

    // Contact
    private String phoneNumber;
    private String phonePrimaryYn;
    private String phoneType;
    private String phoneYn;
    private String phoneOptInFlg;
    private String faxNumber;
    private String pager;
    private String virtualNumber;
    private String email;
    private String emailLanguage;
    private String emailYn;
    private String emailOptInFlg;
    private String webpage;

    // Identifications
    private String idNumber;
    private String idType;
    private String idDate;
    private String idExpirationDate;
    private String idPlace;
    private String idCountry;
    private String passportNumber;

    // Tax / legal
    private String taxNumber1;
    private String taxNumber2;
    private String legalCompany;

    // Company / industry
    private String companyNumber;
    private String companyType;
    private String industryCode;
    private String iataNumber;
    private String iataType;
    private String chainCode;
    private String databaseId;

    // Membership
    private String membershipNumber;
    private String membershipType;
    private String membershipLevel;
    private String membershipExpirationDate;
    private String membershipEnrolledAt;
    private String membershipEnrollmentSource;
    private String membershipDeviceCode;
    private String membershipDeviceDisableDate;
    private String autoEnrollMembershipYn;
    private String autoEnrollMembershipOptInFlg;

    // Preferences
    private String preferenceGroup;
    private String preferenceType;
    private String preferenceTypeDescription;

    // Keywords
    private String keyword;
    private String keywordType;

    // A/R & financial
    private String arNumber;
    private String centralArNumber;
    private String creditRating;
    private String cashBlInd;
    private String blMsg;
    private String adjustmentAmount;
    private String adjustmentCode;
    private String adjustmentType;
    private String commissionCode;
    private String commissionCurrency;
    private String accountSource;
    private String accountType;

    // Credit card
    private String creditCardNumber;
    private String creditCardNumber4Digits;
    private String creditCardExpirationDate;
    private String creditCardType;
    private String creditCardVaultId;

    // Access / rate
    private String accessChannel;
    private String accessChannelCode;
    private String accessCode;
    private String accessRateCode;
    private String accessResorts;
    private String accessInactiveDate;
    private String accessUpdateDate;
    private String rateCode;

    // PCC
    private String pccChannel;
    private String pccCode;
    private String pccInactiveDate;

    // Sales / marketing
    private String salesManager;
    private String markets;
    private String scope;
    private String scopeCity;
    private String influence;
    private String priority;
    private String profession;
    private String roomsPotential;
    private String competitionCode;
    private String notification;

    // Opt-ins
    private String mailingListYn;
    private String mailingListOptInFlg;
    private String marketResearchYn;
    private String marketResearchOptInFlg;
    private String thirdPartyYn;
    private String thirdPartyOptInFlg;
    private String smsYn;
    private String smsOptInFlg;
    private String guestPrivacyYn;
    private String guestPrivacyOptInFlg;
    private String contactYn;

    // Misc
    private String actionCode;
    private String barcode;
    private String createdBy;
    private String anonymizationDate;
    private String anonymizationStatus;
    private String comments;
    private String departmentNoteShort;
    private String resortLogged;
    private String resortRegistered;

    // UDF Char fields (01-40)
    private String udfChar01;
    private String udfChar02;
    private String udfChar03;
    private String udfChar04;
    private String udfChar05;
    private String udfChar06;
    private String udfChar07;
    private String udfChar08;
    private String udfChar09;
    private String udfChar10;
    private String udfChar11;
    private String udfChar12;
    private String udfChar13;
    private String udfChar14;
    private String udfChar15;
    private String udfChar16;
    private String udfChar17;
    private String udfChar18;
    private String udfChar19;
    private String udfChar20;
    private String udfChar21;
    private String udfChar22;
    private String udfChar23;
    private String udfChar24;
    private String udfChar25;
    private String udfChar26;
    private String udfChar27;
    private String udfChar28;
    private String udfChar29;
    private String udfChar30;
    private String udfChar31;
    private String udfChar32;
    private String udfChar33;
    private String udfChar34;
    private String udfChar35;
    private String udfChar36;
    private String udfChar37;
    private String udfChar38;
    private String udfChar39;
    private String udfChar40;

    // UDF Number fields (01-40)
    private String udfNumber01;
    private String udfNumber02;
    private String udfNumber03;
    private String udfNumber04;
    private String udfNumber05;
    private String udfNumber06;
    private String udfNumber07;
    private String udfNumber08;
    private String udfNumber09;
    private String udfNumber10;
    private String udfNumber11;
    private String udfNumber12;
    private String udfNumber13;
    private String udfNumber14;
    private String udfNumber15;
    private String udfNumber16;
    private String udfNumber17;
    private String udfNumber18;
    private String udfNumber19;
    private String udfNumber20;
    private String udfNumber21;
    private String udfNumber22;
    private String udfNumber23;
    private String udfNumber24;
    private String udfNumber25;
    private String udfNumber26;
    private String udfNumber27;
    private String udfNumber28;
    private String udfNumber29;
    private String udfNumber30;
    private String udfNumber31;
    private String udfNumber32;
    private String udfNumber33;
    private String udfNumber34;
    private String udfNumber35;
    private String udfNumber36;
    private String udfNumber37;
    private String udfNumber38;
    private String udfNumber39;
    private String udfNumber40;

    // UDF Date fields (01-20)
    private String udfDate01;
    private String udfDate02;
    private String udfDate03;
    private String udfDate04;
    private String udfDate05;
    private String udfDate06;
    private String udfDate07;
    private String udfDate08;
    private String udfDate09;
    private String udfDate10;
    private String udfDate11;
    private String udfDate12;
    private String udfDate13;
    private String udfDate14;
    private String udfDate15;
    private String udfDate16;
    private String udfDate17;
    private String udfDate18;
    private String udfDate19;
    private String udfDate20;
}
