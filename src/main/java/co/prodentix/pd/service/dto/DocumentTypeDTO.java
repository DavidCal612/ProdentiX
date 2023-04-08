package co.prodentix.pd.service.dto;

import co.prodentix.pd.domain.Enumerations.StateDocument;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the {@link co.prodentix.pd.domain.DocumentType} entity
 */
public class DocumentTypeDTO implements Serializable {
    private Long id;
    @NotNull
    @Size(max = 10)
    private String initials;

    @NotNull
    @Size(max = 15)
    private String documentName;

    @NotNull
    private StateDocument status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getInitials() {
        return initials;
    }

    public void setInitials(String initials) {
        this.initials = initials;
    }

    public String getDocumentName() {
        return documentName;
    }

    public void setDocumentName(String documentName) {
        this.documentName = documentName;
    }

    public StateDocument getStatus() {
        return status;
    }

    public void setStatus(StateDocument status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o){
        if (this == o){
            return true;
        }
        if (!(o instanceof DocumentTypeDTO)){
            return false;
        }

        DocumentTypeDTO documentTypeDTO = (DocumentTypeDTO) o;
        if (this.id == null){
            return false;
        }
        return Objects.equals(this.id, documentTypeDTO.id);
    }

    @Override
    public int hashCode(){
        return Objects.hash(this.id);
    }

    //pettier-ignore

    @Override
    public String toString() {
        return "DocumentTypeDTO{" +
            "id=" + getId() +
            ", initials='" + getInitials() + '\'' +
            ", documentName='" + getDocumentName() + '\'' +
            ", status=" + getStatus() + "'" +
            '}';
    }
}
