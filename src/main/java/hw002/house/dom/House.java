package hw002.house.dom;

import hw002.house.dom.Building;

public class House extends Building {

    private String address;

    public House(String form, String type, String address) {
        super(form, type);
        this.address = address;
    }

    @Override
    public void printBuildingType() {
        System.out.println("This is " + getType());
    }

    @Override
    public void printConstrForm() {
        System.out.println("Form of Construction is " + getForm());
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
