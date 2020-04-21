
package BookStore;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by uengine on 2018. 11. 21..
 */

@FeignClient(name="Delivery", url="http://localhost:8082")
public interface DeliveryService {

    @RequestMapping(method= RequestMethod.POST, path="/deliveries")
    public void deliveryRequest(@RequestBody Delivery delivery);

    @RequestMapping(method= RequestMethod.PATCH, path="/deliveries")
    public void deliveryCancel(@RequestBody Delivery delivery);
}