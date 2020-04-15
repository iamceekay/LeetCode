/*
package ZanyCap;

package com.disney.wdat.api.packageorderoperation.dao.mapper.dreams;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.junit.Test;

import com.disney.wdat.api.packageorderoperation.model.ReservationProperties;
import com.disney.wdat.api.packageorderoperation.model.request.ExtendDepositDueDateRequest;
import com.disney.wdat.api.packageorderoperation.model.request.GatheringRequest;
import com.disney.wdat.api.packageorderoperation.model.request.OrderItemPropertiesRequest;
import com.disney.wdat.api.packageorderoperation.util.TestFixture;

import com.wdw.dreams.booking.transferobject.segment.UpdateItineraryRequest;

public class UpdateItineraryRequestMapperTest {

    @Test
    public void testMapTBX_Success() throws Exception {

        OrderItemPropertiesRequest orderItemPropertiesRequestModel = TestFixture.mockOrderItemPropRequestTBXModel();
        orderItemPropertiesRequestModel.setOrderId("17180619");
        orderItemPropertiesRequestModel.setIdSource("TBX_DREAMS");

        UpdateItineraryRequest updateItineraryRequest = UpdateItineraryRequestMapper.getInstance().map(orderItemPropertiesRequestModel);

        assertThat(updateItineraryRequest, notNullValue());
        assertThat(updateItineraryRequest.getExternalReferenceDetail(), notNullValue());
        assertThat(updateItineraryRequest.getExternalReferenceDetail().getExternalReferenceCode(), notNullValue());
        assertThat(updateItineraryRequest.getExternalReferenceDetail().getExternalReferenceNumber(), notNullValue());
        assertThat(updateItineraryRequest.getContactName(), notNullValue());
    }

    @Test
    public void testMapTBXNoGrpCode_Success() throws Exception {

        OrderItemPropertiesRequest orderItemPropertiesRequestModel = TestFixture.mockOrderItemPropRequestNoGrpCodeTBXModel();
        orderItemPropertiesRequestModel.setOrderId("17180619");
        orderItemPropertiesRequestModel.setIdSource("TBX_DREAMS");

        UpdateItineraryRequest updateItineraryRequest = UpdateItineraryRequestMapper.getInstance().map(orderItemPropertiesRequestModel);

        assertThat(updateItineraryRequest, notNullValue());
        assertThat(updateItineraryRequest.getExternalReferenceDetail(), notNullValue());
        assertThat(updateItineraryRequest.getExternalReferenceDetail().getExternalReferenceSource(), notNullValue());
        assertThat(updateItineraryRequest.getExternalReferenceDetail().getExternalReferenceNumber(), notNullValue());
        assertThat(updateItineraryRequest.getContactName(), notNullValue());
    }

    @Test
    public void testMapDreams_Success() throws Exception {

        OrderItemPropertiesRequest orderItemPropertiesRequestModel = TestFixture.mockOrderItemPropRequestTBXModel();
        orderItemPropertiesRequestModel.setOrderId("4444333322221111");
        orderItemPropertiesRequestModel.setIdSource("DREAMS");

        UpdateItineraryRequest updateItineraryRequest = UpdateItineraryRequestMapper.getInstance().map(orderItemPropertiesRequestModel);

        assertThat(updateItineraryRequest, notNullValue());
        assertThat(updateItineraryRequest.getTravelPlanSegmentId(), notNullValue());
        assertThat(updateItineraryRequest.getContactName(), notNullValue());
    }

    @Test
    public void testMapEmptyResPropListTBX_Success() throws Exception {

        OrderItemPropertiesRequest orderItemPropertiesRequestModel = TestFixture.mockOrderItemPropRequestTBXModel();
        orderItemPropertiesRequestModel.setOrderId("17180619");
        orderItemPropertiesRequestModel.setIdSource("TBX_DREAMS");
        orderItemPropertiesRequestModel.getItemProperties().get(0).getProperties().clear();

        UpdateItineraryRequest updateItineraryRequest = UpdateItineraryRequestMapper.getInstance().map(orderItemPropertiesRequestModel);

        assertThat(updateItineraryRequest, notNullValue());
        assertThat(updateItineraryRequest.getExternalReferenceDetail(), notNullValue());
        assertThat(updateItineraryRequest.getExternalReferenceDetail().getExternalReferenceSource(), notNullValue());
        assertThat(updateItineraryRequest.getExternalReferenceDetail().getExternalReferenceNumber(), notNullValue());
        assertNull(updateItineraryRequest.getContactName());
    }

    @Test
    public void testMapEmptyResPropListValueTBX_Success() throws Exception {

        OrderItemPropertiesRequest orderItemPropertiesRequestModel = TestFixture.mockOrderItemPropRequestTBXModel();
        orderItemPropertiesRequestModel.setOrderId("17180619");
        orderItemPropertiesRequestModel.setIdSource("TBX_DREAMS");

        List <ReservationProperties> resPropList = orderItemPropertiesRequestModel.getItemProperties().get(0).getProperties();

        resPropList.forEach(resProp -> {
            resProp.getValues().clear();
        });
//orderItemPropertiesRequestModel.getItemProperties().get(0).getProperties().get(0).getValues().clear();
//orderItemPropertiesRequestModel.getItemProperties().get(0).getProperties().get(1).getValues().clear();

        UpdateItineraryRequest updateItineraryRequest = UpdateItineraryRequestMapper.getInstance().map(orderItemPropertiesRequestModel);

        assertThat(updateItineraryRequest, notNullValue());
        assertThat(updateItineraryRequest.getExternalReferenceDetail(), notNullValue());
        assertThat(updateItineraryRequest.getExternalReferenceDetail().getExternalReferenceSource(), notNullValue());
        assertThat(updateItineraryRequest.getExternalReferenceDetail().getExternalReferenceNumber(), notNullValue());
        assertNull(updateItineraryRequest.getContactName());
    }

    @Test
    public void testMapEmptyItemPropListTBX_Success() throws Exception {

        OrderItemPropertiesRequest orderItemPropertiesRequestModel = TestFixture.mockOrderItemPropRequestTBXModel();
        orderItemPropertiesRequestModel.setOrderId("17180619");
        orderItemPropertiesRequestModel.setIdSource("TBX_DREAMS");
        orderItemPropertiesRequestModel.getItemProperties().clear();

        UpdateItineraryRequest updateItineraryRequest = UpdateItineraryRequestMapper.getInstance().map(orderItemPropertiesRequestModel);

        assertThat(updateItineraryRequest, notNullValue());
        assertThat(updateItineraryRequest.getExternalReferenceDetail(), notNullValue());
        assertThat(updateItineraryRequest.getExternalReferenceDetail().getExternalReferenceSource(), notNullValue());
        assertThat(updateItineraryRequest.getExternalReferenceDetail().getExternalReferenceNumber(), notNullValue());
        assertNull(updateItineraryRequest.getContactName());
    }

    @Test
    public void testMapDepositTBX_Success() throws Exception {

        ExtendDepositDueDateRequest extendDepositDueDateRequestModel = TestFixture.mockDepositRequestTBXModel();
        extendDepositDueDateRequestModel.setOrderId("17180619");
        extendDepositDueDateRequestModel.setIdSource("TBX_DREAMS");

        UpdateItineraryRequest updateItineraryRequest = UpdateItineraryRequestMapper.getInstance().map(extendDepositDueDateRequestModel);

        assertThat(updateItineraryRequest, notNullValue());
        assertThat(updateItineraryRequest.getDepositDateExtension(), notNullValue());
        assertThat(updateItineraryRequest.getExternalReferenceDetail(), notNullValue());
        assertThat(updateItineraryRequest.getExternalReferenceDetail().getExternalReferenceCode(), notNullValue());
        assertThat(updateItineraryRequest.getExternalReferenceDetail().getExternalReferenceNumber(), notNullValue());

    }

    @Test
    public void testMapDepositTBXNoGrpCode_Success() throws Exception {

        ExtendDepositDueDateRequest extendDepositDueDateRequestModel = TestFixture.mockDepositRequestNoGrpCodeTBXModel();
        extendDepositDueDateRequestModel.setOrderId("17180619");
        extendDepositDueDateRequestModel.setIdSource("TBX_DREAMS");

        UpdateItineraryRequest updateItineraryRequest = UpdateItineraryRequestMapper.getInstance().map(extendDepositDueDateRequestModel);

        assertThat(updateItineraryRequest, notNullValue());
        assertThat(updateItineraryRequest.getDepositDateExtension(), notNullValue());
        assertThat(updateItineraryRequest.getExternalReferenceDetail(), notNullValue());
        assertThat(updateItineraryRequest.getExternalReferenceDetail().getExternalReferenceSource(), notNullValue());
        assertThat(updateItineraryRequest.getExternalReferenceDetail().getExternalReferenceNumber(), notNullValue());

    }

    @Test
    public void testMapDepositDreams_Success() throws Exception {

        ExtendDepositDueDateRequest extendDepositDueDateRequestModel = TestFixture.mockDepositRequestTBXModel();
        extendDepositDueDateRequestModel.setOrderId("4444333322221111");
        extendDepositDueDateRequestModel.setIdSource("DREAMS");

        UpdateItineraryRequest updateItineraryRequest = UpdateItineraryRequestMapper.getInstance().map(extendDepositDueDateRequestModel);

        assertThat(updateItineraryRequest, notNullValue());
        assertThat(updateItineraryRequest.getDepositDateExtension(), notNullValue());
        assertThat(updateItineraryRequest.getTravelPlanSegmentId(), notNullValue());

    }

    @Test
    public void testMapGatheringDreams_Success() throws Exception {

        GatheringRequest gatheringRequestModel = TestFixture.mockGatheringRequestModel();
        gatheringRequestModel.setOrderId("4444333322221111");
        gatheringRequestModel.setAction("ASSOCIATE");
        gatheringRequestModel.setIdSource("DREAMS");

        UpdateItineraryRequest updateItineraryRequest = UpdateItineraryRequestMapper.getInstance().map(gatheringRequestModel);

        assertThat(updateItineraryRequest, notNullValue());
        assertThat(updateItineraryRequest.getGatheringId(), notNullValue());
        assertThat(updateItineraryRequest.getGatheringName(), notNullValue());
        assertThat(updateItineraryRequest.getGatheringType(), notNullValue());
        assertThat(updateItineraryRequest.getTravelPlanSegmentId(), notNullValue());

    }

    @Test
    public void testMapGatheringDreamsDisAssociate_Success() throws Exception {

        GatheringRequest gatheringRequestModel = TestFixture.mockGatheringRequestModel();
        gatheringRequestModel.setOrderId("4444333322221111");
        gatheringRequestModel.setAction("DISASSOCIATE");
        gatheringRequestModel.setIdSource("DREAMS");

        UpdateItineraryRequest updateItineraryRequest = UpdateItineraryRequestMapper.getInstance().map(gatheringRequestModel);

        assertThat(updateItineraryRequest, notNullValue());
        assertThat(updateItineraryRequest.getGatheringId(), notNullValue());
        assertThat(updateItineraryRequest.getGatheringName(), notNullValue());
        assertThat(updateItineraryRequest.getGatheringType(), notNullValue());
        assertThat(updateItineraryRequest.getTravelPlanSegmentId(), notNullValue());

    }

    @Test
    public void testMapGatheringTbx_Dreams_Success() throws Exception {

        GatheringRequest gatheringRequestModel = TestFixture.mockGatheringRequestModel();
        gatheringRequestModel.setOrderId("17180619");
        gatheringRequestModel.setAction("ASSOCIATE");
        gatheringRequestModel.setIdSource("TBX_DREAMS");

        UpdateItineraryRequest updateItineraryRequest = UpdateItineraryRequestMapper.getInstance().map(gatheringRequestModel);

        assertThat(updateItineraryRequest, notNullValue());
        assertThat(updateItineraryRequest.getGatheringId(), notNullValue());
        assertThat(updateItineraryRequest.getGatheringName(), notNullValue());
        assertThat(updateItineraryRequest.getGatheringType(), notNullValue());
        assertThat(updateItineraryRequest.getExternalReferenceDetail(), notNullValue());
        assertThat(updateItineraryRequest.getExternalReferenceDetail().getExternalReferenceCode(), notNullValue());
        assertThat(updateItineraryRequest.getExternalReferenceDetail().getExternalReferenceNumber(), notNullValue());

    }

    @Test
    public void testMapGatheringTbx_DreamsNoGrpCode_Success() throws Exception {

        GatheringRequest gatheringRequestModel = TestFixture.mockGatheringRequestModel();
        gatheringRequestModel.getId().getAlternateIdentifiers().clear();
        gatheringRequestModel.setOrderId("17180619");
        gatheringRequestModel.setAction("ASSOCIATE");
        gatheringRequestModel.setIdSource("TBX_DREAMS");

        UpdateItineraryRequest updateItineraryRequest = UpdateItineraryRequestMapper.getInstance().map(gatheringRequestModel);

        assertThat(updateItineraryRequest, notNullValue());
        assertThat(updateItineraryRequest.getGatheringId(), notNullValue());
        assertThat(updateItineraryRequest.getGatheringName(), notNullValue());
        assertThat(updateItineraryRequest.getGatheringType(), notNullValue());
        assertThat(updateItineraryRequest.getExternalReferenceDetail(), notNullValue());
        assertThat(updateItineraryRequest.getExternalReferenceDetail().getExternalReferenceSource(), notNullValue());
        assertThat(updateItineraryRequest.getExternalReferenceDetail().getExternalReferenceNumber(), notNullValue());

    }
*/
