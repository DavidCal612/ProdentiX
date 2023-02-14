package co.prodentix.pd.domain.Enumerations;


/**
 *  StateDocument Enumeration
 */
public enum StateDocument {
    ACTIVE("Activo"),
    INACTIVE("Inactivo");

    private final String value;

    StateDocument(String value){
        this.value = value;
    }

    private String getValue(){
        return value;
    }
}
