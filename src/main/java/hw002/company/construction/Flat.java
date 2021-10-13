package hw002.company.construction;

import hw002.company.PrintBlock;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.time.LocalTime;
import java.util.Arrays;
import java.util.Objects;

public class Flat implements PrintBlock, FlatSquareCountable {

    private static final int COST_FLAT_EXTRA_AREA = 50;
    private static final int EXTRA_AREA_FLAT = 12;
    private static final LocalTime EXTRA_TIME_PRODUCE_FOR_FLAT = LocalTime.of(10, 00, 00);
    private static final Logger LOGGER = LogManager.getLogger(Flat.class);

//    private int countRoom;
    private Room room;
    private Room[] rooms;

    public Flat(Room[] rooms) {
        this.rooms = rooms;
    }

//    public Flat(int countRoom, Room room) {
//        this.countRoom = countRoom;
//        this.room = room;
//    }

    @Override
    public double areaFlatCalc(int countRoom, double areaRoom) {
        return countRoom * areaRoom + EXTRA_AREA_FLAT;
    }

    public double costFlatCalc(double TotalRoomCost, int countRoom) {
        return TotalRoomCost * countRoom + COST_FLAT_EXTRA_AREA;
    }

    public long produceTimeOfFlatCalc(long produceTimeOfRoom, int countRoom) {
        long totalFlatExtraSeconds = (long) ((EXTRA_TIME_PRODUCE_FOR_FLAT.getHour() * 3600
                + EXTRA_TIME_PRODUCE_FOR_FLAT.getMinute() * 60
                + EXTRA_TIME_PRODUCE_FOR_FLAT.getSecond()));
        long rez = produceTimeOfRoom * countRoom + totalFlatExtraSeconds;
        return rez;
    }

//    public int getCountRoom() {
//        return countRoom;
//    }
//
//    public void setCountRoom(int countRoom) {
//        this.countRoom = countRoom;
//    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public Room[] getRooms() {
        return rooms;
    }

    public void setRooms(Room[] rooms) {
        this.rooms = rooms;
    }

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        Flat flat = (Flat) o;
//        return countRoom == flat.countRoom && Objects.equals(room, flat.room);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(countRoom, room);
//    }

//    @Override
//    public String toString() {
//        return "Flat{" +
//                "countRoom=" + countRoom +
//                ", room=" + room +
//                '}';
//    }

    @Override
    public void printInfo() {
        LOGGER.debug("Each oneRoomFlat, twoRoomFlat and threeRoomFlat have rooms with flore area - " + room.getRoomSquare() +
                " m2; \n with " + room.getCountWindows() + " in each room");
    }

    @Override
    public String toString() {
        return "Flat{" +
                "rooms=" + Arrays.toString(rooms) +
                '}';
    }
}
