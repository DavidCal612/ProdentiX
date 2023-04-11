package co.prodentix.pd.service.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Objects;

public class ProductDTO implements Serializable {
    private Long id;
    @NotNull
    @Size(max = 100)
    private String name;

    @NotNull
    @Size(max = 100)
    private String  referenceProduct;

    private CategoryDTO category;

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

    public String getReferenceProduct() {
        return referenceProduct;
    }

    public void setReferenceProduct(String referenceProduct) {
        this.referenceProduct = referenceProduct;
    }

    public CategoryDTO getCategory() {
        return category;
    }

    public void setCategory(CategoryDTO category) {
        this.category = category;
    }

    @Override
    public boolean equals(Object o){
        if (this == o){
            return true;
        }
        if (!(o instanceof ProductDTO)){
            return false;
        }
        ProductDTO productDTO = (ProductDTO) o;
        if (this.id == null){
            return false;
        }

        return Objects.equals(this.id, productDTO.id);

    }

    @Override
    public int hashCode(){
        return Objects.hash(this.id);
    }

    // prettier-ignore

    @Override
    public String toString() {
        return "ProductDTO{" +
            "id=" + getId() +
            ", name='" + getName() + '\'' +
            ", referenceProduct='" + getReferenceProduct() + '\'' +
            ", category=" + getCategory() +
            '}';
    }
}
