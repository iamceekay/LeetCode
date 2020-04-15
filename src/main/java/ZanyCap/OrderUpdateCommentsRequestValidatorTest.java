/*
package com.disney.wdat.api.packageorderoperation.webservice.validator;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.validation.ConstraintValidatorContext;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import com.disney.wdat.api.packageorderoperation.util.TestFixture;
import com.disney.wdat.api.packageorderoperation.webservice.resource.IdResource;
import com.disney.wdat.api.packageorderoperation.webservice.resource.UpdateCommentResource;
import com.disney.wdat.api.packageorderoperation.webservice.resource.UpdateOrderItemCommentsResource;
import com.disney.wdat.api.packageorderoperation.webservice.resource.request.OrderUpdateCommentsRequest;

public class OrderUpdateCommentsRequestValidatorTest {
    private ConstraintValidatorContext contextMock;
    private ValidOrderUpdateCommentsRequest validOrderUpdateCommentsRequest;
    OrderUpdateCommentsRequestValidator orderUpdateCommentsRequestValidator=new OrderUpdateCommentsRequestValidator();

    @Before
    public void setup() {
        contextMock = Mockito.mock(ConstraintValidatorContext.class);
        when(contextMock.buildConstraintViolationWithTemplate(anyString()))
                .thenReturn(Mockito.mock(ConstraintValidatorContext.ConstraintViolationBuilder.class));
        orderUpdateCommentsRequestValidator.initialize(validOrderUpdateCommentsRequest);
    }

    @Test
    public void test_EmptyOrderAndItemComments() throws Exception {
        OrderUpdateCommentsRequest orderCommentsRequest = TestFixture.mockOrderUpdateCommentsDreamOrderRequest();
        orderCommentsRequest.setOrderItemsComments(null);
        orderCommentsRequest.setOrderComments(null);
        assertThat(!orderUpdateCommentsRequestValidator.isValid(orderCommentsRequest, contextMock), is(equalTo(true)));
    }

    @Test
    public void test_EmptyOrder() throws Exception {
        OrderUpdateCommentsRequest orderCommentsRequest = TestFixture.mockOrderUpdateCommentsDreamOrderRequest();
        orderCommentsRequest.setOrderComments(null);
        assertThat(!orderUpdateCommentsRequestValidator.isValid(orderCommentsRequest, contextMock), is(equalTo(false)));
    }

    @Test
    public void test_AddCommentsSuccess() throws Exception {
        OrderUpdateCommentsRequest orderCommentsRequest = TestFixture.mockValidOrderUpdateCommentsRequest();
        assertThat(!orderUpdateCommentsRequestValidator.isValid(orderCommentsRequest, contextMock), is(equalTo(false)));
    }

    @Test
    public void test_EmptyOrderItemComments() throws Exception {
        OrderUpdateCommentsRequest orderCommentsRequest = TestFixture.mockOrderUpdateCommentsDreamOrderRequest();
        orderCommentsRequest.setOrderItemsComments(null);
        assertThat(!orderUpdateCommentsRequestValidator.isValid(orderCommentsRequest, contextMock), is(equalTo(true)));
    }

    @Test
    public void test_MultipleOrderItemComments() throws Exception {
        OrderUpdateCommentsRequest orderCommentsRequest = TestFixture.mockOrderUpdateCommentsDreamOrderRequest();
        UpdateOrderItemCommentsResource updateOrderItemCommentsResource = orderCommentsRequest.getOrderItemsComments().get(0);
        orderCommentsRequest.getOrderItemsComments().add(updateOrderItemCommentsResource);
        assertThat(!orderUpdateCommentsRequestValidator.isValid(orderCommentsRequest, contextMock), is(equalTo(true)));
    }

    @Test
    public void test_OrderCodedComment() throws Exception {
        OrderUpdateCommentsRequest orderCommentsRequest = TestFixture.mockOrderUpdateCommentsDreamOrderRequest();
        IdResource codedComment= new IdResource();
        codedComment.setValue("AA");
        UpdateCommentResource updateCommentResource=new UpdateCommentResource();
        updateCommentResource.setCode(codedComment);
        List<UpdateCommentResource> list=new ArrayList<>();
        list.add(updateCommentResource);
        orderCommentsRequest.setOrderComments(list);
        assertThat(orderUpdateCommentsRequestValidator.isValid(orderCommentsRequest, contextMock), is(equalTo(false)));
    }

    @Test
    public void test_EmptyOrderCodedComment() throws Exception {
        OrderUpdateCommentsRequest orderCommentsRequest = TestFixture.mockOrderUpdateCommentsDreamOrderRequest();
        UpdateCommentResource updateCommentResource=new UpdateCommentResource();
        updateCommentResource.setCode(null);
        List<UpdateCommentResource> list=new ArrayList<>();
        list.add(updateCommentResource);
        orderCommentsRequest.setOrderComments(list);
        assertThat(orderUpdateCommentsRequestValidator.isValid(orderCommentsRequest, contextMock), is(equalTo(false)));
    }

    @Test
    public void test_IsNotEmptyOrderAndEmptyItemComments() throws Exception {
        OrderUpdateCommentsRequest orderCommentsRequest = TestFixture.mockOrderUpdateCommentsDreamOrderRequest();
        orderCommentsRequest.getOrderItemsComments().get(0).getItemId().setSource(null);
        orderCommentsRequest.setOrderComments(Collections.emptyList());
        assertThat(!orderUpdateCommentsRequestValidator.isValid(orderCommentsRequest, contextMock), is(equalTo(false)));
    }

    @Test
    public void test_IsNotEmptyOrderAndEmptyItemComments() throws Exception {
        OrderUpdateCommentsRequest orderCommentsRequest = TestFixture.mockOrderUpdateCommentsDreamOrderRequest();
        orderCommentsRequest.
        orderCommentsRequest.setOrderItemsComments(Collections.emptyList());
        assertThat(!orderUpdateCommentsRequestValidator.isValid(orderCommentsRequest, contextMock), is(equalTo(false)));
    }
    public void test_IsNotEmptyOrderAndEmptyItemWithsizeOne() throws Exception {
        OrderUpdateCommentsRequest orderCommentsRequest = TestFixture.mockOrderUpdateCommentsDreamOrderRequest();
        UpdateOrderItemCommentsResource updateOrderItemCommentsResource = orderCommentsRequest.getOrderItemsComments().get(0);
        List<UpdateOrderItemCommentsResource> list=new ArrayList<>();
        list.add(updateOrderItemCommentsResource);
        orderCommentsRequest.
                orderCommentsRequest.setOrderItemsComments(list);
        assertThat(!orderUpdateCommentsRequestValidator.isValid(orderCommentsRequest, contextMock), is(equalTo(false)));
    }



}*/
