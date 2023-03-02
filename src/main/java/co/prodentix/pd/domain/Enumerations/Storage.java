package co.prodentix.pd.domain.Enumerations;

public enum Storage {
    ANESTHESIA("Anestesia"),
    TWEEZERS("Pinzas");
    private final String value;

    Storage(String value){
        this.value = value;
    }

    public String getValue(){
        return value;
    }
}
