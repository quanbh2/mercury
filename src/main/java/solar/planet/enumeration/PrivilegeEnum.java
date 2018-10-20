package solar.planet.enumeration;

public enum PrivilegeEnum {

    VIEW("VIEW"), CREATE("CREATE"), DELETE("DELETE"), UPDATE("UPDATE");

    String name;

    PrivilegeEnum(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

}
