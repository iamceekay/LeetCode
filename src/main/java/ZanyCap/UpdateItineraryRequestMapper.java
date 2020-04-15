/*
package ZanyCap;

package com.disney.wdat.api.packageorderoperation.dao.mapper.dreams;

import static com.disney.wdat.api.packageorderoperation.util.PackageOrderOperationServiceConstants.Accovia;
import static org.apache.commons.collections.CollectionUtils.isNotEmpty;

import java.util.List;
import java.util.Optional;

import org.apache.commons.lang3.StringUtils;

import com.disney.wdat.api.packageorderoperation.enums.GatheringAction;
import com.disney.wdat.api.packageorderoperation.enums.OrderIdSource;
import com.disney.wdat.api.packageorderoperation.mapper.BaseMapper;
import com.disney.wdat.api.packageorderoperation.model.AlternateIdentifier;
import com.disney.wdat.api.packageorderoperation.model.Id;
import com.disney.wdat.api.packageorderoperation.model.ItemProperty;
import com.disney.wdat.api.packageorderoperation.model.ReservationProperties;
import com.disney.wdat.api.packageorderoperation.model.request.ExtendDepositDueDateRequest;
import com.disney.wdat.api.packageorderoperation.model.request.GatheringRequest;
import com.disney.wdat.api.packageorderoperation.model.request.OrderItemPropertiesRequest;
import com.wdw.dreams.booking.transferobject.bookingschema.ExternalReferenceDetail;
import com.wdw.dreams.booking.transferobject.enums.RoomResActionEnum;
import com.wdw.dreams.booking.transferobject.segment.UpdateItineraryRequest;

*/
/**
 * Maps the {@link UpdateItineraryRequest} object using the OrderConfirmationRequest
 * {@link OrderConfirmationRequest}
 *
 *
 *//*

public class UpdateItineraryRequestMapper implements BaseMapper<OrderItemPropertiesRequest, UpdateItineraryRequest> {

    private static final UpdateItineraryRequestMapper INSTANCE = new UpdateItineraryRequestMapper();

    private enum PROPERTY_NAME { GROUP_CODE, CONTACT_PERSON_NAME }

    public static UpdateItineraryRequestMapper getInstance() {
        return INSTANCE;
    }

    */
/**
     * @param orderItemPropertiesRequest
     * @return UpdateItineraryRequest
     * maps the OrderItemPropertiesRequest to UpdateItineraryRequest
     *//*

    @Override
    public UpdateItineraryRequest map(OrderItemPropertiesRequest ordItmPropsReq) {
        String groupCode = getPropertyValue(PROPERTY_NAME.GROUP_CODE, ordItmPropsReq.getItemProperties());
        UpdateItineraryRequest updateItineraryRequest = initUpdateItineraryRequest(ordItmPropsReq.getIdSource(),
                ordItmPropsReq.getOrderId(), groupCode);

        updateItineraryRequest.setContactName(getPropertyValue(PROPERTY_NAME.CONTACT_PERSON_NAME, ordItmPropsReq.getItemProperties()));

        return updateItineraryRequest;
    }

    */
/**
     * @param String
     * @param String
     * @param ItemProperty list
     * @param String
     * @return UpdateItineraryRequest
     * maps the data in OrderItemPropertiesRequest to UpdateItineraryRequest
     *//*

    private UpdateItineraryRequest initUpdateItineraryRequest(String idSource, String orderId, String groupCode) {
        UpdateItineraryRequest updateItineraryRequest = new UpdateItineraryRequest();
        if (OrderIdSource.DREAMS.name().equalsIgnoreCase(idSource)) {
            updateItineraryRequest.setTravelPlanSegmentId(Long.valueOf(orderId));
        } else {
            updateItineraryRequest.setExternalReferenceDetail(mapExternalReferenceDetail(orderId, groupCode));
        }
        return updateItineraryRequest;
    }

    */
