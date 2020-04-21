package BookStore;

public class PayApproved extends AbstractEvent {

    private Long id;

    public PayApproved(){
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
