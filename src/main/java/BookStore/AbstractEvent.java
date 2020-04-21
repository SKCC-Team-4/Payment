package BookStore;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.util.MimeTypeUtils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class AbstractEvent {

    String eventType;
    String timestamp;

    public AbstractEvent(){
        this.setEventType(this.getClass().getSimpleName());
        SimpleDateFormat defaultSimpleDateFormat = new SimpleDateFormat("YYYYMMddHHmmss");
        this.timestamp = defaultSimpleDateFormat.format(new Date());
    }

    public String toJson(){
        ObjectMapper objectMapper = new ObjectMapper();
        String json = null;

        try {
            json = objectMapper.writeValueAsString(this);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("JSON format exception", e);
        }

        return json;
    }

    public void publish(){
        this.publish(this.toJson());
    }
    @Autowired
    PaymentRepository paymentRepository;
    public void publish(String json){
        if( json != null ){

            /**
             * spring streams 방식
             */
            KafkaProcessor processor = Application.applicationContext.getBean(KafkaProcessor.class);
            MessageChannel outputChannel = processor.outboundTopic();

            outputChannel.send(MessageBuilder
                    .withPayload(json)
                    .setHeader(MessageHeaders.CONTENT_TYPE, MimeTypeUtils.APPLICATION_JSON)
                    .build());


/*
            System.out.println("111111111111111111111111111111111111111111111111111111111");
            if(payApproved.getEventType().equals("PayApproved")) {
                System.out.println("=======================================================================");
                ZoneId defaultZoneId = ZoneId.systemDefault();
                LocalDate localDate = LocalDate.of(LocalDate.now().getYear(), LocalDate.now().getMonth(), LocalDate.now().getDayOfMonth());
                Date date = Date.from(localDate.atStartOfDay(defaultZoneId).toInstant());

                System.out.println("결제 요청");
                Payment p =new Payment();
                p.setStatus("Payment Request");
                p.setPaymentDate(date);
                paymentRepository.save(p);
                System.out.println("========================================================================");
            }

 */

        }


    }


    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public boolean isMe(){
        return getEventType().equals(getClass().getSimpleName());
    }
}
