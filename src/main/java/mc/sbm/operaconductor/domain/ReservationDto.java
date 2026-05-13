package mc.sbm.operaconductor.domain;

import lombok.*;

@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class ReservationDto {

    // Event-level fields
    private String timestamp;
    private String primaryKey;
    private String hotelId;

    // Guest
    private String name;
    private String firstName;
    private String middleName;
    private String name2;
    private String name3;
    private String title;
    private String language;
    private String vipStatus;
    private String guestNameId;
    private String membershipNumber;
    private String membershipType;

    // Reservation identifiers
    private String confirmationNo;
    private String confirmationLegNo;
    private String parentResvNameId;
    private String extSegNo;

    // Associated profiles
    private String travelAgentName;
    private String travelAgentNameId;
    private String companyName;
    private String companyNameId;
    private String sourceName;
    private String sourceNameId;
    private String groupName;
    private String groupNameId;
    private String partyCode;

    // Reservation status & type
    private String reservationStatus;
    private String reservationType;

    // Reservation core identifiers (additional)
    private String resvNameId;
    private String resvVoucherId;
    private String resort;
    private String externalReference;
    private String externalReferenceLegNumber;
    private String externalReferenceRevisionToken;
    private String externalType;

    // Addressee
    private String addresseeNameId;
    private String addresseeName;

    // Dates & stay
    private String arrivalDate;
    private String arrivalTime;
    private String departureDate;
    private String lengthOfStay;
    private String checkoutTime;
    private String numberOfRooms;
    private String advanceCheckedInYn;
    private String advanceCheckInTime;
    private String expectedTimeOfReturn;
    private String etrComments;

    // Stay details (additional)
    private String stayDate;
    private String stayDay;
    private String beginDate;
    private String endDate;
    private String preRegisteredYn;

    // Room
    private String room;
    private String roomType;
    private String rtc;
    private String roomStatus;
    private String roomClass;
    private String roomFeatures;
    private String specialRequest;
    private String scheduledRoomMoveStatus;

    // Room (additional)
    private String noOfUnits;
    private String extraBeds;
    private String cribs;
    private String item;
    private String quantity;
    private String moveAcrossResort;

    // Rate & financials
    private String rateCode;
    private String rateAmount;
    private String currencyCode;
    private String marketCode;
    private String sourceCode;
    private String blockCode;
    private String discountAmount;
    private String discountPercent;
    private String discountReason;
    private String discountReasonRule;
    private String fixedRate;
    private String shareAmountOriginal;
    private String baseRateCode;
    private String localBaseRateAmount;
    private String baseRateCurrencyCode;

    // Rate & financials (additional)
    private String realtimeExchange;
    private String retroBenefitYn;
    private String upsellCharge;
    private String refTypeCode;
    private String applySeq;
    private String benefitBasedOn;

    // Occupancy
    private String adults;
    private String children;
    private String children1;
    private String children2;
    private String children3;
    private String childrenAge;

    // Payment
    private String paymentMethod;
    private String paymentMethodDesc;
    private String creditCardNumber;
    private String creditCardNumber4Digits;
    private String creditCardExpirationDate;
    private String creditCardType;
    private String creditCardVaultId;
    private String panToken;
    private String authorizer;
    private String externalUserId;
    private String authorizeCreditBill;
    private String creditLimitAutoPayAllowYn;

    // Payment (additional)
    private String authorizeDirectBill;
    private String countryDialingCode;
    private String phoneNumber;
    private String phonePrimaryYn;
    private String phoneRole;
    private String phoneType;
    private String validYn;
    private String optInYn;

    // Voucher / certificates
    private String voucherBenefitCode;
    private String voucherBenefitDtlCode;
    private String voucherNo;
    private String voucherType;
    private String eCertificateNo;

    // Loyalty / awards
    private String awardCode1;
    private String awardVoucher1;
    private String gpEligibility;

    // Commission
    private String commissionPaidTo;
    private String commissionPayoutTo;
    private String taRecordLocator;

    // Preferences (new reservation specific)
    private String preferenceGroup;
    private String preferenceType;
    private String preferenceTypeDescription;

    // Notes / Comments
    private String commentId;
    private String commentType;
    private String comments;
    private String noteCode;
    private String noteTitle;
    private String topicId;
    private String transactionTypeId;

    // Communication
    private String communication;
    private String communicationPriority;
    private String communicationRole;
    private String communicationType;

    // Yield / revenue management
    private String hurdleRate;
    private String rateableValue;
    private String restrictionOverride;
    private String hurdleOverride;
    private String yieldStatus;
    private String yieldMarketType;
    private String spgUpgradeReasonCode;
    private String spgDiscloseRoomTypeYn;

    // Transport - arrival
    private String arrivalTransportType;
    private String arrivalStationCode;
    private String arrivalCarrierCode;
    private String arrivalTransportCode;
    private String arrivalDatetime;
    private String arrivalTransportTime;
    private String arrivalEstimateTime;
    private String arrivalTransportation;
    private String arrivalComments;

    // Transport - departure
    private String departureTransportType;
    private String departureStationCode;
    private String departureCarrierCode;
    private String departureTransportCode;
    private String departureDatetime;
    private String departureTransportTime;
    private String departureEstimateTime;
    private String departureTransportation;
    private String departureComments;

    // Flags
    private String noPost;
    private String videoCheckout;
    private String printRateYn;
    private String shareYn;
    private String splitYn;
    private String walkIn;
    private String connectingYn;
    private String optedForCommYn;
    private String folioOptIn;
    private String batchFolioOptIn;
    private String externalEfolioYn;
    private String confirmationLetterYn;
    private String folioFlag;
    private String guestMessageYn;
    private String compType;
    private String taxType;
    private String purposeOfStay;
    private String origin;
    private String products;
    private String promotions;
    private String appUser;
    private String upsellRule;
    private String upsold;
    private String jointoResvNameId;

    // Accompanying guest identifiers
    private String accompanyingGuestIdNumber;
    private String accompanyingGuestIdType;
    private String accompanyingGuestPhoneNumber;
    private String accompanyingNameId;

    // Accompanying guest details
    private String accompanyingGuestAddress1;
    private String accompanyingGuestAddress2;
    private String accompanyingGuestAddress3;
    private String accompanyingGuestAddress4;
    private String accompanyingGuestAttachDateTime;
    private String accompanyingGuestBirthDate;
    private String accompanyingGuestCity;
    private String accompanyingGuestCountry;
    private String accompanyingGuestDetachDateTime;
    private String accompanyingGuestDetachedYn;
    private String accompanyingGuestEmail;
    private String accompanyingGuestFirst;
    private String accompanyingGuestMembershipLevel;
    private String accompanyingGuestMembershipNumber;
    private String accompanyingGuestMembershipType;
    private String accompanyingGuestNationality;
    private String accompanyingGuestPostalCode;
    private String accompanyingGuestRelationship;
    private String accompanyingGuestState;
    private String accompanyingGuestVip;

    // Waitlist
    private String waitlistPriority;
    private String waitlistReasonCode;
    private String waitlistReasonDescription;

    // Cancellation (new reservation specific)
    private String cancellationTime;
    private String cancellationDate;
    private String cancellationNo;
    private String cancellationReasonCode;
    private String cancellationReasonDescription;

    // Check-in specific
    private String checkInInitiatedBy;
    private String turndownDate;
    private String turndownStatus;

    // Audit
    private String insertDate;
    private String insertUser;
    private String updateDate;
    private String updateUser;
    private String actionDate;
    private String userName;

    //    // UDF Char fields (01-40)
    //    private String udfChar01; private String udfChar02; private String udfChar03;
    //    private String udfChar04; private String udfChar05; private String udfChar06;
    //    private String udfChar07; private String udfChar08; private String udfChar09;
    //    private String udfChar10; private String udfChar11; private String udfChar12;
    //    private String udfChar13; private String udfChar14; private String udfChar15;
    //    private String udfChar16; private String udfChar17; private String udfChar18;
    //    private String udfChar19; private String udfChar20; private String udfChar21;
    //    private String udfChar22; private String udfChar23; private String udfChar24;
    //    private String udfChar25; private String udfChar26; private String udfChar27;
    //    private String udfChar28; private String udfChar29; private String udfChar30;
    //    private String udfChar31; private String udfChar32; private String udfChar33;
    //    private String udfChar34; private String udfChar35; private String udfChar36;
    //    private String udfChar37; private String udfChar38; private String udfChar39;
    //    private String udfChar40;
    //
    //    // UDF Number fields (01-40)
    //    private String udfNumber01; private String udfNumber02; private String udfNumber03;
    //    private String udfNumber04; private String udfNumber05; private String udfNumber06;
    //    private String udfNumber07; private String udfNumber08; private String udfNumber09;
    //    private String udfNumber10; private String udfNumber11; private String udfNumber12;
    //    private String udfNumber13; private String udfNumber14; private String udfNumber15;
    //    private String udfNumber16; private String udfNumber17; private String udfNumber18;
    //    private String udfNumber19; private String udfNumber20; private String udfNumber21;
    //    private String udfNumber22; private String udfNumber23; private String udfNumber24;
    //    private String udfNumber25; private String udfNumber26; private String udfNumber27;
    //    private String udfNumber28; private String udfNumber29; private String udfNumber30;
    //    private String udfNumber31; private String udfNumber32; private String udfNumber33;
    //    private String udfNumber34; private String udfNumber35; private String udfNumber36;
    //    private String udfNumber37; private String udfNumber38; private String udfNumber39;
    //    private String udfNumber40;
    //
    //    // UDF Date fields (01-20)
    //    private String udfDate01; private String udfDate02; private String udfDate03;
    //    private String udfDate04; private String udfDate05; private String udfDate06;
    //    private String udfDate07; private String udfDate08; private String udfDate09;
    //    private String udfDate10; private String udfDate11; private String udfDate12;
    //    private String udfDate13; private String udfDate14; private String udfDate15;
    //    private String udfDate16; private String udfDate17; private String udfDate18;
    //    private String udfDate19; private String udfDate20;
}
