package BookStore;

import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class PolicyHandler {

    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverPayCanceled_DeliveryCancel(@Payload DeliveryCanceled deliveryCanceled) {

        if(deliveryCanceled.isMe()){
            System.out.println("##### listener PayCancel : " + deliveryCanceled.toJson());
        }
    }

    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverPayApproved_Ship(@Payload Shipped shipped) {

        if(shipped.isMe()){
            System.out.println("##### listener PayApprove : " + shipped.toJson());
        }
    }
}