/**
     * @param ExtendDepositDueDateRequest
     * @return UpdateItineraryRequest
     * maps the ExtendDepositDueDateRequest to UpdateItineraryRequest
     *//*

    public UpdateItineraryRequest map(ExtendDepositDueDateRequest depDueDateReq) {
        String groupCode = Optional.ofNullable(depDueDateReq.getItemId())
                .map(id -> PROPERTY_NAME.GROUP_CODE.name().equalsIgnoreCase(id.getType()) ? id.getValue() : null)
                .orElse(null);

        UpdateItineraryRequest updateItineraryRequest = initUpdateItineraryRequest(depDueDateReq.getIdSource(),
                depDueDateReq.getOrderId(), groupCode);

        updateItineraryRequest.setDepositDateExtension(depDueDateReq.getExtendDays());

        return updateItineraryRequest;
    }

    */
/**
     * @param GatheringRequest
     * @return UpdateItineraryRequest
     * maps the GatheringRequest to UpdateItineraryRequest
     *//*

    public UpdateItineraryRequest map(GatheringRequest gatheringRequest) {
        String groupCode = getAltIdValue(gatheringRequest.getId(), PROPERTY_NAME.GROUP_CODE);
        UpdateItineraryRequest updateItineraryRequest = initUpdateItineraryRequest(gatheringRequest.getIdSource(),
                gatheringRequest.getOrderId(), groupCode);

        updateItineraryRequest.setGatheringId(gatheringRequest.getId().getValue());
        updateItineraryRequest.setGatheringName(gatheringRequest.getName());
        updateItineraryRequest.setGatheringType(gatheringRequest.getType());
        if (GatheringAction.ASSOCIATE.name().equals(gatheringRequest.getAction())) {
            updateItineraryRequest.setRoomResAction(RoomResActionEnum.GATHERING_ASSOCIATE);
        } else if (GatheringAction.DISASSOCIATE.name().equals(gatheringRequest.getAction())) {
            updateItineraryRequest.setRoomResAction(RoomResActionEnum.GATHERING_DIS_ASSOCIATE);
        }


        return updateItineraryRequest;
    }

    */
/**
     * @param orderItemPropertiesRequest
     * @return ExternalReferenceDetail
     * maps the external Reference Details
     *//*

    private ExternalReferenceDetail mapExternalReferenceDetail(String orderId, String groupCode) {
        ExternalReferenceDetail externalReferenceDetail = new ExternalReferenceDetail();

        externalReferenceDetail.setExternalReferenceNumber(String.valueOf(orderId));
        if (StringUtils.isNotBlank(groupCode)) {
            externalReferenceDetail.setExternalReferenceCode(groupCode);
        } else {
// this flow is applicable only to WDW
            externalReferenceDetail.setExternalReferenceSource(Accovia);
        }

        return externalReferenceDetail;
    }

    */
/**
     * @param String propertyName
     * @param ItemProperty List
     * @return String
     * gets the property value
     *//*

    private String getPropertyValue(PROPERTY_NAME propertyName, List<ItemProperty> itemPropertyList) {
        String propertyValue = null;

        if (isNotEmpty(itemPropertyList)) {
            List<ReservationProperties> resPropertiesList = itemPropertyList.get(0).getProperties();
            if (isNotEmpty(resPropertiesList)) {
                propertyValue = resPropertiesList.stream()
                        .filter( resProperty -> resProperty.getKey().equalsIgnoreCase(propertyName.name()))
                        .findFirst()
                        .map(resProperty -> isNotEmpty(resProperty.getValues())
                                ? resProperty.getValues().get(0)
                                : null)
                        .orElse(null);

            }
        }

        return propertyValue;

    }

    */
/**
     * gets the AlternateId value
     *
     * @param Id     {@link Id}
     * @param String
     * @return String
     *//*

    private String getAltIdValue(Id itemId, PROPERTY_NAME propertyName) {
        String value = null;
        if (itemId != null && isNotEmpty(itemId.getAlternateIdentifiers())) {
            value = itemId.getAlternateIdentifiers().stream()
                    .filter(altId -> altId.getType() != null && altId.getType().equalsIgnoreCase(propertyName.name()))
                    .findFirst().map(AlternateIdentifier::getValue).orElse(null);
        }

        return value;

    }

}*/
