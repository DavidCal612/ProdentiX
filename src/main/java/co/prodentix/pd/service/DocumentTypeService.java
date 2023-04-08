package co.prodentix.pd.service;

import co.prodentix.pd.service.dto.DocumentTypeDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;


/**
 * Service Interface for maninig {@link co.prodentix.pd.domain.DocumentType}
 */
public interface DocumentTypeService {
    /**
     * Save a documentType
     *
     * @param documentTypeDTO the entity to save.
     * @return the persisted entity
     */
    DocumentTypeDTO save(DocumentTypeDTO documentTypeDTO);

    /**
     * Updates a documentType
     *
     * @param documentTypeDTO the entity to update.
     * @return the persisted entity.
     */

    DocumentTypeDTO update(DocumentTypeDTO documentTypeDTO);
    /**
     * Partially updates a documentType
     *
     * @param documentTypeDTO the entity to update partially
     * @return the persisted entity
     */

    Optional<DocumentTypeDTO> partialUpdate(DocumentTypeDTO documentTypeDTO);
    /**
     * Get all the documentTypes.
     *
     * @param pageable the pagination information.
     * @return the list of entities
     */

    Page<DocumentTypeDTO> findAll(Pageable pageable);
    /**
     * Get the "id" documentType
     *
     * @param id the id of the entity
     * @return the entity
     */

    Optional<DocumentTypeDTO> findOne(Long id);

    /**
     * Delete the "id" documentType.
     *
     * @pram id the id of the entity
     */

    void delete(Long id);
}
