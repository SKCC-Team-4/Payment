package BookStore;


import java.util.Date;

public class PayApproved extends AbstractEvent {

    private Long id;
    private Long orderId;
    private String status;
    private Date paymentDate;
    private String stateMsg = "Payment Request";

    public PayApproved(){
        super();
    }

    public PayApproved(Payment payment){
        this();
        this.setOrderId(payment.getOrderId());
        this.setPaymentDate(payment.getPaymentDate());
        this.setStatus(payment.getStatus());
    }

    public String getStateMessage() {
        return stateMsg;
    }

    public void setStateMessage(String stateMsg) {
        this.stateMsg = stateMsg;
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
}
