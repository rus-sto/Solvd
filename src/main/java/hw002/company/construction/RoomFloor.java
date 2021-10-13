package hw002.company.construction;

import hw002.company.material.FloorSquare;
import hw002.company.material.Wall;

public class RoomFloor extends FloorSquare {

    private String roomForm;

    public RoomFloor(String floorType, Boolean hasHeater, String color, Wall[] walls, String roomForm) {
        super(floorType, hasHeater, color, walls);
        this.roomForm = roomForm;
    }
    public String roomFormCalc (int count){
        if (count == 1) {
            roomForm = "Round";
        }else if (count == 2) {
            roomForm = "Oval";
        }else if (count == 3) {
            roomForm = "Triangle";
        }else if (count == 4) {
            roomForm = "Quadratic";
        }else if(count == 5) {
            roomForm = "Pentagram";
        }
        return roomForm;
    }

    public String getRoomForm() {
        return roomForm;
    }

    public void setRoomForm(String roomForm) {
        this.roomForm = roomForm;
    }

    @Override
    public String toString() {
        return "RoomFloor{" +
                "roomForm='" + roomForm + '\'' +
                '}';
    }
}



