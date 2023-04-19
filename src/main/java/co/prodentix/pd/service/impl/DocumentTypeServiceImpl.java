package co.prodentix.pd.service.impl;

import co.prodentix.pd.domain.DocumentType;
import co.prodentix.pd.repository.DocumentTypeRepository;
import co.prodentix.pd.service.DocumentTypeService;
import co.prodentix.pd.service.dto.DocumentTypeDTO;
import co.prodentix.pd.service.mapper.DocumentTypeMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class DocumentTypeServiceImpl implements DocumentTypeService {
    private final Logger log = LoggerFactory.getLogger(DocumentTypeServiceImpl.class);
    private final DocumentTypeRepository documentTypeRepository;
    private final DocumentTypeMapper documentTypeMapper;

    public DocumentTypeServiceImpl(DocumentTypeRepository documentTypeRepository, DocumentTypeMapper documentTypeMapper){
        this.documentTypeRepository = documentTypeRepository;
        this.documentTypeMapper = documentTypeMapper;
    }

    @Override
    public DocumentTypeDTO save(DocumentTypeDTO documentTypeDTO){
        log.debug("Request to save DocumentType: {}", documentTypeDTO);

        DocumentType documentType = documentTypeMapper.toEntity(documentTypeDTO);
        documentType = documentTypeRepository.save(documentType);
        return documentTypeMapper.toDto(documentType);
    }

    @Override
    public DocumentTypeDTO update(DocumentTypeDTO documentTypeDTO){
        log.debug("Request to save DocumentType: {}", documentTypeDTO);
        DocumentType documentType = documentTypeMapper.toEntity(documentTypeDTO);
        documentType = documentTypeRepository.save(documentType);
        return documentTypeMapper.toDto(documentType);
    }

    @Override
    public Optional<DocumentTypeDTO> partialUpdate(DocumentTypeDTO documentTypeDTO){
        log.debug("Request to partially update DocumentType: {}", documentTypeDTO);
        return documentTypeRepository.findById(documentTypeDTO.getId())
            .map(existingDocumentType -> {
                documentTypeMapper.partialUpdate(existingDocumentType, documentTypeDTO);
                return existingDocumentType;
            })
            .map(documentTypeRepository::save)
            .map(documentTypeMapper::toDto);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<DocumentTypeDTO> findAll(Pageable pageable){
        log.debug("Request to get all DocumentTypes");
        return documentTypeRepository.findAll(pageable).map(documentTypeMapper::toDto);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<DocumentTypeDTO> findOne(Long id){
        log.debug("Request to get DocumentType: {}", id);
        return documentTypeRepository.findById(id).map(documentTypeMapper::toDto);
    }
    @Override
    public void delete(Long id){
        log.debug("Request to delete DocumentType: {}", id);
        documentTypeRepository.deleteById(id);
    }



}
