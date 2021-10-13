package hw002.company.construction;

public abstract class Floor {

    private String floorType;
    private Boolean hasHeater;

    public Floor(String floorType, Boolean hasHeater) {
        this.floorType = floorType;
        this.hasHeater = hasHeater;
    }

    public abstract void floreInstalling();

    public String getFloorType() {
        return floorType;
    }

    public void setFloorType(String floorType) {
        this.floorType = floorType;
    }

    public Boolean getHasHeater() {
        return hasHeater;
    }

    public void setHasHeater(Boolean hasHeater) {
        this.hasHeater = hasHeater;
    }
}


