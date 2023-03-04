package co.prodentix.pd.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "order_details")
public class OrderDetails implements Serializable {
    private static final long serialVersionUID = 1l;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    @Column(name = "id")
    private Long id;

    @NotNull
    @Size(max = 50)
    @Column(name = "price", length = 50, nullable = false)
    private String price;

    @NotNull
    @Column(name = "amount", nullable = false)
    private Long amount;

    @ManyToOne
    @JsonIgnoreProperties(value = {"orderDetails", "client"}, allowSetters = true)
    private Order order;

    @ManyToOne(optional = false)
    @NotNull
    @JsonIgnoreProperties(value = {"orderDetails", "category"}, allowSetters = true)
    private Product product;

    public Long getId() {
        return this.id;
    }

    public OrderDetails id(Long id){
        this.setId(id);
        return this;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPrice() {
        return this.price;
    }

    public OrderDetails price(String price){
        this.setPrice(price);
        return this;
    }
    public void setPrice(String price) {
        this.price = price;
    }

    public Long getAmount() {
        return this.amount;
    }

    public OrderDetails amount(Long amount){
        this.setAmount(amount);
        return this;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public Order getOrder() {
        return this.order;
    }

    public OrderDetails order(Order order){
        this.setOrder(order);
        return this;
    }
    public void setOrder(Order order) {
        this.order = order;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public OrderDetails product(Product product){
        this.setProduct(product);
        return this;
    }

    @Override
    public boolean equals(Object o){
        if (this == o){
            return true;
        }
        if (!(o instanceof OrderDetails)){
            return false;
        }
        return id != null && id.equals(((OrderDetails)o).id);
    }

    @Override
    public int hashCode(){
        return getOrder().hashCode();
    }

    // prettier-ignore

    @Override
    public String toString() {
        return "OrderDetails{" +
            "id=" + id +
            ", price='" + price + '\'' +
            ", amount=" + amount +
            ", order=" + order +
            ", product=" + product +
            '}';
    }
}
