package hw002.house.sostav;

public  class Element {

    private double length;
    private double height;
    private String material;

    public Element() {
    }
    public Element(double length, double height, String material) {
        this.length = length;
        this.height = height;
        this.material = material;
    }

    public void printMaterialInfo() {
        System.out.println(" this material is " + material + " It's length and height  are - " + length + " - " + height);
    }
    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    @Override
    public String toString() {
        return "Element{" +
                "length=" + length +
                ", height=" + height +
                ", material='" + material + '\'' +
                '}';
    }
}