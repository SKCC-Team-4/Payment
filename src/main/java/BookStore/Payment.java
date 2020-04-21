package BookStore;

import org.springframework.beans.BeanUtils;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="Payment_table")
public class Payment {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private Long orderId;
    private String status;
    private Date paymentDate;
    private Date cancelDate;


    @PostPersist
    public void onPostPersist() {
        PayApproved payApproved = new PayApproved();
        BeanUtils.copyProperties(this, payApproved);
        payApproved.publish();

        Delivery delivery = new Delivery();
        // mappings goes here
        delivery.setOrderId(payApproved.getOrderId());
        Application.applicationContext.getBean(DeliveryService.class)
                .deliveryRequest(delivery);

    }

    @PostUpdate
    public void onPostUpdate(){
        PayCanceled payCanceled = new PayCanceled();
        BeanUtils.copyProperties(this, payCanceled);
        payCanceled.publish();

        Delivery delivery = new Delivery();
        // mappings goes here
        delivery.setOrderId(payCanceled.getOrderId());
        Application.applicationContext.getBean(DeliveryService.class)
                .deliveryCancel(delivery);


    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    public Date getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }
    public Date getCancelDate() {
        return cancelDate;
    }

    public void setCancelDate(Date cancelDate) {
        this.cancelDate = cancelDate;
    }




}
