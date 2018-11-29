package main.java.service;

import main.java.view.ParkingSlot;

import java.util.Arrays;
import java.util.concurrent.CopyOnWriteArrayList;

public class ParkingLotServiceImpl implements ParkingLotService{

    private int totalParkingLot;
    private CopyOnWriteArrayList<ParkingSlot> parkingSlots;

    public ParkingLotServiceImpl(int slot){
        this.totalParkingLot = slot;
        ParkingSlot[] parkingSlots1 = new ParkingSlot[slot];
        parkingSlots = new CopyOnWriteArrayList(parkingSlots1);
        System.out.println("Created a parking lot with "+slot+" slots");
    }

    public void allocateSlotToCar(String carRegistrationNumber, String carColor){
        ParkingSlot parkingSlot = getAvailableSlot(carRegistrationNumber,carColor);
        if(parkingSlot != null){
            System.out.println("Allocated slot number: " + parkingSlot.getDisplaySlotNumber());
        }else{
            System.out.println("Sorry, parking lot is full");
        }
    }

    private ParkingSlot getAvailableSlot(String carRegistrationNumber, String carColor) {
        for(int i = 0; i<totalParkingLot; i++){
            if(parkingSlots.get(i) == null){
                ParkingSlot parkingSlot = new ParkingSlot();
                parkingSlot.setSlotNumber(i);
                parkingSlot.setCarRegistrationNumber(carRegistrationNumber);
                parkingSlot.setCarColor(carColor);
                parkingSlots.set(i,parkingSlot);
                return parkingSlot;
            }
        }
        return null;
    }

    public void freeSlot(int slotNumber) {
        if(totalParkingLot >= slotNumber) {
            parkingSlots.set(slotNumber - 1,null);
            System.out.println("Slot number " + slotNumber + " is free");
        }else{
            System.out.println("Slot number " + slotNumber + " not found");
        }
    }

    public void status() {
        boolean showTableHeader = false;
        for (int i = 0; i < totalParkingLot; i++) {
            ParkingSlot parkingSlot = parkingSlots.get(i);
            if(parkingSlot != null){
                if(!showTableHeader) {
                    System.out.println("Slot No.  Registration No  Colour");
                    showTableHeader = true;
                }
                System.out.println(parkingSlot.getDisplaySlotNumber()+"         "+parkingSlot.getCarRegistrationNumber()+"    "+parkingSlot.getCarColor());
            }
        }
    }

    public void getRegistrationNumberOfAllCarWithGivenColor(String color) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < totalParkingLot; i++) {
            ParkingSlot parkingSlot = parkingSlots.get(i);
            if(parkingSlot != null && parkingSlot.getCarColor().equals(color)){
                sb.append(parkingSlot.getCarRegistrationNumber()+", ");
            }
        }
        print(sb);
    }

    public void getSlotNumberForCarsWithColor(String color) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < totalParkingLot; i++) {
            ParkingSlot parkingSlot = parkingSlots.get(i);
            if(parkingSlot != null && parkingSlot.getCarColor().equals(color)){
                sb.append(parkingSlot.getDisplaySlotNumber()+", ");
            }
        }
        print(sb);
    }

    public void getSlotNumberForRegistrationNumber(String registrationNumber) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < totalParkingLot; i++) {
            ParkingSlot parkingSlot = parkingSlots.get(i);
            if(parkingSlot != null && parkingSlot.getCarRegistrationNumber().equals(registrationNumber)){
                sb.append(parkingSlot.getDisplaySlotNumber()+", ");
            }
        }
        print(sb);
    }

    private void print(StringBuffer sb) {
        if(sb.length() > 0){
            System.out.println(sb.substring(0,sb.length()-2));
        }else {
            System.out.println("Not found");
        }
    }
}
