package main.java.service;

public interface ParkingLotService {

    void allocateSlotToCar(String carRegistrationNumber, String carColor);
    void freeSlot(int slotNumber);
    void status();
    void getRegistrationNumberOfAllCarWithGivenColor(String color);
    void getSlotNumberForCarsWithColor(String color);
    void getSlotNumberForRegistrationNumber(String registrationNumber);
}
