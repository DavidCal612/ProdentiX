package co.prodentix.pd.domain;
import co.prodentix.pd.domain.Enumerations.OrderStatus;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name="prodentix_order")
public class Order implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    @Column(name = "id")
    private Long id;

    @NotNull
    @Column(name = "date", nullable = false)
    private Long date;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private OrderStatus status;

    @NotNull
    @Size(max = 25)
    @Column(name = "total", length = 100, nullable = false)
    private String total;

    @OneToMany(mappedBy = "order")
    @JsonIgnoreProperties(value = {"order", "product"}, allowSetters = true)
    private Set<OrderDetails> orderDetails = new HashSet<>();

    @ManyToOne(optional = false)
    @NotNull
    @JsonIgnoreProperties(value = {"user", "order","documentType"}, allowSetters = true)
    private Patients patients;

    public Long getId() {
        return id;
    }

    public  Order id(Long id){
        this.setId(id);
        return this;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public Long getDate() {
        return date;
    }

    public Order date(LocalDate date){
        this.setDate(date);
        return this;

    }
    public void setDate(Long date) {
        this.date = date;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public Order status(OrderStatus status){
        this.setStatus(status);
        return this;
    }
    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public String getTotal() {
        return total;
    }

    public Order total(String total){
        this.setTotal(total);
        return this;
    }
    public void setTotal(String total) {
        this.total = total;
    }

    public Set<OrderDetails> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(Set<OrderDetails> orderDetails) {
        if (this.orderDetails != null){
            this.orderDetails.forEach(i -> i.setOrder(null));
        }
        if (orderDetails != null){
            orderDetails.forEach(i -> i.setOrder(this));
        }
        this.orderDetails = orderDetails;
    }

    public Order orderdetails(Set<OrderDetails> orderDetails){
        this.setOrderDetails(orderDetails);
        return this;
    }

    public Order addOrderDetails(OrderDetails orderDetails){
        this.orderDetails.add(orderDetails);
        orderDetails.setOrder(this);
        return this;
    }

    public Order removeOrderDetails(OrderDetails orderDetails){
        this.orderDetails.remove(orderDetails);
        orderDetails.setOrder(null);
        return this;
    }

    public Patients getPatients() {
        return patients;
    }

    public void setPatients(Patients patients) {
        this.patients = patients;
    }

    public Order patients(Patients patients){
        this.setPatients(patients);
        return this;
    }

    @Override
    public boolean equals(Object o){
        if (this == o){
            return true;
        }
        if (!(o instanceof Order)){
            return false;
        }
        return id != null && id.equals(((Order)o).id);
    }

    @Override
    public int hashCode(){
        return getClass().hashCode();
    }
    @Override
    public String toString() {
        return "Order{" +
            "id=" + getId() +
            ", date=" + getDate() +
            ", status=" + getStatus() +
            ", total='" + getTotal() + '\'' +
            '}';
    }
}
