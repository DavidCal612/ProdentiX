package co.prodentix.pd.domain.Enumerations;

public enum OrderStatus {
    PLACED("OrdenRealizada"),
    CANCELED("OrdenCancelada");

    private final String value;

    OrderStatus(String value){
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
