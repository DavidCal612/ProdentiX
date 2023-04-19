package co.prodentix.pd.service.dto;

import co.prodentix.pd.domain.Enumerations.OrderStatus;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

public class OrderDTO implements Serializable {
    private Long id;

    @NotNull
    private LocalDate date;

    @NotNull
    private OrderStatus status;

    @NotNull
    @Size(max = 100)
    private String total;

    private PatientsDTO patients;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public PatientsDTO getPatients() {
        return patients;
    }

    public void setPatients(PatientsDTO patients) {
        this.patients = patients;
    }

    @Override
    public boolean equals(Object o){
        if (this == o){
            return false;
        }
        if (!(o instanceof OrderDTO)){
            return false;
        }
        OrderDTO orderDTO = (OrderDTO) o;
        if (this.id == null){
            return false;
        }
        return Objects.equals(this.id, orderDTO.id);
    }

    @Override
    public int hashCode(){
        return Objects.hash(this.id);
    }

    // prettier-ignore


    @Override
    public String toString() {
        return "OrderDTO{" +
            "id=" + getId() +
            ", date=" + getDate() +
            ", status=" + getStatus() +
            ", total='" + getTotal() + '\'' +
            ", patients=" + getPatients() +
            '}';
    }
}


