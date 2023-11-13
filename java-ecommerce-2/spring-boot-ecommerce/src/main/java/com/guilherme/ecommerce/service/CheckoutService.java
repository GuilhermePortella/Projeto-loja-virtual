package com.guilherme.ecommerce.service;

import com.guilherme.ecommerce.dto.PaymentInfo;
import com.guilherme.ecommerce.dto.Purchase;
import com.guilherme.ecommerce.dto.PurchaseResponse;
import com.stripe.exception.StripeException;
import com.stripe.model.PaymentIntent;

public interface CheckoutService {

    PurchaseResponse placeOrder(Purchase purchase);

    PaymentIntent createPaymentIntent(PaymentInfo paymentInfo) throws StripeException;
}
