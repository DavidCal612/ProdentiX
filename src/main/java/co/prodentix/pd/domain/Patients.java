package co.prodentix.pd.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

import co.prodentix.pd.domain.Enumerations.Sex;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.mapstruct.ap.internal.model.GeneratedType;

@Entity
@Table(name= "patients")
public class Patients implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    @Column(name = "id")
    private Long id;

    @NotNull
    @Size(max = 200)
    @Column(name = "address", length = 200, nullable = false)
    private String address;

    @NotNull
    @Size(max = 25)
    @Column(name = "phone_number", length = 25, nullable = false)
    private  String phoneNumber;

    @NotNull
    @Size(max = 15)
    @Column(name = "first_name", length = 15, nullable = false)
    private String firstName;


    @NotNull
    @Size(max = 15)
    @Column(name = "second_name", length = 15, nullable = false)
    private String secondName;

    @NotNull
    @Size(max = 10)
    @Column(name = "last_name", length = 10, nullable = false)
    private String lastName;

    @NotNull
    @Size(max = 10)
    @Column(name = "second_last_name", length = 10, nullable = false)
    private String secondLastName;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "sex_type", nullable = false)
    private Sex sexType;


    @NotNull
    @Size(max = 50)
    @Column(name = "email", length = 50, nullable = false)
    private String email;

    @NotNull
    @Size(max = 100)
    @Column(name = "document_number", length = 100, nullable = false)
    private String documentNumber;

    @OneToOne(optional = false)
    @NotNull
    @JoinColumn(unique = true)
    private User user;

    @OneToMany(mappedBy = "patients")
    @JsonIgnoreProperties(value = {"orderDetails", "patients"}, allowSetters = true)
    private Set<Order> orders = new HashSet<>();

    @ManyToOne(optional = false)
    @NotNull
    @JsonIgnoreProperties(value = {"patients"}, allowGetters = true)
    private DocumentType documentType;

    public Long getId() {
        return this.id;
    }
    public Patients id(Long id){
        this.setId(id);
        return this;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAddress() {
        return this.address;
    }

    public Patients address(String address){
        this.setAddress(address);
        return this;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public Patients phoneNumber(String phoneNumber){
        this.setPhoneNumber(phoneNumber);
        return this;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public Patients firstName(String firstName){
        this.setFirstName(firstName);
        return this;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public Patients secondName(String secondName){
        this.setSecondName(secondName);
        return this;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getLastName() {
        return lastName;
    }

    public Patients lastName(String lastName){
        this.setLastName(lastName);
        return this;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getSecondLastName() {
        return secondLastName;
    }

    public Patients secondLastname(String secondLastName){
        this.setSecondName(secondLastName);
        return this;
    }

    public void setSecondLastName(String secondLastName) {
        this.secondLastName = secondLastName;
    }

    public Sex getSexType() {

        return this.sexType;
    }

    public Patients sexType(Sex sexType){
        this.setSexType(sexType);
        return this;
    }
    public void setSexType(Sex sexType) {

        this.sexType = sexType;
    }

    public String getEmail() {
        return this.email;
    }

    public Patients email(String email){
        this.setEmail(email);
        return this;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public String getDocumentNumber() {
        return documentNumber;
    }

    public Patients documentNumber(String documentNumber){
        this.setDocumentNumber(documentNumber);
        return this;
    }

    public void setDocumentNumber(String documentNumber) {
        this.documentNumber = documentNumber;
    }

    public User getUser() {
        return user;
    }

    public Patients user(User user){
        this.setUser(user);
        return this;
    }
    public void setUser(User user) {
        this.user = user;
    }

    public Set<Order> getOrders() {
        return this.orders;
    }

    public void setOrders(Set<Order> orders) {
        if (this.orders != null){
            this.orders.forEach(i -> i.setPatients(null));
        }
        if (orders != null){
            orders.forEach(i -> i.setPatients(this));
        }
        this.orders = orders;
    }

    public Patients orders(Set<Order> orders){
        this.setOrders(orders);
        return this;
    }

    public Patients addOrder(Order order){
        this.orders.add(order);
        order.setPatients(this);
        return this;
    }

    public Patients removeOrder(Order order){
        this.orders.remove(order);
        order.setPatients(null);
        return this;
    }

    public DocumentType getDocumentType() {
        return documentType;
    }

    public void setDocumentType(DocumentType documentType) {
        this.documentType = documentType;
    }

    public Patients documentType(DocumentType documentType){
        this.setDocumentType(documentType);
        return this;
    }

    @Override
    public boolean equals(Object o){
        if (this == o){
            return true;
        }
        if (!(o instanceof Patients)){
            return false;
        }
        return id != null && id.equals(((Patients)o).id);
    }

    @Override
    public int hashCode(){
        return getClass().hashCode();
    }

    @Override
    public String toString() {
        return "Patients{" +
                "id=" + id +
                ", address='" + address + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", secondLastName='" + secondLastName + '\'' +
                ", sexType='" + sexType + '\'' +
                ", email='" + email + '\'' +
                ", documentNumber='" + documentNumber + '\'' +
                ", user=" + user +
                ", orders=" + orders +
                ", documentType=" + documentType +
                '}';
    }
}
