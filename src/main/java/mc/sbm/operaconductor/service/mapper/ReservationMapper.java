//package mc.sbm.operaconductor.service.mapper;
//
//import mc.sbm.operaconductor.GenericEvent;
//import mc.sbm.operaconductor.domain.ReservationDto;
//import org.springframework.stereotype.Component;
//
//import java.util.Map;
//import java.util.stream.Collectors;
//
//@Component
//public class ReservationMapper implements SinkMapper<ReservationDto> {
//
//    @Override
//    public String eventKey() {
//        return "RESERVATION_NEW_RESERVATION";
//    }
//
//    @Override
//    public ReservationDto map(GenericEvent event) {
//        return fromEvent(event);
//    }
//
//    @Override
//    public Class<ReservationDto> targetClass() {
//        return ReservationDto.class;
//    }
//
//    public static ReservationDto fromEvent(GenericEvent event) {
//        Map<String, String> d = event.getDetail().stream()
//            .collect(Collectors.toMap(
//                GenericEvent.EventDetail::getElementName,
//                detail -> detail.getNewValue() != null ? detail.getNewValue() : "",
//                (existing, replacement) -> existing
//            ));
//
//        return ReservationDto.builder()
//            // Event-level
//            .timestamp(event.getTimestamp())
//            .primaryKey(event.getPrimaryKey())
//            .hotelId(event.getHotelId())
//
//            // Guest
//            .name(d.get("NAME"))
//            .firstName(d.get("FIRST NAME"))
//            .middleName(d.get("MIDDLE NAME"))
//            .name2(d.get("NAME2"))
//            .name3(d.get("NAME3"))
//            .guestNameId(d.get("GUEST NAME ID"))
//            .membershipNumber(d.get("MEMBERSHIP NUMBER"))
//            .membershipType(d.get("MEMBERSHIP TYPE"))
//
//            // Reservation identifiers
//            .confirmationNo(d.get("CONFIRMATION NO"))
//            .confirmationLegNo(d.get("CONFIRMATION LEG NO"))
//            .parentResvNameId(d.get("PARENT RESV NAME ID"))
//            .extSegNo(d.get("EXT SEG NO"))
//            .resvNameId(d.get("RESV NAME ID"))
//            .resvVoucherId(d.get("RESV VOUCHER ID"))
//            .resort(d.get("RESORT"))
//            .externalReference(d.get("EXTERNAL REFERENCE"))
//            .externalReferenceLegNumber(d.get("EXTERNAL REFERENCE LEG NUMBER"))
//            .externalReferenceRevisionToken(d.get("EXTERNAL REFERENCE REVISION TOKEN"))
//            .externalType(d.get("EXTERNAL TYPE"))
//
//            // Addressee
//            .addresseeNameId(d.get("ADDRESSEE NAME ID"))
//            .addresseeName(d.get("ADDRESSEE NAME"))
//
//            // Associated profiles
//            .travelAgentName(d.get("TRAVEL AGENT NAME"))
//            .travelAgentNameId(d.get("TRAVEL AGENT NAME ID"))
//            .companyName(d.get("COMPANY NAME"))
//            .companyNameId(d.get("COMPANY NAME ID"))
//            .sourceName(d.get("SOURCE NAME"))
//            .sourceNameId(d.get("SOURCE NAME ID"))
//            .groupName(d.get("GROUP NAME"))
//            .groupNameId(d.get("GROUP NAME ID"))
//            .partyCode(d.get("PARTY CODE"))
//
//            // Reservation status & type
//            .reservationStatus(d.get("RESERVATION STATUS"))
//            .reservationType(d.get("RESERVATION TYPE"))
//
//            // Dates & stay
//            .arrivalDate(d.get("ARRIVAL DATE"))
//            .arrivalTime(d.get("ARRIVAL TIME"))
//            .departureDate(d.get("DEPARTURE DATE"))
//            .lengthOfStay(d.get("LENGTH OF STAY"))
//            .checkoutTime(d.get("CHECKOUT TIME"))
//            .numberOfRooms(d.get("NUMBER OF ROOMS"))
//            .advanceCheckedInYn(d.get("ADVANCE CHECKED IN YN"))
//            .advanceCheckInTime(d.get("ADVANCE CHECK IN TIME"))
//            .expectedTimeOfReturn(d.get("EXPECTED TIME OF RETURN"))
//            .etrComments(d.get("ETR COMMENTS"))
//
//            // Stay (additional)
//            .stayDate(d.get("STAY DATE"))
//            .stayDay(d.get("STAY DAY"))
//            .beginDate(d.get("BEGIN DATE"))
//            .endDate(d.get("END DATE"))
//            .preRegisteredYn(d.get("PRE REGISTERED YN"))
//
//            // Room
//            .room(d.get("ROOM"))
//            .roomType(d.get("ROOM TYPE"))
//            .rtc(d.get("RTC"))
//            .roomFeatures(d.get("ROOM FEATURES"))
//            .specialRequest(d.get("SPECIAL REQUEST"))
//            .scheduledRoomMoveStatus(d.get("SCHEDULED ROOM MOVE STATUS"))
//
//            // Room (additional)
//            .noOfUnits(d.get("NO OF UNITS"))
//            .extraBeds(d.get("EXTRA BEDS"))
//            .cribs(d.get("CRIBS"))
//            .item(d.get("ITEM"))
//            .quantity(d.get("QUANTITY"))
//            .moveAcrossResort(d.get("MOVE ACROSS RESORT"))
//
//            // Rate & financials
//            .rateCode(d.get("RATE CODE"))
//            .rateAmount(d.get("RATE AMOUNT"))
//            .currencyCode(d.get("CURRENCY CODE"))
//            .marketCode(d.get("MARKET CODE"))
//            .sourceCode(d.get("SOURCE CODE"))
//            .blockCode(d.get("BLOCK CODE"))
//            .discountAmount(d.get("DISCOUNT AMOUNT"))
//            .discountPercent(d.get("DISCOUNT PERCENT"))
//            .discountReason(d.get("DISCOUNT REASON"))
//            .discountReasonRule(d.get("DISCOUNT REASON RULE"))
//            .fixedRate(d.get("FIXED RATE"))
//            .shareAmountOriginal(d.get("SHARE AMOUNT ORIGINAL"))
//            .baseRateCode(d.get("BASE RATE CODE"))
//            .localBaseRateAmount(d.get("LOCAL BASE RATE AMOUNT"))
//            .baseRateCurrencyCode(d.get("BASE RATE CURRENCY CODE"))
//
//            // Rate & financials (additional)
//            .realtimeExchange(d.get("REALTIME EXCHANGE"))
//            .retroBenefitYn(d.get("RETRO BENEFIT YN"))
//            .upsellCharge(d.get("UPSELL CHARGE"))
//            .refTypeCode(d.get("REF TYPE CODE"))
//            .applySeq(d.get("APPLY SEQ"))
//            .benefitBasedOn(d.get("BENEFIT BASED ON"))
//
//            // Occupancy
//            .adults(d.get("ADULTS"))
//            .children(d.get("CHILDREN"))
//            .children1(d.get("CHILDREN 1"))
//            .children2(d.get("CHILDREN 2"))
//            .children3(d.get("CHILDREN 3"))
//            .childrenAge(d.get("CHILDREN AGE"))
//
//            // Payment
//            .paymentMethod(d.get("PAYMENT METHOD"))
//            .paymentMethodDesc(d.get("PAYMENT METHOD DESC"))
//            .creditCardNumber(d.get("CREDIT CARD NUMBER"))
//            .creditCardNumber4Digits(d.get("CREDIT CARD NUMBER 4 DIGITS"))
//            .creditCardExpirationDate(d.get("CREDIT CARD EXPIRATION DATE"))
//            .creditCardType(d.get("CREDIT CARD TYPE"))
//            .creditCardVaultId(d.get("CREDIT CARD VAULT ID"))
//            .panToken(d.get("PAN TOKEN"))
//            .authorizer(d.get("AUTHORIZER"))
//            .externalUserId(d.get("EXTERNAL USER ID"))
//            .authorizeCreditBill(d.get("AUTHORIZE CREDIT BILL"))
//            .creditLimitAutoPayAllowYn(d.get("CREDIT LIMIT AUTO PAY ALLOW YN"))
//
//            // Payment (additional)
//            .authorizeDirectBill(d.get("AUTHORIZE DIRECT BILL"))
//            .countryDialingCode(d.get("COUNTRY DIALING CODE"))
//            .phoneNumber(d.get("PHONE NUMBER"))
//            .phonePrimaryYn(d.get("PHONE PRIMARY YN"))
//            .phoneRole(d.get("PHONE ROLE"))
//            .phoneType(d.get("PHONE TYPE"))
//            .validYn(d.get("VALID YN"))
//            .optInYn(d.get("OPT IN YN"))
//
//            // Voucher / certificates
//            .voucherBenefitCode(d.get("VOUCHER BENEFIT CODE"))
//            .voucherBenefitDtlCode(d.get("VOUCHER BENEFIT DTL CODE"))
//            .voucherNo(d.get("VOUCHER NO"))
//            .voucherType(d.get("VOUCHER TYPE"))
//            .eCertificateNo(d.get("E CERTIFICATE NO"))
//
//            // Loyalty / awards
//            .awardCode1(d.get("AWARD CODE 1"))
//            .awardVoucher1(d.get("AWARD VOUCHER 1"))
//            .gpEligibility(d.get("GP_ELIGIBILITY"))
//
//            // Commission
//            .commissionPaidTo(d.get("COMMISSION PAID TO"))
//            .commissionPayoutTo(d.get("COMMISSION PAYOUT TO"))
//            .taRecordLocator(d.get("TA RECORD LOCATOR"))
//
//            // Commission (additional)
//            .refTypeCode(d.get("REF TYPE CODE"))
//            .applySeq(d.get("APPLY SEQ"))
//            .benefitBasedOn(d.get("BENEFIT BASED ON"))
//
//            // Preferences
//            .preferenceGroup(d.get("PREFERENCE GROUP"))
//            .preferenceType(d.get("PREFERENCE TYPE"))
//            .preferenceTypeDescription(d.get("PREFERENCE TYPE DESCRIPTION"))
//
//            // Notes / Comments
//            .commentId(d.get("COMMENT ID"))
//            .commentType(d.get("COMMENT TYPE"))
//            .comments(d.get("COMMENTS"))
//            .noteCode(d.get("NOTE CODE"))
//            .noteTitle(d.get("NOTE TITLE"))
//            .topicId(d.get("TOPIC ID"))
//            .transactionTypeId(d.get("TRANSACTION TYPE ID"))
//
//            // Communication
//            .communication(d.get("COMMUNICATION"))
//            .communicationPriority(d.get("COMMUNICATION PRIORITY"))
//            .communicationRole(d.get("COMMUNICATION ROLE"))
//            .communicationType(d.get("COMMUNICATION TYPE"))
//
//            // Yield / revenue management
//            .hurdleRate(d.get("HURDLE RATE"))
//            .rateableValue(d.get("RATEABLE VALUE"))
//            .restrictionOverride(d.get("RESTRICTION OVERRIDE"))
//            .hurdleOverride(d.get("HURDLE OVERRIDE"))
//            .yieldStatus(d.get("YIELD STATUS"))
//            .yieldMarketType(d.get("YIELD MARKET TYPE"))
//            .spgUpgradeReasonCode(d.get("SPG UPGRADE REASON CODE"))
//            .spgDiscloseRoomTypeYn(d.get("SPG DISCLOSE ROOM TYPE YN"))
//
//            // Transport - arrival
//            .arrivalTransportType(d.get("ARRIVAL TRANSPORT TYPE"))
//            .arrivalStationCode(d.get("ARRIVAL STATION CODE"))
//            .arrivalCarrierCode(d.get("ARRIVAL CARRIER CODE"))
//            .arrivalTransportCode(d.get("ARRIVAL TRANSPORT CODE"))
//            .arrivalDatetime(d.get("ARRIVAL DATETIME"))
//            .arrivalTransportTime(d.get("ARRIVAL TRANSPORT TIME"))
//            .arrivalEstimateTime(d.get("ARRIVAL ESTIMATE TIME"))
//            .arrivalTransportation(d.get("ARRIVAL TRANSPORTATION"))
//            .arrivalComments(d.get("ARRIVAL COMMENTS"))
//
//            // Transport - departure
//            .departureTransportType(d.get("DEPARTURE TRANSPORT TYPE"))
//            .departureStationCode(d.get("DEPARTURE STATION CODE"))
//            .departureCarrierCode(d.get("DEPARTURE CARRIER CODE"))
//            .departureTransportCode(d.get("DEPARTURE TRANSPORT CODE"))
//            .departureDatetime(d.get("DEPARTURE DATETIME"))
//            .departureTransportTime(d.get("DEPARTURE TRANSPORT TIME"))
//            .departureEstimateTime(d.get("DEPARTURE ESTIMATE TIME"))
//            .departureTransportation(d.get("DEPARTURE TRANSPORTATION"))
//            .departureComments(d.get("DEPARTURE COMMENTS"))
//
//            // Flags
//            .noPost(d.get("NO POST"))
//            .videoCheckout(d.get("VIDEO CHECKOUT"))
//            .printRateYn(d.get("PRINT RATE YN"))
//            .shareYn(d.get("SHARE YN"))
//            .splitYn(d.get("SPLIT YN"))
//            .walkIn(d.get("WALK IN"))
//            .connectingYn(d.get("CONNECTING YN"))
//            .optedForCommYn(d.get("OPTED FOR COMM YN"))
//            .folioOptIn(d.get("FOLIO OPT IN"))
//            .batchFolioOptIn(d.get("BATCH FOLIO OPT IN"))
//            .externalEfolioYn(d.get("EXTERNAL EFOLIO YN"))
//            .confirmationLetterYn(d.get("CONFIRMATION LETTER YN"))
//            .folioFlag(d.get("FOLIO FLAG"))
//            .compType(d.get("COMP TYPE"))
//            .taxType(d.get("TAX TYPE"))
//            .purposeOfStay(d.get("PURPOSE OF STAY"))
//            .origin(d.get("ORIGIN"))
//            .products(d.get("PRODUCTS"))
//            .promotions(d.get("PROMOTIONS"))
//            .appUser(d.get("APP USER"))
//            .upsellRule(d.get("UPSELL RULE"))
//            .upsold(d.get("UPSOLD"))
//            .jointoResvNameId(d.get("JOINTO RESV NAME ID"))
//
//            // Accompanying guest identifiers
//            .accompanyingGuestIdNumber(d.get("ACCOMPANYING GUEST ID NUMBER"))
//            .accompanyingGuestIdType(d.get("ACCOMPANYING GUEST ID TYPE"))
//            .accompanyingGuestPhoneNumber(d.get("ACCOMPANYING GUEST PHONE NUMBER"))
//            .accompanyingNameId(d.get("ACCOMPANYING NAMEID"))
//
//            // Accompanying guest details
//            .accompanyingGuestAddress1(d.get("ACCOMPANYING GUEST ADDRESS1"))
//            .accompanyingGuestAddress2(d.get("ACCOMPANYING GUEST ADDRESS2"))
//            .accompanyingGuestAddress3(d.get("ACCOMPANYING GUEST ADDRESS3"))
//            .accompanyingGuestAddress4(d.get("ACCOMPANYING GUEST ADDRESS4"))
//            .accompanyingGuestAttachDateTime(d.get("ACCOMPANYING GUEST ATTACH DATE TIME"))
//            .accompanyingGuestBirthDate(d.get("ACCOMPANYING GUEST BIRTH DATE"))
//            .accompanyingGuestCity(d.get("ACCOMPANYING GUEST CITY"))
//            .accompanyingGuestCountry(d.get("ACCOMPANYING GUEST COUNTRY"))
//            .accompanyingGuestDetachDateTime(d.get("ACCOMPANYING GUEST DETACH DATE TIME"))
//            .accompanyingGuestDetachedYn(d.get("ACCOMPANYING GUEST DETACHED YN"))
//            .accompanyingGuestEmail(d.get("ACCOMPANYING GUEST EMAIL"))
//            .accompanyingGuestFirst(d.get("ACCOMPANYING GUEST FIRST"))
//            .accompanyingGuestMembershipLevel(d.get("ACCOMPANYING GUEST MEMBERSHIP LEVEL"))
//            .accompanyingGuestMembershipNumber(d.get("ACCOMPANYING GUEST MEMBERSHIP NUMBER"))
//            .accompanyingGuestMembershipType(d.get("ACCOMPANYING GUEST MEMBERSHIP TYPE"))
//            .accompanyingGuestNationality(d.get("ACCOMPANYING GUEST NATIONALITY"))
//            .accompanyingGuestPostalCode(d.get("ACCOMPANYING GUEST POSTAL CODE"))
//            .accompanyingGuestRelationship(d.get("ACCOMPANYING GUEST RELATIONSHIP"))
//            .accompanyingGuestState(d.get("ACCOMPANYING GUEST STATE"))
//            .accompanyingGuestVip(d.get("ACCOMPANYING GUEST VIP"))
//
//            // Waitlist
//            .waitlistPriority(d.get("WAITLIST PRIORITY"))
//            .waitlistReasonCode(d.get("WAITLIST REASON CODE"))
//            .waitlistReasonDescription(d.get("WAITLIST REASON DESCRIPTION"))
//
//            // Cancellation
//            .cancellationTime(d.get("CANCELLATION TIME"))
//            .cancellationDate(d.get("CANCELLATION DATE"))
//            .cancellationNo(d.get("CANCELLATION NO"))
//            .cancellationReasonCode(d.get("CANCELLATION REASON CODE"))
//            .cancellationReasonDescription(d.get("CANCELLATION REASON DESCRIPTION"))
//
//            // Audit
//            .insertDate(d.get("INSERT DATE"))
//            .insertUser(d.get("INSERT USER"))
//            .updateDate(d.get("UPDATE DATE"))
//            .updateUser(d.get("UPDATE USER"))
//            .actionDate(d.get("ACTION DATE"))
//            .userName(d.get("USER NAME"))
//
//            // UDF Char (01-40)
////            .udfChar01(d.get("UDF CHAR 01")).udfChar02(d.get("UDF CHAR 02")).udfChar03(d.get("UDF CHAR 03"))
////            .udfChar04(d.get("UDF CHAR 04")).udfChar05(d.get("UDF CHAR 05")).udfChar06(d.get("UDF CHAR 06"))
////            .udfChar07(d.get("UDF CHAR 07")).udfChar08(d.get("UDF CHAR 08")).udfChar09(d.get("UDF CHAR 09"))
////            .udfChar10(d.get("UDF CHAR 10")).udfChar11(d.get("UDF CHAR 11")).udfChar12(d.get("UDF CHAR 12"))
////            .udfChar13(d.get("UDF CHAR 13")).udfChar14(d.get("UDF CHAR 14")).udfChar15(d.get("UDF CHAR 15"))
////            .udfChar16(d.get("UDF CHAR 16")).udfChar17(d.get("UDF CHAR 17")).udfChar18(d.get("UDF CHAR 18"))
////            .udfChar19(d.get("UDF CHAR 19")).udfChar20(d.get("UDF CHAR 20")).udfChar21(d.get("UDF CHAR 21"))
////            .udfChar22(d.get("UDF CHAR 22")).udfChar23(d.get("UDF CHAR 23")).udfChar24(d.get("UDF CHAR 24"))
////            .udfChar25(d.get("UDF CHAR 25")).udfChar26(d.get("UDF CHAR 26")).udfChar27(d.get("UDF CHAR 27"))
////            .udfChar28(d.get("UDF CHAR 28")).udfChar29(d.get("UDF CHAR 29")).udfChar30(d.get("UDF CHAR 30"))
////            .udfChar31(d.get("UDF CHAR 31")).udfChar32(d.get("UDF CHAR 32")).udfChar33(d.get("UDF CHAR 33"))
////            .udfChar34(d.get("UDF CHAR 34")).udfChar35(d.get("UDF CHAR 35")).udfChar36(d.get("UDF CHAR 36"))
////            .udfChar37(d.get("UDF CHAR 37")).udfChar38(d.get("UDF CHAR 38")).udfChar39(d.get("UDF CHAR 39"))
////            .udfChar40(d.get("UDF CHAR 40"))
////
////            // UDF Number (01-40)
////            .udfNumber01(d.get("UDF NUMBER 01")).udfNumber02(d.get("UDF NUMBER 02")).udfNumber03(d.get("UDF NUMBER 03"))
////            .udfNumber04(d.get("UDF NUMBER 04")).udfNumber05(d.get("UDF NUMBER 05")).udfNumber06(d.get("UDF NUMBER 06"))
////            .udfNumber07(d.get("UDF NUMBER 07")).udfNumber08(d.get("UDF NUMBER 08")).udfNumber09(d.get("UDF NUMBER 09"))
////            .udfNumber10(d.get("UDF NUMBER 10")).udfNumber11(d.get("UDF NUMBER 11")).udfNumber12(d.get("UDF NUMBER 12"))
////            .udfNumber13(d.get("UDF NUMBER 13")).udfNumber14(d.get("UDF NUMBER 14")).udfNumber15(d.get("UDF NUMBER 15"))
////            .udfNumber16(d.get("UDF NUMBER 16")).udfNumber17(d.get("UDF NUMBER 17")).udfNumber18(d.get("UDF NUMBER 18"))
////            .udfNumber19(d.get("UDF NUMBER 19")).udfNumber20(d.get("UDF NUMBER 20")).udfNumber21(d.get("UDF NUMBER 21"))
////            .udfNumber22(d.get("UDF NUMBER 22")).udfNumber23(d.get("UDF NUMBER 23")).udfNumber24(d.get("UDF NUMBER 24"))
////            .udfNumber25(d.get("UDF NUMBER 25")).udfNumber26(d.get("UDF NUMBER 26")).udfNumber27(d.get("UDF NUMBER 27"))
////            .udfNumber28(d.get("UDF NUMBER 28")).udfNumber29(d.get("UDF NUMBER 29")).udfNumber30(d.get("UDF NUMBER 30"))
////            .udfNumber31(d.get("UDF NUMBER 31")).udfNumber32(d.get("UDF NUMBER 32")).udfNumber33(d.get("UDF NUMBER 33"))
////            .udfNumber34(d.get("UDF NUMBER 34")).udfNumber35(d.get("UDF NUMBER 35")).udfNumber36(d.get("UDF NUMBER 36"))
////            .udfNumber37(d.get("UDF NUMBER 37")).udfNumber38(d.get("UDF NUMBER 38")).udfNumber39(d.get("UDF NUMBER 39"))
////            .udfNumber40(d.get("UDF NUMBER 40"))
////
////            // UDF Date (01-20)
////            .udfDate01(d.get("UDF DATE 01")).udfDate02(d.get("UDF DATE 02")).udfDate03(d.get("UDF DATE 03"))
////            .udfDate04(d.get("UDF DATE 04")).udfDate05(d.get("UDF DATE 05")).udfDate06(d.get("UDF DATE 06"))
////            .udfDate07(d.get("UDF DATE 07")).udfDate08(d.get("UDF DATE 08")).udfDate09(d.get("UDF DATE 09"))
////            .udfDate10(d.get("UDF DATE 10")).udfDate11(d.get("UDF DATE 11")).udfDate12(d.get("UDF DATE 12"))
////            .udfDate13(d.get("UDF DATE 13")).udfDate14(d.get("UDF DATE 14")).udfDate15(d.get("UDF DATE 15"))
////            .udfDate16(d.get("UDF DATE 16")).udfDate17(d.get("UDF DATE 17")).udfDate18(d.get("UDF DATE 18"))
////            .udfDate19(d.get("UDF DATE 19")).udfDate20(d.get("UDF DATE 20"))
//
//            .build();
//    }
//}
