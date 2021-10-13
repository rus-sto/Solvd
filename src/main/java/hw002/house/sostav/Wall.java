package hw002.house.sostav;

public class Wall {

    private Element element;
    private int countElement;


    public Wall(Element element, int countElement) {
        this.element = element;
        this.countElement = countElement;
    }

    public double wallAreaCalc() {
        return element.getLength() * element.getHeight() * countElement;
    }

    public Element getElement() {
        return element;
    }

    public void setElement(Element element) {
        this.element = element;
    }

    public int getCountElement() {
        return countElement;
    }

    public void setCountElement(int countElement) {
        this.countElement = countElement;
    }

    @Override
    public String toString() {
        return "Wall{" +
                "element=" + element +
                ", countElement=" + countElement +
                '}';
    }
}
