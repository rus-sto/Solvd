package hw002.house;

import hw002.house.dom.flat.Flat;
import hw002.house.room.Ceiling;
import hw002.house.room.Floor;
import hw002.house.room.Room;
import hw002.house.sostav.Element;
import hw002.house.sostav.Wall;
import hw002.house.stage.Stage;

import java.util.Arrays;

public class House002 {
    public static void main(String[] args) {
// Посчитать площадь всех стен в доме, Массивы, Несколько вложенных циклов
        Element element = new Element(0.2, 0.1, "Brick");
        element.printMaterialInfo();
        Element element2 = new Element(5, 2, "Beton");
        Element element3 = new Element(6, 2, "Beton");
        Element element4 = new Element(4, 2, "Beton");
        element2.printMaterialInfo();

        Wall wall1 = new Wall(element, 200);
        System.out.println(wall1.wallAreaCalc());
        Wall wall2 = new Wall(element, 250);
        Wall wall3 = new Wall(element, 350);
        Wall wall4 = new Wall(element, 300);

        Wall[] walls1 = {wall1,wall2,wall3,wall4};
        System.out.println(Arrays.toString(walls1));

        Floor floor1 = new Floor("wood",false);
        Ceiling ceiling1 = new Ceiling(true,"Pink");

        Room room1 = new Room(walls1,floor1,ceiling1,"Bed-room");

        System.out.println(room1.roomWallsAreaCalc());
        room1.printRoomInfo();

        Wall wall5 = new Wall(element2, 1);
        Wall wall6 = new Wall(element3, 1);
        Wall wall7 = new Wall(element4, 2);

        Wall[] walls2 = {wall5,wall6,wall7};

        Floor floor2 = new Floor("Laminat",true);
        Ceiling ceiling2 = new Ceiling(true,"white");

        Room room2 = new Room(walls2,floor2,ceiling2,"Living-room");
        System.out.println(room2.toString());

        Room[] rooms = {room1, room2};

        Flat flat1 = new Flat(rooms,"Green");

        Wall wall8 = new Wall(element, 1000);
        Wall wall9 = new Wall(element4, 2);

        Wall[] walls3 = {wall8,wall8};
        Floor floor3 = new Floor("Lenoleum",false);
        Ceiling ceiling3 = new Ceiling(true,"Yellow");

        Room room3 = new Room(walls3,floor3,ceiling3,"Dinning-room");
          Room[] rooms2 = {room3};

          Flat flat2 = new Flat(rooms2,"Brown");

          Flat[] flats = {flat1,flat2};

        Stage stage = new Stage(flats,true);
        System.out.println("First STAGE");
        System.out.println(stage.toString());

    }
}
