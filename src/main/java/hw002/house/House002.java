package hw002.house;

import hw002.house.dom.House;
import hw002.house.dom.flat.Flat;
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

        Element element = new Element(0.2, 0.1, "Brick");
        Element element2 = new Element(5, 2, "Beton");
        Element element3 = new Element(6, 2, "Beton");
        Element element4 = new Element(4, 2, "Beton");

        Wall wall1 = new Wall(element, 200);
        Wall wall2 = new Wall(element, 250);
        Wall wall3 = new Wall(element, 350);
        Wall wall4 = new Wall(element, 300);
        Wall[] walls1 = {wall1, wall2, wall3, wall4};

        Floor floor1 = new Floor("wood", false);
        Ceiling ceiling1 = new Ceiling(true, "Pink");
        Room room1 = new Room(walls1, floor1, ceiling1, "Bed-room");

        Wall wall5 = new Wall(element2, 1);
        Wall wall6 = new Wall(element3, 1);
        Wall wall7 = new Wall(element4, 2);
        Wall[] walls2 = {wall5, wall6, wall7};

        Floor floor2 = new Floor("Laminat", true);
        Ceiling ceiling2 = new Ceiling(true, "white");
        Room room2 = new Room(walls2, floor2, ceiling2, "Living-room");

        Room[] rooms = {room1, room2};
        Flat flat1 = new Flat(rooms, "Green");

        Wall wall8 = new Wall(element, 1000);
        Wall wall9 = new Wall(element4, 2);
        Wall[] walls3 = {wall8, wall9};

        Floor floor3 = new Floor("Lenoleum", false);
        Ceiling ceiling3 = new Ceiling(true, "Yellow");
        Room room3 = new Room(walls3, floor3, ceiling3, "Dinning-room");

        Room[] rooms2 = {room3};
        Flat flat2 = new Flat(rooms2, "Brown");

        Flat[] flats = {flat1, flat2};

        Stage stage = new Stage(flats, true);

        House house = new House("Round", "Liveable", stage, 2, "Minsk, Center");
        LOGGER.debug(house.toString());

        LOGGER.debug(" ");
        room1.printRoomInfo();
        room2.printRoomInfo(element.getMaterial());

        LOGGER.debug(" ");
        ceiling1.printCeilInfo();
        ceiling2.printCeilInfo(true);

    }
}
