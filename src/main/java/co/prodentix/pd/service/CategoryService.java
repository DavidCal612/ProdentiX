package co.prodentix.pd.service;

import co.prodentix.pd.service.dto.CategoryDTO;

public interface CategoryService {
    /**
     *  Save a category
     *
     * @param categoryDTO the entity to save.
     * @return the persisted entity
     */

    CategoryDTO save(CategoryDTO categoryDTO);

    /**
     * Updates a category
     *
     */
}
