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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class House002 {

    static {
        System.setProperty("log4j.configurationFile", "log4j2.xml");
    }

    private static final Logger LOGGER = LogManager.getLogger(House002.class);

    public static void main(String[] args) {

        LOGGER.debug("Посчитать площадь всех стен в доме, Массивы, Несколько вложенных циклов\n");

        Element<String> elementOne = new Element<>(0.2, 0.1, "Brick", "Gost1");
        Element<Double> elementTwo = new Element<>(5, 2, "Beton", 3.14);
        Element<String> elementThree = new Element<>(6, 2, "Cement", "Gost33");
        Element<Integer> elementFour = new Element<>(4, 2, "Steel", 12345);
        elementOne.printMaterialInfo();

        Map<String, String> elementColorMap = new HashMap<>();
        elementColorMap.put(elementOne.getMaterial(), "Red");
        elementColorMap.put(elementTwo.getMaterial(), "Grey");
        elementColorMap.put(elementThree.getMaterial(), "Green");
        elementColorMap.put(elementFour.getMaterial(), "Black");
        System.out.println("\n\nelementColorMap \n " + elementColorMap + "\n");

        List<Element<?>> elementList = new ArrayList<>();
        elementList.add(elementOne);
        elementList.add(elementTwo);
        elementList.add(elementThree);
        elementList.add(elementFour);
        LOGGER.debug(elementList + "\n");

        Wall wallOne = new Wall(elementOne, 200);
        Wall wallTwo = new Wall(elementOne, 250);
        Wall wallThree = new Wall(elementOne, 350);
        Wall wallFour = new Wall(elementOne, 300);
        wallOne.toColor();

        List<Wall> wallsListOne = new ArrayList<>();
        wallsListOne.add(wallOne);
        wallsListOne.add(wallTwo);
        wallsListOne.add(wallThree);
        wallsListOne.add(wallFour);

        LOGGER.debug("\n");

        Floor floorOne = new Floor("wood", false);
        floorOne.turnOn();
        Ceiling ceilingOne = new Ceiling(true, "Pink");
        Room roomOne = new Room(wallsListOne, floorOne, ceilingOne, "Bed-room");

        Wall wallFive = new Wall(elementTwo, 1);
        Wall wallSix = new Wall(elementThree, 1);
        Wall wallSeven = new Wall(elementFour, 2);

        List<Wall> wallsListTwo = new ArrayList<>();
        wallsListTwo.add(wallFive);
        wallsListTwo.add(wallSix);
        wallsListTwo.add(wallSeven);

        Floor floorTwo = new Floor("Laminat", true);
        Ceiling ceilingTwo = new Ceiling(true, "white");
        ceilingTwo.toColor();
        Room roomTwo = new Room(wallsListTwo, floorTwo, ceilingTwo, "Living-room");
        LOGGER.debug(roomTwo.toPaint());

        List<Room> roomsListOne = new ArrayList<>();
        roomsListOne.add(roomOne);
        roomsListOne.add(roomTwo);

        Flat<String> flatOne = new Flat<>(roomsListOne, "Green");

        LOGGER.debug("\n\n");

        Wall wallEight = new Wall(elementOne, 1000);
        Wall wallNine = new Wall(elementFour, 2);
        List<Wall> wallsListThree = new ArrayList<>();
        wallsListThree.add(wallEight);
        wallsListThree.add(wallNine);

        Floor floorThree = new Floor("Lenoleum", false);
        Ceiling ceilingThree = new Ceiling(true, "Yellow");
        Room room3 = new Room(wallsListThree, floorThree, ceilingThree, "Dinning-room");

        List<Room> roomsListTwo = new ArrayList<>();
        roomsListTwo.add(room3);
        Flat<String> flatTwo = new Flat<>(roomsListTwo, "Brown");

        List<Flat<?>> flatsListOne = new ArrayList<>();
        flatsListOne.add(flatOne);
        flatsListOne.add(flatTwo);

        Map<Flat<String>, List<Room>> flatRoomMap = new HashMap<>();
        flatRoomMap.put(flatOne, roomsListOne);
        flatRoomMap.put(flatTwo, roomsListTwo);
        LOGGER.debug("\n\n flatRoomMap\n" + flatRoomMap);


        Stage stage = new Stage(flatsListOne, true);
        LOGGER.debug(stage.toPaint());

        LOGGER.debug("\n\nPolymorphism is here\n");
        Polymorphism test = new Polymorphism();
        LOGGER.debug("floorThree" + floorThree.toString());
        test.floorHeating(floorThree, floorThree.getHeated());
        LOGGER.debug("floorTwo" + floorTwo.toString());
        test.floorHeating(floorTwo, floorTwo.getHeated());

        LOGGER.debug("\n\n");

        House<Boolean> houseOne = null;
        House<String> house = null;
        try {
            houseOne = new House<>("Round", "Liveable", stage, 3, "Brest, Center",false);
            house = new House<>("Round", "Liveable", stage, 1, "Minsk, Center","NO");
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
        roomOne.printRoomInfo();
        roomTwo.printRoomInfo(elementOne.getMaterial());

        LOGGER.debug(" ");
        ceilingOne.printCeilInfo();
        ceilingTwo.printCeilInfo(true);

    }
}
