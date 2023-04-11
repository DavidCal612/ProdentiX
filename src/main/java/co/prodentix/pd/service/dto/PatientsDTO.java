package co.prodentix.pd.service.dto;

import co.prodentix.pd.domain.Enumerations.Sex;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Objects;

public class PatientsDTO implements Serializable {
    private Long id;
    @NotNull
    @Size(max = 200)
    private String address;

    @NotNull
    @Size(max = 20)
    private String phoneNumber;

    @NotNull
    @Size(max = 25)
    private String firstName;

    @NotNull
    @Size(max = 25)
    private String SecondName;

    @NotNull
    @Size(max = 25)
    private String lastName;

    @NotNull
    @Size(max = 25)
    private String secondLastName;
    @NotNull
    private Sex sexType;

    @NotNull
    @Size(max = 15)
    private String email;

    @NotNull
    @Size(max = 15)
    private String documentNumber;

    private UserDTO user;
    private DocumentTypeDTO documentType;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return SecondName;
    }

    public void setSecondName(String secondName) {
        SecondName = secondName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getSecondLastName() {
        return secondLastName;
    }

    public void setSecondLastName(String secondLastName) {
        this.secondLastName = secondLastName;
    }

    public Sex getSexType() {
        return sexType;
    }

    public void setSexType(Sex sexType) {
        this.sexType = sexType;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDocumentNumber() {
        return documentNumber;
    }

    public void setDocumentNumber(String documentNumber) {
        this.documentNumber = documentNumber;
    }

    public UserDTO getUser() {
        return user;
    }

    public void setUser(UserDTO user) {
        this.user = user;
    }

    public DocumentTypeDTO getDocumentType() {
        return documentType;
    }

    public void setDocumentType(DocumentTypeDTO documentType) {
        this.documentType = documentType;
    }

    @Override
    public boolean equals(Object o){
        if (this == o){
            return true;
        }
        if (!(o instanceof PatientsDTO)) {
            return false;
        }
        PatientsDTO patientsDTO = (PatientsDTO) o;
        if (this.id == null){
            return false;
        }
        return Objects.equals(this.id, patientsDTO.id);

    }

    @Override
    public int hashCode(){
        return Objects.hash(this.id);
    }

    @Override
    public String toString() {
        return "PatientsDTO{" +
            "id=" + getId() +
            ", address='" + getAddress() + "'" +
            ", phoneNumber='" + getPhoneNumber() + "'" +
            ", firstName='" + getFirstName() + "'"  +
            ", SecondName='" + getSecondName() + "'" +
            ", lastName='" + getLastName() + '\'' +
            ", secondLastName='" + getSecondLastName() + "'" +
            ", sexType=" + getSexType() + "'" +
            ", email='" + getEmail() + "'" +
            ", documentNumber='" + getDocumentNumber() + "'" +
            ", user=" + getUser() +
            ", documentType=" + getDocumentType() +
            '}';
    }
}
