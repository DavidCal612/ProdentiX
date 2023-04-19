package co.prodentix.pd.service.mapper;

import co.prodentix.pd.domain.DocumentType;
import co.prodentix.pd.service.dto.DocumentTypeDTO;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface DocumentTypeMapper extends EntityMapper<DocumentTypeDTO, DocumentType> {
}
