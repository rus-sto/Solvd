package hw002.house.dom;

public abstract class Building extends Conctruction {

    private String type;

    public Building(String form, String type) {
        super(form);
        this.type = type;
    }

    public abstract void printBuildingType();

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
