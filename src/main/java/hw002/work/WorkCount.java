package hw002.work;

public class WorkCount {
    int minutes;
    //  1м2 здания требует 25 мин
    int timeForOneMeter = 25;
    double costForOneMeter = 35;
    double costForInstalOneWindow;
    int totalNumberOfWindows;

    public double workHouseTime(double totalSquare) {
        double totalHouseTime = totalSquare * timeForOneMeter;
        System.out.println("Total time for building the house is " + totalHouseTime + " min.");
        return totalHouseTime;
    }

    public double workHouseCost(double totalSquare) {
        double totalHouseWorkCost = totalSquare * costForOneMeter + costForInstalOneWindow * totalNumberOfWindows;
        System.out.println("Total cost of work for building the house is " + totalHouseWorkCost + " min.");
        return totalHouseWorkCost;

    }

}
