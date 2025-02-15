package dev.avishek.paymentservice.controlleradvice;

import com.razorpay.RazorpayException;
import dev.avishek.paymentservice.dtos.ExceptionDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(RazorpayException.class)
    public ResponseEntity<ExceptionDto> handleRazorpayException(RazorpayException e) {
        ExceptionDto exceptionDto = new ExceptionDto(e.getMessage(), "Please check the request and try again.");
        ResponseEntity<ExceptionDto> responseEntity = new ResponseEntity<>(
                exceptionDto,
                HttpStatus.ALREADY_REPORTED

        );
        return responseEntity;
    }

}
