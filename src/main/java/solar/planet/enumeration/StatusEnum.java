package solar.planet.enumeration;

public enum StatusEnum {

    ACTIVE("ACTIVE"), INACTIVE("INACTIVE");

    String name;

    StatusEnum(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }


}
