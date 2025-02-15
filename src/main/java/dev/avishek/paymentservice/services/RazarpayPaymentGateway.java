package dev.avishek.paymentservice.services;

import com.razorpay.PaymentLink;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;
import dev.avishek.paymentservice.dtos.OrderDto;
import dev.avishek.paymentservice.dtos.ProductDto;
import dev.avishek.paymentservice.dtos.UserDto;
import org.json.JSONObject;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Primary
public class RazarpayPaymentGateway implements PaymentService {
    private RazorpayClient razorpayClient;
    private OrderService orderService;
    private static final Long EXPIRATION_TIME = (System.currentTimeMillis() / 1000) + 960;
    private static final String CALLBACK_URL = "https://example-callback-url.com/";

    public RazarpayPaymentGateway(RazorpayClient razorpayClient, OrderService orderService) {
        this.razorpayClient = razorpayClient;
        this.orderService = orderService;
    }
    public String generatePaymentLink(Long orderId) throws RazorpayException {

        /*
            Review this whole code once user service will be implemented
            data = OrderService.getOrderDetains(orderId);
        */
        JSONObject paymentLinkRequest = new JSONObject();

        // Get these details from the order service
        OrderDto orderDto = orderService.getOrderDetails(orderId);
        ProductDto productDetails = orderDto.getProductDetails();
        Long orderAmount = (Long)Math.round(productDetails.getPrice());
        paymentLinkRequest.put("amount", orderAmount * 100);
        paymentLinkRequest.put("currency","INR");
        paymentLinkRequest.put("expire_by", EXPIRATION_TIME);

        paymentLinkRequest.put("reference_id", orderId.toString());
        paymentLinkRequest.put("description","Payment for " + productDetails.getTitle());

        JSONObject customer = new JSONObject();
        UserDto userDetail = orderDto.getUserDetails();
        customer.put("name", userDetail.getName());
        customer.put("contact",userDetail.getPhone());
        customer.put("email",userDetail.getEmail());
        paymentLinkRequest.put("customer",customer);

        JSONObject notify = new JSONObject();
        notify.put("sms",true);
        notify.put("email",true);
        paymentLinkRequest.put("notify",notify);
        paymentLinkRequest.put("reminder_enable",true);
        JSONObject notes = new JSONObject();
        notes.put("policy_name","Testing Razorpay Payment Gateway");
        paymentLinkRequest.put("notes",notes);
        paymentLinkRequest.put("callback_url", CALLBACK_URL);
        paymentLinkRequest.put("callback_method","get");

        PaymentLink payment = razorpayClient.paymentLink.create(paymentLinkRequest);

        return payment.toString();
    }
}
