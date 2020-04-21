package BookStore;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

 @RestController
 public class PaymentController {

@RequestMapping(value = "/Payment",
        method = RequestMethod.POST,
        produces = "application/json;charset=UTF-8")

public void payRequest(HttpServletRequest request, HttpServletResponse response)
        throws Exception {
        System.out.println("##### /payment/payRequest  called #####11111111111111111111111111111111111111111111111111111111111");
        }

@RequestMapping(value = "/Payment",
        method = RequestMethod.PATCH,
        produces = "application/json;charset=UTF-8")

public void payCancel(HttpServletRequest request, HttpServletResponse response)
        throws Exception {
        System.out.println("##### /payment/payCancel  called #####2222222222222222222222222222222222222222222");
        }
 }
