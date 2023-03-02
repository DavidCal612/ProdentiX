package co.prodentix.pd.domain;


import co.prodentix.pd.domain.Enumerations.StateDocument;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "document_type")
public class DocumentType implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    @Column(name = "id")
    private Long id;

    @NotNull
    @Size(max = 10)
    @Column(name = "initials", length = 10, nullable = false, unique = true)
    private String initials;


    @NotNull
    @Size(max = 20)
    @Column(name = "document_name", length = 20, nullable = false,unique = true)
    private String documentName;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private StateDocument status;

    @OneToMany(mappedBy = "documentType")
    @JsonIgnoreProperties(value = {"user", "orders", "documentType"}, allowSetters = true)
    private Set<Patients> patients = new HashSet<>();

    public Long getId() {
        return this.id;
    }

    public DocumentType id(Long id){
        this.setId(id);
        return this;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getInitials() {
        return this.initials;
    }

    public DocumentType initials(String initials){
        this.setInitials(initials);
        return this;
    }
    public void setInitials(String initials) {
        this.initials = initials;
    }

    public String getDocumentName() {
        return this.documentName;
    }


    public DocumentType documentName(String documentName){
        this.setDocumentName(documentName);
        return this;
    }

    public void setDocumentName(String documentName) {
        this.documentName = documentName;
    }

    public StateDocument getStatus() {
        return status;
    }

    public DocumentType status(StateDocument status){
        this.setStatus(status);
        return this;
    }
    public void setStatus(StateDocument status) {
        this.status = status;
    }

    public Set<Patients> getPatients() {
        return patients;
    }

    public void setPatients(Set<Patients> patients) {
        if ((this.patients != null)) {
            this.patients.forEach(i -> i.setDocumentType(null));
        }
        if (patients != null){
            patients.forEach(i -> i.setDocumentType(this));
        }
        this.patients = patients;
    }

    public DocumentType patients(Set<Patients> patients){
        this.setPatients(patients);
        return this;
    }

    public DocumentType addPatients(Patients patients){
        this.patients.add(patients);
        patients.setDocumentType(this);
        return this;
    }

    public DocumentType removePatients(Patients patients){
        this.patients.remove(patients);
        patients.setDocumentType(null);
        return this;
    }

    @Override
    public boolean equals(Object o){
        if (this == o){
            return true;
        }
        if (!(o instanceof DocumentType)){
            return false;
        }
        return id != null && id.equals(((DocumentType)o).id);
    }

    @Override
    public int hashCode(){
        return getClass().hashCode();
    }

    @Override
    public String toString() {
        return "DocumentType{" +
            "id=" + id +
            ", initials='" + initials + '\'' +
            ", documentName='" + documentName + '\'' +
            ", status=" + status +
            ", patients=" + patients +
            '}';
    }
}
