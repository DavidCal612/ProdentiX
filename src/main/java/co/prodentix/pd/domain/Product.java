package co.prodentix.pd.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "product")
public class Product implements Serializable {
    private static final long serialVersionUID = 1l;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    @Column(name = "id")
    private Long id;

    @NotNull
    @Size(max = 25)
    @Column(name = "name", length = 100, nullable = false)
    private String name;
    @NotNull
    @Size(max = 100)
    @Column(name = "reference_product", length = 100, nullable = false, unique = true)
    private String referenceProduct;

    @OneToMany(mappedBy = "product")
    @JsonIgnoreProperties(value = {"order", "product"}, allowSetters = true)
    private Set<OrderDetails> orderDetails = new HashSet<>();

    @ManyToOne
    @JsonIgnoreProperties(value = {"products"}, allowSetters = true)
    private Category category;

    public Long getId() {
        return this.id;
    }

    public Product id(Long id){
        this.setId(id);
        return this;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public Product name(String name){
        this.setName(name);
        return this;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getReferenceProduct() {
        return this.referenceProduct;
    }

    public Product referenceProduct(String referenceProduct){
        this.setReferenceProduct(referenceProduct);
        return this;
    }
    public void setReferenceProduct(String referenceProduct) {
        this.referenceProduct = referenceProduct;
    }

    public Set<OrderDetails> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(Set<OrderDetails> orderDetails) {
        if (this.orderDetails != null){
            this.orderDetails.forEach(i-> i.setProduct(null));
        }
        if (orderDetails != null){
            orderDetails.forEach(i-> i.setProduct(this));
        }
        this.orderDetails = orderDetails;
    }

    public Product addOrderDetails(OrderDetails orderDetails){
        this.orderDetails.add(orderDetails);
        orderDetails.setProduct(this);
        return this;
    }

    public Product removeOrderdetails(OrderDetails orderDetails){
        this.orderDetails.remove(orderDetails);
        orderDetails.setProduct(null);
        return this;
    }
    public Category getCategory() {
        return this.category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Product category(Category category){
        this.setCategory(category);
        return this;
    }

    @Override
    public boolean equals(Object o){
        if (this == o){
            return true;
        }
        if (!(o instanceof Product)){
            return false;
        }
        return id != null && id.equals(((Product)o).id);
    }

    @Override
    public int hashCode(){
        return getClass().hashCode();
    }

    @Override
    public String toString() {
        return "Product{" +
            "id=" + getId() +
            ", name='" + getName() + '\'' +
            ", referenceProduct='" + getReferenceProduct() + '\'' +
            '}';
    }
}
