package hw002.house.room;

public class Floor {

    private String material;
    private Boolean isHeated;

    public Floor(String material, Boolean isHeated) {
        this.material = material;
        this.isHeated = isHeated;
    }

    public void turnOn() {
        if (isHeated) {
            System.out.println("heater is on");
        } else {
            System.out.println("no heater on this floor");
        }
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public Boolean getHeated() {
        return isHeated;
    }

    public void setHeated(Boolean heated) {
        isHeated = heated;
    }

    @Override
    public String toString() {
        return "Floor{" +
                "material='" + material + '\'' +
                ", isHeated=" + isHeated +
                '}';
    }
}
