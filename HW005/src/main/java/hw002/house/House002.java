package hw002.house;

import hw002.house.dom.House;
import hw002.house.flat.Flat;
import hw002.house.exception.InvalidAddressException;
import hw002.house.exception.InvalidCountStageException;
import hw002.house.room.Ceiling;
import hw002.house.room.Floor;
import hw002.house.room.Room;
import hw002.house.sostav.Element;
import hw002.house.sostav.Wall;
import hw002.house.stage.Stage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class House002 {

    static {
        System.setProperty("log4j.configurationFile", "log4j2.xml");
    }

    private static final Logger LOGGER = LogManager.getLogger(House002.class);

    public static void main(String[] args) {

        LOGGER.debug("Посчитать площадь всех стен в доме, Массивы, Несколько вложенных циклов");

        System.out.println("Hreynj");
        Element elementOne = new Element(0.2, 0.1, "Brick");
        elementOne.printMaterialInfo();
        Element elementTwo = new Element(5, 2, "Beton");
        Element elementThree = new Element(6, 2, "Beton");
        Element elementFour = new Element(4, 2, "Beton");

        Wall wallOne = new Wall(elementOne, 200);
        wallOne.toColor();
        Wall wallTwo = new Wall(elementOne, 250);
        Wall wallThree = new Wall(elementOne, 350);
        Wall wallFour = new Wall(elementOne, 300);
        Wall[] wallsArrayOne = {wallOne, wallTwo, wallThree, wallFour};

        LOGGER.debug("        -----       -----        ----           ");

        Floor floorOne = new Floor("wood", false);
        floorOne.turnOn();
        Ceiling ceilingOne = new Ceiling(true, "Pink");
        Room room1 = new Room(wallsArrayOne, floorOne, ceilingOne, "Bed-room");

        Wall wallFive = new Wall(elementTwo, 1);
        Wall wallSix = new Wall(elementThree, 1);
        Wall wallSeven = new Wall(elementFour, 2);
        Wall[] wallsArrayTwo = {wallFive, wallSix, wallSeven};

        Floor floorTwo = new Floor("Laminat", true);
        Ceiling ceilingTwo = new Ceiling(true, "white");
        ceilingTwo.toColor();
        Room roomTwo = new Room(wallsArrayTwo, floorTwo, ceilingTwo, "Living-room");
        LOGGER.debug(roomTwo.toPaint());

        Room[] roomsArrayOne = {room1, roomTwo};
        Flat flatOne = new Flat(roomsArrayOne, "Green");

        LOGGER.debug("        -----       -----        ----           ");

        Wall wallEight = new Wall(elementOne, 1000);
        Wall wallNine = new Wall(elementFour, 2);
        Wall[] wallsArrayThree = {wallEight, wallNine};

        Floor floorThree = new Floor("Lenoleum", false);
        Ceiling ceilingThree = new Ceiling(true, "Yellow");
        Room room3 = new Room(wallsArrayThree, floorThree, ceilingThree, "Dinning-room");

        Room[] roomsArrayTwo = {room3};
        Flat flatTwo = new Flat(roomsArrayTwo, "Brown");

        Flat[] flatsArrayOne = {flatOne, flatTwo};

        Stage stage = new Stage(flatsArrayOne, true);
        LOGGER.debug(stage.toPaint());

        LOGGER.debug("Polymorphism is here");
        Polymorphism test = new Polymorphism();
        LOGGER.debug("floorThree" + floorThree.toString());
        test.floorHeating(floorThree, floorThree.getHeated());
        LOGGER.debug("floorTwo" + floorTwo.toString());
        test.floorHeating(floorTwo, floorTwo.getHeated());

        LOGGER.debug("        -----       -----        ----           ");

        House house = null;
        try {
            house = new House("Round", "Liveable", stage, 1, "Minsk, Center");
        } catch (InvalidCountStageException | InvalidAddressException e) {
            LOGGER.debug("Incorrect number of (count)Stages or Address name.  " + e.getLocalizedMessage(), e);
        } catch (Exception e) {
            LOGGER.debug("Other exception");
        } finally {
            LOGGER.debug("End of setting the house");
        }
        try (ConnectionResource resource = new ConnectionResource()) {
            LOGGER.debug("Do smth in 'try block'");
        }

        LOGGER.debug("        -----       -----        ----           ");

        assert house != null;
        LOGGER.debug(house.toString());

        LOGGER.debug("        -----       -----        ----           ");

        LOGGER.debug(" ");
        room1.printRoomInfo();
        roomTwo.printRoomInfo(elementOne.getMaterial());

        LOGGER.debug(" ");
        ceilingOne.printCeilInfo();
        ceilingTwo.printCeilInfo(true);

    }
}
