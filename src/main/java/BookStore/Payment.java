package BookStore;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.PostPersist;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Entity
public class Payment {
    @Id
    @GeneratedValue
    Long id;
    String name;
    Long price;
    int qty;

    @PostPersist
    public void eventPublish(){
        PayApproved payApproved = new PayApproved();
        payApproved.setBookId(this.getId());
        payApproved.setBookName(this.getName());
        payApproved.setBookPrice(this.getPrice());
        payApproved.setTotalQty(this.getQty());
        ObjectMapper objectMapper = new ObjectMapper();
        String json = null;

        try {
            json = objectMapper.writeValueAsString(payApproved);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("JSON format exception", e);
        }
        System.out.println(json);
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public Payment(){
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
