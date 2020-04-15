/*
package ZanyCap;

package com.disney.wdat.api.packageorderoperation.webservice.validator;

import static org.apache.commons.collections.CollectionUtils.isEmpty;
import static org.apache.commons.collections.CollectionUtils.isNotEmpty;

import java.util.concurrent.atomic.AtomicInteger;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.disney.wdat.api.packageorderoperation.webservice.resource.request.OrderUpdateCommentsRequest;

*/
/**
 * This class validates order and item comments in OrderUpdateCommentsRequest
 * {@link OrderUpdateCommentsRequest}
 *
 * @author leksh001
 *
 *//*

public class OrderUpdateCommentsRequestValidator
        implements ConstraintValidator<ValidOrderUpdateCommentsRequest, OrderUpdateCommentsRequest> {

    */
/**
     * Initializes the validator in preparation for
     * {@link #isValid(Object, ConstraintValidatorContext)} calls.
     *
     * @param constraintAnnotation annotation instance for a given constraint
     *                             declaration
     *//*

    @Override
    public void initialize(ValidOrderUpdateCommentsRequest constraintAnnotation) {
    }

    */
/**
     * Implements the validation logic. The state of {@code value} must not be
     * altered.
     *
     * @param orderUpdateCommentsRequest -{@link OrderUpdateCommentsRequest}
     * @param context              context in which the constraint is evaluated
     * @return {@code false} if {@code value} does not pass the constraint
     *//*

    @Override
    public boolean isValid(OrderUpdateCommentsRequest orderUpdateCommentsRequest, ConstraintValidatorContext context) {
        AtomicInteger violations = new AtomicInteger();
        if (isEmpty(orderUpdateCommentsRequest.getOrderComments()) && isEmpty(orderUpdateCommentsRequest.getOrderItemsComments())) {
            context.buildConstraintViolationWithTemplate(
                    "Both orderComments and orderItemsComments cannot be empty or null.").addConstraintViolation();
            violations.incrementAndGet();
        } else if (isNotEmpty(orderUpdateCommentsRequest.getOrderItemsComments())
                && orderUpdateCommentsRequest.getOrderItemsComments().size() > 1) {
            context.buildConstraintViolationWithTemplate("Multiple orderItemsComments are not allowed.")
                    .addConstraintViolation();
            violations.incrementAndGet();
        }

        if (isNotEmpty(orderUpdateCommentsRequest.getOrderComments()) && isNotEmpty(orderUpdateCommentsRequest.getOrderItemsComments())) {
            context.buildConstraintViolationWithTemplate(
                    "Both orderComments and orderItemsComments are not allowed for Update").addConstraintViolation();
            violations.incrementAndGet();
        }
        if (isNotEmpty(orderUpdateCommentsRequest.getOrderComments())) {
            orderUpdateCommentsRequest.getOrderComments().forEach(orderComment -> {
                if (null != orderComment.getCode()) {
                    context.buildConstraintViolationWithTemplate("Update Comments at order Level is not Valid")
                            .addConstraintViolation();
                    violations.incrementAndGet();
                }
            });
        }
        return violations.get() == 0;
    }
}
*/
