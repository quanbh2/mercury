package solar.planet.enumeration;

public enum RoleEnum {

    ADMIN("ADMIN"), GUEST("GUEST"), USER("USER");

    String name;

    RoleEnum(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}
