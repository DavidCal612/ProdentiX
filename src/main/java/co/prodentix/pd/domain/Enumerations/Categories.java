package co.prodentix.pd.domain.Enumerations;

public enum Categories {
    PROSTHESIS("Protesis")
    ;

    private final String value;

    Categories(String value){
        this.value = value;
    }

    public String getValue(){
        return value;
    }
}
