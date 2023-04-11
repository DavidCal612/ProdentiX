package co.prodentix.pd.service.dto;

import co.prodentix.pd.domain.Enumerations.Categories;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Objects;

public class CategoryDTO implements Serializable {
    private Long id;

    @NotNull
    private Categories category;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Categories getCategory() {
        return category;
    }

    public void setCategory(Categories category) {
        this.category = category;
    }

    @Override
    public boolean equals(Object o){
        if (this == o){
            return true;
        }
        if (!(o instanceof CategoryDTO)){
            return false;
        }
        CategoryDTO categoryDTO = (CategoryDTO) o;
            if (this.id == null){
                return false;
            }
            return Objects.equals(this.id, categoryDTO.id);
    }

    @Override
    public int hashCode(){
        return Objects.hash(this.id);
    }

    @Override
    public String toString() {
        return "CategoryDTO{" +
            "id=" + getId() +
            ", category=" + getCategory() + "'" +
            '}';
    }
}
