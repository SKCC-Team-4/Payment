package BookStore;

import java.util.Date;

public class PayCanceled extends AbstractEvent {

    private Long id;
    private Long orderId;
    private String status;
    private Date cancelDate;
    private  String stateMsg = "Payment Canceled";

    public PayCanceled(){
        super();
    }

    public PayCanceled(Payment payment){
        this();
        this.setOrderId(payment.getOrderId());
        this.setCancelDate(payment.getCancelDate());
        this.setStatus(payment.getStatus());
    }


    public Long getId() {
        return id;
    }

    public String getStateMessage() {
        return stateMsg;
    }

    public void setStateMessage(String stateMsg) {
        this.stateMsg = stateMsg;
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
    public Date getCancelDate() {
        return cancelDate;
    }

    public void setCancelDate(Date cancelDate) {
        this.cancelDate = cancelDate;
    }
}
