package hw002.company.material;

public class Material {

    private String type;

    public Material(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return " Material{ " +
                " type = '" + type + '\'' +
                '}';
    }
}
